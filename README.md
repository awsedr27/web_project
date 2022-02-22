# web_project
졸업 프로젝트용 홈쇼핑 웹입니다.<br>
스프링 프레임워크를 이용했고 학습하면서 진행했습니다. <br>
데이터베이스 밑 기타 민감정보는 더미데이터이고 실제와는 다릅니다.<br>

<h1>기본 페이지</h1>

![정면](https://user-images.githubusercontent.com/70567584/155086646-cd70d2e9-7f71-4c63-a0f8-f29e35912888.png)


<h5>기본 페이지 구현 기술<h5> <br>
페이징 구현 - ajax을 이용한 비동기 통신으로 페이지를 갱신하지 않고 스크롤 위치에 따라 다음페이지를 생성 <br>
장바구니 구현 - 클릭이벤트로 데이터베이스에 접근, 장바구니 내역확인을 위해 오른쪽에 고정위치한 내역확인 UI 설치(클릭시 오픈, 내역 확인) <br>
네비게이션 바, 이동UI(로그인, 개인정보, 장바구니 결제) - 네비게이션 기준(상품종류,게시판)에 따라 이동

![오버](https://user-images.githubusercontent.com/70567584/155086824-78570425-4a2f-4a9b-bbb2-0924a6ed5c84.png)

마우스 오버시 장바구니 UI 등장 <br>

<h1>로그인</h1>

![로그인신](https://user-images.githubusercontent.com/70567584/155087105-5249893e-9bf2-435a-8a0a-52f9201cd858.png)

<h1>아이템 뷰</h1>

![아이템뷰 신](https://user-images.githubusercontent.com/70567584/155087335-2a898682-ba3e-4f1f-9559-657521e20a9f.png)

<h1>게시판</h1>

![게시판 신](https://user-images.githubusercontent.com/70567584/155087499-45c3c68e-ad9e-480a-88f9-68ba2ebb42b6.png)
xss보안문제 간단하게 해결
