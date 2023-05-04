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
  
 	<div class="row justify-content-center">
        <div class="row pt-3 text-center text-decoration-underline" >
			<h4>글쓰기</h4>
		</div>
        <div class="col-lg-8 col-md-10 col-sm-12">
          <form id="form-register" method="POST" enctype="multipart/form-data" action="">
          	<input type="hidden" name="pgno" value="1">
		    <input type="hidden" name="key" value="">
		    <input type="hidden" name="word" value="">
            <div class="mb-3">
              <label for="subject" class="form-label">제목 : </label>
              <input
                type="text"
                class="form-control"
                id="subject"
                name="subject"
                placeholder="제목..."
              />
            </div>
            <div class="mb-3">
              <label for="content" class="form-label">내용 : </label>
              <textarea class="form-control" id="content" name="content" rows="7"></textarea>
            </div>
            <div class="mb-3">
				<label for="upfile" class="form-label">파일:</label>
				<input type="file" class="form-control border" id="upfile" name="upfile" multiple="multiple">
			</div>
            <div class="col-auto text-center">
              <button type="button" id="btn-register" class="btn btn-outline-primary mb-3">
                글쓰기
              </button>
              <button type="button" id="btn-list" class="btn btn-outline-danger mb-3">
                목록으로이동...
              </button>
            </div>
          </form>
        </div>
      </div>
       <form id="form-param" method="get" action="">
      <input type="hidden" id="pgno" name="pgno" value="${pgno}">
      <input type="hidden" id="key" name="key" value="${key}">
      <input type="hidden" id="word" name="word" value="${word}">
    </form>
 </div>
</main>
<script>
	document.querySelector("#btn-register").addEventListener("click", function () {
	    if (!document.querySelector("#subject").value) {
	      alert("제목 입력!!");
	      return;
	    } else if (!document.querySelector("#content").value) {
	      alert("내용 입력!!");
	      return;
	    } else {
	      let form = document.querySelector("#form-register");
	      form.setAttribute("action", "${root}/board/write");
	      form.submit();
	    }
	  });
	  
	  document.querySelector("#btn-list").addEventListener("click", function () {
	  	if(confirm("취소를 하시면 작성한 글은 삭제됩니다.\n취소하시겠습니까?")) {
	  		let form = document.querySelector("#form-param");
	     	form.setAttribute("action", "${root}/board/list");
	        form.submit();
	 	}
	  });
</script>
</body>
</html>