# 🚗 Team 202Success 프로젝트 ( 영화 어때-자동차극장) 🎥


## 목차
  
  - [개요]
  
  - [기술 스택]
    
  - [프로젝트 설계]
    
  - [핵심 기능]
    
  - [주요기능 실행화면]
    
  - [개선사항]

## 🚩 개요

이 프로젝트는 팀프로젝트로 협의를 통해 **자동차 극장 예매사이트**를 개발하는 것으로 일반적인 영화사이트보다 색다른 접근으로 개발자의 입장에서 많은 기능 구현 과제들을 통해 성장할 수 있는 계기가 될 것으로 기대되어 선택하게 되었습니다.
이 프로젝트는 학습한 웹 개발 기술 HTML, CSS, JavaScript와 Servlet, JSP, 스프링 프레임워크 등을 활용하고, 오라클 데이터베이스를 적용해 동작하는 웹 애플리케이션입니다.

*프로젝트 목표: 소셜 로그인 및 결제 API를 적용하여 서버와 클라이언트가 별도로 분리된 Spring Framework 기반의 JSP 영화 예매 사이트 "영화어때" 개발.

웹사이트의 주요 기능은 예매, 리뷰 작성,관리자계층 등을 포함하며, 사용자 친화적 인터페이스를 통해 편리한 영화 예매 경험을 제공하는 것을 목표로 합니다.

**개발 기간 : 24/11/14 ~ 24/12/13

## 💻 사용한 기술 스택
- API : 카카오 소셜 API, Kobis API(박스오피스 영화 정보), TMDB API(영화 상세정보), KakaoPay API, OpenWeatherMap API, JavaMail API

- 개발 환경 : Java11, Spring Tool Suite3(3.9.17.RELEASE), Visual Studio Code, Apache Tomcat9.0, Windows 10
- 템플릿 엔진 : JSP
- 프로그래밍 언어 : Java(11), JavaScript(ES6)
- 마크업 언어 : HTML, XML
- 스타일 시트 언어 : CSS
- 데이터베이스: Oracle(11.2.0.2.0)
- 타겟 : Web Browser
- 버전 관리 : Git
- 문서 관리 : Notion
- 라이브러리 : Spring-Security(5.4.2), Spring-Web-MVC, MyBatis(3.5.14), Lombok, ojdbc8, HikariCP, Jackson, Gson, AspectJ, Thumbnailator, Json-simple, slf4j, Junit(4.12), Bootstrap

