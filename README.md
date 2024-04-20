# Test Techincal REST API Backend Developer

Ini adalah aplikasi Rest APtI untuk memenuhi test Technical untuk kebutuhan rekrutment pekerjaan

## How to Run 

* Clone this repository 
* kamu dapat melakukan build dan run dengan command berikut ```mvn spring-boot:run```

Jika sudah berjalan maka, comand promt akan seperti berikut

```
2024-04-20T01:04:40.864+07:00  INFO 5156 --- [TechnicalTest] [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port 8080 (http) with context path ''
2024-04-20T01:04:40.870+07:00  INFO 5156 --- [TechnicalTest] [           main] c.t.t.TechnicalTestApplication           : Started TechnicalTestApplication in 1.566 seconds (process running for 2.121)
```

Here are some endpoints you can call:

### Layanan yang dimiliki:

```
http://localhost:8080/api/fibonacci
http://localhost:8080/api/non-palindrome
```

### Mencari fibonanci ke-n
Parameter yang dibutuhkan adalah```n``` dengan tipe data harus bilangan bulat positif 
 

```
POST /api/fibonacci
Accept: application/json
Content-Type: application/json

{
    "n":5
}

Response: HTTP 200
Content: 
{
    "data": {
        "Hasil": 5
    },
    "message": "Success",
    "status": "OK"
}
Location header: http://localhost:8080/api/fibonacci
```

### Mencari substring non-palindrome terpanjang
Parameter yang dibutuhkan adalah```s``` dengan tipe data harus sebuah string 

```
POST /api/non-palindrome
Accept: application/json
Content-Type: application/json

{
    "s":"racecar"
}

Response: HTTP 200
Content: 
{
    "data": {
        "Hasil": "raceca"
    },
    "message": "Success",
    "status": "OK"
}
Location header: http://localhost:8080/api/non-palindrome
```


