
Fatsecret Portfolio
=============

FatSecret은 식단을 일기장처럼 매일 기록하며 다른사람들과 sns형식으로 소통하며 다이어트 정보를 공유할 수 있는 홈페이지입니다.<br>


* 프레임워크 : spring, mybatis, bootstrap
* 프로그램 언어 : java11, javascript, html, css, jsp, xml
* 서버 : tomcat.9.0.62
* DB : mysql


<br>
주요 기능 5가지<br>
- 자신의 키와 체중에 따라 칼로리를 자동으로 계산해줍니다<br>
- 쉬운 인터페이스로 매일 기록하기 편합니다<br>
- 다른사람의 식단도 공유하며 다이어트 식단에 도움을 줍니다<br>
- 식단 데이터를 통하여 탄수화물, 단백질, 지방 함유량이 자동 계산됩니다<br>
<br><br>

<h1>1. 회원가입 / 권장 일일칼로리</h1>
<br>
<div class="d-flex">
<img src="https://user-images.githubusercontent.com/98947074/190089888-38e875ca-4baf-47fc-b359-75f463803c11.gif" width="40%"/>
<img src="https://user-images.githubusercontent.com/98947074/190089948-19d2bb5c-a25f-4def-a13c-63656a450e64.gif" width="45%"/>
</div>
<br>
 - 회원가입시 입력한 키와 체중, 활동량의 정보를 토대로 권장 일일칼로리를 계산받습니다<br>
 - 비밀번호는 EncriptUtils를 사용해 암호화하여 저장합니다<br>
 - 자기소개와 프로필 사진은 원하지 않으면 패스할 수 있습니다<br>
 - 닉네임 중복확인 버튼 클릭 시 입력한 값의 중복 여부를 알림 문구로 확인할 수 있습니다<br>
<br>

<h1>2. 음식 / 운동 다이어리</h1>
<br>
<h4>음식 다이어리 추가/삭제</h4><br>
<img src="https://user-images.githubusercontent.com/98947074/190096392-cad0d209-6b65-4979-8caa-b5e39f5fd75f.gif" width="60%"/>
<h4>운동 다이어리 추가/삭제</h4><br>
<img src="https://user-images.githubusercontent.com/98947074/190097343-ea53ba03-8681-4f83-aaf3-4a8e0ce28082.gif" width="60%"/>


<br>
 - datepicker로 날짜를 선택할 수 있습니다.
 - 항목 추가하기 버튼 클릭시 하단으로 페이지가 펼쳐지며 입력창이 나타납니다<br>
 - 추가된 항목은 버튼의 상단에 삭제버튼과 함께 표시되며 버튼 클릭시 나타나는 입력창에서도 확인과 삭제가 가능합니다<br>
 - 항목 추가하기 버튼 클릭 시 펼쳐지는 페이지 왼쪽에 입력했던 음식의 리스트와 음식별 삭제 버튼이 보여집니다<br>
 - 총 탄단지 칼로리값이 입력받은 즉시 계산되어 수정되고 아래에 권장 섭취칼로리와 비교하여 당일 섭취량 현황을 퍼센트로 확인할 수 있습니다<br>
 - 페이지 상단의 총 계산값과 수면버튼은 최초엔 기록버튼이 표시되고 버튼 클릭시 수정버튼으로 변경되어 리스트값에 변동이 생길경우 다시 수정버튼을 클릭하여 값을 새로 저장이 가능합니다<br>
 - 다른 날짜를 클릭 시 해당 날짜의 기록 확인 가능합니다

<br>
<h1>3. 커뮤니티</h1>
<h3>sns형식으로 다른사람들과 정보를 공유할 수 있는 페이지입니다.</h3>
<br>
<h4>게시글 추가</h4>
<img src="https://user-images.githubusercontent.com/98947074/190099298-fc3bc217-4d61-4620-95f1-b3c70ef1fd9b.gif" width="40%"/>
<h6>사진을 추가할 시 아래로 생성된다</h6>
<img src="https://user-images.githubusercontent.com/98947074/190108623-78eb8d2f-3208-4073-bbc7-10599f388b7c.gif" width="40%"/>

