GET http://localhost:8080/api/v1/users - get all users
GET http://localhost:8080/api/v1/prelections - get list of all prelections
POST http://localhost:8080/api/v1/users - allow you to create new user (data passed as a JSON)
JSON example:
{
"login": "samplelogin",
"email": "sample.mail@gmail.com"
}
