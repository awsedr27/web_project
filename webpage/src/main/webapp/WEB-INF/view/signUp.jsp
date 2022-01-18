<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sign up</title>
<link rel="stylesheet" href="/css/jquery.bxslider.css">
<link rel="stylesheet" href="/css/css.css">

</head>
<body>
	<div id="wrap">
		<div id="headerSign" align='center'>
			<a href="/index"><h2>HOMESHOP</h2></a>
		</div>



		<div class="sign_box">
			<h2 align="center">회원가입</h2>
			<form action="/signUp" method="post" id="login">
				<div align='center'>
					<input type="text" class="id_login" name="memberId" placeholder="아이디"><br>
					<input type="password" class="password_login" name="memberPassword"
						placeholder="비밀번호"><br>
					<input type="date" id="birthday" name="birthday" placeholder="생일">
					<input type="text" id="phoneNum" name="phoneNum" placeholder="핸드폰번호 (-빼고)">
					<input type="text" id="email" name="email" placeholder="이메일">
					<input type="text" id="houseLocation" name="houseLocation" placeholder="집주소">
				    <input class="login_button" type="submit" value="회원가입">
				</div>
			</form>
		</div>



	



	

	</div>


	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	
	<script src="/js/common.js"></script>
</body>
</html>