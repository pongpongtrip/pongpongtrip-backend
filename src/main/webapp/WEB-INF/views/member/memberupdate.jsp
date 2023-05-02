<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<%@ include file="../head.jsp" %>
</head>
<body>
<%@ include file="../header.jsp" %>
<c:set value="${pageContext.request.contextPath}" var="root"></c:set>
<c:if test="${not empty alert}">
  	<script>
  		var msg = "${alert}";
  		alert(msg);
  	</script>
</c:if>
<main id="main"class="pt-5">
<div class="container mt-5">
  <h2>회원정보</h2>
  <form id="form-memberupdate" action="" method="POST"> <!-- form 시작 -->
    <div class="mb-3 mt-3">
      <label for="user_id">사용자 아이디:</label>
      <input type="text" class="form-control" id="user_id" name="userId" value="${memberinfo.userId}" readonly="readonly">
    </div>
    <div class="mb-3 mt-3">
      <label for="user_name">사용자 이름:</label>
      <input type="text" class="form-control" id="user_name" name="userName" value="${memberinfo.userName}">
    </div>
    <div class="mb-3">
      <label for="user_password">사용자 패스워드:</label>
      <input type="text" class="form-control" id="user_password" name="userPassword" value="${memberinfo.userPassword}">
    </div>
    <div class="mb-3">
      <label for="password_check">패스워드 확인:</label>
      <input type="text" class="form-control" id="password_check" value="${memberinfo.userPassword}">
    </div>
    <div class="mb-3">
      <label for="password_check">가입 일 :</label>
      <input type="text" class="form-control" id="user_joindate" value="${memberinfo.joinDate}" readonly="readonly">
    </div>
    <button type="button" id="btn-memberupdate" class="btn btn-primary me-1">수정하기</button>
    <a class="btn btn-outline-danger" href="${root}/member/member-info">뒤로가기</a>
  </form>
</div>
</main>
<!-- <a href='./board?action=boardlist'>글목록 </a>
<a href='./board?action=boardwrite'>글쓰기 </a> -->
<script>
	document.querySelector("#btn-memberupdate").addEventListener("click", function () {
	    if (!document.querySelector("#user_name").value) {
	    	alert("이름 입력!!");
	      	return;
	    } else if (!document.querySelector("#user_password").value) {
	      	alert("비밀번호 입력!!");
	      	return;
	    } else if (document.querySelector("#user_password").value != document.querySelector("#password_check").value) {
	      	alert("비밀번호 확인!!");
	      	return;
	    } else {
	      	let form = document.querySelector("#form-memberupdate");
	      	form.setAttribute("action", "${root}/member/update");
	      	form.submit();
	    }
	});
</script>
</body>

</html>