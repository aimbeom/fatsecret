
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

<p>
프로젝트 일정표 : https://docs.google.com/spreadsheets/d/1CtJtLa2NB-2CyqH6gTY_iQHzgFjJCcUc/edit#gid=488077327
DB 설계표 : https://docs.google.com/spreadsheets/d/1tqH4AeFnApgesBRM40CAfHEfreGO9K_sGmq1fUvM8rU/edit#gid=0
url 설계표 : https://docs.google.com/spreadsheets/d/1od3uM4wn3Hz3r-fi1tlRPBCjCM3-6GuM_oJMoM_urCU/edit#gid=0
</p>

<h1>1. 회원가입 / 권장 일일칼로리</h1>
<br>
<div class="d-flex">
<img src="https://user-images.githubusercontent.com/98947074/190089888-38e875ca-4baf-47fc-b359-75f463803c11.gif" width="40%"/>
<img src="https://user-images.githubusercontent.com/98947074/190089948-19d2bb5c-a25f-4def-a13c-63656a450e64.gif" width="45%"/>
</div>
<br>
- 회원가입시 입력한 정보를 바탕으로 일일 권장 섭취칼로량을 계산 받습니다.<br>
- 이미지와 자기소개는 원치 않는다면 넘길 수 있습니다.<br>
<br>

<h1>2. 음식 / 운동 다이어리</h1>
<br>
<h4>음식 다이어리 추가/삭제</h4><br>
<img src="https://user-images.githubusercontent.com/98947074/190096392-cad0d209-6b65-4979-8caa-b5e39f5fd75f.gif" width="60%"/>
<h4>운동 다이어리 추가/삭제</h4><br>
<img src="https://user-images.githubusercontent.com/98947074/190097343-ea53ba03-8681-4f83-aaf3-4a8e0ce28082.gif" width="60%"/>


<br>
- 음식 다이어리에선 아침, 점심, 저녁으로 섭취한 음식에 대한 정보를 입력하여 전체적인 섭취 칼로리량을 파악할 수 있습니다.<br>
- 운동 다이어리에선 활동량과 수면시간을 입력하여 전체 소비 칼로리량을 파악할 수 있습니다.<br>

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

- sns 형식으로 타임라인을 만들어 타 사용자와 정보 공유를 할 수 있는 페이지 입니다.


<br>
<h1>4. 마이페이지</h1>
<br>
<h4>프로필 이미지 수정/삭제</h4>
<img src="https://user-images.githubusercontent.com/98947074/190110873-2e886fbe-f7d0-4010-afd6-016863058d5c.gif" width="60%"/>
<h4>체중 수정</h4>
<img src="https://user-images.githubusercontent.com/98947074/190111083-78a62183-d707-426c-8331-6b71512b69f5.gif" width="60%"/>



 - 회원가입시 지정했던 이미지와 개인정보, 여태 게시했던 글 목록이 나타나며 최초 입력 몸무게와 현재 몸무게, 목표 몸무게 값을 나타내며 현재 감량 혹은 증량한 값과 목표치까지 남은 무게를 확인할 수 있습니다<br>

<br>
<h1>5. 다이어트 캘린더</h1>
<h4>캘린더 최초 상태</h4>
<img src="https://user-images.githubusercontent.com/98947074/190115864-d5c2e486-0e30-4220-9269-044c278ab2e2.gif" width="60%"/>
<h4>음식/운동 중 한가지 추가시</h4>
<img src="https://user-images.githubusercontent.com/98947074/190116207-f0390040-20a5-4bf0-8ff3-dabe534b022d.gif" width="60%"/>
<h4>캘린더 완성</h4>
<img src="https://user-images.githubusercontent.com/98947074/190116369-e184c086-e590-4235-a0da-0a4e77f31eaa.gif" width="60%"/>

 - 해당 날짜의 음식, 운동 다이어리의 총 계산값을 기록시 완성하여 하나의 표로 확인할 수 있는 페이지 입니다.
