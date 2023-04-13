# 📬 예매 API 명세

## 영화 목록 조회

```http request
GET /api/movies
```

### · response

```json
{
  "movies": [
    {
      "movieId": 1,
      "title": "title",
      "bannerUrl": "bannerUrl",
      "genre": "genre",
      "duration": 150
    }
  ]
}
```

| Path                | Type   | Description   |
|:--------------------|:-------|:--------------|
| movies              | Array  | 조회된 영화 목록     |
| movies[i].movieId   | Number | 영화 아이디        |
| movies[i].title     | String | 영화 제목         |
| movies[i].bannerUrl | String | 영화 배너 이미지 URL |
| movies[i].genre     | String | 영화 장르         |
| movies[i].duration  | Number | 영화 길이(1분)     |

## 영화 상세 정보 조회

```http request
GET /api/movies/{movieId}
```

### · request

| Parameter | Required | Description | Forms |
|:----------|:---------|:------------|:------|
| movieId   | true     | 영화 아이디      |       |

### · response

```json
{
  "movieId": 1,
  "title": "title",
  "description": "description",
  "bannerUrl": "bannerUrl",
  "genre": "genre",
  "duration": 150
}
```

| Path        | Type   | Description   |
|:------------|:-------|:--------------|
| movieId     | Number | 영화 아이디        |
| title       | String | 영화 제목         |
| description | String | 영화 설명         |
| bannerUrl   | String | 영화 배너 이미지 URL |
| genre       | String | 영화 장르         |
| duration    | Number | 영화 길이(분)      |

## 🔎 예매 차트 목록 조회

```http request
GET /api/showings/charts?page={page}?size={size}?sort={sort}
```

### · request

| Parameter | Required | Description     | Forms                           |
|:----------|:---------|:----------------|:--------------------------------|
| page      | false    | 예매 차트 목록 페이지    | 기본값=1                           |
| size      | false    | 예매 차트 목록 불러올 크기 | 기본값=10                          |
| sort      | false    | 예매 차트 목록 정렬 방식  | 기본값=mostly(예매율 순), recently=최근순 |

### · response

```json
{
  "showings": [
    {
      "movieId": 1,
      "title": "title",
      "bannerUrl": "bannerUrl",
      "genre": "genre",
      "showingStartDate": "2023-01-01",
      "showingEndDate": "2023-02-01",
      "rate": 30.2
    }
  ]
}
```

| Path                         | Type   | Description   |
|:-----------------------------|:-------|:--------------|
| showings                     | Array  | 상영 영화 목록      |
| showings[i].movieId          | Number | 영화 아이디        |
| showings[i].title            | String | 영화 제목         |
| showings[i].bannerUrl        | String | 영화 배너 이미지 URL |
| showings[i].genre            | String | 영화 장르         |
| showings[i].showingStartDate | Date   | 상영 시작일        |
| showings[i].showingEndDate   | Date   | 상영 종료일        |
| showings[i].rate             | Double | 예매율          |

## 상영관 목록 조회

```http request
GET /api/theaters
```

### · response

```json
{
  "theaters": [
    {
      "theaterId": 1,
      "name": "Theater Name"
    }
  ]
}
```

| Path                         | Type   | Description |
|:-----------------------------|:-------|:------------|
| theaters                     | Array  | 상영관 목록      |
| theaters[i].theaterId        | Number | 상영관 아이디     |
| theaters[i].name             | String | 상영관 이름      |

## 상영 목록 조회

```http request
GET /showings/movies/{movieId}?theater={theaterId}&date={date}
```

### · request

| Parameter | Required | Description | Forms       |
|:----------|:---------|:------------|:------------|
| movieId   | true     | 영화 아이디      |             |
| theaterId | false    | 상영관 아이디     | 없을 시 모든 상영관 |
| date      | false    | 조회할 상영일     | 기본값=now()   |

### · response

```json
{
  "showings": [
    {
      "showingId": 1,
      "theaterId": 1,
      "movieId": 1,
      "showDate": "2000-01-01",
      "startTime": "10:00:00",
      "endTime": "12:30:00",
      "price": "20000.00",
      "seatTotalCount": 100,
      "seatRemainingCount": 30
    }
  ]
}
```

| Path                           | Type   | Description       |
|:-------------------------------|:-------|:------------------|
| showings[i].showingId          | Number | 상영 아이디            |
| showings[i].theaterId          | Number | 상영관 아이디           |
| showings[i].movieId            | Number | 영화 아이디            |
| showings[i].showDate           | Date   | 상영 일자             |
| showings[i].startTime          | Time   | 상영 시작 시간          |
| showings[i].endTime            | Time   | 상영 종료 시간          |
| showings[i].price              | String | 예매 가격(BigDecimal) |
| showings[i].seatTotalCount     | Number | 상영관 총 좌석 수        |
| showings[i].seatRemainingCount | Number | 상영 잔여 좌석 수        |

## 좌석 정보 조회

```http request
GET /showings/{showingId}/seats
```

### · request

| Parameter | Required | Description | Forms       |
|:----------|:---------|:------------|:------------|
| showingId | true     | 상영 아이디      |             |

### · response

```json
{
  "seats": [
    {
      "row": "A",
      "column": 1,
      "isAvailable": true
    }
  ]
}
```

| Path                 | Type    | Description |
|:---------------------|:--------|:------------|
| seats[i].row         | String  | 좌석 열        |
| seats[i].column      | Number  | 좌석 행        |
| seats[i].isAvailable | Boolean | 좌석 사용 가능 여부 |


## 예매 신청

```http request
POST /reservations/showings/{showingId}/seats/{seatId}
```

### · request

| Parameter | Required | Description | Forms |
|:----------|:---------|:------------|:------|
| showingId | true     | 상영 아이디      |       |
| seatId    | true     | 좌석 아이디      |       |

