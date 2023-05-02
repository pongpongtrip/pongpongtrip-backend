<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  
<%@ include file="head.jsp" %>

    <style>
        .container{
            font-family:Verdana, Geneva, Tahoma, sans-serif;
            text-align: center;
        }
        table > tbody > tr:hover{
            cursor:pointer;
        }
        .infoT{
            border: 1px solid rgb(140, 189, 204);
            border-radius: 3px;
        }
        .infoA{
            background-color: rgb(167, 226, 226);
            border-radius: 3px;
            padding: 5px;
            font-weight: bold;
        }
        .hover-grow:hover{
            scale:1.1;
            
        }
        img {
            object-fit: contain;
        }
        .user-box{
            border: 1px solid rgb(78, 76, 76);
            border-radius: 5px;
            padding: 3px;
        }
    </style>
  <!-- =======================================================
  * Template Name: Moderna
  * Updated: Mar 10 2023 with Bootstrap v5.2.3
  * Template URL: https://bootstrapmade.com/free-bootstrap-template-corporate-moderna/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
</head>

<body>

  <!-- ======= Header ======= -->
  <%@ include file="header.jsp" %>
<c:set value="${pageContext.request.contextPath}" var="root"></c:set>
  
  <main id="main">
  <div class="row pt-3 text-center text-decoration-underline" >
       <h4>관리자 페이지</h4>
   </div>
  	<div class="container p-3">
		  	<table class="table table-hover">
		         <col width="10%"><col width="25%"><col width="25%"><col width="20%"><col width="20%">
		         <thead>
		         <tr>
		             <th>번호</th><th>회원 아이디</th><th>회원 이름</th><th>회원 등급</th><th>관리</th>
		         </tr>
		         </thead>
		         <tbody>
		         <c:forEach var="member" items="${members}" varStatus="vs">
		             <tr id="${member.id }" onclick="memberInfo('${member.id}')">
			                 <td>${vs.count}</td>
			                 <td>${member.id}</td>
			                 <td>${member.name}</td>
			                 <c:if test="${member.admin eq true}">
		                    	<td>관리자</td>
			                </c:if>
			                <c:if test="${member.admin eq false}">
		                    	<td>일반 회원</td>
			                </c:if>
		               <td>
		               	<form style="display:inline" action="${root}/member" method="post">
		                      <input type="hidden" name="action" value="update"/>
		                      <input type="hidden" name="mode" value="1"/>
		                      <input type="hidden" name="userId" value="${member.id}"/>
		                     <button class="btn btn-outline-primary" type="submit" >수정</button>
		                 </form>
		               
		                <form style="display:inline" action="${root}/member" method="post">
		                      <input type="hidden" name="action" value="delete"/>
		                      <input type="hidden" name="mode" value="1"/>
		                      <input type="hidden" name="userId" value="${member.id}"/>
		                     <button class="btn btn-danger" type="submit" >삭제</button>
		                 </form>
		                </td>
		             </tr>
		         </c:forEach>
		         </tbody>
		       </table>
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
        function memberInfo(id) {
            window.location.href = "${root}/member?action=memberInfo&userId=" + id;
        }
    </script>

   </body>
    
</html>

