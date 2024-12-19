<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>영화 어때</title>
<link rel="stylesheet" href="/resources/css/reset.css">
<link rel="stylesheet" href="/resources/css/common.css">
<link rel="stylesheet" href="/resources/css/login.css">

<link rel="stylesheet" href="https://unpkg.com/bootstrap@5.3.2/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="https://unpkg.com/bs-brain@2.0.3/components/registrations/registration-7/assets/css/registration-7.css">
</head>

<body>


	<div id="wrap">
		<div class="register">
			<!-- Registration 7 - Bootstrap Brain Component -->
			<section class="bg-light p-3 p-md-4 p-xl-5">
				<div class="container">
					<div class="row justify-content-center">
						<div class="col-12 col-md-9 col-lg-7 col-xl-6 col-xxl-5">
							<div class="card border border-light-subtle rounded-4">
								<div class="card-body p-3 p-md-4 p-xl-5">
									<div class="row">
										<div class="col-12">
											<div class="mb-5">
												<h2 class="h4 text-center">회원가입</h2>
											</div>
										</div>
									</div>
									<form action="/user/register" method="post" name="frm">
										<!-- 보안토큰 -->
										<sec:csrfInput />
										<div class="row gy-3 overflow-hidden">
											<div class="col-12">
												<div class="form-floating mb-3">
													<input type="text" class="form-control" name="user_id" id="user_id" placeholder="Enter id" required value="${user.kakaoEmail }">
													<label for="user_id" class="form-label">아이디</label>
													<input type="button" value="중복 확인" onclick="idCheck()">
													<input type="hidden" name="reid" id="reid" required="required">
												</div>
											</div>
											<div class="col-12">
												<div class="form-floating mb-3">
													<input type="text" class="form-control" name="user_name" id="user_name" placeholder="Enter Your Name" required readonly value="${user.nickname }">
													<label for="user_name" class="form-label">이름</label>
												</div>
											</div>
											<div class="col-12">
												<div class="form-floating mb-3">
													<input type="password" class="form-control" name="user_pw" id="user_pw" value="" placeholder="Password" required>
													<label for="user_pw" class="form-label">비밀번호</label>
												</div>
											</div>
											<div class="col-12">
												<div class="form-floating mb-3">
													<input type="password" class="form-control" name="password_check" id="password_check" value="" placeholder="Password Check" required>
													<label for="password_check" class="form-label">비밀번호 확인</label>
												</div>
											</div>
											<div class="col-12">
												<div class="form-floating mb-3">
													<input type="text" class="form-control" name="birth" id="birth" placeholder="주민번호 앞자리 6자리입력해주세요(ex:95xxxx)">
													<label for="birth" class="form-label">생년월일</label>
												</div>
											</div>

											<div class="col-12">
												<div class="d-grid">
													<button class="btn bsb-btn-xl btn-primary" type="submit" onclick="return registerCheck()">회 원 가 입</button>
												</div>
											</div>
										</div>
									</form>
									<div class="row">
										<div class="col-12">
											<hr class="mt-5 mb-4 border-secondary-subtle">
											<p class="m-0 text-secondary text-center">
												이미 계정이 있으신가요?
												<a href="/user/login" class="link-primary text-decoration-none">로그인</a>
											</p>
										</div>
									</div>

								</div>
							</div>
						</div>
					</div>
				</div>
			</section>

		</div>
	</div>




	<script type="text/javascript" src="/resources/script/users.js"></script>
	<script type="text/javascript">
		var terms = document.getElementById("register-terms");
		var url = terms.getAttribute("href");

		terms.addEventListener("click", function(e) {
			e.preventDefault();
			window.open(url, "", "width= 800px, height= 1000px")
		});
	</script>
</body>
</html>