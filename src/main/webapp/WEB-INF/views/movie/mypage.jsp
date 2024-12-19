<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>영화어때-마이페이지</title>
<link rel="stylesheet" href="../resources/css/sub_common.css" />
<link rel="stylesheet" href="../resources/css/mypage.css" />
<link rel="stylesheet" href="../resources/css/reset.css" />
<meta name="_csrf" content="${_csrf.token}">
<meta name="_csrf_header" content="${_csrf.headerName}">

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
						<img src="../resources/img/logo/sub1.png" alt="">
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
						<li><a href="/movie/more" class="gnb-txt-movie" title="영화">영화</a></li>
						<li><a href="/booking" class="gnb-txt-reserve" title="예매">예매</a></li>
						<li><a href="/theater/list" class="gnb-txt-theater" title="극장">극장</a></li>
						<li><a href="/event" class="gnb-txt-event" title="이벤트">이벤트</a></li>
						<li><a href="/store" class="gnb-txt-store" title="스토어">스토어</a></li>
						<li><a href="/benefit/membership" class="gnb-txt-benefit" title="혜택">혜택</a></li>
					</ul>
				</div>
		</header>

		<div class="snb" style="padding-top: 150px;">
			<div class="inner">
				<ul class="m5">
					<li><a href="javascript:void(0);" class="active">예매/취소 내역</a></li>
					<li><a href="javascript:goLink('about:blank');">지난관람내역</a></li>
					<li><a href="javascript:goLink('about:blank');">영화할인</a></li>
					<li><a href="javascript:goLink('about:blank');">1:1문의</a></li>
					<li><a href="javascript:goLink('about:blank');">회원정보수정</a></li>
				</ul>
			</div>
		</div>

		<div class="content">
			<div class="inner">
				<div class="tabs1">
					<a href="javascript:void(0);" class="active">예매내역</a>
				</div>

				<div class="step">
					<div class="raser-desc1">
						<strong class="blue">${userName}</strong>님의 관람 가능 예매내역이 <strong class="blue">${membercountReservation}</strong>건 있습니다.
					</div>
					<div class="raser-desc2">
						- 6개월이내 예매 내역만 확인 가능합니다.<br />- 관람당일 매표소 및 무인발권기에서 예매번호로 티켓을 교환하세요.
					</div>

					<br> <br> <br> <br> <br> <br>

					<%-- 예매 내역이 있을 때 reservation-card, 없을 때 no-raser 출력 --%>
					<c:choose>
						<c:when test="${not empty reserve}">
							<c:forEach var="reserve" items="${reserve}">
								<div class="reservation-card">
									<table>
										<tr>
											<td rowspan="4" class="poster"><img src="${reserve.movie_img}" alt="Poster"></td>
											<td class="tname" id="tname"><strong>${reserve.movie_name}</strong></td>
										</tr>
										<tr>
											<td class="tname"><strong>예약자</strong></td>
											<td>: ${reserve.user_name}</td>
										</tr>
										<tr>
											<td class="tname"><strong>좌석</strong></td>
											<td>: ${reserve.seat_info}</td>
										</tr>
										<tr>
											<td class="tname"><strong>가격</strong></td>
											<td>: ${reserve.price}</td>
										</tr>
										<tr>
											<td colspan="3" class="buttons">
												<button class="cancel" id="canclebtn" data-oper="cancle">예약취소</button>
												<form id="payInfo" method="POST" action="/payment/ready">
													<input type="hidden" name="userId" value="${userId}">
													<input type="hidden" name="price" value="${reserve.price}">
													<input type="hidden" name="movieName" value="${reserve.movie_name}">
													<input type="hidden" name="quantity" value="1">
													<sec:csrfInput />
													<button type="submit" class="pay" id="paybtn" data-oper="pay">결제</button>
												</form>
											</td>
										</tr>
									</table>
									<input type="hidden" name="rno" id="rno" value="${reserve.rno}">
								</div>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<div class="no-raser">
								<img src="../resources/img/mypage/alert.jpg" alt="예매 내역 없음" />
								<p>예매내역이 없습니다.</p>
							</div>
						</c:otherwise>
					</c:choose>

					<br> <br> <br> <br> <br> <br>

					<h6 class="h6">예매하고 티켓 찾기</h6>
					<div class="description">
						<p>
							- 예매 완료 시 생성되는 <span class="red2">예매번호로 매표소 및 무인 발권기</span>에서 티켓을 수령할 수 있습니다.
						</p>
						<p>- 예고편 상영 등 극장 사정에 의해 영화시작이 10여분 차이 날 수 있습니다.</p>
						<p>* 19세 이상 관람가 영화는 보호자를 동반해도 만 19세 미만 고객은 관람이 불가합니다. 상영관 입장시, 신분증을 지참하시기 바랍니다.</p>
						<p>* 일부 극장은 상영시작 이후 입장이 제한될 수 있으니, 반드시 상영시작 시간 내에 발권 후 입장해 주세요.</p>
					</div>

					<h6 class="h6">예매를 취소하고 싶을 때</h6>
					<div class="description">
						<p>- 예매 취소는 각 극장별 취소가능시간까지만 가능합니다.</p>
						<p>- 고객센터 및 각 극장에 전화상으로 취소는 불가능하며 인터넷상에서 취소가 불가능한 경우 관람시간 전에 극장에 방문하시어 현장 취소하셔야 합니다.</p>
						<p>- 단, 극장에서 발권한 후에는 시간에 관계없이 인터넷상에서 취소는 불가하며 현장취소만 가능합니다.</p>
						<p>- 예매완료 후에는 부분취소나 시간 변동을 할 수 없습니다. 예매내역 전체를 취소한 후 재예매를 하셔야 합니다.</p>
						<p>- 예매 취소 완료 여부는 반드시 취소내역에서 확인하셔야 합니다.</p>
					</div>

					<h6 class="h6">극장 현장에서 취소 했을 때</h6>
					<div class="description">
						<p>- 극장 현장에서 취소하신 경우 취소 내역은 관람일 다음날 오전 중에 반영 됩니다.</p>
						<p>- 이 때 결제도 함께 취소되니 현장 취소시에 유의하시기 바랍니다.</p>
					</div>

					<h6 class="h6">환불규정</h6>
					<div class="description">
						<strong>온라인 영화 예매 후 취소가능시간 내에 취소하시면 전액 환불됩니다.</strong><br /> 1. 신용카드 : 결제일과 취소일이 다를 경우 영업일 기준 3~5일 소요됩니다.<br /> 2. 네이버페이 : 네이버페이 포인트를 사용하신 경우 포인트로 재적립 됩니다.<br /> 카드결제를 한 경우 카드사 정책에 따라 승인 취소가
						진행되며, 3일 이후 매입 취소 시 영업일 기준 3~10일 소요됩니다.<br /> 3. 카카오페이 : 카카오페이머니를 사용하신 경우 카카오페이머니 잔액으로 원복됩니다.<br /> 카드결제를 한 경우 카드사 정책에 따라 승인취소가 진행되며, 3일 이후 매입 취소 시 영업일 기준 3~10일 소요됩니다.<br /> 4. 페이코 : PAYCO
						포인트를 사용하신 경우 포인트로 재적립됩니다.<br /> 카드결제를 한 경우 카드사 정책에 따라 승인취소가 진행되며, 3일 이후 매입 취소 시 영업일 기준 3~10일 소요됩니다.<br /> <br /> <span class="red2">※ 예매내용을 변경할 때는, 취소가능시간 내에 취소하고 다시 예매해 주시기 바랍니다.<br />
							※ 예매내역은 12개월 이내 예매하신 내역만 제공됩니다.
						</span>
					</div>

					<div class="cs-bottom">
						<div class="tel">
							<img src="../resources/img/mypage/tel.jpg" alt="예매 문의 아이콘" />
							<dl>
								<dt>예매문의</dt>
								<dd>(031)8017-8332</dd>
							</dl>
						</div>
						<div class="time">
							평일 10:00 ~ 12:30, 13:30 ~ 18:00 / 주말 및 공휴일은 운영하지 않습니다.<br />전화예매 불가. 인터넷 및 모바일 예매 후 문의주세요.
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- body-warp -->

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
					<img src="../resources/img/logo/footer1.png" alt="logo">
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


	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="../resources/js/mypage.js"></script>
</body>

</html>
