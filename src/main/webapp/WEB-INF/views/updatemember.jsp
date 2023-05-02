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
<main id="main"class=pt-5>
<div class="container mt-5">
  <h2>회원 정보 수정</h2>
  <form action="${root }/member" method="post">
    <input type="hidden"  id="action" name="action" value="updateaf">
    <input type="hidden"  id="action" name="mode" value="${mode }">
    <div class="mb-3 mt-3">
      <label for="user_id">사용자 아이디:</label>
      <input type="text" class="form-control" id="user_id" readonly="readonly" placeholder="아이디 입력" name="user_id" value="${user.id }">
    </div>
    <div class="mb-3 mt-3">
      <label for="user_name">사용자 이름:</label>
      <input type="text" class="form-control" id="user_name" placeholder="이름 입력" name="user_name" value="${user.name }">
    </div>
    <div class="mb-3">
      <label for="user_password">사용자 패스워드:</label>
      <input type="password" class="form-control" id="user_password" placeholder="패스워드입력" name="user_password" value="${user.password}">
    </div>
    <c:if test="${not empty mode}">
    	<div class="mb-3">
	      <label for="admin">회원 등급:</label>
	      <select class="form-select"
                  id="admin"
                  name="admin" >
                  <option value="0">일반회원</option>
                  <option value="1">관리자</option>
                </select>
	    </div>
	          
    </c:if>
    <button type="submit" class="btn btn-primary me-1">완료</button>
    <a class="btn btn-outline-danger" href="${root}/member?action=memberInfo&userId=${user.id}">취소</a>
  </form>
</div>
</main>
<!-- <a href='./board?action=boardlist'>글목록 </a>
<a href='./board?action=boardwrite'>글쓰기 </a> -->
</body>
</html>