<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@ include file="../../includes/adminHeader.jsp"%>

<div class="content">
	<div class="animated fadeIn">
		<!-- station -->
		<div class="row">
			<div class="col-lg-12">
				<div class="card">
					<div class="card-header">
						<strong class="card-title">최신 영화목록</strong>
					</div>

					<div class="card-body">
						<table class="table">
							<thead>
								<tr>
									<th scope="col" style="text-align: center;">제목</th>
									<th scope="col"style="text-align: center;">ID</th>
									<th scope="col"style="text-align: center;">연령제한 등급</th>
									<th scope="col"style="text-align: center;">액션</th>
								</tr>
							</thead>
							<tbody id="movie-list">
								<!-- JavaScript에서 데이터를 여기에 렌더링 -->
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>


</div>
</body>

<%@ include file="../../includes/adminFooter.jsp"%>

<script type="text/javascript" src="/resources/script/adminMovies.js"></script>
<script>
        // 페이지 로드 시 영화 데이터를 가져오는 함수 호출
        document.addEventListener("DOMContentLoaded", () => {
            fetchMovies();
        });
    </script>
</body>
</html>
