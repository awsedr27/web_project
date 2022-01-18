<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>myInfoModify</title>
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

		<c:if test="${mode eq 'myInfo'}">

			<div class="myInfoModifyWrap">
				<form action="/myInfo/modify_action" method="post">
					<table id='myInfoModifyTable'>
						<tr>
							<th>
								<p class='myInfoModifyText'>아이디</p>
							</th>
							<td><input type="text" name="memberId"
								value="<c:out value="${memberInfo.memberId}"></c:out>">
							</td>
						</tr>
						<tr>
							<th>
								<p class='myInfoModifyText'>생일</p>
							</th>
							<td><input type="date" name="birthday"
								value="<c:out value='${memberInfo.birthday}'></c:out>">

							</td>
						</tr>

						<tr>
							<th>
								<p class='myInfoModifyText'>전화번호</p>
							</th>
							<td><input type="number" name="phoneNum"
								value="<c:out value='${memberInfo.phoneNum}'></c:out>">
							</td>
						</tr>

						<tr>
							<th>
								<p class='myInfoModifyText'>이메일</p>
							</th>
							<td><input type="text" name="email"
								value="<c:out value="${memberInfo.email}"></c:out>"></td>
						</tr>

						<tr>
							<th>
								<p class='myInfoModifyText'>집주소</p>
							</th>
							<td><input type="text" name="houseLocation"
								value="<c:out value="${memberInfo.houseLocation}"></c:out>">
							</td>
						</tr>
					</table>
					<input type="hidden" name="mode" value="myInfo">
					<div id='myInfoModifyBtn'>
						<input type="submit" value="수정완료">
					</div>
				</form>



			</div>
		</c:if>

		<c:if test="${mode eq 'modifyPassword'}">
			<div class="myInfoModifyWrap">
				<form action="/myInfo/modify_action" mothod="post">
					<table id='myInfoModifyTable'>
						<tr>
							<th><p>현재 비밀번호</p></th>
							<td><input type="password" name="memberPassword"></td>
						</tr>

						<tr>
							<th><p>새로운 비밀번호</p></th>
							<td><input type="password" name="newPassword"></td>
						</tr>

					</table>
					<input type="hidden" name="mode" value="modifyPassword"> 
					<div id='myInfoModifyBtn'>
						<input type="submit" value="수정완료">
					</div>
				</form>
			</div>
		</c:if>










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