### · response

```json
{
  "reservationId": 1,
  "paymentExpireAt": "2000-01-01 10:10:10"
}
```

| Path            | Type     | Description |
|:----------------|:---------|:------------|
| reservationId   | Number   | 예매 아이디      |
| paymentExpireAt | DateTime | 결제 만료 일시    |



## 사용자 예매 내역 목록 조회

```http request
GET /reservations?page={page}&size={size}
```

### · request

| Parameter | Required | Description  | Forms   |
|:----------|:---------|:-------------|:--------|
| page      | false    | 예매 내역 목록 페이지 | 기본 값 1  |
| size      | false    | 예매 내역 목록 크기  | 기본 값 10 |

### · response

```json
{
  "reservations": [
    {
      "reservationId": 1,
      "movieId": 1,
      "movieName": "name",
      "theaterId": 1,
      "theaterName": "DG 상영관",
      "movieBannerUrl": "movieBannerUrl",
      "showingDate": "2000-01-11",
      "startDate": "10:00:00",
      "endDate": "12:00:00",
      "reservationAt": "2000-01-01 09:00:00",
      "amount": "20000.00",
      "paymentStatus": "Completed"
    }
  ]
}
```

| Path                           | Type     | Description | other                                     |                                   
|:-------------------------------|:---------|:------------|:------------------------------------------|
| reservations                   | Array    | 예매 목록       |                                           |
| reservations[i].reservationId  | Number   | 예매 아이디      |                                           |
| reservations[i].theaterId      | Number   | 상영관 아이디     |                                           |
| reservations[i].theaterName    | String   | 상영관 이름      |                                           |
| reservations[i].movieId        | Number   | 영화 아이디      |                                           |
| reservations[i].movieName      | String   | 영화 이름       |                                           |
| reservations[i].movieBannerUrl | String   | 영화 배너 이미지   |                                           |
| reservations[i].showingDate    | Date     | 상영 일자       |                                           |
| reservations[i].startDate      | Time     | 상영 시작 시간    |                                           |
| reservations[i].endDate        | Time     | 상영 종료 시간    |                                           |
| reservations[i].reservationAt  | DateTime | 예약 일시       |                                           |
| reservations[i].amount         | String   | 결제 금액       |                                           |
| reservations[i].paymentStatus  | String   | 결제 상태       | (Completed=완료, Waiting=대기 중, Expired=만료됨) |



## 사용자 예매 내역 조회

```http request
GET /reservations/{reservationId}
```

### · request

| Parameter     | Required | Description | Forms |
|:--------------|:---------|:------------|:------|
| reservationId | true     | 예매 아이디      |       |

### · response

```json
{
  "reservations": [
    {
      "reservationId": 1,
      "movieId": 1,
      "movieName": "name",
      "theaterId": 1,
      "theaterName": "DG 상영관",
      "movieBannerUrl": "movieBannerUrl",
      "showingDate": "2000-01-11",
      "startDate": "10:00:00",
      "endDate": "12:00:00",
      "reservationAt": "2000-01-01 09:00:00",
      "amount": "20000.00",
      "paymentStatus": "Completed"
    }
  ]
}
```

| Path           | Type     | Description | other                                     |                                   
|:---------------|:---------|:------------|:------------------------------------------|
| reservations   | Array    | 예매 목록       |                                           |
| reservationId  | Number   | 예매 아이디      |                                           |
| theaterId      | Number   | 상영관 아이디     |                                           |
| theaterName    | String   | 상영관 이름      |                                           |
| movieId        | Number   | 영화 아이디      |                                           |
| movieName      | String   | 영화 이름       |                                           |
| movieBannerUrl | String   | 영화 배너 이미지   |                                           |
| showingDate    | Date     | 상영 일자       |                                           |
| startDate      | Time     | 상영 시작 시간    |                                           |
| endDate        | Time     | 상영 종료 시간    |                                           |
| reservationAt  | DateTime | 예약 일시       |                                           |
| amount         | String   | 결제 금액       |                                           |
| paymentStatus  | String   | 결제 상태       | (Completed=완료, Waiting=대기 중, Expired=만료됨) |


## 영화 예매율 목록 조회

```http request
GET /showings/reservations/rates
```

### · response

```json
{
  "rates": [
    {
      "movieId": 1,
      "movieName": "movieName",
      "movieBanner": "movieBanner",
      "rank": 1,
      "rate": 36.1,
      "reservationTotalCount": 100000
    }
  ]
}
```

| Path            | Type     | Description |
|:----------------|:---------|:------------|
| rates   | Array   | 예매율 목록      |
| rates[i].movieId   | Number   | 영화 아이디      |
| rates[i].movieName   | String   | 영화 이름      |
| rates[i].movieBanner   | String   | 영화 배너 URL      |
| rates[i].rank   | Number   | 예매율 순위      |
| rates[i].rate   | Number   | 예매율      |
| rates[i].reservationTotalCount   | Number   | 해당 영화 총 예매 횟수      |

## 영화 예매율 조회

```http request
GET /showings/reservations/rates/{movieId}
```

### · response

```json
{
  "movieId": 1,
  "movieName": "movieName",
  "movieBanner": "movieBanner",
  "rank": 1,
  "rate": 36.1,
  "reservationTotalCount": 100000
}
```

| Path            | Type     | Description |
|:----------------|:---------|:------------|
| movieId   | Number   | 영화 아이디      |
| movieName   | String   | 영화 이름      |
| movieBanner   | String   | 영화 배너 URL      |
| rank   | Number   | 예매율 순위      |
| rate   | Number   | 예매율      |
| reservationTotalCount   | Number   | 해당 영화 총 예매 횟수      |

