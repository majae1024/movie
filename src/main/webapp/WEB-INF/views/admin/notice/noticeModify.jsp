<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ include file="../../includes/adminHeader.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="content">
	<div class="animated fadeIn">
		<div class="container">
			<div class="noticeWrite form">
				<div class="card">
					<div class="card-header">
						<strong>공지사항 수정</strong>
					</div>
					<form action="/admin/noticeModify" method="post" class="form-horizontal" name="frm">
						<sec:csrfInput />
						<input type='hidden' name='pageNum' value='${cri.pageNum}'>
						<input type='hidden' name='amount' value='${cri.amount}'>
						<input type='hidden' name='nno' value='${vo.nno }'>
						<div class="card-body card-block">
							<div class="row form-group">
								<div class="col col-md-3">
									<label class=" form-control-label">공지사항 번호</label>
								</div>
								<div class="col-12 col-md-9">
									<p class="form-control-static">${vo.nno }</p>
								</div>
							</div>

							<div class="row form-group">
								<div class="col col-md-3">
									<label for="title" class=" form-control-label">제목</label>
								</div>
								<div class="col-12 col-md-9">
									<input type="text" id="title" name="title" placeholder="공지사항 제목을 입력하세요"
										class="form-control" value="${vo.title }">
								</div>
							</div>

							<div class="row form-group">
								<div class="col col-md-3">
									<label for="writer" class="form-control-label">작성자</label>
								</div>
								<div class="col-12 col-md-9">
									<input type="text" id="user_name" name="user_name" readonly class="form-control"
										value="${vo.user_name }">
								</div>
							</div>
							<div class="row form-group">
								<div class="col col-md-3">
									<label for="show_notice" class="form-control-label">공개여부</label>
									<select name="show_notice">
										<option value="0" ${vo.show_notice == 0 ? 'selected' : ''}>비공개</option>
										<option value="1" ${vo.show_notice == 1 ? 'selected' : ''}>공개</option>
									</select>
								</div>
							</div>
							<div class="row form-group">
								<div class="col col-md-3">
									<label for="content" class=" form-control-label">내용</label>
								</div>
								<div class="col-12 col-md-9">
									<textarea name="notice_text" id="content" rows="9" placeholder="공지사항 내용을 입력하세요"
										class="form-control">${vo.notice_text }</textarea>
								</div>
							</div>



						</div>
						<div class="card-footer">
							<button type="submit" class="btn btn-primary btn-sm" onclick="return adminBoardCheck()">
								<i class="fa fa-pencil"></i> Modify
							</button>
							<button type="reset" class="btn btn-danger btn-sm">
								<i class="fa fa-ban"></i> reset
							</button>
							<button type="button" class="btn btn-info btn-sm" onclick="location.href='/admin/noticeList'">
								<i class="fa fa-list-alt"></i> List
							</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>


<%@ include file="../../includes/adminFooter.jsp"%>
<script type="text/javascript" src="/resources/script/admin.js"></script>
</body>
</html>