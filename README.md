# account-api


1. Create Account

Url:- localhost:8080/account/create

Method:- POST

RequestData:- 

{
"userId":5,
"balance":32  // optional
}

2. Credit Account

Url:- localhost:8080/account/credit

Method:- POST

RequestData:- 

{
"userId":5,
"amount":32  
}

3. Debit Account

Url:- localhost:8080/account/debit

Method:- POST

RequestData:- 

{
"userId":5,
"amount":32  
}


4. Get Account

Url:- localhost:8080/account/get?userId=5

Method:- GET




