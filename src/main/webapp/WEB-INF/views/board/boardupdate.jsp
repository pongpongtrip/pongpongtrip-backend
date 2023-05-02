<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../head.jsp" %>

<style type="text/css">
	#section {margin: auto;}
	#tboard {margin: auto;}
	#tboard > table {margin: auto; width:  80%; border: 1px solid #aabbcc; }
</style>
</head>
<body>
<%@include file="../header.jsp" %>

<main id="main" class="pt-5">
 	<div class="row pt-3 text-center text-decoration-underline" >
       <h4>수정하기</h4>
   </div>
   <div class="container p-3">
 <form action="${root}/board" method="post">
	<input type="hidden" name="action" value="updateaf"/>
 		<table>
 		<col width="40%"><col width="60%">
 		<tr>
 			<th>번호</th><td><input type="text" name="article_no" readonly="readonly"
 			width="50" value="${board.article_no}"/></td>
 		</tr>
 		<tr>
 			<th>작성자</th><td><input type="text" name="user_id" readonly="readonly"
 			width="50" value="${board.user_id}"/></td>
 		</tr>
 		<tr>
 			<th>제목</th><td><input type="text" name="subject" 
 			width="50" value="${board.subject}"/></td>
 		</tr>
 		<tr>
 			<th>작성일</th><td><input type="text" name="register_time" readonly="readonly"
 			width="50" value="${board.register_time}"/></td>
 		</tr>
 		<tr>
 			<th>조회수</th><td><input type="text" name="hit" readonly="readonly"
 			width="50" value="${board.hit}"/></td>
 		</tr>
 		<tr>
 			<th>내용</th><td><textarea name="content" 
 			rows="10" cols="50">${board.content}</textarea> </td>
 		</tr>
		<tr>
 			<td colspan="2"><button type="submit" class="btn btn-outline-primary">글 수정</button></td>
 		</tr>
 		</table>
 		</form>
 		</div>
 		</main>
</body>
</html>