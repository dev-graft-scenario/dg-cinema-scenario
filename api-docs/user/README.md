# 📬 회원 API 명세

## 🔎 회원가입

```http request
POST /api/users/sign-up
```
### · request
```json
{
  "email": "email@gmail.com",
  "password": "password",
  "phone": "010-1234-5678"
}
```

| Parameter | Required | Description | Forms                          |
|:----------|:---------|:------------|:-------------------------------|
| email     | true     | 로그인 용 이메일   | 공백, 빈값 불가능                     |
| password  | true     | 패스워드        | 12자 이상, 대소문자 1개 이상, 특수문자 1개 이상 |
| phone     | true     | 사용자 핸드폰 번호  | 010-0000-0000                  |

### · response

```
HTTP/1.1 201 Created
```

## 🔎 로그인

```http request
POST /api/users/sign-in
```

### · request

```json
{
  "email": "email@gmail.com",
  "password": "password"
}
```

| Parameter | Required | Description | Forms                          |
|:----------|:---------|:------------|:-------------------------------|
| email     | true     | 로그인 용 이메일   | 공백, 빈값 불가능                     |
| password  | true     | 패스워드        | 12자 이상, 대소문자 1개 이상, 특수문자 1개 이상 |

### · response

```
HTTP/1.1 200 Ok
- H ACCESS-TOKEN: "ACCESS-TOKEN"
- C REFRESH-TOKEN: "REFRESHTOKEN" httpOnly
```


| Parameter     | Path   | Description  |
|:--------------|:-------|:-------------|
| ACCESS-TOKEN  | Header | AccessToken  |
| REFRESH-TOKEN | Cookie | RefreshToken |
