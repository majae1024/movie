var csrfToken = $('meta[name="_csrf"]').attr("content");
var csrfHeader = $('meta[name="_csrf_header"]').attr("content");

$(document).ready(function () {
	$(".cancel").on("click", function () {
		const Rno = $(this).closest('.reservation-card').find('#rno').val(); // 예약 번호 가져오기
	    
	    console.log("예매 취소할 번호:", Rno);

		// AJAX 요청
		$.ajax({
			url: '/movie/delete', // 요청할 컨트롤러 URL
		    type: 'POST',
		    contentType: 'application/json',
		    data: JSON.stringify({ rno: Rno }), // JSON으로 예약 번호 전달
		     beforeSend: function(xhr) {
            	xhr.setRequestHeader(csrfHeader, csrfToken);
	        	},
		    success: function (response) {
		    	alert('예매가 취소되었습니다.');
		        location.reload(); // 페이지 새로고침
		    },
		    error: function (error) {
		    	alert('예매 취소에 실패했습니다.');
		        console.error('예매 취소에 실패했습니다.');
		    }
		});
	});
});	

