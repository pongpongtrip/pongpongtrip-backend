{/* <script
    type="text/javascript"
    src="//dapi.kakao.com/v2/maps/sdk.js?appkey=2223d2f22a341325eecde67a3e4ec69f&libraries=services,clusterer,drawing"
    ></script> */}

const serviceKey = "T%2FAhyTaE0rj803LnvkkF61K45eKKUhlcmpHuGSwflWQGhTM%2BF9fvx%2By%2BlRXOf2b8VQQOPjConQOOrw%2F47eNkxg%3D%3D";
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
    console.log(areas);
    // let sel = document.getElementById("search-area");
    // areas.forEach((area) => {
    //     let opt = document.createElement("option");
    //     opt.setAttribute("value", area.code);
    //     opt.appendChild(document.createTextNode(area.name));

    //     sel.appendChild(opt);
    // });
}

// 로딩되면 랜덤하게 공공데이터 조회결과 50개 받아오기
window.onload = function () {
    let searchUrl = `https://apis.data.go.kr/B551011/KorService1/searchKeyword1?serviceKey=${serviceKey}&numOfRows=50&pageNo=1&MobileOS=ETC&MobileApp=AppTest&_type=json&listYN=Y&arrange=A`;
    let areaCode = 0;
    let contentTypeId = 12;
    let search = ["궁", "계곡", "사", "부산"];
    let keyword = search[Math.floor(Math.random() * 4)];

    if (parseInt(areaCode)) searchUrl += `&areaCode=${areaCode}`;
    if (parseInt(contentTypeId)) searchUrl += `&contentTypeId=${contentTypeId}`;
    searchUrl += `&keyword=${keyword}`;

    fetch(searchUrl)
        .then((response) => response.json())
        .then((data) => makeList(data));
    
    let searchUrl2 = `https://apis.data.go.kr/B551011/KorService1/searchKeyword1?serviceKey=${serviceKey}&numOfRows=50&pageNo=1&MobileOS=ETC&MobileApp=AppTest&_type=json&listYN=Y&arrange=A`;
    let areaCode2 = 0;
    let contentTypeId2 = 15;
    let search2 = ["축"];
    let keyword2 = search2[0];

    if (parseInt(areaCode2)) searchUrl2 += `&areaCode=${areaCode2}`;
    if (parseInt(contentTypeId2)) searchUrl2 += `&contentTypeId=${contentTypeId2}`;
    searchUrl2 += `&keyword=${keyword2}`;
    console.log(searchUrl2)
    fetch(searchUrl2)
        .then((response) => response.json())
        .then((data) => makeList2(data));

}


// 검색 버튼을 누르면..
// 지역, 유형, 검색어 얻기.
// 위 데이터를 가지고 공공데이터에 요청.
// 받은 데이터를 이용하여 화면 구성.
// document.getElementById("btn-search").addEventListener("click", () => {
//     let searchUrl = `https://apis.data.go.kr/B551011/KorService1/searchKeyword1?serviceKey=${serviceKey}&numOfRows=10&pageNo=1&MobileOS=ETC&MobileApp=AppTest&_type=json&listYN=Y&arrange=A`;

//     let areaCode = 0;
//     let contentTypeId = 12;
//     let keyword = document.getElementById("search-keyword").value;

//     if (parseInt(areaCode)) searchUrl += `&areaCode=${areaCode}`;
//     if (parseInt(contentTypeId)) searchUrl += `&contentTypeId=${contentTypeId}`;
//     if (!keyword) {
//         alert("검색어 입력 필수!!!");
//         return;
//     } else searchUrl += `&keyword=${keyword}`;

//     fetch(searchUrl)
//         .then((response) => response.json())
//         .then((data) => makeList(data));
//     });

var positions; // marker 배열.
function makeList(data) {
    let boxes = document.querySelectorAll(".portfolio-item.t1");
    let boxes2 = document.querySelectorAll(".portfolio-info");
    let trips = data.response.body.items.item;
    console.log(trips);

    let tripList = ``;
    let nameList = ``;
    positions = [];
    let cnt = 0;
    trips.forEach((area) => {
        // console.log(area);
        if (area.firstimage === "") {
            return;
        }
        var img = document.createElement('img');
        img.src = `${area.firstimage}`;
        img.setAttribute('class', 'img-fluid border border-white m-auto'); 
        // tripList = `<img src="${area.firstimage}" class="img-fluid" alt="">`;
        boxes[cnt].appendChild(img);
        

        var text = document.createElement('h3');
        text.innerHTML = area.title;
        
        // nameList = `<img src="${area.firstimage}" class="img-fluid" alt="">`;
        boxes2[cnt].insertBefore(text, boxes2[cnt].firstChild);
        // boxes2[cnt].appendChild(text);
        cnt+=1;
    });
    
}

function makeList2(data) {
    let boxes = document.querySelectorAll(".portfolio-item.f1");
    let boxes2 = document.querySelectorAll(".portfolio-info.f1");
    console.log(boxes2);
    let trips = data.response.body.items.item;
    let tripList = ``;
    let nameList = ``;
    positions = [];
    let cnt = 0;
    trips.forEach((area) => {
        // console.log(area);
        if (area.firstimage === "") {
            return;
        }
        var img = document.createElement('img');
        img.src = `${area.firstimage}`;
        img.setAttribute('class', 'img-fluid border border-white m-auto'); 
        // tripList = `<img src="${area.firstimage}" class="img-fluid" alt="">`;
        boxes[cnt].appendChild(img);
        

        var text = document.createElement('h3');
        text.innerHTML = area.title;
        
        // nameList = `<img src="${area.firstimage}" class="img-fluid" alt="">`;
        boxes2[cnt].insertBefore(text, boxes2[cnt].firstChild);
        // boxes2[cnt].appendChild(text);
        cnt+=1;
    });
    
}

// // 카카오지도
// var mapContainer = document.getElementById("map"), // 지도를 표시할 div
// mapOption = {
//     center: new kakao.maps.LatLng(37.500613, 127.036431), // 지도의 중심좌표
//     level: 5, // 지도의 확대 레벨
// };

// // 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
// var map = new kakao.maps.Map(mapContainer, mapOption);

// function displayMarker() {
// // 마커 이미지의 이미지 주소입니다
// var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png";

// for (var i = 0; i < positions.length; i++) {
//     // 마커 이미지의 이미지 크기 입니다
//     var imageSize = new kakao.maps.Size(24, 35);

//     // 마커 이미지를 생성합니다
//     var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);

//     // 마커를 생성합니다
//     var marker = new kakao.maps.Marker({
//     map: map, // 마커를 표시할 지도
//     position: positions[i].latlng, // 마커를 표시할 위치
//     title: positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
//     image: markerImage, // 마커 이미지
//     });
// }

// // 첫번째 검색 정보를 이용하여 지도 중심을 이동 시킵니다
// map.setCenter(positions[0].latlng);
// }

function moveCenter(lat, lng) {
    map.setCenter(new kakao.maps.LatLng(lat, lng));
}
