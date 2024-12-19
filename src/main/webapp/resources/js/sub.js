$(document).ready(function () {

     // btn-like hover 이벤트
    $('.btn-like').hover(
        function () {
            $(this).css('background-color', '#fff');
            $(this).css('color', '#000');
            $(this)
                .find('.ico-heart-line')
                .css(
                    'background-image',
                    "url('https://img.megabox.co.kr/static/pc/images/common/ico/ico-heart-on.png')"
                );
        },
        function () {
            $(this).css('background-color', '');
            $(this).css('color', '');
            $(this)
                .find('.ico-heart-line')
                .css(
                    'background-image',
                    "url('https://img.megabox.co.kr/static/pc/images/common/ico/ico-heart-line.png')"
                );
        }
    );

    $('.btn-common-share').hover(
        function () {
            $(this).css('background-color', '#fff');
            $(this).css('color', '#000'); // 글씨 색 변경
            $(this)
                .find('.ico-sns-line')
                .css(
                    'background-image',
                    "url('https://img.megabox.co.kr/static/pc/images/common/ico/ico-sns-on.png')"
                );
        },
        function () {
            $(this).css('background-color', '');
            $(this).css('color', ''); // 원래 색상으로 복원
            $(this)
                .find('.ico-sns-line')
                .css(
                    'background-image',
                    "url('https://img.megabox.co.kr/static/pc/images/common/ico/ico-sns-line.png')"
                );
        }
    );

    $('.btn-common-share').click(function () {
        $(this).siblings('.btn-sns-share-wrap').toggleClass('on');
    });
});

/******************************************************************
*																  *
*							수정									  *		
*																  *
*																  *
*******************************************************************/
const MOVIEID = document.getElementById('movieId').value;
console.log('영화 ID:', MOVIEID);

//누적영화관객수 호출  api
$(function () {
    const today = new Date();
    const yesterday = new Date();
    yesterday.setDate(today.getDate() - 1); // 어제 날짜

    const year = yesterday.getFullYear();
    const month = (yesterday.getMonth() + 1).toString().padStart(2, '0');
    const date = yesterday.getDate().toString().padStart(2, '0');
    const dateword = `${year}${month}${date}`; // "YYYYMMDD" 형식의 날짜

    const API_KEY = '0e1d629d41bba9656cef266b69e9ccaf'; // KOBIS API 키

    // KOBIS API 호출
    $.ajax({
        url: `http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=${API_KEY}&targetDt=${dateword}`,
        method: 'GET',
        success: function (response) {
            const movieList = response.boxOfficeResult.dailyBoxOfficeList;
			const movieNm = document.getElementById('movieNm').value;
 			console.log("영화이름"+movieNm);
			
            // 특정 영화의 누적 관객수 가져오기
            const targetMovie = movieList.find(
                movie => movie.movieNm === movieNm
            ); 

            if (targetMovie) {
                const audienceCount = Number(
                    targetMovie.audiAcc
                ).toLocaleString(); // 숫자 포맷팅
                $('#audience-count').text(audienceCount);
            } else {
                console.error('해당 영화 데이터를 찾을 수 없습니다.');
            }
        },
        error: function () {
            console.error('KOBIS API 요청 실패');
        },
    });
});
/******************************************************************
*																  *
*							수정 끝								  *		
*																  *
*																  *
*******************************************************************/

function showPopup(button) {
    // 팝업창 열기
    const popup = document.getElementById('popup');
    popup.classList.remove('hidden');

    // 클릭된 버튼이 포함된 리뷰 컨테이너 찾기
    const reviewElement = button.closest('.review');

    // 해당 리뷰 컨테이너에서 review_id 값 가져오기
    const idElement = reviewElement.querySelector('#rid'); // 리뷰 ID가 있는 요소 선택
    const reviewId = idElement.textContent.trim(); // 리뷰 ID 값 추출

    // 가져온 review_id를 신고창의 <span>에 삽입
    const popupReviewId = document.getElementById('popup-review-id');
    popupReviewId.textContent = reviewId;
    
     //해당 리뷰 컨테이너에서 user_id 값 가져오기
    const nameElement = reviewElement.querySelector('.reviewUserId');
    console.log("댓글창에서 받아온 유저아이디:", nameElement);
    const reviewName = nameElement.value.trim();
    console.log("값 추출:",reviewName);
    
    //가져온 reviewName값 신고창 <input>에 삽입
    document.getElementById('review_user_id').value = reviewName;
    
    

    // 콘솔 출력 (디버깅 용도)
    console.log("Review ID:", reviewId);
     
};



function hidePopup() {
    const popup = document.getElementById('popup');
    popup.classList.add('hidden');
};


