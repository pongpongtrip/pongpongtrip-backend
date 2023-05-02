<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  
<%@ include file="../head.jsp" %>
</head>

<body>

  <!-- ======= Header ======= -->
  <%@ include file="../header.jsp" %>
<main id="main" class="pt-5">
 	<div class="row pt-3 text-center text-decoration-underline" >
       <h4>상세보기</h4>
   </div>
  	<div class="container p-3">
		<table class="table">
 		<col width="40%"><col width="60%">
 		<tr>
 			<th>번호</th><td><input type="text" name="article_no" readonly="readonly"
 			width="50" value="${board.article_no }"/></td>
 		</tr>
 		<tr>
 			<th>작성자</th><td><input type="text" name="user_id" readonly="readonly"
 			width="50" value="${board.user_id }"/></td>
 		</tr>
 		<tr>
 			<th>제목</th><td><input type="text" name="subject" readonly="readonly"
 			width="50" value="${board.subject }"/></td>
 		</tr>
 		<tr>
 			<th>작성일</th><td><input type="text" name="register_time" readonly="readonly"
 			width="50" value="${board.register_time }"/></td>
 		</tr>
 		<tr>
 			<th>조회수</th><td><input type="text" name="hit" readonly="readonly"
 			width="50" value="${board.hit }"/></td>
 		</tr>
 		<tr>
 			<th>내용</th><td><textarea name="content" readonly="readonly"
 			rows="10" cols="50">${board.content }</textarea> </td>
 		</tr>

 		</table>
 		<c:if test="${board.user_id eq login.id}">
 		 <div style="float: left">
			 <form style="display: inline" action="${root}/board" method="post">
			    <input type="hidden" name="action" value="updateBoard"/>
			    <input type="hidden" name="article_no" value="${board.article_no}"/>
			    <button type="submit" class="btn btn-outline-primary mb-2">수정</button>
			</form>
			<form style="display: inline" action="${root}/board" method="post">
			    <input type="hidden" name="action" value="delete"/>
			    <input type="hidden" name="article_no" value="${board.article_no}"/>
			    <button type="submit" class="btn btn-danger mb-2">삭제</button>	
			</form>
		 </div>
		 </c:if>
		 </div>
		 
</main>
<%-- <a href='<%=root%>/board?action=boardlist'>글목록 </a> --%>
</body>
</html>