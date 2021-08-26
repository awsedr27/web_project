<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cart</title>
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
							<li class="dropDown"><a href="">장바구니</a></li>
							<li class="dropDown"><a href="">서비스</a></li>
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

		<div class="cartTableItemWrap">
			<c:choose>
				<c:when test="${not empty sessionScope.memberId}">
					<table>

						<tr>
							<th>이름</th>
							<th>가격</th>
							<th>할인</th>
							<th>사진</th>
							<th>개수</th>
							
							<td></td>
						</tr>

						<c:forEach var="cartItem" items="${cartList}">



							<tr>
								<td><c:out value="${cartItem.itemName}"></c:out></td>
								<td><span class="cartTableItemPrice">${cartItem.itemPrice}</span>원</td>
								<c:choose>
								<c:when test="${cartItem.discount eq true}">
								<td>-<span class="cartTableItemDiscount">${cartItem.discountNum}</span>원</td>
								</c:when>
								<c:otherwise>
								<td>-<span class="cartTableItemDiscount">0</span>원</td>
								</c:otherwise>
								</c:choose>
								<td><img src="${cartItem.itemUrl}"></td>
								<td><div class="itemId">${cartItem.itemId}</div><button class="cartQuantityMiusBtn">-</button><span class="cartQuantity">${cartItem.quantity}</span><button class="cartQuantityPlusBtn">+</button></td>
								
								<td><div>
										<button class="cartDelBtn" value="${cartItem.itemId}">
											<i class="far fa-trash-alt"></i>
										</button>
									</div></td>
							</tr>

						</c:forEach>
					</table>

					<div id="cartTextWrap">

						<div class="cartText">총 주문금액</div>
						<div class="cartTextPrice">
							<span id="cartPriceSum">${cartSum}</span>원
						</div>
						<div class="cartText">할인 금액</div>
						<div class="cartTextPrice">
							-<span id="cartPriceDiscountSum">${cartDiscountSum}</span>원
						</div>
						<div class="cartText">예상결제금액</div>
						<div class="cartTextPrice">
							<span id="cartAllPriceSum"></span>원
						</div>
						<div id="cartOrderBtnWrap">
						<form action="/cart/order" method="post">
						<c:forEach var="cartOrderItem" items="${cartList}" varStatus="status">
						    <input type="hidden" name="orderItemList[${status.index}].itemId" value="${cartOrderItem.itemId}">
						    <input type="hidden" name="orderItemList[${status.index}].quantity" value="${cartOrderItem.quantity}">
							
						
						</c:forEach>
						    
						
						
						    <input type="submit"value="주문하기">
						
						</form>
						</div>

					</div>


				</c:when>
				<c:otherwise>로그인하세요</c:otherwise>
			</c:choose>
         </div>
			<div id="footer">
				<div id="footerTitle">
					<h2>HomeShop</h2>
					<br> 대표이사 : 김진옥 주소 : 서울특별시 은평구 <br> 판매신고번호 :
					2020-서울-0000호 <br>개인정보 및 보호책임자 : 김진옥 <br> 안전한 금융거래를 위해
					타인에게 비밀번호를 발설하지 마십시오.<br>
				</div>
				<div id="footerContens">
					<br> 고객센터 전화번호 : 000-0000-0000 <br>(업무시간 09:00~21:00) <br>
					이메일 : awsedr27@naver.com<br>
				</div>
			</div>
		

	</div>


		<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="/js/common.js"></script>
</body>
</html>