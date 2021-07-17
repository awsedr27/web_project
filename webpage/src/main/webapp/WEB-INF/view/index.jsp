<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
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

				<li role="presentation" class="dropdown"><a
					class="dropdown-toggle" data-toggle="dropdown" href="#"
					role="button" aria-expanded="false"> 나의쇼핑 <span class="caret"></span>
				</a>
					<ul class="dropdown-menu" role="menu">
						<li><a>장바구니</a></li>
						<li><a>이전장바구니</a></li>
						<li><a>내정보</a></li>
					</ul></li>

			</ul>
		</div>
		<div id="sliderBar">
			<ul class="slide">
				<li><img src="/img/1.jpg"></li>
				<li><a href="/login"><img src="/img/2.png"></a></li>
				<li><img src="/img/3.jpg"></li>
				<li><img src="/img/4.jpg"></li>
			</ul>
		</div>
		<div id="itemImg"></div>
		<div id="footer"></div>
	</div>


	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script src="/js/bootstrap.js"></script>
	<script src="/js/jquery.bxslider.js"></script>
	<script src="/js/custom.js"></script>
</body>
</html>