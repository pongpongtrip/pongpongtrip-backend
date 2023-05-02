<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set value="${pageContext.request.contextPath}" var="root"></c:set>

<header id="header" class="fixed-top d-flex align-items-center header-transparent">
    <div class="container d-flex justify-content-between align-items-center">

      <div class="logo">
        <h1 class="text-light"><a href="${root }"><span>TRIP</span></a></h1>
        <!-- Uncomment below if you prefer to use an image logo -->
        <!-- <a href="index.html"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>-->
      </div>

      <nav id="navbar" class="navbar">
        <ul>
          <li><a class="active " href="${root}">홈</a></li>
          <li><a href="${root}/attraction/tripsearch">지역별여행지</a></li>
          <li><a href="${root }/attraction/tripplan">나의여행계획</a></li>
          <li><a href="#">핫플자랑하기</a></li>
          <li><a href="${root }/board?action=boardList">여행정보공유</a></li>
          <li class="dropdown"><a href="#"><svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor" class="bi bi-person-circle" viewBox="0 0 16 16">
            <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
            <path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"/>
          </svg>
          <c:if test="${not empty userinfo}">
              	&nbsp;${userinfo.userName} 님
		  </c:if>
		  <i class="bi bi-chevron-down"></i></a>
            <ul>
                <c:if test="${not empty userinfo}">
                	<c:if test="${userinfo.userId eq 'admin'}">
                		<li><a type="button" class="btn " id ="adminBtn" href="${root}/member/adminPage">관리자 페이지</a></li>
	                </c:if>
	                <li><a type="button" class="btn " id ="userinfoBtn" href="${root}/member/member-info">회원 정보</a></li>
	                <li><a type="button" class="btn " id ="logoutBtn" href="${root}/member/logout">로그아웃</a></li>
				</c:if>
				<c:if test="${empty userinfo}">
					<li><a type="button" class="btn " href="${root}/member/login">로그인</a></li>
                	<li><a type="button" class="btn " href="${root}/member/regist">회원가입</a></li>
				
				</c:if>
				
            </ul>
          </li>
          <!-- <li><a href="contact.html">Contact Us</a></li> -->
        </ul>
        <i class="bi bi-list mobile-nav-toggle"></i>
      </nav><!-- .navbar -->

    </div>
  </header>
  
