# DEV-GRAFT Cinema

DEV-GRAFT가 영화관 운영을 시작했습니다!  
그리고 우리 DG-MOVIE.Team은 영화관 서비스에 필요한 영화 예매 플랫폼을 개발해야합니다!

## 🎭 시나리오

### 🤗 사용자 인증

| UseCase | Desc                                   |
|:--------|:---------------------------------------|
| 회원가입    | 사용자는 회원가입 절차를 거쳐 계정을 동록합니다.            |
| 로그인     | 가입한 사용자는 아이디와 패스워드를 사용해 로그인을 할 수 있습니다. |

### 🎥 영화 조회

| UseCase  | Desc                        |
|:---------|:----------------------------|
| 영화 목록 조회 | 사용자는 영화 목록을 조회할 수 있습니다.     |
| 영화 상세 조회 | 사용자는 영화의 상세 정보를 조회할 수 있습니다. |

### 🎟 예매

| UseCase         | Desc                                                      |
|:----------------|:----------------------------------------------------------|
| 예매 차트 목록 조회     | 사용자는 예매 가능한 영화 목록을 조회할 수 있습니다.                            |
| 상영관 목록 조회       | 사용자는 상영관 목록을 조회할 수 있습니다.                                  |
| 상영 목록 조회        | 사용자는 [영화, 상영 시작 일자,상영 정료 일자, 상영관] 기준으로 상영 목록을 조회할 수 있습니다. |
| 좌석 정보 조회        | 사용자는 [상영 정보] 기준으로 상영관의 좌석 정보를 조회할 수 있습니다.                 |
| 예매 신청           | 사용자는 [상영 정보, 좌석 정보]를 기준으로 예매 신청할 수 있습니다.                  |
| 사용자 예매 정보 조회    | 사용자는 예매한 정보를 조회할 수 있습니다.                                  |
| 사용자 예매 내역 목록 조회 | 사용자는 예매내역 목록을 조회할 수 있습니다.                                 |
| 상영 영화 예매율 목록 조회 | 사용자는 상영 중인 영화의 예매율 목록을 내림차순으로 조회할 수 있습니다.                 |

### 💵 결제

| UseCase  | Desc                    |
|:---------|:------------------------|
| 결제 요청    | 사용자는 결제를 요청할 수 있습니다.    |
| 결제 정보 확인 | 사용자는 결제 정보를 확인할 수 있습니다. |

## 💬 Comment

### 📚 전제 조건
- 영화, 상영관, 좌석 정보는 주어진 정보가 있다고 전제합니다!
- 테이블 및 기본데이터 셋 제공을 위해 .sql 파일을 제공하였습니다.
- 시나리오의 학습 목표는 외부 모듈 연동이 아니므로 실제 외부 결제 모듈을 연동하지 않습니다!
- 결제 모듈(가짜!) 인터페이스와 구현체가 제공될 예정입니다.

### ⛳ Goals
- ✅ 결제 과정에 내가 선택한 좌석을 다른 사용자가 예매할 수 없도록 제한할 수 있어야합니다.
- ✅ 결제가 완료된 예매 정보를 예매율에 반영할 수 있어야합니다.
- ✅ 대규모 트래픽을 고려하여 예매율을 실시간으로 보여줄 수 있어야합니다.
- ✅ 요구사항을 모두 지키고자 노력해봅니다.

## Spec


### **프로젝트 구성**

| Name        | Version |
|:------------|:--------|
| Spring Boot | 2.7.3   |
| Java        | 17      |
| Gradle      | 7.5     |

### **개발환경**

| Name         | Desc      |
|:-------------|:----------|
| Architecture | Hexagonal |
| DB           | H2        |

### **기본 의존성**

| Name | Desc |
|:-----|:-----|
| H2   |      |

### 📄 Schema

![Image](https://user-images.githubusercontent.com/22608825/230760951-27f90bea-c1af-4de4-a6a5-babb5d0a1f6c.png)

### 🎈 EventStorming

![Image](https://user-images.githubusercontent.com/22608825/230773112-41cd98ad-aff9-4519-b11b-e26e4478dc0d.png)

### BorisDiagram

### Package 구조

## 아래는 fork 이후 직접 작성해주세요.

### :pushpin: 참여 팀원
|     [팀원 닉네임](팀원-프로필-주소)      |
|:----------------------------:|
|  <img src="" width="100px">  |
| BE, FE, IOS, ANDROID, DESIGN |
|            한줄 설명             |

--- 
### :screwdriver: 기술 스택
<p align="center">
<img alt="" src="https://img.shields.io/badge/TypeScript-569A31?style=for-the-badge&logo=JavaScript&logoColor=white">
<img alt="" src="https://img.shields.io/badge/TypeScript-3178C6?style=for-the-badge&logo=TypeScript&logoColor=white">
<img alt="" src="https://img.shields.io/badge/JAVA-007396?style=for-the-badge&logo=java&logoColor=white">
<img alt="" src="https://img.shields.io/badge/Kotlin-2496ED?style=for-the-badge&logo=kotlin&logoColor=orange">
<img alt="" src="https://img.shields.io/badge/ReactNative-2496ED?style=for-the-badge&logo=react&logoColor=white">
</p>
<p align="center">
<img alt="" src="https://img.shields.io/badge/IOS-white?style=for-the-badge&logo=apple&logoColor=black">
<img alt="" src="https://img.shields.io/badge/Android-green?style=for-the-badge&logo=android&logoColor=white">
<img alt="" src="https://img.shields.io/badge/react-61DAFB?style=for-the-badge&logo=react&logoColor=black">
<img alt="" src="https://img.shields.io/badge/Testing Library-E33332?style=for-the-badge&logo=testingLibrary&logoColor=white">
<img alt="" src="https://img.shields.io/badge/React Router-CA4245?style=for-the-badge&logo=reactRouter&logoColor=white">
</p>
<p align="center">
<img alt="" src="https://img.shields.io/badge/Spring Boot-6DB33F?style=for-the-badge&logo=Spring Boot&logoColor=white">
<img alt="" src="https://img.shields.io/badge/JUnit5-25A162?style=for-the-badge&logo=JUnit5&logoColor=white">
<img alt="" src="https://img.shields.io/badge/mariaDB-003545?style=for-the-badge&logo=mariaDB&logoColor=white">
<img alt="" src="https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white"> 
<img alt="" src="https://img.shields.io/badge/Amazon AWS-232F3E?style=for-the-badge&logo=Amazon AWS&logoColor=white">
</p>
<p align="center">
<img alt="" src="https://img.shields.io/badge/Amazon S3-569A31?style=for-the-badge&logo=Amazon S3&logoColor=white">
<img alt="" src="https://img.shields.io/badge/NGINX-009639?style=for-the-badge&logo=NGINX&logoColor=white">  
<img alt="" src="https://img.shields.io/badge/Jenkins-D24939?style=for-the-badge&logo=Jenkins&logoColor=white"> 
<img alt="" src="https://img.shields.io/badge/SonarQube-4E9BCD?style=for-the-badge&logo=SonarQube&logoColor=white"> 
<img alt="" src="https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=Docker&logoColor=white"> 
</p>

### 
