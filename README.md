### Jackson JSON Placeholder

Uses data from the API made available from [the JSON placeholder API](https://jsonplaceholder.typicode.com/) to demonstrate the Jackson object mapper functionality. 

The stub files in the resources folder are the return of a single user and of all users. The same UserDTO is used to initialise both. As the User object comprises nested JSON objects, the UserDTO class contains other DTO classes as member variables. There is no requirement to deserialise these separately for the object mapper to work. 

The classes `UserDeserialiserTests` and `UsersDeserialiserTests` provide tests based on the stub records. The single object tests assert based on the data inside the stub. The array asserts are more generalised and could potentially be used against the service.  

