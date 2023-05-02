<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  
<%@ include file="head.jsp" %>

    <style>
        .container{
            font-family:Verdana, Geneva, Tahoma, sans-serif
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
    </style>
 
</head>

<body>
<%@ include file="header.jsp" %>

  
  <main id="main">
    <div class="container text-center">
        <div class="row pt-3 text-center text-decoration-underline" >
            <h4>회원 정보</h4>
        </div>
        <div class="row p-4 border-dark">
            <div class="col-lg-4 ">
                <div class="pt-3 infoT">
                    <p>아이디</p>
                </div>
                <div class="m-3  pt-3 infoA">
                    <p>${user.id }</p>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="pt-3 infoT">
                    <p>회원 이름</p>
                </div>
                <div class="m-3 pt-3 infoA">
                    <p>${user.name }</p>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="pt-3 infoT">
                    <p>회원 등급</p>
                </div>
                <div class="m-3 pt-3 infoA">
                	<c:if test="${user.admin eq true}">
                    	<p>관리자</p>
	                </c:if>
	                <c:if test="${user.admin eq false}">
                    	<p>일반 회원</p>
	                </c:if>
                </div>
            </div>
            
          </div>
        </div>
        <div class="row p-4 ">
          <div class="col-xxl-10"></div>
          <div class="col-xxl-2 d-flex align-items-center justify-content-around" >
            <c:if test="${user.id eq login.id}">
	          <form style="display: inline" action="${root}/member" method="post">
				    <input type="hidden" name="action" value="update"/>
			        <input type="hidden" name="userId" value="${user.id}"/>
				    <button type="submit" class="btn btn-outline-primary mb-2">회원 정보 수정</button>
				</form>
			
               	<form style="display: inline" action="${root}/member" method="post">
				    <input type="hidden" name="action" value="delete"/>
	                <input type="hidden" name="userId" value="${user.id}"/>
				    <button type="submit" class="btn btn-danger mb-2">회원 탈퇴</button>
				</form>
            </c:if>
            
            
         </div>
        </div>

        <div class="row ">
            <div class="col-md-1"></div>
            <div class="col-md-10">
                <div class="row">
                    <div class="col-md-4 col-sm-12">
                        <div class="card-body">
                            <div class="card h-100 m-3">
                                <img src="assets/img/01.jpg" class="rounded img-fluid hover-grow" alt="...">
                            
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4 col-sm-12">
                        <div class="card-body">
                            <div class="card h-100 m-3">
                                <img src="assets/img/02.jpg" class="rounded img-fluid hover-grow" alt="...">
                            
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4 col-sm-12">
                        <div class="card-body">
                            <div class="card h-100 m-3">
                                <img src="assets/img/03.jpg" class="rounded img-fluid hover-grow" alt="...">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-1"></div>
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
  <script src="resources/vendor/purecounter/purecounter_vanilla.js"></script>
  <script src="resources/vendor/aos/aos.js"></script>
  <script src="resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="resources/vendor/glightbox/js/glightbox.min.js"></script>
  <script src="resources/vendor/isotope-layout/isotope.pkgd.min.js"></script>
  <script src="resources/vendor/swiper/swiper-bundle.min.js"></script>
  <script src="resources/vendor/waypoints/noframework.waypoints.js"></script>
  <script src="resources/vendor/php-email-form/validate.js"></script>

  <!-- Template Main JS File -->
  <script src="resources/js/main.js"></script>
  
  <!-- 키 js 로딩 -->

    </body>
    
    </div>
</html>
