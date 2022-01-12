<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
 <link
    rel="stylesheet"
    href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"
  />
<link rel="stylesheet" href="/css/jquery.bxslider.css">
<link rel="stylesheet" href="/css/css.css">


</head>
<body>
	<div id="wrap">
		<div id="header">
			<a href="/index"><h2>HOMESHOP</h2></a>
		</div>

		<div id="iconNav">
			<div id="iconWrap">
				<a href="/signIn"><i class="fas fa-power-off" id="iconPower"></i></a>
				<a href="/myInfo"><i class="far fa-user" id="iconUser"></i></a> <a href="/cart"><i
					class="fas fa-shopping-cart" id="iconCart"></i></a>
			</div>
		</div>

		<div id="navWrap">
			<ul id="nav">
				<li class="navLi"><a href="/category?category=discountItem">할인상품</a></li>
				<li class="navLi"><a href="/category?category=hotItem">인기상품</a></li>
				<li class="navLi"><a href="/category?category=food">식품</a></li>
				<li class="navLi"><a href="/category?category=appliance">가전</a></li>
				<li class="navLi"><a href="/category?category=clothing">의류</a></li>
				<li class="navLi"><a href="/category?category=book">도서</a></li>
				<li class="navLi"><a href="/bbs">게시판</a></li>

			</ul>
			<div id="dropDownWrap">
				<button id="dropDownBtn">
					내 쇼핑<i class="fas fa-chevron-down" id="iconChevronDown"></i>
				</button>

				<c:choose>
					<c:when test="${not empty sessionScope.memberId}">
						<ul>
					    	<li class="dropDown"><a href="/order">주문하기</a></li>
							<li class="dropDown"><a href="/cart">장바구니</a></li>
							<li class="dropDown"><a href="/signOut">로그아웃</a></li>
						</ul>
					</c:when>

					<c:otherwise>
						<ul>
							<li><a href="/signIn">로그인</a></li>
						</ul>
					</c:otherwise>

				</c:choose>

			</div>


		</div>


		<div id="sliderBar">
			<ul class="slide">
				<li><a href="/login"><img src="/img/banner1.jpg"></a>
				    <a href="/login"><img src="/img/banner2.jpg"></a>
				</li>
				<li><a href="/login"><img src="/img/banner3.jpg"></a>
				    <a href="/login"><img src="/img/banner4.jpg"></a>
				</li>
				<li><a href="/login"><img src="/img/banner5.jpg"></a>
				    <a href="/login"><img src="/img/banner6.jpg"></a>
				</li>

			</ul>
		</div>

		<div id="itemListWrap">
			<c:forEach var="item" items="${itemList}">
				<div class="itemWrap">
					<div class="itemImgWrap">
						<a href="/itemView?itemId=${item.itemId}"> <img
							class="itemImg" src="${item.itemUrl}">
						</a>
						<div class="itemIcon">
							<a class="itemCartPut">
							<i class="fas fa-shopping-basket"></i></a>
						</div>
					</div>

					<div class="itemTextWrap"> 
						<span class="itemText"><c:out value="${item.itemText}"></c:out></span>
					</div>
					
					<div class="itemPriceWrap">
						<span class="itemPrice">${item.itemPrice}</span>원
					</div>
					<div class="itemDiscountNumWrap">
						-<span class="itemDiscountNum">${item.discountNum}</span>원
					</div>
					<div class="itemResultPriceWrap">
						<span class="itemResultPrice"></span>원
					
					</div>
					<div class="itemId">${item.itemId}</div>
					
				</div>
			</c:forEach>
		</div>
		
		<div id="cartBtnWrap">
		<button type="button" id="cartBtn">
		<i id="iconChevronLeft" class="fas fa-chevron-left"></i>
		</button>
		</div>
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
	<script src="/js/jquery.bxslider.js"></script>
	<script src="/js/custom.js"></script>
	<script src="/js/common.js"></script>
</body>
</html>