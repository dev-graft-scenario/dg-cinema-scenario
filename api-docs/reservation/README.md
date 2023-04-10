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
      "genre": "genre"
    }
  ]
}
```

| Path                  | Type   | Description   |
|:----------------------|:-------|:--------------|
| movies                | Array  | 조회된 영화 목록     |
| movies[i].movieId     | Number | 영화 아이디        |
| movies[i].title       | String | 영화 제목         |
| movies[i].bannerUrl   | String | 영화 배너 이미지 URL |
| movies[i].genre       | String | 영화 장르         |


## 영화 상세 정보 조회

```http request
GET /api/movies/{movieId}
```

### · request

| Parameter | Required | Description | Forms                          |
|:----------|:---------|:------------|:-------------------------------|
| movieId   | true     | 영화 아이디      | |

### · response

```json
{
  "movieId": 1,
  "title": "title",
  "description": "description",
  "bannerUrl": "bannerUrl",
  "genre": "genre"
}
```

| Path        | Type   | Description   |
|:------------|:-------|:--------------|
| movieId    | Number | 영화 아이디        |
| title      | String | 영화 제목         |
| description| String | 영화 설명         |
| bannerUrl  | String | 영화 배너 이미지 URL |
| genre      | String | 영화 장르         |


## 🔎 예매 차트 목록 조회

```http request
GET /api/showings?page={page}?size={size}?sort={sort}
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
| showings[i].rate             | Double | 영화 장르         |


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

## 좌석 정보 조회

## 사용자 예매 내역 조회

## 예매 신청

## 영화 예매율 조회
