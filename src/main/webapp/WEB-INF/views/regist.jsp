<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<%@ include file="head.jsp" %>
</head>
<body>
<%@ include file="header.jsp" %>
<c:set value="${pageContext.request.contextPath}" var="root"></c:set>
<c:if test="${not empty alert}">
  	<script>
  		var msg = "${alert}";
  		alert(msg);
  	</script>
</c:if>
<main id="main"class="pt-5">
<div class="container mt-5">
  <h2>회원가입</h2>
  <form action="${root }/member" method="post">
    <input type="hidden"  id="action" name="action" value="registaf">
    <div class="mb-3 mt-3">
      <label for="user_id">사용자 아이디:</label>
      <input type="text" class="form-control" id="user_id" placeholder="아이디 입력" name="user_id">
    </div>
    <div class="mb-3 mt-3">
      <label for="user_name">사용자 이름:</label>
      <input type="text" class="form-control" id="user_name" placeholder="이름 입력" name="user_name">
    </div>
    <div class="mb-3">
      <label for="user_password">사용자 패스워드:</label>
      <input type="password" class="form-control" id="user_password" placeholder="패스워드입력" name="user_password">
    </div>
    <button type="submit" class="btn btn-primary me-1">회원가입</button>
    <a class="btn btn-outline-danger" href="${root}/member?action=login">로그인</a>
  </form>
</div>
</main>
<!-- <a href='./board?action=boardlist'>글목록 </a>
<a href='./board?action=boardwrite'>글쓰기 </a> -->
</body>
</html>