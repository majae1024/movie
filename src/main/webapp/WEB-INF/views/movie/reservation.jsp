<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>영화 어때</title>


<link rel="stylesheet" href="../resources/css/reset.css">
<link rel="stylesheet" href="../resources/css/reservation.css" />



<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>


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
						<img src="../resources/img/logo/logo.png" alt="">
					</a>
				</div>

				<div id="util-right-area">
					<div id="right-link">
						<c:choose>
							<c:when test="${isAuthenticated}">
								<a href="/movie/mypage">안녕하세요! ${userName} 님</a>
								<form action="/user/customLogout" method="POST" class="login_form"style="display: inline;">
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
						<span class="title">${movie.movieNm}</span> <span class="age" style="font-size: 18px; color: #white; font-weight: bold;">-${movie.certification }-</span>
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
										        	<c:when test="${movie.certification == '전체이용가'}">all</c:when>
										        	<c:when test="${movie.certification == '12세이용가'}">age12</c:when>
										        	<c:when test="${movie.certification == '15세이용가'}">age15</c:when>
										        	<c:when test="${movie.certification == '19세이용가'}">age19</c:when>
										        	<c:otherwise>unknown</c:otherwise>
										    	</c:choose>">
						</p>
						<img src="${movie.imgSrc }" alt="위키드">
					</div>
				</div>
				<!------------------------------------------------------------마재원 수정 끝----------------------------------------------->
				<!------------------------------------------------------------마재원 수정 끝----------------------------------------------->
				<!------------------------------------------------------------마재원 수정 끝----------------------------------------------->

			</div>
		</div>
	</div>
	<!-- /body-wrap -->

	<div id="wrap">


		<div id="table-wrap">

			<div id="body-frame">
				<h2>좌석 선택</h2>

				<!-- 차량크기 -->
				<h3>차량 크기선택</h3>
				<div id="viewer-selection">
					<label><input type="radio" name="viewer-size" value="small" /> 소형</label> <label><input type="radio" name="viewer-size" value="medium" /> 중형</label> <label><input type="radio"
							name="viewer-size" value="large" /> 준대형/대형</label>
					<button id="reset-button">리셋</button>
				</div>


				
				

				<!-- 좌석 선택 -->
				<div class="container">
					<h1>SCREEN</h1>
					<div class="screen"></div>
					<div class="seating-area" id="seating-area">
						<div class="row" data-row-index="1">
							<div class="row-label">A</div>
							<button class="seat" id="A1">1</button>
							<button class="seat" id="A2">2</button>
							<button class="seat" id="A3">3</button>
							<button class="seat" id="A4">4</button>
							<button class="seat" id="A5">5</button>
							<button class="seat" id="A6">6</button>
							<button class="seat" id="A7">7</button>
							<button class="seat" id="A8">8</button>
							<button class="seat" id="A9">9</button>
							<button class="seat" id="A10">10</button>
						</div>
						<div class="row" data-row-index="2">
							<div class="row-label">B</div>
							<button class="seat" id="B1">1</button>
							<button class="seat" id="B2">2</button>
							<button class="seat" id="B3">3</button>
							<button class="seat" id="B4">4</button>
							<button class="seat" id="B5">5</button>
							<button class="seat" id="B6">6</button>
							<button class="seat" id="B7">7</button>
							<button class="seat" id="B8">8</button>
							<button class="seat" id="B9">9</button>
							<button class="seat" id="B10">10</button>
						</div>
						<div class="row" data-row-index="3">
							<div class="row-label">C</div>
							<button class="seat" id="C1">1</button>
							<button class="seat" id="C2">2</button>
							<button class="seat" id="C3">3</button>
							<button class="seat" id="C4">4</button>
							<button class="seat" id="C5">5</button>
							<button class="seat" id="C6">6</button>
							<button class="seat" id="C7">7</button>
							<button class="seat" id="C8">8</button>
							<button class="seat" id="C1">9</button>
							<button class="seat" id="C10">10</button>
						</div>
						<div class="row" data-row-index="4">
							<div class="row-label">D</div>
							<button class="seat" id="D1">1</button>
							<button class="seat" id="D2">2</button>
							<button class="seat" id="D3">3</button>
							<button class="seat" id="D4">4</button>
							<button class="seat" id="D5">5</button>
							<button class="seat" id="D6">6</button>
							<button class="seat" id="D7">7</button>
							<button class="seat" id="D8">8</button>
							<button class="seat" id="D9">9</button>
							<button class="seat" id="D10">10</button>
						</div>
						<div class="row" data-row-index="5">
							<div class="row-label">E</div>
							<button class="seat" id="E1">1</button>
							<button class="seat" id="E2">2</button>
							<button class="seat" id="E3">3</button>
							<button class="seat" id="E4">4</button>
							<button class="seat" id="E5">5</button>
							<button class="seat" id="E6">6</button>
							<button class="seat" id="E7">7</button>
							<button class="seat" id="E8">8</button>
							<button class="seat" id="E9">9</button>
							<button class="seat" id="E10">10</button>
						</div>
						<div class="row" data-row-index="6">
							<div class="row-label">F</div>
							<button class="seat" id="F1">1</button>
							<button class="seat" id="F2">2</button>
							<button class="seat" id="F3">3</button>
							<button class="seat" id="F4">4</button>
							<button class="seat" id="F5">5</button>
							<button class="seat" id="F6">6</button>
							<button class="seat" id="F7">7</button>
							<button class="seat" id="F8">8</button>
							<button class="seat" id="F9">9</button>
							<button class="seat" id="F10">10</button>
						</div>
					</div>
				</div>
			</div>
			<div class="info">
				<p>
					<span style="color: purple">■</span> 선택
				</p>
				<p>
					<span style="color: RGB(096, 000, 185)">■</span> 예매완료
				</p>
			
				<p>
					<span style="color: #747474">■</span> 일반
				</p>
			</div>
			<div class="preview" id="preview">
				<p>
					선택된 좌석: <span id="preview-seats">없음</span>
				</p>
				<p>
					총 금액: <span id="preview-price">0</span>
				</p>
			</div>


			<form method="POST" action="/movie/reservate">
				<input type="hidden"  id="movieId" name="movie_id" value="${movie.movieId}" >
				<input type="hidden" id="imgSrc" name="movie_img" value="${movie.imgSrc}" >
				<input type="hidden" id="movieNm" name="movie_name" value="${movie.movieNm}" >
				<input type="hidden" id="userName" name="user_name" value="${userName}" >
				<input type="hidden" id="userId" name="user_id" value="${userId}" >

				<!-- 좌석과 가격 -->
				<input type="hidden" id="seatInfo" name="seat_info" value="" >
				<input type="hidden" id="price" name="price" value="" >
				
				<!-- 보안토큰 -->
				<sec:csrfInput />
				<button style="margin: 0 0 0 250px; font-weight: 700; font-size: 1.2em; color: #fff; border: none; background-color: #59bec9; border-radius: 5px; width: 260px; height: 46px;" type="submit">예매하기</button>
			</form>
		</div>




	</div>


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
					<img src="../resources/img/logo/footer1.png" alt="logo" />
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
	
	<script type="text/javascript">
    	const reservedSeats = JSON.parse('${reserv}'); // 서버에서 전달된 예매된 좌석 정보
    	console.log(reservedSeats); // 콘솔에서 예매된 좌석 정보 확인
	</script>
	<script src="/resources/js/reserve.js"></script>
	
	
</body>
</html>