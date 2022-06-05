GET http://localhost:8080/api/v1/users 
- get all users

GET http://localhost:8080/api/v1/prelections 
- get list of all prelections

POST http://localhost:8080/api/v1/users 
- allows to create new user (data passed as a JSON)
JSON example:
{
"login": "samplelogin",
"email": "sample.mail@gmail.com"
}

POST http://localhost:8080/api/v1/users/register/ 
- allows user to register to the specific prelection
data passed via form data (key value)
1. login Bob777
2. prelectionId 5
3. email bob777@gmail.com

DELETE http://localhost:8080/api/v1/users/resign/
- allows user to resign from the specific prelection
  data passed via form data (key value)
1. login Bob777
2. prelectionId 5
3. email bob777@gmail.com

