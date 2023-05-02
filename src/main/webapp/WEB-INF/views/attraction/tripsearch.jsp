<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html lang="en">

<head>
<c:set var="root" value="${pageContext.request.contextPath}" ></c:set>

  <%@ include file="head.jsp" %>
  <%-- <%@ include file="src/main/webapp/WEB-INF/views/head.jsp" %> --%>
  
</head>

<body>
<%@ include file="header.jsp" %>


  
  <main id="main">
    <div class="row">
      <div class="col-md-1"></div>
      <div class="col-md-10">
        <div class = "text-center">
          <span class = "fs-2 border-bottom border-5 border-dark border-opacity-50">전국 관광지 정보</span>
        </div>
        <!-- 관광지 검색 start -->
        <form class="d-flex my-3" action="${root}/attraction/search" method="post" >
        	<input type="hidden" name="action" value="tripsearch">
          <select id="search-area" class="form-select me-2" name="ssido_code">
            <option value="0" selected>검색 할 지역 선택</option>
          </select>
          <select id="search-content-id" class="form-select me-2" name="scontent_type_id">
            <option value="0" selected>관광지 유형</option>
            <option value="12">관광지</option>
            <option value="14">문화시설</option>
            <option value="15">축제공연행사</option>
            <option value="25">여행코스</option>
            <option value="28">레포츠</option>
            <option value="32">숙박</option>
            <option value="38">쇼핑</option>
            <option value="39">음식점</option>
          </select>
          <input
            id="search-keyword"
            class="form-control me-2"
            type="search"
            name="title"
            placeholder="검색어"
            aria-label="검색어"
          />
          <button id="btn-search" class="btn btn-outline-success w-25" type="submit">검색</button>
        </form>
        
        
        <!-- kakao map start -->
        <div id="map" class="mt-3" style="width: 100%; height: 700px"></div>
        <!-- kakao map end -->
        <!-- <div class="row">
          <table class="table table-striped" style="display: none">
            <thead>
              <tr>
                <th>대표이미지</th>
                <th>관광지명</th>
                <th>주소</th>
                <th>위도</th>
                <th>경도</th>
              </tr>
            </thead>
            <tbody id="trip-list"></tbody>
          </table>
        </div>
        관광지 검색 end -->
        
        <!-- 관광지 검색 test용 -->
        <div id="tboard">
        <div style="display:flex;">
		  <h1 style="flex-basis:30%;">관광지 목록</h1>
      <input
            id="search-list"
            class="form-control me-2"
            type="search"
            name="title"
            placeholder="검색어"
            aria-label="검색어"
          />
          </div>
		 		<table class="table table-striped" >
		         <col width="20%"><col width="10%"><col width="20%"><col width="15%"><col width="15%"><col width="20%">
		         <tr>
		             <th>이미지</th><th>이름</th><th>주소</th><th>위도</th><th>경도</th><th>싸피와의 거리</th>
		         </tr>
             <tbody id="areaList">
             
             </tbody>
		        
		         </table>
		 </div>
		 <!-- 관광지 검색 test용 -->
    </div>
    
    </div>
  </div>
  <!-- 중앙 content end -->
    
  
  </main>
  <!-- End #main -->
    <!-- Modal -->
    <div class="modal fade" id="loginModal" tabindex="-1" aria-labelledby="loginModalLabel" aria-hidden="true">
      <div class="modal-dialog">
          <div class="modal-content">
              <div class="modal-header">
                  <h5 class="modal-title" id="loginModalLabel">로그인</h5>
                  <button type="button" class="btn-close text-white" data-bs-dismiss="modal" aria-label="Close"></button>
              </div>
              <div class="modal-body">
                <form>
                  <input type="text"
                  class="form-control mb-2"
                  id="id"
                  placeholder="아이디"/>
                  <input type="password"
                  class="form-control"
                  id="password"
                  placeholder="비밀번호"/>
                </form>
              </div>
              <div class="modal-footer">
                  <button type="button" class="btn btn-secondary" id="loginCancel" data-bs-dismiss="modal">취소</button>
                  <button type="button" class="btn btn-primary" id="loginBtn">로그인</button>
              </div>
          </div>
      </div>
  </div>
  <!-- Modal End-->
  <div class="modal fade" id="joinModal" tabindex="-1" aria-labelledby="joinModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="joinModalLabel">회원 가입</h5>
                <button type="button" class="btn-close text-white" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
              <form>
                <input type="text"
                class="form-control mb-2"
                id="name"
                placeholder="이름"/>
                <input type="text"
                class="form-control mb-2"
                id="id"
                placeholder="아이디"/>
                <input type="password"
                class="form-control"
                id="password"
                placeholder="비밀번호"/>
              </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
                <button type="button" class="btn btn-primary">회원 가입</button>
            </div>
        </div>
    </div>
  </div>
  <div class="modal fade" id="logoutModal" tabindex="-1" aria-labelledby="logoutModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="logoutModalLabel">로그인</h5>
                <button type="button" class="btn-close text-white" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
              <p>정말 로그아웃 하시겠습니까?</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" id="logoutCancel" data-bs-dismiss="modal">아니오</button>
                <button type="button" class="btn btn-primary" id="logoutBtn">예</button>
            </div>
        </div>
    </div>
  </div>
  <!-- Modal End-->
  

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
  <script src="${root}/resources/vendor/purecounter/purecounter_vanilla.js"></script>
  <script src="${root}/resources/vendor/aos/aos.js"></script>
  <script src="${root}/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="${root}/resources/vendor/glightbox/js/glightbox.min.js"></script>
  <script src="${root}/resources/vendor/isotope-layout/isotope.pkgd.min.js"></script>
  <script src="${root}/resources/vendor/swiper/swiper-bundle.min.js"></script>
  <script src="${root}/resources/vendor/waypoints/noframework.waypoints.js"></script>
  <script src="${root}/resources/vendor/php-email-form/validate.js"></script>

  <!-- Template Main JS File -->
  <script src="${root}/resources/js/main.js"></script>

  <!-- 키 js 로딩 -->
  <script src="${root}/resources/js/key.js"></script>
  <!-- <script
      type="text/javascript"
      src="//dapi.kakao.com/v2/maps/sdk.js?appkey=2223d2f22a341325eecde67a3e4ec69f&libraries=services,clusterer,drawing"
    ></script> -->
    <script>
      const areaList = document.getElementById("areaList");
      const searchList = document.getElementById("search-list");
      const locationlist = [];
      let copiedLocationList = [];
      let markers = [];

      let obj;
      <c:forEach var="area" items="${list}">
        obj = ${area};
        locationlist.push(obj);
      </c:forEach>
      copiedLocationList = [...locationlist];


      searchList.addEventListener("change", (e) => {
        copiedLocationList = [...locationlist].filter((el) => {
          // return el.title.includes(e.target.value)
          return kmp(el.title, e.target.value);
        });


        markers.map((marker) => {
          marker.setMap(null);
        });

        

        makeList();
      });

      


      // index page 로딩 후 전국의 시도 설정.
      let areaUrl =
        "https://apis.data.go.kr/B551011/KorService1/areaCode1?serviceKey=" +
        serviceKey +
        "&numOfRows=20&pageNo=1&MobileOS=ETC&MobileApp=AppTest&_type=json";

      // fetch(areaUrl, { method: "GET" }).then(function (response) { return response.json() }).then(function (data) { makeOption(data); });
      fetch(areaUrl, { method: "GET" })
        .then((response) => response.json())
        .then((data) => makeOption(data));

      function makeOption(data) {
        let areas = data.response.body.items.item;
        // console.log(areas);
        let sel = document.getElementById("search-area");
        areas.forEach((area) => {
          let opt = document.createElement("option");
          opt.setAttribute("value", area.code);
          opt.appendChild(document.createTextNode(area.name));

          sel.appendChild(opt);
        });
      }

      window.onload = function() {
    	  makeList();
      }



      var positions; // marker 배열.
      function makeList() {
    	 console.log();
        
        let trips = new Array();
        
        positions = [];
        
        console.log(trips.length);
        
        
        
        
        
        
        
        copiedLocationList.map((el) => {
      	  var markerInfo = {
                  title:  el.title,
                  latlng: new kakao.maps.LatLng(el.latitude, el.longitude),
                };
                
                
                positions.push(markerInfo);        	
        });
        
        
        let list = "";

        copiedLocationList.map((el) => {
          let distance = calculateDistance( 37.50057897395317, el.latitude, 127.03626812097968, el.longitude);
          list += `
              <tr>
                <td><img src=' ` + el.first_image + `' width="100px"/></td>
                <td>` + el.title + `</td>
                <td>` + el.addr1 + `</td>
                <td>` + el.latitude + `</td> 
                <td>` + el.longitude + `</td>
                <td>` + distance + `</td>
              </tr>
          `;          
        });
        areaList.innerHTML = list;

        	  
        	  // 위도 경도 가 들어간 배열
        	/* trips.push([${area.latitude}, ${area.longitude}]); */
        
        /* console.log(trips); */
        displayMarker();
        
      }

      // 카카오지도
      var mapContainer = document.getElementById("map"), // 지도를 표시할 div
        mapOption = {
          center: new kakao.maps.LatLng(37.500613, 127.036431), // 지도의 중심좌표
          level: 5, // 지도의 확대 레벨
        };

      // 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
      var map = new kakao.maps.Map(mapContainer, mapOption);

      function displayMarker() {
        // 마커 이미지의 이미지 주소입니다
        var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png";
        map.setLevel(8);
        for (var i = 0; i < positions.length; i++) {
          // 마커 이미지의 이미지 크기 입니다
          var imageSize = new kakao.maps.Size(24, 35);

          // 마커 이미지를 생성합니다
          var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);

          // 마커를 생성합니다
          var marker = new kakao.maps.Marker({
            // map: map, // 마커를 표시할 지도
            position: positions[i].latlng, // 마커를 표시할 위치
            title: positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
            image: markerImage, // 마커 이미지
          });

            marker.setMap(map);
            markers.push(marker);
        }

        // 첫번째 검색 정보를 이용하여 지도 중심을 이동 시킵니다
        map.setCenter(positions[0].latlng);
      }

      function moveCenter(lat, lng) {
        map.setCenter(new kakao.maps.LatLng(lat, lng));
      }

      function kmp(text, pattern) {
        
        let tLength = text.length;
        let pLength = pattern.length;
        
        // 부분일치테이블 만들기 : KMP의 아이디어를 똑같이 적용, W에서 W를 찾는 듯한 행위를 해서...
        let pi = [];
          for(let i=1, j=0; i<pLength; i++){// i:접미사 포인터(i=1부터 시작: 우리는 부분일치테이블를 만드는게 목적이므로 첫글자 틀리면 0위치로 가야하므로.), j:접두사 포인터
              while(j > 0 && pattern[i] != pattern[j]) j = pi[j-1]; 
              
              if(pattern[i] == pattern[j]) pi[i] = ++j;
              else pi[i] = 0;
          }
        
        let cnt = 0;
        let list = [];
        // i : 텍스트 포인터 , j: 패턴 포인터 
        for(let i=0,j=0; i<tLength; ++i) { 
          
          while(j>0 && text[i] != pattern[j]) j = pi[j-1]; 
          
          if(text[i] == pattern[j]) { //두 글자 일치
            if(j == pLength-1) { // j가 패턴의 마지막 인덱스라면 
              cnt++; // 카운트 증가
              list.push(i-j);  
              j=pi[j]; 
            }else { 
              j++;
            }
          }
        }

        if (cnt > 0) {
          return true;
        } else {
          return false;
        }

      }



      function calculateDistance(lat1, lat2, lng1, lng2) {
        function deg2rad(d) {
          return d * (Math.PI / 180);
        }
        let R = 6371;
        let dLat = deg2rad(lat2 - lat1);
        let dLon = deg2rad(lng2 - lng1);
        let a = Math.sin(dLat/2) * Math.sin(dLat/2) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.sin(dLon/2) * Math.sin(dLon/2);
        let c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        let d = R * c;
        return d;
      }
    </script>
    </body>
    
    </div>
</html>