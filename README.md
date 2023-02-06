# SpringBoot를 이용한 Upbit OpenAPI

#### 프로젝트 설명
클린 아키텍처 기반의 SpringBoot를 이용한 Upbit OpenAPI 호출하기


#### 기술 스택
SpringBoot, JPA, MySQL


#### 구현 기능
1. 내부에서 외부 API 호출
Request URL : localhost:8080/v1/market/all

![market_all](https://user-images.githubusercontent.com/84756243/216936133-add3ddc8-5167-40de-9906-fac72fcfd1bc.png)


---


2. 조회하려는 마켓 이름을 통한 호출
Request URL : localhost:8080/api/v1/market/KRW-BTC

![market_name](https://user-images.githubusercontent.com/84756243/216936359-ad128a0b-b75f-4572-867f-caa2efcdcda2.png)


---


3. DB로 저장하기
Response URL : localhost:8080/v1/market/create

[Postman을 이용해 값 전달]
![random_value_post](https://user-images.githubusercontent.com/84756243/216937330-358cb68d-8b28-4b4e-9819-c5017e9e7b23.png)


---


[쿼리 실행 및 DB에 저장]
![market_list](https://user-images.githubusercontent.com/84756243/216937441-62b68201-ae83-43f1-a960-460eb3545bbf.png)


![sql_data_insert](https://user-images.githubusercontent.com/84756243/216937468-5f6f66fd-d92d-4473-96ee-bf8085ca616b.png)
