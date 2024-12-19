<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>영화 어때</title>

<link rel="stylesheet" href="/resources/css/main.css" />
<link rel="stylesheet" href="/resources/css/reset.css" />
<link rel="stylesheet" href="/resources/css/common.css" />
<!-- CSRF 토큰 메타 태그 -->
<meta name="_csrf" content="${_csrf.token}">
<!-- CSRF 토큰 값 -->
<meta name="_csrf_header" content="${_csrf.headerName}">
<!-- CSRF 헤더 이름 -->
<script src="https://code.jquery.com/jquery-3.6.4.js" integrity="sha256-a9jBBRygX1Bh5lt8GZjXDzyOB+bWve9EiO7tROUtj/E=" crossorigin="anonymous"></script>
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
						<img src="/resources/img/logo/main.PNG" alt="" />
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
						<li><a href="#" class="gnb-txt-movie" title="영화">영화</a></li>
						<li><a href="#" class="gnb-txt-reserve" title="예매">예매</a></li>
						<li><a href="#" class="gnb-txt-theater" title="극장">극장</a></li>
						<li><a href="#" class="gnb-txt-event" title="이벤트">이벤트</a></li>
						<li><a href="#" class="gnb-txt-store" title="스토어">스토어</a></li>
						<li><a href="#" class="gnb-txt-benefit" title="혜택">혜택</a></li>
					</ul>
				</div>
			</div>
		</header>

		<!-- 섹션 -->
		<div id="main-section">
			<div id="bg">
				<img src="https://img.megabox.co.kr/SharedImg/2024/10/07/SQHSlSEbLyxi4aR8B8YPZn44BkUJppwK_380.jpg" alt="4Uwtw3qPGJcWXB18umiryeHVdZV8wqTl.jpg" onerror="noImg(this, 'main');" />
			</div>

			<div id="cont-area">
				<div id="tab-sorting">
					<button type="button" class="on" sort="boxoRankList" name="btnSort">상영중</button>
				</div>

				<a href="/movie/more" class="more-movie" title="더 많은 영화보기">
					더 많은 영화보기 <i class="iconset ico-more-corss gray"></i>
				</a>

				<!-- 포스터 -->
				<div class="main-movie-list">
					<ol class="list">
						<li class="poster"></li>
						<li class="poster"></li>
						<li class="poster"></li>
						<li class="poster"></li>
					</ol>
				</div>
								<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
				<!-- 검색창과 검색버튼 -->
				<div class="search">
					<div class="cell cell1">
						<div class="search_bar">
							<input type="text" placeholder="영화명을 입력해 주세요" class="search_text" />
							<button class="search_btn">
								<img src="/resources/img/section/search/ico-search.png" alt="ico-search" />
							</button>
						</div>
					</div>
					<div class="cell">
						<a href="#">
							<img src="/resources/img/section/search/ico-schedule.png" title="상영시간표" /> 상영시간표
						</a>
					</div>
					<div class="cell">
						<a href="#">
							<img src="/resources/img/section/search/ico-boxoffice.png" title="박스오피스" /> 박스오피스
						</a>
					</div>
					<div class="cell">
						<a href="#">
							<img src="/resources/img/section/search/ico-quick-reserve.png" title="빠른예매" /> 빠른예매
						</a>
					</div>
				</div>
			</div>
		</div>
		<!-- /section -->
	</div>
	<!-- /body-wrap -->
	<!-----------------------------------------------
	 -
	 -                    수정함
	 -
	 -->
	<script type="text/javascript" src="/resources/js/mainMovies.js"></script>
	<!-- 
	-
	-
	-
	-
	---------------------------------------------- -->
</body>
</html>
