<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  
<%@ include file="../head.jsp" %>
  <style>
    #overlay {
        position: absolute;
        width:200px;
        height:70%;
        left: 150px;
        top: 210px;
        z-index: 9999;
        background-color: #c5bdbd;
        padding: 10px;
        border: 1px solid #ccc;
        border-radius: 5px;
        box-shadow: 0 0 5px rgba(0, 0, 0, 0.3);
        user-select: none;
        cursor: grab;
      }
      #overlay:active {
        cursor: grabbing;
      }
      .item{
        border: 1px solid black;
      }
  </style>
</head>

<body>

  <%@ include file="../header.jsp" %>

  
  <main id="main">
    <div class="row">
      <div class="col-md-1"></div>
      <div class="col-md-10">
        <div class = "text-center">
          <span class = "fs-2 border-bottom border-5 border-dark border-opacity-50">나만의 여행 계획</span>
        </div>
        <!-- 관광지 검색 start -->
        <form class="d-flex my-3" action="${root}/attraction/searchPlan" method="post" >
        	<input type="hidden" name="action" value="tripplan">
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
        <div id ="overlay">
            <div id="planitem" class="row">
                
            </div>
            <button id="courseBtn" class ="btn btn-info"style="position: absolute; bottom: 0;">코스 등록</button>
        </div>
        <div class="row">
            <div id="map" class="mt-3 col-md-8 " style=" height: 700px"></div>
            <div class="col-md-4">
                <div class="row">
                    <!-- 관광지 검색 test용 -->
        <div id="tboard">
		  <h1>관광지 목록</h1>
		 		<table class="table table-striped" >
		         <col width="20%"><col width="20%"><col width="20%"><col width="20%"><col width="20%">
		         <tr>
		             <th>이미지</th><th>이름</th><th>주소</th><th>위도</th><th>경도</th>
		         </tr>
		         <c:forEach var="area" items="${list}">
		             <tr class="items">
		                 <td><img src='${area.first_image}' width="100px"/></td>
		                 <td>${area.title}</td>
		                 <td>${area.addr1}</td>
		                 <td>${area.latitude}</td>
		                 <td>${area.longitude}</td>
		                 
		             </tr>
		         </c:forEach>
		         </table>
		 </div>
		 <!-- 관광지 검색 test용 -->
                </div>
            </div>
        </div>
        <!-- kakao map end -->
        <!-- 관광지 검색 end -->
    </div>
    
    </div>
  </div>
  <!-- 중앙 content end -->
    
  
  </main>

  

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
  
    <script>
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
    
    if(sessionStorage.getItem("planPositions") === null) {
    	var p = [];
    	sessionStorage.setItem("planPositions", JSON.stringify(p));
    }
    
    var positions2 = JSON.parse(sessionStorage.getItem("planPositions"));
    console.log(positions2);
    console.log(positions2.length);
    function makeList() {
  	 console.log();
      
      let trips = new Array();
      
      // positions = [];
      
      console.log(trips.length);
      
      itemAdd();
    }


      // 카카오지도
      var mapContainer = document.getElementById("map"), // 지도를 표시할 div
        mapOption = {
          center: new kakao.maps.LatLng(37.500613, 127.036431), // 지도의 중심좌표
          level: 12, // 지도의 확대 레벨
        };

      // 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
      var map = new kakao.maps.Map(mapContainer, mapOption);
      
      function itemAdd(){
        const items = document.querySelectorAll(".items");
        console.log("됨");
        items.forEach(function(item){
            item.addEventListener("click", function(event){
                console.log("눌림");
                var node = event.target.parentElement;
                var title = node.children[1].textContent;
                var addr = node.children[2].textContent;
                var lat = node.children[3].textContent;
                var lng = node.children[4].textContent;
                console.log(title);

                var planitem = document.getElementById("planitem");
                var newItem = document.createElement("div");
                newItem.setAttribute("class","item");
                newItem.innerHTML += '<p>' + title + '</p><p>' + addr + '</p>';
                planitem.appendChild(newItem);
                console.log(newItem);

                
                var markerInfo = {
                        title:  title,
                        latlng: new kakao.maps.LatLng(lat, lng),
                      };
                positions2.push(JSON.stringify(markerInfo));
                console.log("positions2 길이: " + positions2.length);
                console.log("positions2: " + positions2	);
            })
        })
    }

    const courseBtn = document.getElementById("courseBtn");
    courseBtn.addEventListener("click", function (event) {
    	sessionStorage.setItem("planPositions", positions2); // 다시 sessionStorage에 넣어줌
        addCourse();
    })

    function addCourse(){
        var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png";
        for (var i = 0; i < positions2.length; i++) {
          // 마커 이미지의 이미지 크기 입니다
          var imageSize = new kakao.maps.Size(24, 35);

          // 마커 이미지를 생성합니다
          var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);

          // 마커를 생성합니다
          var marker = new kakao.maps.Marker({
            map: map, // 마커를 표시할 지도
            position: positions2[i].latlng, // 마커를 표시할 위치
            title: positions2[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
            image: markerImage, // 마커 이미지
          });
        }
        marker.setMap(map);
        var linePath;
        var lineLine = new kakao.maps.Polyline();
        var distance;
        for (var i = 0; i < positions2.length; i++) {
            if (i != 0) {
                linePath = [ positions2[i - 1].latlng, positions2[i].latlng ] 
            }
            ;
            lineLine.setPath(linePath); // 선을 그릴 라인을 세팅합니다
     
            var drawLine = new kakao.maps.Polyline({
                map : map, // 선을 표시할 지도입니다 
                path : linePath,
                strokeWeight : 3, // 선의 두께입니다 
                strokeColor : '#db4040', // 선의 색깔입니다
                strokeOpacity : 1, // 선의 불투명도입니다 0에서 1 사이값이며 0에 가까울수록 투명합니다
                strokeStyle : 'solid' // 선의 스타일입니다
            });
     
            distance = Math.round(lineLine.getLength());
            displayCircleDot(positions2[i].latlng, distance);
            
        }
     
        function displayCircleDot(position, distance) {
            if (distance > 0) {
                // 클릭한 지점까지의 그려진 선의 총 거리를 표시할 커스텀 오버레이를 생성합니다
                var distanceOverlay = new kakao.maps.CustomOverlay(
                        {
                            content : '<div class="dotOverlay">거리 <span class="number">'
                                    + distance + '</span>m</div>',
                            position : position,
                            yAnchor : 1,
                            zIndex : 2
                        });
     
                // 지도에 표시합니다
                distanceOverlay.setMap(map);
            }
        }
    }
    </script>
    
     

    </body>
    
    </div>
</html>