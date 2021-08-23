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
			<h2>홈쇼핑</h2>
		</div>
		
		<div id="iconNav">
			<div id="iconWrap">
				<a href="/signIn"><i class="fas fa-power-off" id="iconPower"></i></a>
				<a href=""><i class="far fa-user" id="iconUser"></i></a> <a href="/cart"><i
					class="fas fa-shopping-cart" id="iconCart"></i></a>
			</div>
		</div>

		<div id="navWrap">
			<ul id="nav">
				<li class="navLi"><a href="">할인상품</a></li>
				<li class="navLi"><a href="">인기상품</a></li>
				<li class="navLi"><a href="/category?category=food">식품</a></li>
				<li class="navLi"><a href="">가전</a></li>
				<li class="navLi"><a href="/category?category=clothing">의류</a></li>
				<li class="navLi"><a href="">도서</a></li>
				<li class="navLi"><a href="">서비스</a></li>

			</ul>
			<div id="dropDownWrap">
				<button id="dropDownBtn">
					내 쇼핑<i class="fas fa-chevron-down" id="iconChevron"></i>
				</button>

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
		
		
		
		<div id="itemViewWrap">
		<div id="itemViewImg"><img src="${itemView.itemUrl}"></div>
		<div id="itemViewTextWrap">
		<div class="itemViewText"><h1>${itemView.itemName}</h1></div>
		<div class="itemViewText"><b>판매가</b>  <div class="itemView">${itemView.itemPrice}원</div></div>
		<div class="itemViewText"><b>상품설명</b> <div class="itemView">${itemView.itemText}</div></div>
		<c:if test="${itemView.discount eq true}">
		<div class="itemViewText"><b>할인가</b>  <div class="itemView">-${itemView.discountNum}원</div></div>
		</c:if>
		<div class="itemViewText"><b>추천점수(한사람당 1~5)</b>  <div class="itemView">${itemView.popularity}점</div></div>
		<div class="itemViewText"><b>배송지</b>  <div class="itemView"></div></div>
		<div class="itemViewText"><b>배송비</b>  <div class="itemView">5000원</div></div>
		
		<input type="hidden" value="${itemView.itemId}" id="itemIdInput">
		
		</div>
		<div id="itemViewBtn">
		<button id="itemPutBtn" onclick="location.href='/cartPut?itemId=${itemView.itemId}'">장바구니</button>
		<button id="itemBuyBtn" >결제하기</button>
		</div>

			<div id="reviewWrap">
				<div class="review">



					<div class="reviewContentsWrap">
						

					</div>


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
	<script src="/js/bootstrap.js"></script>
	<script src="/js/common.js"></script>
	<script src="/js/review.js"></script>
	
</body>
</html>