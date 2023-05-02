<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  
<%@ include file="../head.jsp" %>
<style>
        .container{
            font-family:Verdana, Geneva, Tahoma, sans-serif;
            text-align: center;
        }
        table > tbody > tr:hover{
            cursor:pointer;
        }
        
    </style>
</head>

<body>

  <!-- ======= Header ======= -->
  <%@ include file="../header.jsp" %>



<main id="main" class="pt-5">
  <div class="row pt-3 text-center text-decoration-underline" >
       <h4>공유 게시판</h4>
   </div>
  	<div class="container p-3">
		  	<table class="table table-hover">
		         <col width="10%"><col width="40%"><col width="15%"><col width="15%"><col width="20%">
		         <thead>
		         <tr>
		             <th>번호</th><th>제목</th><th>작성자</th><th>조회수</th><th>작성일</th>
		         </tr>
		         </thead>
		         <tbody>
		         <c:forEach var="board" items="${boards}" varStatus="vs">
		             <tr id="${board.article_no }" onclick="boardInfo('${board.article_no}')">
			                 <td>${vs.count}</td>
			                 <td>${board.subject}</td>
			                 <td>${board.user_id}</td>
			                 <td>${board.hit}</td>
			   				 <td>${board.register_time}</td>
		             </tr>
		         </c:forEach>
		         </tbody>
		       </table>
		       
                <a class="btn btn-outline-primary" href="${root}/board?action=write">글작성</a>
                
  	</div>
  </main>
  <!-- End #main -->
<!-- ======= Footer ======= -->
  <footer id="footer" data-aos="fade-up" data-aos-easing="ease-in-out" data-aos-duration="500">
    <div class="footer-top">
      <div class="container">
        <div class="row">
          <div class="col-lg-4 footer-links text-center">
            <p>여행모아</p>
            
          </div>

          <div class="col-lg-4 footer-links text-center">
            <p>개인정보처리방침</p>
            
          </div>

          <div class="col-lg-4 footer-contact text-center">
            <p>이용약관</p>
          </div>
          </div>
		</div>
    </div>

    <div class="container">
      <div class="copyright">
        &copy; Copyright <strong><span>LeeChanmin & ParkJaehoon</span></strong>. All Rights Reserved
      </div>
      <div class="credits">
        <!-- All the links in the footer should remain intact. -->
        <!-- You can delete the links only if you purchased the pro version. -->
        <!-- Licensing information: https://bootstrapmade.com/license/ -->
        <!-- Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/free-bootstrap-template-corporate-moderna/ -->
        Designed by <a href="https://bootstrapmade.com/">Bootstrap</a>
      </div>
    </div>
  </footer><!-- End Footer -->

  <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

  <!-- Vendor JS Files -->
  <script src="assets/vendor/purecounter/purecounter_vanilla.js"></script>
  <script src="assets/vendor/aos/aos.js"></script>
  <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="assets/vendor/glightbox/js/glightbox.min.js"></script>
  <script src="assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
  <script src="assets/vendor/swiper/swiper-bundle.min.js"></script>
  <script src="assets/vendor/waypoints/noframework.waypoints.js"></script>
  <script src="assets/vendor/php-email-form/validate.js"></script>

  <!-- Template Main JS File -->
  <script src="assets/js/main.js"></script>
  <script>
        function boardInfo(id) {
            window.location.href = "${root}/board?action=detail&article_no=" + id;
        }
    </script>

   </body>
    
</html>