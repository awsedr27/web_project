<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>

<link rel="stylesheet" href="/css/jquery.bxslider.css">
<link rel="stylesheet" href="/css/css.css">


</head>
<body>
	<div id="wrap">
		<div id="header">
			<h2>홈쇼핑</h2>
		</div>
		
		
<div id="navWrap">
<ul id="nav">
<li class="navLi"><a href="">할인상품</a></li>
<li class="navLi"><a href="">인기상품</a></li>
<li class="navLi"><a href="">식품</a></li>
<li class="navLi"><a href="">가전</a></li>
<li class="navLi"><a href="">의류</a></li>
<li class="navLi"><a href="">도서</a></li>
<li class="navLi"><a href="">서비스</a></li>

</ul>
<div id="dropDownWrap">
<button id="dropDownBtn">나의쇼핑</button>
<c:choose>
			<c:when test="${not empty sessionScope.memberId}">
				<ul>
					<li class="dropDown"><a href="">서비스</a></li>
					<li class="dropDown"><a href="">서비스</a></li>
					<li class="dropDown"><a href="">서비스</a></li>
				</ul>
			</c:when>

			<c:otherwise>
				<ul>
					<li><a>로그인하세요</a></li>
				</ul>
			</c:otherwise>

		</c:choose>

</div>


</div>
		

		<div id="sliderBar">
			<ul class="slide">
				<li><img src="/img/1.jpg"></li>
				<li><a href="/login"><img src="/img/2.png"></a></li>
				<li><img src="/img/3.jpg"></li>
				<li><img src="/img/4.jpg"></li>
			</ul>
		</div>

		<div id="itemListWrap">
			<c:forEach var="item" items="${itemList}">
				<div class="itemImg">
					<a href="/itemView?itemId=${item.itemId}">
					<img class="item"src="${item.itemUrl}">
					</a>
					<div class="itemText">
						<h2>${item.itemText}</h2>
					</div>
					<div class="itemPrice">
						<p>${item.itemPrice}</p>
					</div>
					<div class="itemId">${item.itemId}
					</div>
				</div>
			</c:forEach>
		</div>
		
		<div id="cartBtnWrap">
		<button id="cartBtn">사이드버튼</button>
		</div>


		<div id="footer">
			<div id="footerTitle">
				<h2>HomeShop</h2>
				<br> 대표이사 : 김진옥 주소 : 서울특별시 은평구 <br> 판매신고번호 : 2020-서울-0000호
				<br>개인정보 및 보호책임자 : 김진옥 <br> 안전한 금융거래를 위해 타인에게 비밀번호를 발설하지
				마십시오.<br>
			</div>
			<div id="footerContens">
				<br> 고객센터 전화번호 : 000-0000-0000 <br>(업무시간 09:00~21:00) <br>
				이메일 : awsedr27@naver.com<br>
			</div>
		</div>

	</div>


	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script src="/js/bootstrap.js"></script>
	<script src="/js/jquery.bxslider.js"></script>
	<script src="/js/custom.js"></script>
</body>
</html>