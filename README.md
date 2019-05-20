### Web JSON Placeholder

Uses the API made available from [the JSON placeholder API](https://jsonplaceholder.typicode.com/) to demonstrate the [Jackson object mapper](https://fasterxml.github.io/jackson-databind/javadoc/2.7/com/fasterxml/jackson/databind/ObjectMapper.html) functionality, and the [Apache HttpComponents](http://hc.apache.org/). This code is to be demonstrated after the Jackson JSON Placeholder as it relies heavily on that code.

The stub files from that project are still available here. Also included is the capability to retrieve data from the web service directly. The Deserialiser classes will detect if the call is to a url or file and redirect accordingly. Investigation is underway to create a parent class to remove some code duplication.

The custom exception `PropertyUndefinedException` is thrown when the user ID is not provided. This is included to demonstrate custom exceptions. There is also a test suite packaging the deserialiser tests. Most (if not all) classes have an associated unit test class, though of course these could be extended.  

