<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sign in</title>

<link rel="stylesheet" href="/css/jquery.bxslider.css">
<link rel="stylesheet" href="/css/css.css">

</head>
<body>
	<div id="wrap">
		<div id="headerSign" align='center'>
			<a href="/index"><h2>HOMESHOP</h2></a>
		</div>



		<div class="sign_box">
			<h2 align="center">로그인</h2>
			<form action="/signIn" method="post" id="login">
				<div align='center'>
					<input type="text" class="id_login" name="userID" placeholder="아이디"><br>
					<input type="password" class="password_login" name="userPassword"
						placeholder="비밀번호"><br> <input class="login_button"
						type="submit" value="로그인">
				</div>
			</form>
			
			<div id="loginSearch">
			<a href="/serchId">아이디찾기</a> 
			<a href="/serchPassword">비밀번호찾기</a>
			</div>
			<button type="button" id="signUpBtn"
				onclick="location.href='/signUp'">회원가입</button>
			
		</div>



	



	

	</div>


	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	
	<script src="/js/common.js"></script>
</body>
</html>