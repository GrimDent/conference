GET http://localhost:8080/api/v1/users 
- gets list of all users

GET http://localhost:8080/api/v1/prelections 
- gets list of all prelections

GET http://localhost:8080/api/v1/prelections/yourPrelections
- gets list of all prelections that user was registered for
data passed via form data (key value)
- Example:
1. login Bob777

POST http://localhost:8080/api/v1/users 
- allows to create new user
data passed via form data (key value)
- Example:
1. login sampleLogin
2. email sample.mail@gmail.com

POST http://localhost:8080/api/v1/users/prelection 
- allows user to register to the specific prelection
data passed via form data (key value)
- Example:
1. login Bob777
2. prelectionId 5
3. email bob777@gmail.com

DELETE http://localhost:8080/api/v1/users/prelection
- allows user to resign from the specific prelection
  data passed via form data (key value)
- Example:
1. login Bob777
2. prelectionId 5
3. email bob777@gmail.com

PUT http://localhost:8080/api/v1/users
- allows to update user's email
  data passed via form data (key value)
- Example:
1. login sampleLogin
2. email sample.mail@gmail.com

GET http://localhost:8080/api/v1/prelections/statistics
- shows stats for the organizers 

