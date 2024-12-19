# Team Unknown 프로젝트 (팔닭, 8DAK)

---

## 목차
  
  - [개요]
  
  - [기술 스택]
    
  - [프로젝트 설계]
    
  - [핵심 기능]
    
  - [주요기능 실행화면]
    
  - [개선사항]

## 🚩 개요

이 프로젝트는 팀프로젝트로 협의를 통해 **웹 쇼핑몰**을 개발하는 것으로 웹 쇼핑몰은 사용자가 가장 친숙하게 접근할 수 있으며, 개발자의 입장에서 많은 기능 구현 과제들을 통해 성장할 수 있는 계기가 될 것으로 기대되어 선택하게 되었습니다.
이 프로젝트는 학습한 웹 개발 기술 HTML, CSS, JavaScript와 Servlet, JSP, 스프링 프레임워크 등을 활용하고, 오라클 데이터베이스를 적용해 동작하는 웹 애플리케이션입니다.

*프로젝트 목표 : 소셜 로그인 및 결제 api를 적용하여 서버와 클라이언트가 별도로 분리된 Spring FrameWork, jsp 쇼핑몰 사이트

**개발 기간 : 24/04/23 ~ 24/05/30

## 사용한 기술 스택
- API : Daum 주소 API, 카카오 소셜 API, Portone 결제 API
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
웹사이트(랭킹 닭컴(https://www.rankingdak.com/)), 문헌(코드로 배우는 스프링 웹 프로젝트(구멍가게 코딩단, 남가람북스))

- 웹사이트 분석
1. **디자인 및 레이아웃 분석:**  헤더, 슬라이더, 세션, 푸터로 구성된 레이아웃과 편리하고 익숙한 인터페이스 구조를 갖고 있습니다.
2. **게시판 분석**: 공지사항, 질의응답, 자주찾는 질문, 구매후기 4개의 게시판과 특정 게시판은 이미지 파일 첨부가 가능합니다.
3. **사용자 경험 분석:** 사용자들은 웹사이트의 다양한 필터링을 통해 원하는 정보를 찾을 수 있습니다.

 ## 👾 프로젝트 설계, 구현 📂 PPT 📂 (ERD, USECASE)
프로젝트 설계, 구현 PPT

<div align="center">

| ![이미지1](https://github.com/user-attachments/assets/552a99e3-6de4-4d8d-b885-b7a868dbca20) | ![이미지2](https://github.com/user-attachments/assets/b900c307-6062-476e-ab54-03291c31b202) |
| :----------------------: | :----------------------: |
| ![이미지3](https://github.com/user-attachments/assets/c2bc93f6-55c1-4233-9e1f-74e2f691590b) | ![이미지4](https://github.com/user-attachments/assets/756c34a2-d736-4ea0-9d94-65b465be2abe) |
| ![이미지5](https://github.com/user-attachments/assets/0bb9d94e-52c3-4eb2-8227-a78761a613f4) | ![이미지6](https://github.com/user-attachments/assets/e05b1d42-5faa-4632-8abf-bcb719f2b013) |
| ![이미지7](https://github.com/user-attachments/assets/4982eced-af2d-47a3-ba44-cb2a09ff9bb2) | ![이미지8](https://github.com/user-attachments/assets/889b8aa5-87f1-408c-b39e-f748755e710a) |
| ![이미지9](https://github.com/user-attachments/assets/7c714671-2cd4-4579-bdf7-571a70e63541) | ![이미지10](https://github.com/user-attachments/assets/ad98627b-48c2-434a-80bf-7bb5097c7f6e) |
| ![이미지11](https://github.com/user-attachments/assets/1aad1912-b602-473b-afd8-2151f133640d) | ![이미지12](https://github.com/user-attachments/assets/f2d82abc-c5bd-408c-9c35-10b62722098d) |
| ![이미지13](https://github.com/user-attachments/assets/b55e1b53-aa10-4689-a3b5-8e10ccb6fb06) | ![이미지14](https://github.com/user-attachments/assets/7221ceeb-75e1-4624-a677-89e0efee38fa) |
| ![이미지15](https://github.com/user-attachments/assets/6624219e-af21-4de2-9ca7-923735a40a31) |![슬라이드16](https://github.com/user-attachments/assets/a2ba3895-779a-4e58-b051-1734b98abe60)|
</div>

<div align="center">
<img src="https://github.com/user-attachments/assets/f5a74a24-1a7f-42f8-a5a8-10f49b908657" alt="이미지17" width="1000" height="600"><br>
<img src="https://github.com/user-attachments/assets/6286c875-fa9b-4eed-9a2c-55ded00b8543" alt="이미지18" width="1000" height="600"><br>
<img src="https://github.com/user-attachments/assets/8ff7cf9c-6154-400b-b39d-fe1a8c6e50e1" alt="이미지19" width="1000" height="600">
</div>

<div align="center">
|![이미지20](https://github.com/user-attachments/assets/80cb62de-9190-41fb-8e33-83e34311f67c) |![이미지21](https://github.com/user-attachments/assets/286612ee-f33f-4272-acb2-9778a1b18e27) | 
|![이미지22](https://github.com/user-attachments/assets/dd23b104-994b-4d09-93e7-9cd007269f94) |![이미지23](https://github.com/user-attachments/assets/efb5a059-4f71-4b05-a52e-69758a3ed7bf) |
|![이미지24](https://github.com/user-attachments/assets/0daa22be-bbad-4aff-8bfd-95bd70d23fd6) |![이미지25](https://github.com/user-attachments/assets/60626690-9843-4d46-b698-fd914cbc262d) | 
|![이미지26](https://github.com/user-attachments/assets/66411fc4-94b8-466a-bd7e-1c536bb71820) |![이미지27](https://github.com/user-attachments/assets/0535a0e7-1e95-41fc-8069-5591d828e57e) | 
|![이미지28](https://github.com/user-attachments/assets/5440c898-e2f7-483d-b060-62dffc495fcf) |![이미지29](https://github.com/user-attachments/assets/5ee019ae-90b4-4e23-9024-07ea23d5f8ca) | 
|![이미지30](https://github.com/user-attachments/assets/4d4eb88c-7142-46f5-b51a-e14908e46016) |![이미지31](https://github.com/user-attachments/assets/33dca4c2-33ba-44af-9332-d548277dc8a5) | 
|![이미지32](https://github.com/user-attachments/assets/7d89fb38-ccd9-4fea-8721-c8e8a1308827) |![이미지33](https://github.com/user-attachments/assets/c2f9697d-99b7-4562-b401-81514e319ecc) | 
|![이미지34](https://github.com/user-attachments/assets/7df4bbbe-5bf9-4be6-bfef-53c701c297d9) |![이미지35](https://github.com/user-attachments/assets/330d995d-6b48-4224-81a6-03d310cde84a) |
|![이미지36](https://github.com/user-attachments/assets/cc95b7f3-c3e8-4105-a299-6f849bc2ba5f) |![이미지37](https://github.com/user-attachments/assets/8d0223a5-bd69-4cd0-951b-76b44724b612) |
|![이미지38](https://github.com/user-attachments/assets/259722d5-29c9-444b-8bea-95381c295997) |![이미지39](https://github.com/user-attachments/assets/9ee0a08a-6724-4ce1-b589-eb0d59787f1d) | 
|![이미지40](https://github.com/user-attachments/assets/bea44e4d-f8c9-4ee6-b18c-b7a010bbc2d7) |![이미지41](https://github.com/user-attachments/assets/d1102693-8b77-4bec-8bbb-43dbaf819703) | 
|![이미지42](https://github.com/user-attachments/assets/e9ea3fd6-687a-43e3-83ec-0597a040dc4c) |

</div>



## 💻 핵심 기능

#### 상품 구매
- 지정한 조건에 따른 상품 목록을 출력
- 사용자가 일련의 구매 활동(상품 상세페이지 조회, 장바구니, 주문, 결제)을 위해 행동을 취할 경우 서버에서 각 요청에 대응하여 DB에 저장 및 업데이트 처리
- 사용자가 주문사항에 대한 결제를 완료할 경우, 사용 포인트에 따른 포인트 차감과 적립, 재고량 감소, 주문 내역에서 주문 진행상황 출력

#### 일반회원
- 소셜 로그인(카카오)
- 이메일 중복확인
- 비밀번호 암호화 처리(bcrypt)
- Daum 주소 검색 API
- 마이페이지(메인, 주문내역, 취소/반품내역, 포인트, 최근 본 상품, 1:1 문의 내역, 상품후기, 정보수정)
- 아이디, 비밀번호 찾기
- 로그인 아이디 저장
- 아임포트(PORTONE) API를 통한 결제 및 포인트 충전

#### 관리자
- 대시보드(매출액, 회원, 문의, 구매 후기, 상품, 발주, 입고 현황, 최다 누적 리뷰 상품, 일일 최대 판매액 상품 조회) 
- 상품 작업(전체 상품 조회, 필터링(상품명,브랜드ID,카테고리ID,상품번호), 정렬, 등록, 수정, 품절 처리)
- 재고 관리(전체 상품 재고 조회, 필터링(발주ID, 상품명, 미입고), 정렬, 발주 신청, 입고 처리)
- 발주/입고 이력(전체 상품 발주/입고 이력 조회)
- 브랜드 등록(전체 브랜드 조회, 필터링(브랜드ID, 브랜드명), 정렬, 브랜드 등록, 수정, 삭제) 
- 카테고리 등록(전체 카테고리 조회, 필터링(카테고리ID, 카테고리명), 정렬, 카테고리 등록, 수정, 삭제)
- 공지사항(전체 공지사항 조회, 필터링(제목, 내용, 등록번호, 제목 or 내용, 제목 or 내용 or 등록번호), 정렬, 등록, 수정, 삭제)
- 자주 찾는 질문(전체 QNA 조회, 필터링(제목, 내용, 등록번호, 제목 or 내용, 제목 or 내용 or 등록번호), 정렬, 등록, 수정, 삭제)
- 구매 후기(전체 상품 구매 후기 조회, 필터링(제목, 내용, 상품ID, 제목 or 내용, 제목 or 내용 or 상품ID), 정렬, 등록, 수정, 삭제)
- 질의 응답(전체 1:1 문의 조회, 필터링(제목, 내용, 상품ID, 제목 or 내용, 제목 or 내용 or 상품ID), 정렬, 등록, 수정, 삭제)
- 회원 작업(전체 회원 정보 조회, 필터링(아이디, 회원이름, 메일주소), 정렬, 회원 등록, 수정, 휴면, 탈퇴 처리)
- 혜택 문의(전체 혜택 문의 댓글 조회, 필터링(혜택ID, 작성자), 정렬, 댓글 등록, 수정, 삭제, 답글 등록, 수정, 삭제)
- 전체 회원 장바구니 조회(필터링(장바구니ID, 회원ID), 정렬)
- 주문&배송(필터링(주문ID, 회원ID, 수령인), 정렬, 주문 등록, 수정, 삭제)
- 주문 상품(필터링(주문ID), 정렬, 전체 주문에 대한 상품ID, 주문 수량, 상품 가격, 할인율, 적립포인트 조회)



## 🎇 주요기능 실행화면
주요기능 실행화면

  * **메인 페이지**

    * **로그인**
      * 메인 페이지 우측 상단 네비게이션 메뉴를 통해 로그인 페이지에 접근이 가능하며, 로그인 아이디 저장, 아이디 찾기, 비밀번호 찾기, 카카오 소셜 로그인이 가능합니다.
      
     ![login](https://github.com/lambda512/UnknownProject/assets/155952874/fc2baa13-7f48-4679-80fa-4fa4478bd924)

    * **회원가입**
      * (공통)회원가입 페이지에서 '주소 검색' 버튼을 통해 Daum 주소 검색 API를 호출하여 주소 입력을 진행할 수 있습니다.
      * (소셜)회원가입 페이지 혹은 로그인 페이지에서 'K' 버튼을 누르면 카카오 소셜 로그인 API를 호출하여 카카오 계정으로 회원가입 및 로그인을 진행할 수 있습니다.
      * (일반)로그인 페이지의 '간편회원가입' 버튼 혹은 상단 회원가입 버튼을 통해 이동한 회원가입 페이지에서 '이메일 인증' 버튼 클릭 시 이메일 인증을 통해 일반 회원가입을 진행할 수 있습니다.
      
      (1) 소셜 회원가입 실행화면
      
      ![kakaologin](https://github.com/lambda512/UnknownProject/assets/155952874/c3c0f2b9-7262-4f8f-be58-df0e45e2f5ad)

      (2) 일반 회원가입 실행화면
      
      ![normaljoin](https://github.com/lambda512/UnknownProject/assets/155952874/d0cad6f4-7c51-42cf-b926-df3578483fe8)
      

    * **아이디, 비밀번호 찾기**
      * 이메일을 입력하여 해당 이메일 주소로 가입된 아이디를 찾을 수 있습니다.
      * 비밀번호 찾기 페이지에서 이메일 입력 후 '인증번호 전송' 버튼을 클릭하면 인증번호가 포함된 메일이 전송되며, 올바른 인증번호를 입력하면 발급된 임시 비밀번호가 메일로 발송됩니다.
  
      ![findidandpassword](https://github.com/lambda512/UnknownProject/assets/155952874/da741760-4de0-435b-b67a-016d098656da)
      

    * **회원 정보수정**
      * 로그인을 완료한 회원은 상단 네비게이션 정보수정 버튼 혹은 마이페이지 - 회원정보관리 - 정보수정 탭을 통해 회원 정보수정 페이지로 접근할 수 있습니다.
      * 정보수정 페이지에서 로그인 시 입력했던 비밀번호를 올바르게 입력하면 정보를 수정할 수 있으며, 이름, 비밀번호, 휴대폰 번호, 주소만을 수정할 수 있습니다.
      * 비밀번호 수정 시 비밀번호 수정 버튼을 누르고 수정할 비밀번호를 입력하여 수정하기 버튼을 누르면 수정할 수 있습니다.
      * 주소 찾기 버튼을 통해 Daum API를 호출하여 주소를 수정할 수 있습니다.
      
       ![4_update](https://github.com/lambda512/UnknownProject/assets/155952874/c7be9b53-a903-4978-8759-e6898da3d3af)


    * **메인화면**
      * 메인 화면에서는 다음과 같은 상품을 조회할 수 있습니다.
        - MD 지정 상품(서버에서 리스트로 지정한 상품ID에 해당하는 상품)
        - 추천 상품(주문 이력이 없는 상품)
        - 최다 판매량 상품 TOP4
        - 신상품(카테고리 코드 1000)
        - 닭다리살(카테고리 코드 1402)
        - 상품명에 '패키지'가 포함된 상품
        - 맛있닭 상품(브랜드ID 2)

      ![5_main](https://github.com/lambda512/UnknownProject/assets/155952874/52e22417-4378-49f5-9b12-3c79f4a7a16d)
      

    * **카테고리**
      * 카테고리 탭에서는 각 상위 카테고리(전체) 혹은 해당 상위 카테고리에 포함된 하위 카테고리 상품을 조회할 수 있습니다.

      ![6_category](https://github.com/lambda512/UnknownProject/assets/155952874/2ad2cb5b-c5eb-4421-b047-98699f3c3a3e)
      
      
    * **랭킹**
      * 랭킹 탭에서는 주문이 존재하는 상품 중, 주문량이 많은 상품부터 내림차순으로 상품을 조회할 수 있습니다.

      ![7_ranking](https://github.com/lambda512/UnknownProject/assets/155952874/ad4c57d7-0c25-4391-85ec-6a709082e1b6)
      

    * **이달의 특가**
      * 이달의 특가 탭에서는 할인율이 존재하는 상품 중, 할인율이 높은 상품부터 내림차순으로 상품을 조회할 수 있습니다.

      ![8_promotion](https://github.com/lambda512/UnknownProject/assets/155952874/d94649e2-9a11-4b6d-8792-dddfd611e202)
      
      
    * **브랜드관**
      * 브랜드관 탭에서는 등록된 모든 브랜드를 조회, 검색(필터링) 할 수 있으며 해당 브랜드를 클릭하면 해당 브랜드 코드를 가지고 있는 상품을 조회할 수 있습니다.

     ![9_brand](https://github.com/lambda512/UnknownProject/assets/155952874/b437900a-9664-432a-9d6a-fb6aa812a09e)
    
      
    * **888데이**
      * 888데이 탭에서는 관리자가 지정한 시간 한정 할인 상품을 조회할 수 있습니다.(시간은 매일 오후 8시를 기준으로 설정되어 있습니다.)

      ![10_timesale](https://github.com/lambda512/UnknownProject/assets/155952874/ae690a55-6cf0-43f4-bfe3-34a558231f45)
      
      
    * **혜택정리**
      * 혜택정리 탭에서는 로그인 된 회원이 댓글을 작성할 수 있고, 남긴 댓글을 조회할 수 있습니다.
      
      ![11_benefits](https://github.com/lambda512/UnknownProject/assets/155952874/122bad83-db4f-496d-b9d3-0d1018490c63)
      

    * **검색**
      * 헤더의 상단 검색 창에서는 상품명과 브랜드명을 기준으로 상품을 필터링하여 조회할 수 있습니다.
      
      ![12_search](https://github.com/lambda512/UnknownProject/assets/155952874/bf886c65-7550-4753-9b6f-9549237af5b1)
      
      
    * **장바구니**
      * 로그인을 완료한 회원은 상품 상세 페이지를 통해 상품을 장바구니에 추가할 수 있습니다.
      * 이미 장바구니에 추가한 상품은 상품 상세 페이지에서 다시 추가하거나, 수량을 수정할 수 없도록 알림이 발생합니다.
      * 우측 상단 장바구니 아이콘을 통해 장바구니 탭에 접근하여 장바구니에 추가된 상품의 수량을 조절하거나, 장바구니에서 삭제할 수 있습니다.
      
      ![13_cart](https://github.com/lambda512/UnknownProject/assets/155952874/0b9e9ef6-7307-4bbc-b47f-1ff44960d4b3)
      

    * **주문**
      * 회원은 장바구니의 주문하기 혹은 상품 상세 페이지의 바로 구매 버튼을 통하여 주문 페이지로 이동할 수 있습니다.
      * 주문 페이지에서는 상품 금액, 배송비, 할인금액, 최종 결제 금액, 적립예정 포인트를 조회할 수 있으며, 수령인의 이름, 주소, 연락처를 회원 가입시 입력한 정보 그대로 사용하거나, 직접 입력 탭을 통해 수정할 수 있습니다.
      * 보유한 포인트를 사용할 수 있습니다.
      * 결제하기 버튼을 누르면 포트원(아임포트) 결제 API를 호출하여 결제 및 포인트 차감, 적립을 진행할 수 있습니다.
      
      ![14_order](https://github.com/lambda512/UnknownProject/assets/155952874/81113901-f98b-47ad-8167-c1b8ca480123)
      

* **마이페이지**
  
  * 로그인을 완료한 회원은 상단 정보수정 버튼 혹은 사람 모양의 아이콘을 통해 회원 정보 수정 페이지로 접근하여 마이페이지에서 회원정보를 변경할 수 있습니다.
  * 마이페이지 메인에서는 회원 아이디, 보유한 포인트, 최근 주문 내역(3개월), 최근 본 상품, 상품후기, 1:1문의 내역을 간략하게 확인할 수 있습니다.
  * 마이페이지 좌측 메뉴를 통하여 주문내역, 취소/반품내역, 포인트, 최근 본 상품, 1:1 문의 내역, 상품 후기, 정보 수정 페이지로 접근할 수 있습니다.
        
  (1) 주문내역, 취소/반품 내역
  * 주문 내역에서는 주문 정보와 상품 정보를 조회할 수 있으며, 주문 취소 버튼을 통해 주문을 취소할 수 있습니다.
  * 취소/반품 내역에서는 주문을 취소한 주문 내역과 상품 정보를 조회할 수 있습니다.
      
  ![15_orderlist](https://github.com/lambda512/UnknownProject/assets/155952874/c436dca5-3071-4305-8a4a-b2648bd5ba0c)
              
  (2) 포인트
  * 현재까지 보유한 포인트, 적립, 차감된 포인트의 변동 사항과 변동 날짜를 최근 날짜부터 조회할 수 있습니다.
  ![16_point](https://github.com/lambda512/UnknownProject/assets/155952874/b12ce8b0-173e-46e9-89c4-cc45c0aa9dd6)
        
  (3) 최근 본 상품
  * 상품 상세 페이지에 접근한 상품을 최근 접근한 순서대로 조회할 수 있습니다.
  * 상품을 클릭하면 해당 상품의 상세 페이지로 접근할 수 있습니다.
      
  ![17_recentitem](https://github.com/lambda512/UnknownProject/assets/155952874/6834fa7d-a376-4da2-a6f1-72fec710dd7c)
        
  (4) 상품후기
  * 선택한 상품에 대한 후기를 작성, 수정, 삭제할 수 있습니다.
      
  ![18_review](https://github.com/lambda512/UnknownProject/assets/155952874/5219d0ae-bb93-43a1-9623-cd149e4a5414)
        
  (5) 1:1 문의 내역
  * 선택한 문의 유형에 대한 문의를 작성, 수정, 삭제할 수 있습니다.
      
  ![19_1by1QNA](https://github.com/lambda512/UnknownProject/assets/155952874/95d4d87d-ccf7-4742-89a2-0d9b9a4ab7af)

        
#
* **관리자**

    * **관리자 페이지**
      * 로그인 시, 관리자 권한(adminCk==1)을 보유한 회원은 상단 관리자 페이지 탭을 통해 관리자 페이지 대시보드로 접근할 수 있습니다.
      * 대시보드에서는 현재 시각, 매출, 회원, 문의, 구매 후기, 상품, 발주, 입고 현황, 최다 누적 리뷰 상품, 일일 최대 판매액 상품 정보를 한 눈에 조회할 수 있습니다.
      * 관리자 페이지에서는 좌측 사이드의 탭을 통해 상품, 게시판, 회원, 주문 관리를 할 수 있습니다.

      ![20_admindashbord](https://github.com/lambda512/UnknownProject/assets/155952874/b9d22f3d-b675-41ba-aabd-9d73b52d33f0)
      
      
      * **상품 관리**
        * '상품 작업' 탭에서는 상품 목록을 호출하고 상품을 등록, 수정, 품절 처리 할 수 있습니다.
        * '재고 관리' 탭에서는 각 상품의 재고량을 호출하고 발주 신청, 입고 처리를 통해 상품의 재고량을 증가시킬 수 있습니다.
        * '브랜드 등록' 탭에서는 브랜드 목록을 호출하고 브랜드를 등록, 수정, 삭제 처리 할 수 있습니다.
        * '카테고리 등록' 탭에서는 카테고리 목록을 호출하고 카테고리를 등록, 수정, 삭제 처리 할 수 있습니다.

         (1) 상품 작업

        ![21_itemenroll](https://github.com/lambda512/UnknownProject/assets/155952874/c8e7c308-2753-4881-ab56-5d2388b6f16e)
  
         (2) 재고 관리

        ![22_itemstock](https://github.com/lambda512/UnknownProject/assets/155952874/854d64dc-bd40-43ad-9f26-ce5aec7adfe1)
    
         (3) 브랜드 등록

        ![23_brandenroll](https://github.com/lambda512/UnknownProject/assets/155952874/9b8afea1-89b3-4b8f-a724-c2cd3b63afa3)
    
         (4) 카테고리 등록

        ![24_categoryenroll](https://github.com/lambda512/UnknownProject/assets/155952874/b7b98878-291e-4a46-aec9-71da6c25e0e1)

  
      * **게시판 관리**
        * '공지사항' 탭에서는 공지사항 목록을 호출하고 공지사항을 등록, 수정, 삭제 처리 할 수 있습니다.
        * '자주 찾는 문의' 탭에서는 FAQ 목록을 호출하고 FAQ를 등록, 수정, 삭제 처리 할 수 있습니다.
        * '구매 후기' 탭에서는 후기 목록을 호출하고 후기를 등록, 수정, 삭제 처리 할 수 있으며, 후기에 대한 답글을 작성할 수 있습니다. 작성한 후기와 답글은 해당 상품의 상세 페이지에서도 조회가 가능합니다.
        * '질의응답' 탭에서는 1:1 문의 목록을 호출하고 1:1 문의를 등록, 수정, 삭제 처리할 수 있으며 1:1 문의에 대한 답변을 작성할 수 있습니다.
       
        ![25_adminboard](https://github.com/lambda512/UnknownProject/assets/155952874/61b03e37-d540-4bc7-890d-7e38f23dbb68)<br/>
        
  
      * **회원 관리**
        * '회원 작업' 탭에서는 회원 목록을 호출하고 회원등록, 수정(권한 유형, 휴면 여부), 휴면, 탈퇴 처리를 할 수 있습니다.
        * '혜택 문의' 탭에서는 혜택 정리 페이지의 댓글 목록을 호출하고 댓글을 작성, 수정, 삭제할 수 있으며, 답변 또한 작성 가능합니다.
        * '장바구니 조회' 탭에서는 전체 회원의 장바구니 목록을 호출하여 조회할 수 있습니다.
       
        ![26_membermanage](https://github.com/lambda512/UnknownProject/assets/155952874/b7d789c8-7167-4477-b6d9-638ec48d574c)
       
  
      * **주문 관리**
        * '주문 & 배송' 탭에서는 주문을 등록, 수정, 취소 처리할 수 있습니다.
        * '주문 상품' 탭에서는 전체 회원의 주문 목록을 호출하여 조회할 수 있습니다.
       
        ![27_ordermanage](https://github.com/lambda512/UnknownProject/assets/155952874/74275b04-b465-43bf-bab4-bb5235b1f77e)



## 🌄 개선사항
- 로그인 회원에 대한 세션 관리 및 로그인 여부에 대한 유효성 검사
- 미구현 기능에 대한 구현
- 각 로직을 병합한 메인 페이지에 대한 가시성, 코드의 재사용성
- 디렉토리 구조 개선
- 계산 알고리즘 보완
