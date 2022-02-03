<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>order</title>
 <link
    rel="stylesheet"
    href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"
  />
<link rel="stylesheet" href="/css/jquery.bxslider.css">
<link rel="stylesheet" href="/css/css.css">
<script type="text/javascript">
if(${cartEmpty}==true){
	alert("장바구니가 비어있습니다.");
	location.href="/index";
}
</script>

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


		<div id="orderWrap">
			<div id="orderLeft">

				<div id="orderImgWrap">
					<span>주문상품</span>
					<ul>
						<c:forEach var="cartItem" items="${cartList}">
							<li><img src="${cartItem.itemUrl}"></li>
						</c:forEach>
					</ul>
				</div>





				<div id="orderInfo">
					<form action="/cart/order/payment" method="post">
						<table>
							<tr>
								<th><p class="orderInfoText">주문자</p></th>
								<td><input type="text" name="orderName"></td>
							</tr>

							<tr>
								<th><p class="orderInfoText">배송지</p></th>
								<td><input type="text" name="orderLocation"></td>
							</tr>

							<tr>
								<th><p class="orderInfoText">받는분</p></th>
								<td><input type="text" name="orderRecipient"></td>
							</tr>

							<tr>
								<th><p class="orderInfoText">요청사항</p></th>
								<td><input type="text" name="orderRequest"></td>
							</tr>
						</table>
						<div><input type="submit" value="결제하기"></div>
					</form>
				</div>
			</div>

			<div id="orderRight">
				<div id="orderInfoListWrap">
					<table id="orderInfoList">
					<tr>
					<th><p>물건이름</p></th>
					<th><p>가격</p></th>
					<th><p>할인가격</p></th>
					<th><p>수량</p></th>
					</tr>
						<c:forEach var="cartItems" items="${cartList}">
							<tr>
								<th><p>
										<c:out value="${cartItems.itemName}"></c:out>
									</p></th>


								<td>
									<p>
										<c:choose>
											<c:when test="${cartItems.itemPrice eq '0'}"></c:when>
											<c:otherwise>
												<c:out value="${cartItems.itemPrice}"></c:out>
											</c:otherwise>
										</c:choose>
									</p>
								</td>
								<td><p style="color:red">
										<c:out value="${cartItems.discountNum}"></c:out>
									</p></td>
								<td><p>
										<c:out value="${cartItems.quantity}"></c:out>
									</p></td>
							</tr>
						</c:forEach>
					</table>
				</div>
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
	
	<script src="/js/common.js"></script>
</body>
</html>