## **참고**
웹사이트(메가 박스([[(https://www.megabox.co.kr/))](https://www.megabox.co.kr/), 마이페이지-디트릭스(https://www.dtryx.com/main.do?cgid=FE8EF4D2-F22D-4802-A39A-D58F23A29C1E)) 
- 

 ## 👾 프로젝트 설계, 구현 📂 PPT 📂 (ERD, USECASE)
프로젝트 설계, 구현 PPT

<div align="center">

| ![이미지1](https://github.com/user-attachments/assets/552a99e3-6de4-4d8d-b885-b7a868dbca20) | ![이미지2](https://github.com/user-attachments/assets/b900c307-6062-476e-ab54-03291c31b202) |
| :----------------------: | :----------------------: |
| ![이미지3](https://github.com/user-attachments/assets/c2bc93f6-55c1-4233-9e1f-74e2f691590b) | ![이미지4](https://github.com/user-attachments/assets/756c34a2-d736-4ea0-9d94-65b465be2abe) |
| ![이미지5](https://github.com/user-attachments/assets/0bb9d94e-52c3-4eb2-8227-a78761a613f4) | ![이미지6](https://github.com/user-attachments/assets/e05b1d42-5faa-4632-8abf-bcb719f2b013) |
| ![이미지7](https://github.com/user-attachments/assets/4982eced-af2d-47a3-ba44-cb2a09ff9bb2) | 
|![이미지8](https://github.com/user-attachments/assets/889b8aa5-87f1-408c-b39e-f748755e710a) |![이미지9](https://github.com/user-attachments/assets/7c714671-2cd4-4579-bdf7-571a70e63541) | 
|![이미지10](https://github.com/user-attachments/assets/ad98627b-48c2-434a-80bf-7bb5097c7f6e) |![이미지11](https://github.com/user-attachments/assets/1aad1912-b602-473b-afd8-2151f133640d) | 
|![이미지12](https://github.com/user-attachments/assets/f2d82abc-c5bd-408c-9c35-10b62722098d) |![이미지13](https://github.com/user-attachments/assets/389f1e45-213b-46b5-822c-b1dd6469235f) | 
|![이미지14](https://github.com/user-attachments/assets/7221ceeb-75e1-4624-a677-89e0efee38fa) |![이미지15](https://github.com/user-attachments/assets/6624219e-af21-4de2-9ca7-923735a40a31) |
</div>

<div align="center">
<hr>
<img src="https://github.com/user-attachments/assets/bbd83ac8-12a3-4a42-9073-2a978256a89c" alt="이미지17" width="1000" height="600"><hr>
<img src="https://github.com/user-attachments/assets/f3899034-b0e3-4837-83e5-8499e2b1fe29" alt="이미지18" width="1000" height="600"><hr>
<img src="https://github.com/user-attachments/assets/28c13f97-16e9-40fe-9bb3-2d57822bac03" alt="이미지19" width="1000" height="600"><hr>
<img src="https://github.com/user-attachments/assets/c34c4aa2-f246-49ea-99f6-b07985351c3c" alt="이미지19" width="1000" height="600"><hr>
<img src="https://github.com/user-attachments/assets/192af4c6-8df4-468b-ac41-ebe1d24339a7" alt="이미지19" width="1000" height="600"><hr>
</div>

<div align="center">

| ![이미지20](https://github.com/user-attachments/assets/80cb62de-9190-41fb-8e33-83e34311f67c) | ![이미지21](https://github.com/user-attachments/assets/286612ee-f33f-4272-acb2-9778a1b18e27) |
| :----------------------: | :----------------------: |
| ![이미지22](https://github.com/user-attachments/assets/dd23b104-994b-4d09-93e7-9cd007269f94) | ![이미지23](https://github.com/user-attachments/assets/efb5a059-4f71-4b05-a52e-69758a3ed7bf) |
| ![이미지24](https://github.com/user-attachments/assets/0daa22be-bbad-4aff-8bfd-95bd70d23fd6) | ![이미지25](https://github.com/user-attachments/assets/60626690-9843-4d46-b698-fd914cbc262d) |
| ![이미지26](https://github.com/user-attachments/assets/66411fc4-94b8-466a-bd7e-1c536bb71820) | ![이미지27](https://github.com/user-attachments/assets/0535a0e7-1e95-41fc-8069-5591d828e57e) |
| ![이미지28](https://github.com/user-attachments/assets/5440c898-e2f7-483d-b060-62dffc495fcf) | ![이미지29](https://github.com/user-attachments/assets/5ee019ae-90b4-4e23-9024-07ea23d5f8ca) |
| ![이미지30](https://github.com/user-attachments/assets/4d4eb88c-7142-46f5-b51a-e14908e46016) | ![이미지31](https://github.com/user-attachments/assets/33dca4c2-33ba-44af-9332-d548277dc8a5) |
| ![이미지32](https://github.com/user-attachments/assets/7d89fb38-ccd9-4fea-8721-c8e8a1308827) | ![이미지33](https://github.com/user-attachments/assets/c2f9697d-99b7-4562-b401-81514e319ecc) |
| ![이미지34](https://github.com/user-attachments/assets/7df4bbbe-5bf9-4be6-bfef-53c701c297d9) | ![이미지35](https://github.com/user-attachments/assets/330d995d-6b48-4224-81a6-03d310cde84a) |
| ![이미지36](https://github.com/user-attachments/assets/cc95b7f3-c3e8-4105-a299-6f849bc2ba5f) | ![이미지37](https://github.com/user-attachments/assets/8d0223a5-bd69-4cd0-951b-76b44724b612) |
| ![이미지38](https://github.com/user-attachments/assets/259722d5-29c9-444b-8bea-95381c295997) | ![이미지39](https://github.com/user-attachments/assets/9ee0a08a-6724-4ce1-b589-eb0d59787f1d) |
| ![이미지40](https://github.com/user-attachments/assets/bea44e4d-f8c9-4ee6-b18c-b7a010bbc2d7) | ![이미지41](https://github.com/user-attachments/assets/d1102693-8b77-4bec-8bbb-43dbaf819703) |
| ![이미지42](https://github.com/user-attachments/assets/e9ea3fd6-687a-43e3-83ec-0597a040dc4c) |

</div>

## 🎯 핵심 기능

#### 영화 예매
- 박스오피스 정보(kobis API)와 해당 영화 이름을 비교하여 영화 상세정보(TMDB API)를 결합
- 세션을 통한 영화정보 API호출 중복 최소화
- 최근 댓글순으로 정렬
- 인증객체를 통해 유저만 예매페이지 이동
- 유저의 나이와 영화의 연령제한등급을 비교하여 연령등급을 충족시 예매페이지로 이동
- 유저의 차량 크기에 따라 예매할 수 있는 구역을 나눔


#### 일반회원
- 소셜 로그인(카카오)을 통해 닉네임, 이메일을 받아와 회원가입창을 통해 추가정보 입력(생년월일)
- 아이디(이메일) 중복확인
- 비밀번호 암호화 처리(bcrypt)
- 예매한 영화 마이페이지를 통해 취소, 결재(Kakao API)
- 리뷰(신고, 작성, 수정) 버튼으로 자신의 리뷰에는 작성, 수정버튼 / 타인의 댓글에는 신고버튼

#### 관리자
- 대시보드(회원 수, 신고리뷰 수, 예매 수, 최근 예매정보 조회) 
- 공지 등록(페이징처리, 공지작성, 수정, 공개-비공개)
- 회원 관리(페이징처리, 필터링(이름, 아이디, 이름 or 아이디), 삭제)
- 신고리뷰관리(페이징처리, 필터링(아이디, 내용, 아이디 or 내용), 삭제)
- 예약목록(페이징처리, 필터링(영화이름, 아이디, 영화이름 or 아이디), 삭제)


## 🎬 주요기능 실행화면
주요기능 실행화면

 * **메인 페이지**

  * **로그인**
    * 메인 페이지 우측 상단 네비게이션 메뉴를 통해 `로그인` 페이지에 접근이 가능합니다.
      - 로그인하지 않은 유저는 예매, 더 많은 영화, 마이페이지로 접근할 수 없습니다.

    <img src="https://github.com/user-attachments/assets/283956fd-2f73-4e58-ad53-2b3d192514a6" alt="메인인" width="650" height="400"><br>

  * **회원가입**
    * (통합) 로그인 페이지의 `카카오 로그인` 버튼을 통해 이동한 회원가입 페이지에서 받아온 이름, 이메일을 이용하여 추가정보 입력 후 일반 회원가입을 진행할 수 있습니다.

    <img src="https://github.com/user-attachments/assets/15809829-e6e8-4b7b-a582-eeabb10c531e" alt="회원가입" width="650" height="400"><br>
 <img src="https://github.com/user-attachments/assets/9aaafc45-27df-4adb-836e-9637486c27d6" alt="회원가입" width="650" height="400"><br>
  * **메인화면**
    * 메인 화면에서는 다음과 같은 정보를 조회할 수 있습니다:
      - 인기 상영작
      - 영화 간략 줄거리
      - 좋아요 수

    <img src="https://github.com/user-attachments/assets/958761d9-4a21-4215-b8ae-e048266707b4" alt="메인화면" width="650" height="400">

  * **더 많은 영화**
    * `더 많은 영화`에서는 메인페이지에 표시된 영화를 포함한 나머지 영화를 표시합니다.

    <img src="https://github.com/user-attachments/assets/f0745a93-aba6-43bb-8e65-14a669581d1d" alt="더 많은 영화" width="650" height="400">

      

* **상세페이지**
   
  * `상세페이지`에서는 메인에서는 얻을 수 없었던 영화정보를 보여주며 누적시청자, 평점, 리뷰등을 확인할 수 있습니다.
        
 <img src="https://github.com/user-attachments/assets/839ec5bf-0983-44b3-9fae-52e8fcd06ed0" alt="연령 등급" width="650" height="400"><br>
 
   - 만약 해당 등급나이를 충족하지 못한다면 이전페이지로 돌려보냅니다.
      <img src="https://github.com/user-attachments/assets/448d88dc-880a-4ba8-bc6c-9f0cf611ef4f" alt="연령 등급" width="650" height="400"><br>
      
   - 리뷰작성.
      <img src="https://github.com/user-attachments/assets/579f2481-87ce-464c-bc4c-46e54032c2d8" alt="작성" width="650" height="400"><br>

   - 해당 리뷰는 댓글작성자만 수정, 삭제 할 수 있고, 나머지 댓글에 대해서는 신고할 수 있습니다.
      <img src="https://github.com/user-attachments/assets/76c792b4-7da8-4873-b334-78bd212c82d1" alt="작성 신고" width="650" height="400"><br>
      
   - 중복 신고
        <img src="https://github.com/user-attachments/assets/766c5ebc-9aae-4351-98fe-dd19d81957c5" alt="중복신고" width="650" height="400"><br>
        
   - 수정 / 삭제
       <img src="https://github.com/user-attachments/assets/258b8252-7813-4fdc-ae80-991bfe42bdae" alt="수정 삭제" width="650" height="400"><br>

  * **예매페이지**
    * `예매` 페이지에서는 차량 크기에따른 열 선택제한, 이미 예약한 좌석 예매불가, 좌석 및 가격 표시, 리셋 버튼을 통해 처음부터 입력하기 편하게 사용자 친화적 경험을 제공합니다.
      - 예매하기
      <img src="https://github.com/user-attachments/assets/986db857-7c23-4a3c-ab95-49f357c9ef79" alt="예매" width="650" height="400">
    
      
  * **마이페이지**
    * `마이페이지`에서는 예매내역 확인, 결제, 예매취소를 할 수 있습니다.
      - 결제
       <img src="https://github.com/user-attachments/assets/944b1a88-489c-4392-a107-82d77ae4bd8f" alt="카카오결제" width="650" height="400"><br>
      - 예매취소
     <img src="https://github.com/user-attachments/assets/5e669fd9-a8fd-4f60-94e9-a1769b4d117d" alt="예매취소" width="650" height="400"><br>
      
      
* **관리자**
   
  * `관리자대쉬보드`에서는 (유저 총 수, 신고리뷰 총 수, 공지 총 수, 상영스케쥴, 날씨)를 확인할 수 있습니다. 
        <img src="https://github.com/user-attachments/assets/64c27c10-4295-4f2e-990b-a1bd3ef0a661" alt="유저관리" width="650" height="400">

  * 유저관리에서는 삭제 시 유저의 댓글, 예매내역을 같이 삭제할 수 있습니다.
        <img src="https://github.com/user-attachments/assets/e9f47100-9a90-4c9a-9780-3643395483b5" alt="유저관리" width="650" height="400">

  * 신고리뷰목록에서는 신고된 리뷰를 삭제하면 해당 유저의 이메일로 삭제를 알립니다.
          
    - 삭제하기
        <img src="https://github.com/user-attachments/assets/1f39db14-f833-4598-83c7-ddb35cb71b3f" alt="신고리뷰삭제" width="650" height="400"><br> 
            
    - 이메일 확인
        <img src="https://github.com/user-attachments/assets/94e1e053-e0b7-4c4b-8ba1-33253f3e058e" alt="신고리뷰이메일" width="650" height="400"><br>

  * 공지목록에서는 공지를 작성하고 수정을 통하여 메인페이지에 공지 유무를 결정합니다.
          
    - 작성
        <img src="https://github.com/user-attachments/assets/0fdd3e58-667c-4f4a-8753-9a660885db39" alt="공지작성" width="650" height="400"><br>
    - 수정, 공지팝업
        <img src="https://github.com/user-attachments/assets/500eb97c-a78d-4075-94ce-53da228dbee2" alt="공지수정" width="650" height="400"><br>
       
    * 예매목록은 전체 영화의 예매내역을 확인할 수 있습니다.
        <img src="https://github.com/user-attachments/assets/d0e3edda-94eb-4502-a9ac-c81394e6adf6" alt="예매내역확인" width="650" height="400">
          
    * 목록에서는 10개씩 페이징처리, 검색필터을 이용하여 찾을 수 있습니다.
        <img src="https://github.com/user-attachments/assets/8c786f5c-f09e-42a9-bb9c-9e32e20466f9" alt="예매내역확인" width="650" height="400">
 
  

## 🌄 개선사항

- 미구현 기능에 대한 구현
   (예매티켓 영화제목 클릭 시 영화예매페이지 이동, 관리자페이지 영화상영계획표, 결제시 결제완료 표)
- 리뷰의 대댓글 기능, 리뷰 신고 시 신고사유 입력
- 로그인 (id찾기, pw찾기)기능
