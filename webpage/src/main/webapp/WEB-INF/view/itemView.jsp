<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>itemView</title>
<link rel="stylesheet" href="/css/bootstrap.css">
<link rel="stylesheet" href="/css/jquery.bxslider.css">
<link rel="stylesheet" href="/css/css.css">

</head>
<body>
<div id="wrap">
		<div id="header">
			<h2>홈쇼핑</h2>
		</div>
		<div id="nav">
			<ul class="nav nav-tabs">

				<li role="presentation"><a href="/login" role="button">
						할인상품</a></li>
				<li role="presentation"><a href="/login" role="button">
						인기상품</a></li>
				<li role="presentation"><a href="/category?category=food"
					role="button"> 식품</a></li>
				<li role="presentation"><a href="/login" role="button"> 가전</a></li>
				<li role="presentation"><a href="/category?category=clothing"
					role="button"> 의류</a></li>
				<li role="presentation"><a href="/login" role="button"> 도서</a></li>
				<li role="presentation"><a href="/login" role="button"> 서비스</a></li>
				<li role="presentation"><a href="/login" role="button"> 잡화</a></li>

				<li role="presentation" class="dropdown"><a
					class="dropdown-toggle" data-toggle="dropdown" href="#"
					role="button" aria-expanded="false"> 나의쇼핑 <span class="caret"></span>
				</a>
				<c:choose>
				    <c:when test="${not empty sessionScope.userId}"> 
				        <ul class="dropdown-menu" role="menu">
						    <li><a>통합게시판</a></li>
						    <li><a>장바구니</a></li>
						    <li><a>이전장바구니</a></li>
						    <li><a>내정보</a></li>
					    </ul>
					</c:when>
					
					<c:otherwise>
					    <ul class="dropdown-menu" role="menu">
						    <li><a>로그인하세요</a></li>
					    </ul>
					</c:otherwise>
				   
				</c:choose>

					
				</li>

			</ul>
		</div>
		
		
		<div id="itemViewWrap">
		<div id="itemViewImg"><img src="${itemView.itemUrl}"></div>
		<div id="itemViewTextWrap">
		<div class="itemViewText"><h1>${itemView.itemName}</h1></div>
		<div class="itemViewText"><b>판매가</b>  <div class="itemView">${itemView.itemPrice}원</div></div>
		<div class="itemViewText"><b>상품설명</b> <div class="itemView">${itemView.itemText}</div></div>
		<div class="itemViewText"><b>배송지</b>  <div class="itemView"></div></div>
		<div class="itemViewText"><b>배송비</b>  <div class="itemView">5000원</div></div>
		<div class="itemViewText"><b>made in</b>  <div class="itemView"></div></div>
		<div class="itemViewText"><b>카드적립</b><div class="itemView"></div></div>
		</div>
		<div id="itemViewBtn">
		<button id="itemPutBtn" >장바구니</button>
		<button id="itemBuyBtn" >결제하기</button>
		</div>

			<div id="reviewWrap">
				<div class="review">
					<table border="1">
						<tr>
							<th>아이디</th>
							<th>리뷰내용</th>
							<th>별점</th>
							<th>입력날짜</th>
						</tr>
						<c:forEach var="review" items="${review}">
						<tr>
							<td>${review.memberId}</td>
							<td>${review.contents}</td>
							<td>${review.rating}</td>
							<td>${review.reviewTime}</td>
						</tr>
						</c:forEach>

					</table>
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
</body>
</html>