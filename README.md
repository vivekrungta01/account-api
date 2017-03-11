# account-api


- **Create Account**

Url:- localhost:8080/account/create

Method:- POST

RequestData:- 

{
"userId":5,
"balance":32  // optional
}

- **Credit Account**

Url:- localhost:8080/account/credit

Method:- POST

RequestData:- 

{
"userId":5,
"amount":32  
}

- **Debit Account**

Url:- localhost:8080/account/debit

Method:- POST

RequestData:- 

{
"userId":5,
"amount":32  
}


- **Get Account**

Url:- localhost:8080/account/get?userId=5

Method:- GET




