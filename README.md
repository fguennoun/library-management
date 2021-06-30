# Lampiris : Library Management 
Proposed solution of Library Management with Spring Boot, Swagger &amp; Docker


## Description

This project is a proposed solution API for managing books in a library with Java, Spring boot, JPA, H2, Swagger and Docker

## Rules

We would like to have a secure API for managing books in a library.
Each book is part of a book family (ex : thriller), and a library contains one or more book families.

With this API, we should be able to :
-	List, insert, update all the book families in the library
-	get, insert, update a book
-	generate an excel or txt export to be sent to a ftp server (a book can be exported, but a collection of books can be exported as well)


## Stack used

The technologies used is Example is :

- JDK 11
- Spring boot
- JPA
- Lombok
- H2 Memory Database
- Swagger
- Docker
- Maven

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `package com.lampiris.library.LibraryManagementApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

```
or with Docker

1- You create docker image
docker build -t library-management.jar . 
2- You can run docker :
docker run -p 8080:8080 library-management.jar

```

## Test End Point with Postman
When you import the collections (LIBRARY MANAGEMENT.postman_collection.json) ,
Our example contains three collections and each collection contain one or more end points:

- Library: contains one end points
    - Create Library
- Book Family: contains two end points
    - Create Book Family
    - Get All Book Family
    - Get Book Family By Id
- Book: contains six end points
    - Create Book
    - Get All Books
    - Get Book By Id
    - Update Book
    - Export All Books (you find the file text "all-books.txt" in the root of the project)
    - Export One Book (you find the file text "one-book.txt" in the root of the project)
    

