# web_project
졸업 프로젝트용 홈쇼핑 웹입니다.<br>
스프링 프레임워크를 이용했고 학습하면서 진행했습니다. <br>
데이터베이스 밑 기타 민감정보는 더미데이터이고 실제와는 다릅니다.<br>

<h1>기본 페이지</h1>

![1](https://user-images.githubusercontent.com/70567584/148721370-2b2ab453-e2b9-48f5-af78-fb65e8a79fc2.png)


<h5>기본 페이지 구현 기술<h5> <br>
페이징 구현 - ajax을 이용한 비동기 통신으로 페이지를 갱신하지 않고 스크롤 위치에 따라 다음페이지를 생성 <br>
장바구니 구현 - 클릭이벤트로 데이터베이스에 접근, 장바구니 내역확인을 위해 오른쪽에 고정위치한 내역확인 UI 설치(클릭시 오픈, 내역 확인) <br>
네비게이션 바, 이동UI(로그인, 개인정보, 장바구니 결제) - 네비게이션 기준(상품종류,게시판)에 따라 이동

![2](https://user-images.githubusercontent.com/70567584/148722088-6601759d-553c-4d94-9a68-bf7b2fd54b19.png)

마우스 오버시 장바구니 UI 등장 <br>

<h1>로그인</h1>

![로그인](https://user-images.githubusercontent.com/70567584/148724388-09212269-7a59-485b-bbfa-6dc06d82658e.png)

<h1>아이템 뷰</h1>

![image](https://user-images.githubusercontent.com/70567584/148724018-8cb31427-85f9-4c3e-b1ba-36e1b54c3e90.png)

<h1>게시판</h1>

![게시판](https://user-images.githubusercontent.com/70567584/148724280-18d5c8c4-c5f2-4912-a7e2-b8a200bdba67.png)
xss보안문제 간단하게 해결
