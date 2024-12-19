<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../../includes/adminHeader.jsp"%>

<div class="content">
	<div class="animated fadeIn">
		<!-- station -->
		<div class="row">
			<div class="col-lg-12">
				<div class="card">
					<div class="card-header">
						<strong class="card-title">예약 목록</strong>
					</div>
					<div class="card-body">
						<table class="table">
							<thead>
								<tr>
									<th scope="col">예매번호</th>
									<th scope="col">아이디</th>
									<th scope="col">이름</th>
									<th scope="col">영화이름</th>
									<th scope="col">좌석</th>
									<th scope="col">가격</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${reservationList }" var="reservation">
									<tr>
										<th scope="row">${reservation.rno }</th>
										<td><a class="move" href="${reservation.rno}">${reservation.user_id }</a></td>
										<td>${reservation.user_name}</td>
										<td>${reservation.movie_name }</td>
										<td>${reservation.seat_info }</td>
										<td>${reservation.price }</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						
						<!-- 검색조건 -->
				<div class='row'>
					<div class="col-lg-12">

						<form id='searchForm' action="/admin/reservationList" method='get'>
							<select name='type'>
								<option value="" <c:out value="${pageMaker.cri.type == null?'selected':''}"/>>--</option>
								<!-- Search버튼을 통해 넘어온 옵션값이 뭔지에 따라서 미리 선택해서 보여주는 삼항조건 연산자 -->
								<option value="I" <c:out value="${pageMaker.cri.type eq 'I'?'selected':''}"/>>이름</option>
								<option value="N" <c:out value="${pageMaker.cri.type eq 'N'?'selected':''}"/>>영화이름</option>
								<option value="IN" <c:out value="${pageMaker.cri.type eq 'IN'?'selected':''}"/>>이름 or 영화이름</option>
							</select>
							<input type='text' name='keyword' value='<c:out value="${pageMaker.cri.keyword}"/>' />
							<!-- 검색한 내용을 벨류값으로 표시 -->
							<input type="hidden" name='pageNum' value='<c:out value="${pageMaker.cri.pageNum}"/>' />
							<input type="hidden" name='amount' value='<c:out value="${pageMaker.cri.amount}"/>' />
							<button class='btn btn-default'>Search</button>
						</form>
					</div>
				</div>
				<!-- end 검색조건 -->
						
						
						<!-- paging -->
						<div class="container">
							<ul class="pagination">
								<c:if test="${pageMaker.prev }">
									<li class="paginate_button"><a class="page-link" href="${pageMaker.startPage - 1}">Previous</a></li>
								</c:if>
								
								<c:forEach var="num" begin="${pageMaker.startPage }" end="${pageMaker.endPage }">
									<li class="paginate_button ${pageMaker.cri.pageNum == num ? 'active' : '' }"><a class="page-link" href="${num}">${num }</a></li>
								</c:forEach>								
								
								<c:if test="${pageMaker.next }">
									<li class="paginate_button"><a class="page-link" href="${pageMaker.endPage + 1}">Next</a></li>
								</c:if>
							</ul>
						</div>
						<!-- /paging -->
						<form id='actionForm' action="/admin/reservationView" method='get'>
							<input type='hidden' name='pageNum' value='${pageMaker.cri.pageNum}'>
							<input type='hidden' name='amount' value='${pageMaker.cri.amount}'>
						</form>
						<div>${message }</div>
					</div>
				</div>
			</div>
		</div>
		<!-- /station -->

	</div>
</div>

<%@ include file="../../includes/adminFooter.jsp"%>

<script>
$(document).ready(function(){		
	var actionForm = $("#actionForm");
	
	$(".page-link").on("click", function(e){
		e.preventDefault();
		console.log("click");
					
		actionForm.find("input[name='pageNum']").val($(this).attr("href"));
		actionForm.attr("action", "/admin/reservationList");
		actionForm.submit();	
	});
	
	
	$(".move").on("click", function(e) {
		e.preventDefault(); // 기본 이벤트(페이지 이동)를 막음
		actionForm.append("<input type='hidden' name='rno' value='" + $(this).attr("href") + "'>");
		actionForm.attr("action","/admin/reservationView");
		actionForm.submit();
	});
	
	var searchForm = $("#searchForm");

	$("#searchForm button").on("click", function(e) {
		if (!searchForm.find("option:selected").val()) {
			alert("검색종류를 선택하세요");
			return false;
		}

		if (!searchForm.find("input[name='keyword']").val()) {
			alert("키워드를 입력하세요");
			return false;
		}
		searchForm.find("input[name='pageNum']").val("1");
		e.preventDefault();

		searchForm.submit();

	});
});


</script>
</body>
</html>