<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../../includes/adminHeader.jsp"%>


<div class="content">
	<div class="animated fadeIn">
		<div class="container">
			<div class="noticeWrite form">
				<div class="card">
					<div class="card-header">
						<strong>회원 상세보기</strong>
               </div>
               <form action="/admin/usersDelete" method="post" class="form-horizontal">
                  <sec:csrfInput />

                  <div class="card-body card-block">

                     <div class="row form-group">
                        <div class="col col-md-3">
                           <label for="uno" class=" form-control-label">회원번호</label>
                        </div>
                        <div class="col-12 col-md-9">
                           <input type="text" id="uno" name="uno" readonly class="form-control" value="${user.uno }">
                        </div>
                     </div>
                     <div class="row form-group">
                        <div class="col col-md-3">
                           <label for="id" class=" form-control-label">아이디</label>
                        </div>
                        <div class="col-12 col-md-9">
                           <input type="text" id="id" name="id" readonly class="form-control" value="${user.user_id }">
                        </div>
                     </div>
                     <div class="row form-group">
                        <div class="col col-md-3">
                           <label for="name" class="form-control-label">이름</label>
                        </div>
                        <div class="col-12 col-md-9">
                           <input type="text" id="name" name="name" readonly class="form-control" value="${user.user_name }">
                        </div>
                     </div>
                     <div class="row form-group">
                        <div class="col col-md-3">
                           <label for="phone" class=" form-control-label">생년월일</label>
                        </div>
                        <div class="col-12 col-md-9">
                           <input type="text" id="phone" name="phone" readonly class="form-control" value="${user.birth }">
                        </div>
                     </div>
                     <div class="row form-group">
                        <div class="col col-md-3">
                           <label for="regDate" class=" form-control-label">등록일</label>
                        </div>
                        <div class="col-12 col-md-9">
                           <input type="text" id="regDate" name="regDate" readonly value='<fmt:formatDate value='${user.regdate }' pattern='yyyy-MM-dd'/>' class="form-control">

                        </div>
                     </div>

                        <input type='hidden' name='pageNum' value='${cri.pageNum}'>
                        <input type='hidden' name='amount' value='${cri.amount}'>
                        <input type='hidden' name='type' value='${cri.type}'>
                        <input type='hidden' name='keyword' value='${cri.keyword}'>


                  </div>
                  <div class="card-footer">

							<button type="submit" class="btn btn-danger btn-sm" data-oper="delete" onclick="return adminDeleteCheck()">
								<i class="fa fa-ban"></i> Delete
							</button>
							<button type="button" class="btn btn-info btn-sm" data-oper="list" onclick="location.href='/admin/usersList'">
								<i class="fa fa-list-alt"></i> List
							</button>
						</div>
					</form>
				</div>
				<form id='operForm' action="/admin/usersList" method='get'>
					<input type='hidden' name='pageNum' value='${cri.pageNum}'>
					<input type='hidden' name='amount' value='${cri.amount}'>
					<input type='hidden' name='type' value='${cri.type}'>
					<input type='hidden' name='keyword' value='${cri.keyword}'>
				</form>
			</div>
		</div>
	</div>
</div>


<%@ include file="../../includes/adminFooter.jsp"%>
<script type="text/javascript" src="/resources/script/admin.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		var operForm = $("#operForm");

		$("button[data-oper='list']").on("click", function(e) {

			operForm.attr("action", "/admin/usersList")
			operForm.submit();

		});
		
	});
</script>
</body>
</html>