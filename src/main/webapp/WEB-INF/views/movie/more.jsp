<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>영화 어때</title>

<link rel="stylesheet" href="/resources/css/more.css" />
<link rel="stylesheet" href="/resources/css/reset.css" />
<link rel="stylesheet" href="/resources/css/sub_common.css" />
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
						<img src="/resources/img/logo/sub1.png" alt="" />
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
		<div id="cont-area">
			<div class="main-movie-list">
				<ol class="list">
					<li class="poster"></li>
					<li class="poster"></li>
					<li class="poster"></li>
					<li class="poster"></li>
					<li class="poster"></li>
					<li class="poster"></li>
					<li class="poster"></li>
					<li class="poster"></li>
					<li class="poster"></li>
					<li class="poster"></li>
					<li class="poster"></li>
					<li class="poster"></li>
				</ol>
			</div>
		</div>
	</div>

	<!-- /section -->
	<!-- /body-wrap -->

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
					<img src="/resources/img/logo/footer1.png" alt="logo" />
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
	<script type="text/javascript" src="/resources/js/moreMovies.js"></script>

</body>
</html>
