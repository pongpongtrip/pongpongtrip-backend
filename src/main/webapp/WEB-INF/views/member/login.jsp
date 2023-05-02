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

<main id="main" class="pt-5">
<div class="container mt-5">
  <h2>로그인</h2>
  <form id="form-login" action="" method="POST">
    <div class="form-check mb-3 float-end">
	    <input
	      class="form-check-input"
	      type="checkbox"
	      value="ok"
	      id="saveid"
	      name="saveid"
	      ${idck}
	    />
		<label class="form-check-label" for="saveid"> 아이디저장 </label>
    </div>
    <div class="mb-3 mt-3">
      <label for="user_id">사용자 아이디:</label>
      <input type="text" class="form-control" id="user_id" placeholder="아이디 입력" name="userId">
    </div>
    <div class="mb-3">
      <label for="user_password">사용자 패스워드:</label>
      <input type="password" class="form-control" id="user_password" placeholder="패스워드입력" name="userPassword">
    </div>
    <button type="button" id="btn-login" class="btn btn-primary me-1">로그인</button>
    <a class="btn btn-outline-danger" href="${root}/member/regist">회원가입</a>
  	
  </form>
</div>
</main>
<c:if test="${not empty alert}">
  	<script>
  		var msg = "${alert}";
  		alert(msg);
  	</script>
</c:if>
<script>
	document.querySelector("#btn-login").addEventListener("click", function () {
        if (!document.querySelector("#user_id").value) {
          alert("아이디 입력!!");
          return;
        } else if (!document.querySelector("#user_password").value) {
          alert("비밀번호 입력!!");
          return;
        } else {
          let form = document.querySelector("#form-login");
          form.setAttribute("action", "${root}/member/login");
          form.submit();
        }
      });
</script>
</body>
</html>