<h4>좋아요, 댓글 추가/삭제</h4>
<img src="https://user-images.githubusercontent.com/98947074/190100107-4b767413-0358-4138-8f1e-b7b63cbe220f.gif" width="60%"/>
<h4>게시글 수정</h4>
<img src="https://user-images.githubusercontent.com/98947074/190106560-526c6461-7a58-49d6-ab46-b25e6eaadc16.gif" width="60%"/>
<h4>게시글 삭제</h4>
<img src="https://user-images.githubusercontent.com/98947074/190107317-30be111e-0dac-4ecb-a864-5abe42d62bd1.gif" width="60%"/>



 - 댓글,게시물,유저,좋아요의 묶음으로 하나의 게시글을 만들고 댓글과 유저를 다시 한묶음로 카드의 형식으로 만들어 게시글 내부 하단에 배치하여 게시글 생성시 하나의 묶음으로 생성됩니다.<br>
 - 게시글은 로그인시 저장되는 유저의 id값을 받아와 해당 게시글의 글쓴이 유무를 판단하여 글쓴이 본인일 경우 해당 게시글에만 우측 상단에 삭제와 수정을 할 수 있는 버튼이 나타납니다.<br>
 - 버튼 클릭시 모달로 삭제와 수정버튼이 나타나며 수정버튼 클릭 시 해당 게시글의 수정하기 페이지로 이동되며 삭제버튼 클릭시 게시글이 삭제됩니다.<br>
 - 댓글 게시는 게시글 하단의 입력박스로 입력 가능하며 댓글을 게시할 경우 유저명과 게시글의 내용이 나타나며 본인이 쓴 댓글에는 삭제버튼이 우측에 생성됩니다.<br>
 - 좋아요 버튼을 클릭시 내부가 가득 차있는 이미지로 변경되며 게시글의 전체 좋아요 갯수가 증가하고 한번더 클릭시 원래의 이미지로 돌아가며 전제 좋아요 갯수가 줄어듭니다.<br>

<br>
<h1>4. 마이페이지</h1>
<br>
<h4>프로필 이미지 수정/삭제</h4>
<img src="https://user-images.githubusercontent.com/98947074/190110873-2e886fbe-f7d0-4010-afd6-016863058d5c.gif" width="60%"/>
<h4>체중 수정</h4>
<img src="https://user-images.githubusercontent.com/98947074/190111083-78a62183-d707-426c-8331-6b71512b69f5.gif" width="60%"/>



 - 회원가입시 지정했던 이미지와 개인정보, 여태 게시했던 글 목록이 나타나며 최초 입력 몸무게와 현재 몸무게, 목표 몸무게 값을 나타내며 현재 감량 혹은 증량한 값과 목표치까지 남은 무게를 확인할 수 있습니다<br>
 - 바이오업데이트 버튼을 클릭시 현재 몸무게 수정페이지로 이동하여 현재 몸무게를 수정할 수 있습니다.<br>
 - 작성했던 글 목록에서도 수정과 삭제가 가능합니다.<br>
 - 사진을 클릭 시 다른 사진으로 수정 삭제가 가능하며 아무 사진도 없을시엔 삭제버튼이 보이지 않습니다.<br>

<br>
<h1>5. 다이어트 캘린더</h1>
<h4>캘린더 최초 상태</h4>
<img src="https://user-images.githubusercontent.com/98947074/190115864-d5c2e486-0e30-4220-9269-044c278ab2e2.gif" width="60%"/>
<h4>음식/운동 중 한가지 추가시</h4>
<img src="https://user-images.githubusercontent.com/98947074/190116207-f0390040-20a5-4bf0-8ff3-dabe534b022d.gif" width="60%"/>
<h4>캘린더 완성</h4>
<img src="https://user-images.githubusercontent.com/98947074/190116369-e184c086-e590-4235-a0da-0a4e77f31eaa.gif" width="60%"/>

 - 해당 날짜의 음식, 운동 다이어리의 총 계산값을 기록시 완성하여 하나의 표로 나타납니다.
 - 총 소비 칼로리가 섭취 칼로리보다 많은 경우와 그렇지 않은 경우를 수치와 함께 이미지로 나타내어 확인할 수 있습니다
 - 다이어트 캘린더의 알림 메세지는 당일을 기준으로 하며 당일 입력된 다이어리가 없다면 운동, 음식 페이지로 이동할 수 있는 문구가 표시됩니다.
 - 두개의 다이어리중 아직 입력되지 않은 다이어리가 있다면 해당 다이어리로 이동할 수 있는 문구가 나타나 클릭 시 해당 페이지로 이동할 수 있습니다.
