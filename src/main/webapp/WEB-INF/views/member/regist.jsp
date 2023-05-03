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
  <h2>회원가입</h2>
  <form id="form-regist" action="" method="POST"> <!-- form 시작 -->
    <div class="mb-3 mt-3">
      <label for="user_id">사용자 아이디:</label>
      <input type="text" class="form-control" id="user_id" placeholder="아이디 입력" name="userId">
    </div>
    <div id="idcheck-result"></div>
    <div class="mb-3 mt-3">
      <label for="user_name">사용자 이름:</label>
      <input type="text" class="form-control" id="user_name" placeholder="이름 입력" name="userName">
    </div>
    <div class="mb-3">
      <label for="user_password">사용자 패스워드:</label>
      <input type="password" class="form-control" id="user_password" placeholder="패스워드입력" name="userPassword">
    </div>
    <div class="mb-3">
      <label for="password_check">패스워드 확인:</label>
      <input type="password" class="form-control" id="password_check" placeholder="패스워드확인">
    </div>
    
    <button type="button" id="btn-regist" class="btn btn-primary me-1">회원가입</button>
    <a class="btn btn-outline-danger" href="${root}/member/login">로그인</a>
  </form>
</div>
</main>
<!-- <a href='./board?action=boardlist'>글목록 </a>
<a href='./board?action=boardwrite'>글쓰기 </a> -->
<script>
let isUseId = false;
document.querySelector("#user_id").addEventListener("keyup", function () {
	let userid = this.value;
	console.log(userid);
	 	let resultDiv = document.querySelector("#idcheck-result");
	 	if(userid.length < 6 || userid.length > 16) {
		 	resultDiv.setAttribute("class", "mb-3 text-dark");
		 	resultDiv.textContent = "아이디는 6자 이상 16자 이하 입니다.";
		 	isUseId = false;
	 	} else {
		 	fetch("${root}/member/" + userid)
   		.then(response => response.text())
   		.then(data => {
   			console.log(data);
	 		if(data == 0) {
	   			resultDiv.setAttribute("class", "mb-3 text-primary");
       			resultDiv.textContent = userid + "는 사용할 수 있습니다.";
       			isUseId = true;
	 		} else {
	   			resultDiv.setAttribute("class", "mb-3 text-danger");
		       		resultDiv.textContent = userid + "는 사용할 수 없습니다.";
		     		isUseId = false;
	 		}
		   });
	 	}
});

	document.querySelector("#btn-regist").addEventListener("click", function () {
		if (!document.querySelector("#user_id").value) {
			alert("아이디 입력!!");
			return;
	    } else if (!document.querySelector("#user_name").value) {
	    	alert("이름 입력!!");
	      	return;
	    } else if (!document.querySelector("#user_password").value) {
	      	alert("비밀번호 입력!!");
	      	return;
	    } else if (document.querySelector("#user_password").value != document.querySelector("#password_check").value) {
	      	alert("비밀번호 확인!!");
	      	return;
	    } else {
	      	let form = document.querySelector("#form-regist");
	      	form.setAttribute("action", "${root}/member/regist");
	      	form.submit();
	    }
	});
</script>
</body>

</html>