<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  
<%@ include file="head.jsp" %>
</head>

<body>

  <!-- ======= Header ======= -->
  <%@ include file="header.jsp" %>

  <!-- ======= Hero Section ======= -->
  <section id="hero" class="d-flex justify-cntent-center align-items-center">
    <div id="heroCarousel" class="container carousel carousel-fade" data-bs-ride="carousel" data-bs-interval="5000">

      <!-- Slide 1 -->
      <div class="carousel-item active">
        <div class="carousel-container">
          <h2 class="animate__animated animate__fadeInDown">여행정보 <span>다모아</span></h2>
          <p class="animate__animated animate__fadeInUp">Ut velit est quam dolor ad a aliquid qui aliquid. Sequi ea ut et est quaerat sequi nihil ut aliquam. Occaecati alias dolorem mollitia ut. Similique ea voluptatem. Esse doloremque accusamus repellendus deleniti vel. Minus et tempore modi architecto.</p>
          <!-- <a href="" class="btn-get-started animate__animated animate__fadeInUp">Read More</a> -->
        </div>
      </div>

      <!-- Slide 2 -->
      <div class="carousel-item">
        <div class="carousel-container">
          <h2 class="animate__animated animate__fadeInDown">음식점 찾아보세요</h2>
          <p class="animate__animated animate__fadeInUp">Ut velit est quam dolor ad a aliquid qui aliquid. Sequi ea ut et est quaerat sequi nihil ut aliquam. Occaecati alias dolorem mollitia ut. Similique ea voluptatem. Esse doloremque accusamus repellendus deleniti vel. Minus et tempore modi architecto.</p>
          <!-- <a href="" class="btn-get-started animate__animated animate__fadeInUp">Read More</a> -->
        </div>
      </div>

      <!-- Slide 3 -->
      <!-- <div class="carousel-item">
        <div class="carousel-container">
          <h2 class="animate__animated animate__fadeInDown">Sequi ea ut et est quaerat</h2>
          <p class="animate__animated animate__fadeInUp">Ut velit est quam dolor ad a aliquid qui aliquid. Sequi ea ut et est quaerat sequi nihil ut aliquam. Occaecati alias dolorem mollitia ut. Similique ea voluptatem. Esse doloremque accusamus repellendus deleniti vel. Minus et tempore modi architecto.</p>
          <a href="" class="btn-get-started animate__animated animate__fadeInUp">Read More</a>
        </div>
      </div> -->

      <a class="carousel-control-prev" href="#heroCarousel" role="button" data-bs-slide="prev">
        <span class="carousel-control-prev-icon bx bx-chevron-left" aria-hidden="true"></span>
      </a>

      <a class="carousel-control-next" href="#heroCarousel" role="button" data-bs-slide="next">
        <span class="carousel-control-next-icon bx bx-chevron-right" aria-hidden="true"></span>
      </a>

    </div>
  </section><!-- End Hero -->

  <main id="main">
    
  <!-- 대한민국 관광지 시작 -->
  <section class="portfolio">
    <div class="container">
      <div class="col-lg-12" >
        <p class ="text-start" style ="font-size: 40px;">대한민국 관광지</p>
      </div>
      <!-- <div class="row">
        <div class="col-lg-12">
          <ul id="portfolio-flters">
            <li data-filter="*" class="filter-active">All</li>
            <li data-filter=".filter-app">App</li>
            <li data-filter=".filter-card">Card</li>
            <li data-filter=".filter-web">Web</li>
          </ul>
        </div>
      </div> -->

      <div class="row portfolio-container" data-aos="fade-up" data-aos-easing="ease-in-out" data-aos-duration="500">
        <div class="col-lg-4 col-md-6 portfolio-wrap filter-app">
          <div class="portfolio-item t1">
            <!-- <img src="assets/img/portfolio/portfolio-1.jpg" class="img-fluid" alt=""> -->
            <div class="portfolio-info">
              <!-- <h3>1</h3> -->
              <div class="t1">
                <a id = "t1" href="resources/img/portfolio/portfolio-1.jpg" data-gallery="portfolioGallery" class="portfolio-lightbox" title="App 1"><i class="bx bx-plus"></i></a>
                <!-- <a href="portfolio-details.html" title="Portfolio Details"><i class="bx bx-link"></i></a> -->
              </div>
            </div>
          </div>
        </div>

        <div class="col-lg-4 col-md-6 portfolio-wrap filter-web">
          <div class="portfolio-item t1">
            <!-- <img src="assets/img/portfolio/portfolio-2.jpg" class="img-fluid" alt=""> -->
            <div class="portfolio-info">
              <!-- <h3>2</h3> -->
              <div class="t1">
                <a id = "t2" href="resources/img/portfolio/portfolio-2.jpg" data-gallery="portfolioGallery" class="portfolio-lightbox" title="Web 3"><i class="bx bx-plus"></i></a>
                <!-- <a href="portfolio-details.html" title="Portfolio Details"><i class="bx bx-link"></i></a> -->
              </div>
            </div>
          </div>
        </div>

        <div class="col-lg-4 col-md-6 portfolio-wrap filter-app">
          <div class="portfolio-item t1">
            <!-- <img src="assets/img/portfolio/portfolio-3.jpg" class="img-fluid" alt=""> -->
            <div class="portfolio-info">
              <!-- <h3>3</h3> -->
              <div class="t1">
                <a id = "t3" href="resources/img/portfolio/portfolio-3.jpg" data-gallery="portfolioGallery" class="portfolio-lightbox" title="App 2"><i class="bx bx-plus"></i></a>
                <!-- <a href="portfolio-details.html" title="Portfolio Details"><i class="bx bx-link"></i></a> -->
              </div>
            </div>
          </div>
        </div>

        <div class="col-lg-4 col-md-6 portfolio-wrap filter-card">
          <div class="portfolio-item t1">
            <!-- <img src="assets/img/portfolio/portfolio-4.jpg" class="img-fluid" alt=""> -->
            <div class="portfolio-info">
              <!-- <h3>4</h3> -->
              <div class="t1">
                <a href="resources/img/portfolio/portfolio-4.jpg" data-gallery="portfolioGallery" class="portfolio-lightbox" title="Card 2"><i class="bx bx-plus"></i></a>
                <!-- <a href="portfolio-details.html" title="Portfolio Details"><i class="bx bx-link"></i></a> -->
              </div>
            </div>
          </div>
        </div>

        <div class="col-lg-4 col-md-6 portfolio-wrap filter-web">
          <div class="portfolio-item t1">
            <!-- <img src="assets/img/portfolio/portfolio-5.jpg" class="img-fluid" alt=""> -->
            <div class="portfolio-info">
              <!-- <h3>5</h3> -->
              <div class="t1">
                <a href="resources/img/portfolio/portfolio-5.jpg" data-gallery="portfolioGallery" class="portfolio-lightbox" title="Web 2"><i class="bx bx-plus"></i></a>
                <!-- <a href="portfolio-details.html" title="Portfolio Details"><i class="bx bx-link"></i></a> -->
              </div>
            </div>
          </div>
        </div>

        <div class="col-lg-4 col-md-6 portfolio-wrap filter-app">
          <div class="portfolio-item t1">
            <!-- <img src="assets/img/portfolio/portfolio-6.jpg" class="img-fluid" alt=""> -->
            <div class="portfolio-info">
              <!-- <h3>6</h3> -->
              <div class="t1">
                <a href="resources/img/portfolio/portfolio-6.jpg" data-gallery="portfolioGallery" class="portfolio-lightbox" title="App 3"><i class="bx bx-plus"></i></a>
                <!-- <a href="portfolio-details.html" title="Portfolio Details"><i class="bx bx-link"></i></a> -->
              </div>
            </div>
          </div>
        </div>

        <div class="col-lg-4 col-md-6 portfolio-wrap filter-card">
          <div class="portfolio-item t1">
            <!-- <img src="assets/img/portfolio/portfolio-7.jpg" class="img-fluid" alt=""> -->
            <div class="portfolio-info">
              <!-- <h3>7</h3> -->
              <div class="t1">
                <a href="resources/img/portfolio/portfolio-7.jpg" data-gallery="portfolioGallery" class="portfolio-lightbox" title="Card 1"><i class="bx bx-plus"></i></a>
                <!-- <a href="portfolio-details.html" title="Portfolio Details"><i class="bx bx-link"></i></a> -->
              </div>
            </div>
          </div>
        </div>

        <div class="col-lg-4 col-md-6 portfolio-wrap filter-card">
          <div class="portfolio-item t1">
            <!-- <img src="assets/img/portfolio/portfolio-8.jpg" class="img-fluid" alt=""> -->
            <div class="portfolio-info">
              <!-- <h3>8</h3> -->
              <div class="t1">
                <a href="resources/img/portfolio/portfolio-8.jpg" data-gallery="portfolioGallery" class="portfolio-lightbox" title="Card 3"><i class="bx bx-plus"></i></a>
                <!-- <a href="portfolio-details.html" title="Portfolio Details"><i class="bx bx-link"></i></a> -->
              </div>
            </div>
          </div>
        </div>

        <div class="col-lg-4 col-md-6 portfolio-wrap filter-web">
          <div class="portfolio-item t1">
            <!-- <img src="assets/img/portfolio/portfolio-9.jpg" class="img-fluid" alt=""> -->
            <div class="portfolio-info">
              <!-- <h3>9</h3> -->
              <div class="t1">
                <a href="resources/img/portfolio/portfolio-9.jpg" data-gallery="portfolioGallery" class="portfolio-lightbox" title="Web 1"><i class="bx bx-plus"></i></a>
                <!-- <a href="portfolio-details.html" title="Portfolio Details"><i class="bx bx-link"></i></a> -->
              </div>
            </div>
          </div>
        </div>

      </div>

    </div>
  </section>
  <!-- 대한민국 관광지 끝 -->

  <!-- 대한민국 축제 시작 -->
  <section class="portfolio">
    <div class="container">
      <div class="col-lg-12" >
        <p class ="text-start" style ="font-size: 40px;">대한민국 축제</p>
      </div>
      <!-- <div class="row">
        <div class="col-lg-12">
          <ul id="portfolio-flters">
            <li data-filter="*" class="filter-active">All</li>
            <li data-filter=".filter-app">App</li>
            <li data-filter=".filter-card">Card</li>
            <li data-filter=".filter-web">Web</li>
          </ul>
        </div>
      </div> -->

      <div class="row portfolio-container" data-aos="fade-up" data-aos-easing="ease-in-out" data-aos-duration="500">

        <div class="col-lg-4 col-md-6 portfolio-wrap filter-app">
          <div class="portfolio-item f1">
            <!-- <img src="assets/img/portfolio/portfolio-1.jpg" class="img-fluid" alt=""> -->
            <div class="portfolio-info f1">
              <!-- <h3>App 1</h3> -->
              <div>
                <a href="resources/img/portfolio/portfolio-1.jpg" data-gallery="portfolioGallery" class="portfolio-lightbox" title="App 1"><i class="bx bx-plus"></i></a>
                <!-- <a href="portfolio-details.html" title="Portfolio Details"><i class="bx bx-link"></i></a> -->
              </div>
            </div>
          </div>
        </div>

        <div class="col-lg-4 col-md-6 portfolio-wrap filter-web">
          <div class="portfolio-item f1">
            <!-- <img src="assets/img/portfolio/portfolio-2.jpg" class="img-fluid" alt=""> -->
            <div class="portfolio-info f1">
              <!-- <h3>Web 3</h3> -->
              <div>
                <a href="resources/img/portfolio/portfolio-2.jpg" data-gallery="portfolioGallery" class="portfolio-lightbox" title="Web 3"><i class="bx bx-plus"></i></a>
                <!-- <a href="portfolio-details.html" title="Portfolio Details"><i class="bx bx-link"></i></a> -->
              </div>
            </div>
          </div>
        </div>

        <div class="col-lg-4 col-md-6 portfolio-wrap filter-app">
          <div class="portfolio-item  f1">
            <!-- <img src="assets/img/portfolio/portfolio-3.jpg" class="img-fluid" alt=""> -->
            <div class="portfolio-info f1">
              <!-- <h3>App 2</h3> -->
              <div>
                <a href="resources/img/portfolio/portfolio-3.jpg" data-gallery="portfolioGallery" class="portfolio-lightbox" title="App 2" data-bs-toggle = "modal" data-bs-targer="#pollModal"><a class="bx bx-plus" data-bs-toggle = "modal" href = "#" data-bs-targer="#pollModal"></a></a>
                <!-- <a href="portfolio-details.html" title="Portfolio Details"><i class="bx bx-link"></i></a> -->
              </div>
            </div>
          </div>
        </div>

        <div class="col-lg-4 col-md-6 portfolio-wrap filter-card">
          <div class="portfolio-item f1">
            <!-- <img src="assets/img/portfolio/portfolio-4.jpg" class="img-fluid" alt=""> -->
            <div class="portfolio-info f1">
              <!-- <h3>Card 2</h3> -->
              <div>
                <a href="resources/img/portfolio/portfolio-4.jpg" data-gallery="portfolioGallery" class="portfolio-lightbox" title="Card 2"><i class="bx bx-plus"></i></a>
                <!-- <a href="portfolio-details.html" title="Portfolio Details"><i class="bx bx-link"></i></a> -->
              </div>
            </div>
          </div>
        </div>

        <div class="col-lg-4 col-md-6 portfolio-wrap filter-web">
          <div class="portfolio-item f1">
            <!-- <img src="assets/img/portfolio/portfolio-5.jpg" class="img-fluid" alt=""> -->
            <div class="portfolio-info f1">
              <!-- <h3>Web 2</h3> -->
              <div>
                <a href="resources/img/portfolio/portfolio-5.jpg" data-gallery="portfolioGallery" class="portfolio-lightbox" title="Web 2"><i class="bx bx-plus"></i></a>
                <!-- <a href="portfolio-details.html" title="Portfolio Details"><i class="bx bx-link"></i></a> -->
              </div>
            </div>
          </div>
        </div>

        <div class="col-lg-4 col-md-6 portfolio-wrap filter-app">
          <div class="portfolio-item f1">
            <!-- <img src="assets/img/portfolio/portfolio-6.jpg" class="img-fluid" alt=""> -->
            <div class="portfolio-info f1">
              <!-- <h3>App 3</h3> -->
              <div>
                <a href="resources/img/portfolio/portfolio-6.jpg" data-gallery="portfolioGallery" class="portfolio-lightbox" title="App 3"><i class="bx bx-plus"></i></a>
                <!-- <a href="portfolio-details.html" title="Portfolio Details"><i class="bx bx-link"></i></a> -->
              </div>
            </div>
          </div>
        </div>

        <div class="col-lg-4 col-md-6 portfolio-wrap filter-card">
          <div class="portfolio-item f1">
            <!-- <img src="assets/img/portfolio/portfolio-7.jpg" class="img-fluid" alt=""> -->
            <div class="portfolio-info f1">
              <!-- <h3>Card 1</h3> -->
              <div>
                <a href="resources/img/portfolio/portfolio-7.jpg" data-gallery="portfolioGallery" class="portfolio-lightbox" title="Card 1"><i class="bx bx-plus"></i></a>
                <!-- <a href="portfolio-details.html" title="Portfolio Details"><i class="bx bx-link"></i></a> -->
              </div>
            </div>
          </div>
        </div>

        <div class="col-lg-4 col-md-6 portfolio-wrap filter-card">
          <div class="portfolio-item f1">
            <!-- <img src="assets/img/portfolio/portfolio-8.jpg" class="img-fluid" alt=""> -->
            <div class="portfolio-info f1">
              <!-- <h3>Card 3</h3> -->
              <div>
                <a href="resources/img/portfolio/portfolio-8.jpg" data-gallery="portfolioGallery" class="portfolio-lightbox" title="Card 3"><i class="bx bx-plus"></i></a>
                <!-- <a href="portfolio-details.html" title="Portfolio Details"><i class="bx bx-link"></i></a> -->
              </div>
            </div>
          </div>
        </div>

        <div class="col-lg-4 col-md-6 portfolio-wrap filter-web">
          <div class="portfolio-item f1">
            <!-- <img src="assets/img/portfolio/portfolio-9.jpg" class="img-fluid" alt=""> -->
            <div class="portfolio-info f1">
              <!-- <h3>Web 1</h3> -->
              <div>
                <a href="resources/img/portfolio/portfolio-9.jpg" data-gallery="portfolioGallery" class="portfolio-lightbox" title="Web 1"><i class="bx bx-plus"></i></a>
                <!-- <a href="portfolio-details.html" title="Portfolio Details"><i class="bx bx-link"></i></a> -->
              </div>
            </div>
          </div>
        </div>

      </div>

    </div>
  </section><!-- End Portfolio Section -->
  <!-- 대한민국 축제 끝 -->
  
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

    <div class="container">
      <div class="copyright">
        &copy; Copyright <strong><span>LeeChanmin & JeonJunGyu</span></strong>. All Rights Reserved
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
  <script src="resources/js/main.js?ver=1.0"></script>
  <script src="resources/js/randomInfo.js?ver=1.1"></script>
    </body>
    
    </div>
</html>