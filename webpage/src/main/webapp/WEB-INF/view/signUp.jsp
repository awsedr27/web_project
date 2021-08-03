<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sign up</title>
<link rel="stylesheet" href="/css/bootstrap.css">
<link rel="stylesheet" href="/css/jquery.bxslider.css">
<link rel="stylesheet" href="/css/css.css">

</head>
<body>
	<div id="wrap">
		<div align='center'>
			<h2>홈쇼핑</h2>
		</div>



		<div class="sign_box">
			<h2 align="center">회원가입</h2>
			<form action="/signUp" method="post" id="login">
				<div align='center'>
					<input type="text" class="id_login" name="memberID" placeholder="아이디"><br>
					<input type="password" class="password_login" name="memberPassword"
						placeholder="비밀번호"><br>
					<input type="date" id="birthday" name="birthday" placeholder="생일">
					<input type="text" id="phoneNum" name="phoneNum" placeholder="핸드폰번호 (-빼고)">
					<input type="text" id="email" name="email" placeholder="이메일">
				    <input class="login_button" type="submit" value="회원가입">
				</div>
			</form>
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
	<script src="/js/bootstrap.js"></script>
	<script src="/js/jquery.bxslider.js"></script>
	<script src="/js/custom.js"></script>
</body>
</html>