$(document).ready(function () {

    $(".menu-button").on("click", function () {
    	const reviewUserId = document.getElementById("review_user_id").value;
    	const userId = document.getElementById("user_id").value;
    
    	console.log("리뷰쓴 사람아이디:",reviewUserId);
  		console.log("로그인한 유저아이디:",userId);
   
   		// 조건 비교
    	if (reviewUserId === userId) {
        	document.getElementById("modifyButton").style.display = "inline";
        	document.getElementById("deleteButton").style.display = "inline";
        	document.getElementById("reportButton").style.display = "none";
    	}else{
    		document.getElementById("modifyButton").style.display = "none";
        	document.getElementById("deleteButton").style.display = "none";
        	document.getElementById("reportButton").style.display = "inline";
    	}
	});
});




function openModal() {
    document.getElementById('Modal').style.display = 'block';
};

function closeModal() {
	document.getElementById('Modal').style.display = 'none';
};
	
window.onclick = function (event) {
       var Modal = document.getElementById('Modal');
       if (event.target === Modal) {
           Modal.style.display = 'none';
       }
   };
var csrfToken = $('meta[name="_csrf"]').attr("content");
var csrfHeader = $('meta[name="_csrf_header"]').attr("content");
	
$(document).ready(function () {
    // 수정 버튼 클릭 이벤트
    $(".report-link[data-oper='modify']").on("click", function () {
        var reviewId = $(this).closest(".popup-content").find("#popup-review-id").text();
        
        // 리뷰 정보 가져오기
        $.ajax({
            url: "/movie/getReview",
            type: "GET",
            data: { review_id: reviewId },
            dataType: "json",
            beforeSend: function(xhr) {
            xhr.setRequestHeader(csrfHeader, csrfToken);
	        },
            success: function (review) {
                // 수정 모달창에 데이터 채우기
                $("#Rid").val(review.review_id);
                $("#Uname").val(review.user_name);
                $("#Rrating").val(review.review_rating);
                $("#Rtext").val(review.review_text);

				// 기존 popup 창 숨기기
                $("#popup").fadeOut();
				
                // 수정 모달창 열기
                $("#ModifyModal").fadeIn();
            },
            error: function () {
                alert("리뷰 정보를 가져오는 데 실패했습니다.");
            }
        });
    });

    // 삭제 버튼 클릭 이벤트
    $(".report-link[data-oper='remove']").on("click", function () {
        var reviewId = $(this).closest(".popup-content").find("#popup-review-id").text();

        if (confirm("정말 삭제하시겠습니까?")) {
            $.ajax({
                url: "/movie/remove",
                type: "POST",
                data: { review_id: reviewId },
                beforeSend: function(xhr) {
	            xhr.setRequestHeader(csrfHeader, csrfToken);
		        },
                success: function () {
                    alert("리뷰가 삭제되었습니다.");
                    location.reload(); // 페이지 새로고침
                },
                error: function () {
                    alert("리뷰 삭제에 실패했습니다.");
                }
            });
        }
    });
    
     
    // 수정 완료 버튼 클릭 이벤트
    $("#modifyForm").on("submit", function (e) {
        e.preventDefault();

        var review = {
            review_id: $("#Rid").val(),
            user_name: $("#Uname").val(),
            review_rating: $("#Rrating").val(),
            review_text: $("#Rtext").val()
        };

        $.ajax({
            url: "/movie/modify",
            type: "POST",
            contentType: "application/json",
            data: JSON.stringify(review),
            beforeSend: function(xhr) {
            xhr.setRequestHeader(csrfHeader, csrfToken);
	        },
            success: function () {
                alert("리뷰가 수정되었습니다.");
                location.reload(); // 페이지 새로고침
            },
            error: function () {
                alert("리뷰 수정에 실패했습니다.");
            }
        });
    });
    
    // 신고 버튼 클릭 이벤트
    $(".report-link[data-oper='report']").on("click", function () {
        var reviewId = $(this).closest(".popup-content").find("#popup-review-id").text();

        if (confirm("이 리뷰를 신고하시겠습니까?")) {
            $.ajax({
                url: "/movie/report",
                type: "POST",
                data: { review_id: reviewId },
                beforeSend: function(xhr) {
            	xhr.setRequestHeader(csrfHeader, csrfToken);
	        	},
                success: function () {
                    alert("리뷰가 신고되었습니다.");
                    // 기존 popup 창 숨기기
              		$("#popup").fadeOut();
                    location.reload(); // 페이지 새로고침
                },
                error: function () {
                    alert("이미 신고된 리뷰 입니다.");
                    $("#popup").fadeOut();
                    location.reload(); // 페이지 새로고침
                }
            });
        }
    });
    
});



function closeModifyModal() {
	document.getElementById('ModifyModal').style.display = 'none';
	
window.onclick = function (event) {
	    var ModifyModal = document.getElementById('ModifyModal');
		ModifyModal.style.display = 'none';
	};
}