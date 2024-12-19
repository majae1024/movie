<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="/resources/css/popupstyle.css">
</head>
<body>
      <h2>공지사항</h2>
    <div class="popup-body">
        <ul>
            <c:forEach items="${sessionScope.notices}" var="notice">
                <li>${notice.NOTICE_TEXT}</li></br>
            </c:forEach>
        </ul>
    </div>
</body>
</html>