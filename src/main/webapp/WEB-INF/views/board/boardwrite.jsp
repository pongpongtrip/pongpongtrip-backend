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
  <div class="container p-3">
 	<div id="tboard" >
  	<h1>글작성</h1>
 	<form action="${root }/board" method="post">
 		<input type="hidden" name="action" value="writeaf"/>
 		<table>
 		<col width="40%"><col width="60%">
 		<tr>
 			<th>작성자</th><td><input type="text" name="user_id" 
 			readonly="readonly" width="50" value="${login.id}"/></td>
 		</tr>
 		<tr>
 			<th>제목</th><td><input type="text" name="subject" width="50"/></td>
 		</tr>
 		<tr>
 			<th>내용</th><td><textarea name="content" rows="10" cols="50"></textarea> </td>
 		</tr>
 		</table>
 		<button type="submit" class="btn btn-primary me-1">완료</button>
    <a class="btn btn-outline-danger" href="${root}/board?action=boardlist">취소</a>
 	</form>
 	</div>
 </div>
</main>

</body>
</html>