# 학습 관리 시스템(Learning Management System)
## Step2
### 수강 신청 기능
- 과정
  - 과정은 기수 단위로 운영
  - 과정은 여러 개의 강의를 가짐
- 강의
  - 시작일과 종료일을 가짐
  - 강의 커버 이미지 정보를 가짐
    - 이미지는 1MB 이하
    - 이미지 타입은 gif, jpg(jpeg 포함), png, svg 허용
    - 이미지의 width는 300픽셀, hegith는 200픽셀 이상
    - width : height = 3:2
  - 강의는 무료, 유료로 나뉨
    - 무료는 인원제한 X
    - 유료는 최대 수강 인원 제한
    - 유료는 결제 금액과 수강료가 일치할 때 수강 가능
  - 강의 상태는 준비중, 모집중, 종료 3가지 상태
    - 강의 수강신청은 강의 상태가 모집중일 때만 가능
  - 결제를 완료한 결제 정보는 payments 모듈을 통해 관리
    - 결제 정보는 Payment 객체에 담겨 반환