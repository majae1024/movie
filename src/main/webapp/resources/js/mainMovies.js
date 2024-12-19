 
 
 /************************전체 복붙****************************************/
 
  $(function () {
        // 포스터 데이터를 배열로 정의
        const posterData = [];
        const totalPosters = 4; // 포스터 개수와 자리에 맞게

        async function fetchTMDbData(movieNm) {
          const response = await fetch(
            `https://api.themoviedb.org/3/search/movie?api_key=24a0e4e4edb3306a476c479af857b789&query=${encodeURIComponent(
              movieNm
            )}&language=ko` // 줄거리 내용을 한국어로
          );
			
          	const data = await response.json();
          	return data.results && data.results[0]; // 첫 번째 결과 반환
        }
		
		 async function fetchMovieCertification(movieId) {
        try {
             const response = await fetch(
            `https://api.themoviedb.org/3/movie/${movieId}?api_key=24a0e4e4edb3306a476c479af857b789&language=ko-KR&append_to_response=release_dates`
        	);

        	if (!response.ok) {
            	throw new Error(`HTTP 오류: ${response.status}`); // 응답이 성공적이지 않으면 오류 발생
        	}

        const data = await response.json();

        // 한국(KR) 데이터 필터링
        const releaseDates = data.release_dates.results;
        const krReleaseInfo = releaseDates.find((release) => release.iso_3166_1 === "KR");
        const certification = krReleaseInfo ? krReleaseInfo.release_dates[0]?.certification : "정보 없음";
		console.log(certification);
        return certification;
    } catch (error) {
        console.error("연령제한 등급 가져오기 실패:", error);
        return "정보 없음";
    }
}
		
		
        async function processMovies() {
  				const today = new Date();
  				const yesterday = new Date();
  				yesterday.setDate(today.getDate() - 1); // 현재 날짜에서 하루 전 조회

  				const year = yesterday.getFullYear();
  				const month = (yesterday.getMonth() + 1).toString().padStart(2, "0");
  				const date = yesterday.getDate().toString().padStart(2, "0");
  				const dateword = `${year}${month}${date}`; // "YYYYMMDD" 형식의 날짜

  				const response = await fetch(
    				`http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=0e1d629d41bba9656cef266b69e9ccaf&targetDt=${dateword}`
  					);
  				const result = await response.json();
  				const movieList = result.boxOfficeResult.dailyBoxOfficeList;

  				let outputCount = 0;

  				for (const movie of movieList) {
    				if (outputCount >= totalPosters) break; // 원하는 영화 수 초과 시 중단

    				const movieNm = movie.movieNm; // 영화명
    				const audiAcc = Number(movie.audiAcc).toLocaleString(); // 누적 관객수
    				const salesShare = parseFloat(movie.salesShare); // 예매율(매출 점유율)

    				try {
      					const tmdbData = await fetchTMDbData(movieNm);

      					if (tmdbData && tmdbData.poster_path && tmdbData.overview) {
        				const posterPath = `https://image.tmdb.org/t/p/w500${tmdbData.poster_path}`;
        				const overview = truncateText(tmdbData.overview, 110);
        				const movieId = tmdbData.id;
						const voteAverage = tmdbData.vote_average.toFixed(1);
		
						const certification = await fetchMovieCertification(movieId);

						console.log(tmdbData);
        				// 포스터 데이터를 배열에 추가
        				posterData.push({
          					rank: outputCount + 1, // 순위
          					imgSrc: posterPath, // 포스터 경로
          					heartImg: "/resources/img/section/poster/poster_heart/empty_heart.png", // 기본 하트 이미지
          					heartCount: Math.floor(Math.random() * 10001), // 좋아요 0~10,000 랜덤 숫자
          					description: overview, // 줄거리
          					movieId: movieId,
          					movieNm: movieNm,
          					voteAverage: voteAverage,
          					salesShare: salesShare, // 예매율
          					certification: certification.toString(), // 연령제한 등급
          					
        				});

        				outputCount++;
      					}
    				} catch (error) {
      					console.error(`영화 데이터 처리 중 오류 발생: ${movieNm}`, error);
    					}
         		}

          		renderPosters();
        }

        function renderPosters() {
          $(".poster").each(function (index) {
            if (posterData[index]) {
              const posterHTML = createPoster(posterData[index]);
              $(this).html(posterHTML);
            }
          });
        }
		const csrfToken = document.querySelector('meta[name="_csrf"]').getAttribute('content');
		const csrfHeader = document.querySelector('meta[name="_csrf_header"]').getAttribute('content');
        function createPoster(data) {
          const heartFormatted = formatNumber(data.heartCount);
          const ImgSrc = encodeURIComponent(data.imgSrc); // URL 인코딩
 	 	  const Description = encodeURIComponent(data.description); // 줄거리도 인코딩
  		  const MovieNm = encodeURIComponent(data.movieNm); // 영화 제목도 인코딩
          return `
            <div class="box1">
                <div class="image-container">
                    <div class="rank">${data.rank}</div>
                    <img src="${data.imgSrc}" alt="poster${data.rank}" class="poster-image">
                    <div class="overlay">
                        <p class="description">${data.description}</p>
                    </div>
                </div>
                <div class="btn-util">
                    <button class="btn1">
                        <img src="${data.heartImg}" alt="empty_heart" class="empty_heart">
                        <span class="heart-count">${heartFormatted}</span>
                    </button>
                    <div class="case">
                    	<form action="/movie/sub" method="POST">
                    		<input type="hidden" name="movieId" value="${data.movieId}">
    						<input type="hidden" name="imgSrc" value="${data.imgSrc}">
    						<input type="hidden" name="description" value="${data.description}">
    						<input type="hidden" name="movieNm" value="${data.movieNm}">
    						<input type="hidden" name="voteAverage" value="${data.voteAverage}">
    						<input type="hidden" name="salesShare" value="${data.salesShare}">
    						<input type="hidden" name="certification" value="${data.certification}">
                      		<input type="hidden" name="_csrf" value="${csrfToken}"> <!-- CSRF 토큰 추가 -->
    						<button type="submit" class="btn2">예매</button>                        
    					</form>
                    </div>
                </div>
            </div>
        `;
        }

        function truncateText(text, maxLength) {
          if (text.length > maxLength) {
            return text.slice(0, maxLength) + "...";
          }
          return text;
        }

        // 숫자 포맷팅 함수
        function formatNumber(number) {
          if (number < 1000) {
            return number.toString();
          } else {
            return (number / 1000).toFixed(1).replace(/\.0$/, "") + "k";
          }
        }

        // 문자열에서 숫자 추출 함수
        function parseNumber(text) {
          if (text.includes("k")) {
            return parseFloat(text.replace("k", "")) * 1000; // 1,000이 넘어가면 1k로 바뀌게 설정
          } else {
            return parseInt(text, 10); // 일반 숫자 변환
          }
        }

        // 하트 버튼 클릭 이벤트 핸들러
        $(document).on("click", ".btn1", function () {
          const heartCountElement = $(this).find(".heart-count");
          const heartImage = $(this).find(".empty_heart");
          const currentText = heartCountElement.text();
          let currentNumber = parseNumber(currentText);

          // 이미지 변경 및 숫자 증가/감소
          if (heartImage.attr("src").includes("empty_heart.png")) {
            heartImage.attr("src", "/resources/img/section/poster/poster_heart/heart.png"); // 하트 채우기
            currentNumber++; // 숫자 증가
          } else {
            heartImage.attr(
              "src",
              "/resources/img/section/poster/poster_heart/empty_heart.png"
            ); // 빈 하트로 변경
            currentNumber--; // 숫자 감소
          }

          // 숫자 포맷팅 후 업데이트
          heartCountElement.text(formatNumber(currentNumber));
        });
        
         // 공지사항 리스트 요청
         $.ajax({
			    url: '/movie/showNotices',
			    method: 'GET',
			    dataType: 'json',
			    success: function (data) {
			        if (data && data.length > 0) {
			            window.open("/movie/showNoticePage", "noticePopup", "width=500,height=400,scrollbars=yes");
			        }
			    },
			    error: function (xhr, status, error) {
			        console.error('Error fetching notices:', error);
			    }
			});
        
        
        

        processMovies();
      });