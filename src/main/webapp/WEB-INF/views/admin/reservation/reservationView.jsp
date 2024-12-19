<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ include file="../../includes/adminHeader.jsp" %>


<div class="content">
	<div class="animated fadeIn">
		<div class="container">
			<div class="noticeWrite form">
				<div class="card">
                            <div class="card-header">
                                <strong>예매 상세보기</strong>
                            </div>
                            <form action="/admin/reservationDelete" method="post" class="form-horizontal">
                            	<sec:csrfInput/>
                            
                            <div class="card-body card-block">
                                	
                                    <div class="row form-group">
                                        <div class="col col-md-3"><label for="rno" class=" form-control-label">예매번호</label></div>
                                        <div class="col-12 col-md-9"><input type="text" id="rno" name="rno" readonly  class="form-control" value="${reservation.rno }"></div>
                                    </div>
                                    <div class="row form-group">
                                        <div class="col col-md-3"><label for="user_id" class=" form-control-label">아이디</label></div>
                                        <div class="col-12 col-md-9"><input type="text" id="user_id" name="user_id" readonly  class="form-control" value="${reservation.user_id }"></div>
                                    </div>
                                    <div class="row form-group">
                                        <div class="col col-md-3"><label for="user_name" class=" form-control-label">이름</label></div>
                                        <div class="col-12 col-md-9"><input type="text" id="user_name" name="user_name" readonly  class="form-control" value="${reservation.user_name }"></div>
                                    </div>
                                    <div class="row form-group">
                                        <div class="col col-md-3"><label for="movie_name" class="form-control-label">영화이름</label></div>
                                        <div class="col-12 col-md-9"><input type="text" id="movie_name" name="movie_name" readonly class="form-control" value="${reservation.movie_name }"></div>
                                    </div>
                                    <div class="row form-group">
                                        <div class="col col-md-3"><label for="seat_row seat_num" class=" form-control-label">내용</label></div>
                                        <div class="col-12 col-md-9"><input type="text" id="seat_info" name="seat_info" readonly  class="form-control" value="${reservation.seat_info }"></div>
                                    </div>
                                    <div class="row form-group">
                                        <div class="col col-md-3"><label for="price" class=" form-control-label">가격</label></div>
                                        <div class="col-12 col-md-9"><input type="text" id="price" name="price" readonly value="${reservation.price}" class="form-control"></div>
                                    </div>
                                    
                                    
                                    
                                
                            </div>
                            <div class="card-footer">
                                
                                <button type="submit" class="btn btn-danger btn-sm" onclick="return adminDeleteCheck()">
                                    <i class="fa fa-ban"></i> Delete
                                </button>
                                <button type="button" class="btn btn-info btn-sm" data-oper="reservation" onclick="location.href='/admin/reservationList'">
                                    <i class="fa fa-list-alt"></i> List
                                </button>
                            </div>
                            </form>
                        </div>
                        <form id='operForm' action="/admin/reservationModify" method='get'>
							<input type='hidden' name='pageNum' value='${cri.pageNum}'>
							<input type='hidden' name='amount' value='${cri.amount}'>
						</form>
			</div>
		</div>
	</div>
</div>


<%@ include file="../../includes/adminFooter.jsp" %>
<script type="text/javascript" src="/resources/script/admin.js"></script>
<script type="text/javascript">
$(document).ready(function() {
  var operForm = $("#operForm"); 
  
    
  $("button[data-oper='list']").on("click", function(e){
    
    operForm.attr("action","/admin/reservationList")
    operForm.submit();
    
  });  
});
</script>
</body>
</html>