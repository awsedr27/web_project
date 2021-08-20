<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>write</title>
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
			<h2>홈쇼핑</h2>
		</div>

		<div id="iconNav">
			<div id="iconWrap">
				<a href="/signIn"><i class="fas fa-power-off" id="iconPower"></i></a>
				<a href=""><i class="far fa-user" id="iconUser"></i></a> <a
					href="/cart"><i class="fas fa-shopping-cart" id="iconCart"></i></a>
			</div>
		</div>

		<div id="navWrap">
			<ul id="nav">
				<li class="navLi"><a href="/category?category=clothing">할인상품</a></li>
				<li class="navLi"><a href="/category?category=clothing">인기상품</a></li>
				<li class="navLi"><a href="/category?category=food">식품</a></li>
				<li class="navLi"><a href="/category?category=clothing">가전</a></li>
				<li class="navLi"><a href="/category?category=clothing">의류</a></li>
				<li class="navLi"><a href="/category?category=clothing">도서</a></li>
				<li class="navLi"><a href="/category?category=clothing">서비스</a></li>

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

		<div id="writeBbsWrap">
			<form action="/bbs/put" method="post">
				<input type="text" name="bbs_title" placeholder="제목입력하세요"> <input
					type="text" name="bbs_contents" placeholder="글을 입력하세요"> <input
					type="submit">


			</form>

		</div>



	</div>