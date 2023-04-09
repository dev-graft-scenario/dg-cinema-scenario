# 📬 API 명세

## 회원

### 🔎 회원가입

```
$ curl 'http://localhost:8080/api/users/sign-up' -i -X POST
```

**요청 정보**
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

**요청 결과**

```
HTTP/1.1 201 Created
Location /api/users/sign-up
```

### 🔎 로그인

```
$ curl 'http://localhost:8080/api/users/sign-in' -i -X POST
```

**요청 정보**
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

**요청 결과**

```
HTTP/1.1 200 Ok
Location /api/users/sign-in
- H ACCESS-TOKEN: "ACCESS-TOKEN"
- C REFRESH-TOKEN: "REFRESHTOKEN" httpOnly
```
