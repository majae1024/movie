document.addEventListener("DOMContentLoaded", () => {
  const rows = document.querySelectorAll(".row"); // 모든 행
  const seats = document.querySelectorAll(".seat"); // 모든 좌석 버튼
  const vehicleSizeOptions = document.querySelectorAll('input[name="viewer-size"]'); // 차량 크기 선택 라디오 버튼
  const resetButton = document.getElementById("reset-button"); // 리셋 버튼
  const previewSeats = document.getElementById("preview-seats"); // 선택된 좌석 표시
  const previewPrice = document.getElementById("preview-price"); // 선택된 좌석 가격 표시
  const MOVIEID = document.getElementById('movieId').value;
  console.log('영화 ID:', MOVIEID);
  
  // 폼 내 숨겨진 입력 필드
  const seatInfoInput = document.getElementById("seatInfo"); // 좌석 정보
  const priceInput = document.getElementById("price"); // 가격 정보

  let selectedSeat = null; // 현재 선택된 좌석
 

  // 예약된 좌석 처리
  reservedSeats.forEach(seatId => {
    const seatButton = document.getElementById(seatId);
    if (seatButton) {
      seatButton.classList.add("reserved"); // 예약된 좌석 스타일 추가
      seatButton.disabled = true; // 좌석 비활성화
    }
  });

  // 특정 행 활성화 및 비활성화 처리
  const activateRows = (rows, indices) => {
    rows.forEach((row, index) => {
      const seats = row.querySelectorAll(".seat");
      if (indices.includes(index + 1)) {
        // 활성화된 행
        seats.forEach((seat) => {
          if (!seat.classList.contains("reserved")) {
            seat.disabled = false; // 활성화
            seat.classList.remove("disabled-seat"); // 비활성화 스타일 제거
          }
        });
      } else {
        // 비활성화된 행
        seats.forEach((seat) => {
          if (!seat.classList.contains("reserved")) {
            seat.disabled = true; // 비활성화
            seat.classList.add("disabled-seat"); // 비활성화 스타일 추가
          }
        });
      }
    });
  };

  // 좌석 클릭 이벤트 처리
  const handleSeatClick = (event) => {
    const target = event.target;

    // 차량 크기 선택 여부 확인
    const selectedSize = document.querySelector('input[name="viewer-size"]:checked');
    if (!selectedSize) {
      alert("차량 크기를 선택해주세요!"); // 차량 크기 선택을 유도
      return;
    }

    // 좌석 선택 처리
    if (
      target.classList.contains("seat") &&
      !target.classList.contains("reserved") &&
      !target.classList.contains("disabled-seat")
    ) {
      if (selectedSeat) {
        selectedSeat.classList.remove("selected"); // 기존 선택 해제
      }
      selectedSeat = target.classList.contains("selected") ? null : target; // 선택/해제 처리
      target.classList.toggle("selected"); // 선택 상태 토글
      updatePreview(); // 선택 정보 업데이트
    }
  };

  // 선택 정보 업데이트
  const updatePreview = () => {
    if (selectedSeat) {
      const seatId = selectedSeat.id; // 선택된 좌석 ID
      const price = 10000; // 고정 가격

      // 미리보기 정보 업데이트
      previewSeats.textContent = seatId;
      previewPrice.textContent = `${price}원`;

      // 숨겨진 입력 필드 업데이트
      seatInfoInput.value = seatId;
      priceInput.value = price;
    } else {
      // 선택 취소 시 초기화
      previewSeats.textContent = "없음";
      previewPrice.textContent = "0원";
      seatInfoInput.value = "";
      priceInput.value = "";
    }
  };

  // 차량 크기 선택 이벤트
  vehicleSizeOptions.forEach((option) => {
    option.addEventListener("change", () => {
      const selectedSize = option.value;
      switch (selectedSize) {
        case "small":
          activateRows(rows, [1, 2]); // 소형: A, B
          break;
        case "medium":
          activateRows(rows, [3, 4]); // 중형: C, D
          break;
        case "large":
          activateRows(rows, [5, 6]); // 대형: E, F
          break;
      }

      // 좌석 선택 초기화
      if (selectedSeat) {
        selectedSeat.classList.remove("selected");
        selectedSeat = null;
        updatePreview();
      }
    });
  });

  // 리셋 버튼 이벤트
  resetButton.addEventListener("click", () => {
    // 선택된 좌석 초기화
    if (selectedSeat) {
      selectedSeat.classList.remove("selected");
      selectedSeat = null;
    }
    updatePreview();

    // 모든 좌석 활성화
    seats.forEach((seat) => {
      seat.disabled = false;
      seat.classList.remove("disabled-seat");
    });

    // 차량 크기 선택 초기화
    vehicleSizeOptions.forEach((option) => {
      option.checked = false;
    });
  });

  // 좌석 클릭 이벤트 등록
  seats.forEach((seat) => {
    seat.addEventListener("click", handleSeatClick);
  });
  

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
  
  
  
});
