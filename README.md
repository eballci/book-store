# Book Store
Book store is an API to maintain a book list. It's built on Spring Boot. 

## Features
It's capable of listing, creating, and deleting books.

## Requirements
In order to run this application on your machine, you must have the following tools.
* Git
* JDK 17 (or later)
* Docker Desktop
* Maven

## Installation
You can run this application on your machine. To do so, follow these instructions.
* #### Clone this repository
````shell
foo@bar:~$ git clone https://github.com/eballci/book-store.git
foo@bar:~$ cd book-store
````

* #### Build JAR file
````shell
foo@bar:~/book-store$ mvn clean install -DskipTests
````

* #### Run project
````shell
foo@bar:~/book-store$ docker-compose up
````

## Usage
Postman is recommended for using this application to maintain your book list. Alternatively, you can use cURL which is out-of-the-box on major OS (i.e. macOS, Windows, Ubuntu).

The application uses the '8080' port automatically on localhost.

### Endpoints

| Action          | URI                             | Method | Payload 	                                                                   | Response  	           | Clarification 	                                                                  |
|-----------------|---------------------------------|--------|-----------------------------------------------------------------------------|-----------------------|----------------------------------------------------------------------------------|
| List all books  | http://localhost:8080/book/     | GET 	  | -	                                                                          | Book list	            | The book list includes all the book objects that are saved on the database.      |
| Get one book    | http://localhost:8080/book/{id} | GET    | -                                                                           | Requested book object | In case of *id* parameter doesn't point to any book, the server returns HTTP 404 |
| Add a book      | http://localhost:8080/book/     | POST   | Book object. But, you don't need to add the id property to the book object. | Created book object   | In case of a creation error the server returns HTTP 505                          |
| Remove one book | http://localhost:8080/book/{id} | DELETE | -                                                                           | Deleted book object   | In case of *id* parameter doesn't point to any book, the server returns HTTP 404 |

### References
Here are some examples of data types

#### Book object
````json
{
  "id": 125,
  "name": "Cosmos"
}
````

#### Book list

````json
[
  {
    "id": 1,
    "name": "Cosmos"
  },
  {
    "id": 2,
    "name": "I, Robot"
  }
]
````

## LICENSE
MIT License

Copyright (c) EMRE BALCI

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.