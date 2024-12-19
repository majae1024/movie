<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="_csrf" content="${_csrf.token}">
<meta name="_csrf_header" content="${_csrf.headerName}">
<title>영화 어때</title>


<link rel="stylesheet" href="../resources/css/reset.css">
<link rel="stylesheet" href="../resources/css/common.css">
<link rel="stylesheet" href="../resources/css/sub.css">

<!------------------------------------------------------------마재원 수정----------------------------------------------->




<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>




<!------------------------------------------------------------마재원 수정----------------------------------------------->
</head>

<body>
	<div class="body-wrap">
		<!-- 헤더 -->
		<header id="header-wrap">
			<div id="header">

				<div id="util-left-area">
					<div id="left-link">
						<a href="#">VIP LOUNGE</a>
						<a href="#">멥버십</a>
						<a href="#">고객센터</a>
					</div>
				</div>

				<div id="logo">
					<a href="/movie/index">
						<img src="../resources/img/logo/logo1.PNG" alt="">
					</a>
				</div>

				<div id="util-right-area">
					<div id="right-link">
						<c:choose>
							<c:when test="${isAuthenticated}">
								<a href="/movie/mypage">안녕하세요! ${userName} 님</a>
								<form action="/user/customLogout" method="POST" class="login_form" style="display: inline;">
									<input type="hidden" name="_csrf" value="${_csrf.token}">
									<button type="submit" class="logout_btn">로그아웃</button>
								</form>
							</c:when>
							<c:otherwise>
								<a href="/user/login">로그인</a>
								<a href="/user/register">회원가입</a>
							</c:otherwise>
						</c:choose>

					</div>
				</div>

				<div id="link-area">
					<a href="#layer_sitemap" class="header-open-layer btn-layer-sitemap" title="사이트맵">사이트맵</a>
					<a href="#layer_header_search" class="header-open-layer btn-layer-search" title="검색">검색</a>
					<a href="/booking/timetable" class="link-ticket" title="상영시간표">상영시간표</a>
					<a href="/movie/mypage" class="header-open-layer btn-layer-mymega" title="나의 메가박스">나의 메가박스</a>
				</div>

				<div id="gnb">
					<ul>
						<li><a href="/movie" class="gnb-txt-movie" title="영화">영화</a></li>
						<li><a href="/booking" class="gnb-txt-reserve" title="예매">예매</a></li>
						<li><a href="/theater/list" class="gnb-txt-theater" title="극장">극장</a></li>
						<li><a href="/event" class="gnb-txt-event" title="이벤트">이벤트</a></li>
						<li><a href="/store" class="gnb-txt-store" title="스토어">스토어</a></li>
						<li><a href="/benefit/membership" class="gnb-txt-benefit" title="혜택">혜택</a></li>
					</ul>
				</div>
			</div>
		</header>


		<div id="sub-section">
			<div id="bg">
				<img src="${movie.imgSrc }" alt="wikid.jpg" onerror="noImg(this, 'main');">
			</div>
			<!------------------------------------------------------------마재원 수정----------------------------------------------->
			<!------------------------------------------------------------마재원 수정----------------------------------------------->
			<!------------------------------------------------------------마재원 수정----------------------------------------------->

			<div class="z">
				<div class="detail-cont">
					<p class="title">
						<span class="title">${movie.movieNm}</span> <span class="age" style="font-size: 18px; color: #888888; font-weight: bold;">-${movie.certification }-</span>
					</p>

					<div class="sub-desc">
						<p>${movie.description }</p>
					</div>

					<form action="" method="post">
						<input type="hidden" id="movieId" value="${movie.movieId }">
						<input type="hidden" id="imgSrc" value="${movie.imgSrc }">
						<br>
						<input type="hidden" id="description" value="${movie.description }">
						<input type="hidden" id="movieNm" value="${movie.movieNm }">
						<br>
						<input type="hidden" id="voteAverage" value="${movie.voteAverage }">
						<input type="hidden" id="SalesShare" value="${movie.salesShare }">
						<input type="hidden" id="movieRate" value="${movie.certification} ">
						<input type="hidden" id="userAge" value="${userBirth }">

					</form>
				</div>
				<!------------------------------------------------------------마재원 수정 끝----------------------------------------------->
				<!------------------------------------------------------------마재원 수정 끝----------------------------------------------->
				<!------------------------------------------------------------마재원 수정 끝----------------------------------------------->



				<div class="btn-util">
					<button type="button" title="좋아요 버튼" class="btn-like">
						<i class="ico-heart-line"></i> <span id="intrstCnt">2.7k</span>
					</button>
					<div class="sns-share">
						<a href="#" class="btn-common-share" title="공유하기">
							<i class="iconset ico-sns-line"></i>공유하기
						</a>
						<div class="btn-sns-share-wrap">
							<div class="cont-area">
								<div class="btn-sns-share-group">
									<button class="face btnSns">페이스북</button>
									<button class="band btnSns">밴드</button>
									<button class="twitter btnSns">트위터</button>
									<button class="link btnSns">링크공유</button>
								</div>
							</div>
						</div>
					</div>
				</div>

				<div class="screen-type2">
					<p>
						<img src="https://img.megabox.co.kr/static/pc/images/movie/type_mega_mx4d_d.png" alt="mx4d" class="left">
					</p>
					<p>
						<img src="https://img.megabox.co.kr/static/pc/images/movie/type_dolbycinema_d.png" alt="dolby">
					</p>
					<p>
						<img src="https://img.megabox.co.kr/static/pc/images/movie/type_dolbyatmos_d.png" alt="atmos">
					</p>
				</div>


				<!------------------------------------------------------------마재원 수정----------------------------------------------->
				<!------------------------------------------------------------마재원 수정----------------------------------------------->
				<!------------------------------------------------------------마재원 수정----------------------------------------------->



				<div class="info">
					<div class="score">
						<p class="tit">평점</p>
						<div class="number" id="mainmoviescore">
							<p class="before">
								<em>${movie.voteAverage }</em> <span class="ir"></span>
							</p>
						</div>
					</div>

					<div class="rate">
						<p class="tit">예매율</p>
						<p class="cont1">
							<em class="big">${movie.salesShare }</em> %
						</p>
					</div>

					<div class="audience">
						<div class="tit">
							<span class="tooltip"> 누적관객수 <i class="ico-tooltip-gray"></i> <!-- <div class="detail-tooltip">
                                    <div class="bottom"></div>
                                </div> -->
							</span>
						</div>
						<p class="cont2">
							<em class="big" id="audience-count">0</em> <span>명</span>
						</p>
					</div>
				</div>

				<div class="poster">
					<div class="wrap">
						<!-- 받아온 연령등급에 따라 포스터에 추가되는 이미지 변환 -->
						<p
							class="movie-grade <c:choose>
										        	<c:when test="${movie.certification == '전체이용가'}"> all</c:when>
										        	<c:when test="${movie.certification == '12세이용가'}"> age12</c:when>
										        	<c:when test="${movie.certification == '15세이용가'}"> age15</c:when>
										        	<c:when test="${movie.certification == '19세이용가'}"> age19</c:when>
										        	<c:otherwise>unknown</c:otherwise>
										    	</c:choose>">
						</p>
						<img src="${movie.imgSrc }" alt="위키드">
					</div>
				</div>
				<!------------------------------------------------------------마재원 수정 끝----------------------------------------------->
				<!------------------------------------------------------------마재원 수정 끝----------------------------------------------->
				<!------------------------------------------------------------마재원 수정 끝----------------------------------------------->
				<div class="screen-type">
					<div class="reserve">
						<a href="/movie/reservation" class="reservation" title="예매">예매</a>
						<a href="#" class="dolby">
							<img src="https://www.megabox.co.kr/static/pc/images/common/btn/mov_detail_db_btn.png" alt="dolby" title="dolby">
						</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- body-wrap -->

	<br>
	<br>
	<br>

	<!------------------------------------------------------------마재원 수정----------------------------------------------->

	<!--리뷰-->
	<div class="review-container">
		<button class="Modal-link" onclick="openModal()">
			<img alt="작성" src="https://img.megabox.co.kr/static/pc/images/common/ico/ico-story-write.png"> 관람평 작성
		</button>

		<br> <br>

		<c:if test="${not empty reviews}">
			<c:forEach var="reviews" items="${reviews}">
				<div class="review">
					<span class="hide" id="rid">${reviews.review_id}</span>
					<div class="nickname">
						<div class="circle">
							<img src="../resources/img/review/peple.png" alt="User Avatar">
						</div>
						<input type="hidden" class="reviewUserId" value="${reviews.user_id }">
						<span class="name">${reviews.user_name}</span>
					</div>
					<div class="content">
						<span class="rating">${reviews.review_rating}</span> <span class="comment">${reviews.review_text}</span>
					</div>
					<c:choose>
						<c:when test="${userId == reviews.user_id}">
							<button class="menu-button" onclick="showPopup(this)">
								<img alt="수정삭제" src="../resources/img/review/write.png">
							</button>
						</c:when>
						<c:otherwise>
							<button class="menu-button" onclick="showPopup(this)">
								<img alt="신고" src="../resources/img/review/report.png">
							</button>
						</c:otherwise>
					</c:choose>

					<span class="sysdate"> <fmt:formatDate pattern="yyyy-MM-dd" value="${reviews.review_date}" />
					</span>
				</div>
			</c:forEach>
		</c:if>
	</div>

	<!-- 리뷰 작성 모달창 -->
	<div id="Modal" class="Modal">
		<div class="Modal-content">
			<span class="close" onclick="closeModal()">&times;</span>
			<h2>관람평 작성하기</h2>

			<!-- 리뷰 작성 폼 (테이블로 구성) -->
			<form id="reviewForm" action="/movie/register" method="post">
				<input type="hidden" name="review_id" id="review_id">
				<input type="hidden" name="movie_id" id="movie_id" value="${movie.movieId}">
				<input type="hidden" name="movie_name" id="movie_name" value="${movie.movieNm }">
				<input type="hidden" name="user_id" id="user_id" value="${userId}">
				<input type="hidden" id="movieId" value="${movie.movieId }">
				<input type="hidden" id="imgSrc" value="${movie.imgSrc }">
				<input type="hidden" id="description" value="${movie.description }">
				<input type="hidden" name="movieNm" id="movieNm" value="${movie.movieNm }">
				<input type="hidden" id="voteAverage" value="${movie.voteAverage }">
				<input type="hidden" id="SalesShare" value="${movie.salesShare }">
				<input type="hidden" id="movieRate" value="${movie.certification} ">
				<sec:csrfInput />
				<table>
					<tr>
						<td><label class="Modal-text">닉네임</label></td>
						<td><input type="text" id="user_name" name="user_name" value="${userName}" readonly></td>
					</tr>
					<tr>
						<td><label class="Modal-text">평점</label></td>
						<td><input type="number" id="review_rating" name="review_rating" min="1" max="10" step="1" value="1" value="${review.review_rating}" required></td>
					</tr>
					<tr>
						<td><label class="Modal-text">내용</label></td>
						<td><textarea id="review_text" name="review_text" maxlength="100" value="${review.review_text}" required></textarea></td>
					</tr>
				</table>
				<button type="submit" class="submit" onclick="submitReview()">제출</button>
			</form>
		</div>
	</div>

	<!-- 리뷰 수정 모달창 -->
	<div id="ModifyModal" class="Modal">
		<div class="Modal-content">
			<span class="close" onclick="closeModifyModal()">&times;</span>
			<h2>리뷰 수정하기</h2>

			<!-- 리뷰  수정 폼 (테이블로 구성) -->
			<form id="modifyForm" action="/movie/modify" method="post">
				<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
				<input type="hidden" name="review_id" id="Rid">
				<table>
					<tr>
						<td><label class="Modal-text">닉네임</label></td>
						<td><input type="text" name="user_name" id="Uname" readonly="readonly"></td>
					</tr>
					<tr>
						<td><label class="Modal-text">평점</label></td>
						<td><input type="number" name="review_rating" min="1" max="10" step="1" id="Rrating" required></td>

					</tr>
					<tr>
						<td><label class="Modal-text">내용</label></td>
						<td><textarea name="review_text" maxlength="100" id="Rtext" required></textarea></td>
					</tr>
				</table>
				<button type="submit" class="submit">수정</button>
			</form>
		</div>
	</div>


	<!-- 신고창 -->
	<div id="popup" class="popup hidden">
		<div class="popup-content">
			<span class="close-button" onclick="hidePopup()">×</span>
			<p>스포일러 및 욕설/비방하는 내용이 있습니까?</p>

			<input type="hidden" name="review_user_id" id="review_user_id" value="reviewUserId">
			<input type="hidden" name="user_id" id="user_id" value="${userId}">
			<br> <span class="hide" id="popup-review-id"></span>
			<!-- 리뷰 ID가 들어갈 부분 -->
			<button class="report-link" id="reportButton" style="display: none;" data-oper="report">신고</button>
			<button id="modifyButton" style="display: none;" data-oper="modify" class="report-link">수정</button>
			<button id="deleteButton" style="display: none;;" data-oper="remove" class="report-link">삭제</button>
		</div>
	</div>

	<!------------------------------------------------------------임준헌 수정----------------------------------------------->

	<!-- 푸터 -->
	<div id="footer">
		<div id="footer-top">
			<div class="inner-wrap">
				<ul id="fnb">
					<li><a href="#" title="">회사소개</a></li>
					<li><a href="#" title="">인재채용</a></li>
					<li><a href="#" title="">사회공헌</a></li>
					<li><a href="#" title="">제휴/광고/부대사업문의</a></li>
					<li><a href="#" title="">이용약관</a></li>
					<li class="privacy"><a href="#" title="">위치기반서비스 이용약관</a></li>
					<li class="privacy"><a href="#" title="">개인정보처리방침</a></li>
					<li><a href="#" title="">운리경영</a></li>
				</ul>
				<a href="#layer_looking_theater" class="btn-looking-theater" title="극장찾기">
					<i class="iconset ico-footer-search"></i> 극장찾기
				</a>
			</div>
		</div>

		<div id="footer-bottom">
			<div class="inner-wrap">
				<div id="footer-img">
					<img src="/resources/img/logo/footer1.png" alt="logo">
				</div>
				<div id="footer-info">
					<div>
						<address>대한민국 경기도 수원시 (어딘가)</address>
						<p>ARS 1544-xxxx 대표이메일 qwer@naver.com</p>
					</div>
					<p>대표자명 이무기</p>
					<p>ㆍ 개인정보보호책임자 홍길동</p>
					<p>ㆍ 사업자등록번호 xxx-xx-xxxxx</p>
					<p>ㆍ 통신판매업신고번호 xxxx-수원-xxxx</p>
					<p class="copy">COPYRIGHT © Drive-In Theater, All rights reserved</p>
				</div>
				<div id="footer-sns">
					<a href="https://www.youtube.com/" target="_blank" title="유튜브 페이지로 이동">
						<i class="iconset ico-youtubeN">유튜브</i>
					</a>
					<a href="http://instagram.com/" target="_blank" title="인스타그램 페이지로 이동">
						<i class="iconset ico-instagramN">인스타그램</i>
					</a>
					<a href="https://www.facebook.com/" target="_blank" title="페이스북 페이지로 이동">
						<i class="iconset ico-facebookN">페이스북</i>
					</a>
					<a href="https://twitter.com/" target="_blank" title="트위터 페이지로 이동">
						<i class="iconset ico-twitterN">트위터</i>
					</a>
				</div>
			</div>
		</div>
	</div>
	<!-- 푸터 -->



	<script src="../resources/js/sub.js"></script>
	<script src="../resources/js/userAgeCheck.js"></script>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>




	<!------------------------------------------------------------임준헌 수정----------------------------------------------->
	<script type="text/javascript">
	// 리뷰 제출 처리
	function submitReview() {
		var userId = document.getElementById('user_id').value;
		var userName = document.getElementById('user_name').value;
	    var movieId = document.getElementById('movie_id').value;
	    var movieName = document.getElementById('"movie_name"').value;
	    var rating = document.getElementById('review_rating').value;
	    var reviewText = document.getElementById('review_text').value;

	    // 빈 필드 체크
	    if (!userName || !rating || !reviewText) {
	        alert('모든 필드를 작성해주세요.');
	        return;
	    }
	
	    rating = parseInt(rating, 10); // rating을 정수로 변환

	    if (isNaN(rating) || rating < 1 || rating > 10) {
	        alert('평점은 1과 10 사이의 숫자여야 합니다.');
	        return;
	    }
	    
	    // 리뷰 데이터 처리 (백엔드로 전송 등)
	    console.log('리뷰 제출됨:', { userName, rating, reviewText });
	    
	    document.getElementById('reviewForm').submit();

	    // 모달 닫기
	    closeModal();
	}
	
	


	</script>
	<!------------------------------------------------------------임준헌 수정----------------------------------------------->

</body>

</html>