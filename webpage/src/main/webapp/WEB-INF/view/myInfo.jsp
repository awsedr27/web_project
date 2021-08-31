<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>myInfo</title>
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
		
		<div id="myInfoWrap">
			<div id="myInfoText">
				<div>아이디 : <c:out value="${memberInfo.memberId}"></c:out></div>
				<div>생일 : ${memberInfo.birthday}</div>
				<div>전화번호 : ${memberInfo.phoneNum}</div>
				<div>이메일 : <c:out value="${memberInfo.email}"></c:out></div>
				<div>집주소 : <c:out value="${memberInfo.houseLocation}"></c:out></div>
			</div>
			<div id="myInfoBtn">
				<button>
					<a href="/myInfo/modify?mode=myInfo">수정하기</a>
				</button>
				<button>
					<a href="/myInfo/modify?mode=modifyPassword">비밀번호변경</a>
				</button>
			</div>
		</div>
		
		<div id="myInfoOrderWrap">
				<table class="myInfoOrderTable">
					<tr>
						<th>주문ID</th>
						<th>물품ID</th>
						<th>이름</th>
						<th>가격</th>
						<th>할인</th>
						<th>수량</th>
						<th></th>
					</tr>

					<c:forEach var="order" items="${memberInfoOrder}">
						<tbody class="myInfoOrderDeleteBody">
							<tr class="myInfoOrderDeleteWrap">
								<td class="myInfoOrderDelete" colspan="7"><i
									class="far fa-trash-alt"></i></td>
							</tr>
							<c:forEach var="item" items="${order.orderItemList}">
								<tr>
									<td class="myInfoOrderId">${item.orderId}</td>
									<td>${item.itemId}</td>
									<td>${item.itemName}</td>
									<td>${item.itemPrice}</td>
									<td>${item.discountNum}</td>
									<td>${item.quantity}</td>
									<td></td>
								</tr>
							</c:forEach>

						</tbody>
					</c:forEach>
				</table>
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