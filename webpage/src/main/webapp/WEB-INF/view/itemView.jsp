<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>itemView</title>
 <link
    rel="stylesheet"
    href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"
  />
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
		
		
		
		<div id="itemViewWrap">
		<div id="itemViewImg"><img src="${itemView.itemUrl}"></div>
		<div id="itemViewTextWrap">
		<div class="itemViewText"><h1><c:out value="${itemView.itemName}"></c:out></h1></div>
		<div class="itemViewText"><b>판매가</b>  <div class="itemView"><span id="itemViewPrice">${itemView.itemPrice}</span>원</div></div>
		<div class="itemViewText"><b>상품설명</b> <div class="itemView"><c:out value="${itemView.itemText}"></c:out></div></div>
		<c:if test="${itemView.discount eq true}">
		<div class="itemViewText"><b>할인가</b>  <div class="itemView">-<span id="itemViewDiscount">${itemView.discountNum}</span>원</div></div>
		</c:if>
		<div class="itemViewText"><b>추천점수(한사람당 1~5)</b>  <div class="itemView">${itemView.popularity}점</div></div>
		
		<div class="itemViewText"><b>배송비</b>  <div class="itemView">5000원</div></div>
		
		<input type="hidden" value="${itemView.itemId}" id="itemIdInput">
		
		</div>
		
		<div id="itemViewPriceSum"></div>
		<div id="itemViewBtn">
		<button id="minusQuantity">-</button><span id="quantityValue">1</span><button id="plusQuantity">+</button>
		
		<button id="itemPutBtn">장바구니</button>
		
		
		<form action="/cart/order" method="post">
			    <input type="hidden" name="orderItemList[0].itemId" value="${itemView.itemId}">
			    <input type="hidden" name="orderItemList[0].quantity" value="1" id="cartOrderQuantity">
				
				<input type="submit" id="itemBuyBtn" value="결제하기"> 
						
		</form>
		
		</div>

			<div id="reviewWrap">
				<div class="review">



					<div class="reviewContentsWrap"></div>
					<div id="reviewContentsPagingWrap"></div>

					<input type="hidden" id="writeBtnExist" value="${writeBtnExist}">


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
</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	
	<script src="/js/common.js"></script>
	<script src="/js/itemViewJS.js"></script>
	
</body>
</html>