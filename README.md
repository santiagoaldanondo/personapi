# Person API

## Technologies used:

1. Java 8 (1.8.0_161)
2. Spring Boot 2.0.1.RELEASE
3. PostgreSQL 9.5.12
4. Hibernate 5.2.16
5. Maven 3.5.3

## How it was created:

1. Install Java, Maven and Tomcat.
2. Install PostgreSQL and pgAdmin. 
3. Create and download a new Spring Boot project from https://start.spring.io/ with Web, JPA, PostgreSQL and DevTools dependencies.
4. Create person's model, repository (to operate with the DB) and controller (managing http response and requests).
5. Validate using Postman.

## Steps to build and test:

1. Create a database in PostgreSQL named "personapi" with a user "santi" and password "santi". Otherwise, change the corresponding parameters in src/main/resources/application.properties. The table is updated automatically on startup.
2. run "mvn spring-boot:run" from CLI or "mvn compile && mvn package && java -jar target/personapi-0.0.1-SNAPSHOT.jar"
3. The app will listen on localhost:8080/api:
    * GET persons: show all persons. Will return an array of objects with the following keys {id, dni, firstName, lastName1, lastName2, age, birthDate, createdAt, updatedAt}.
    * POST persons: create a new person. It needs to receive a JSON with {dni, firstName, lastName1, lastName2, age, birthDate}. The first three fields are required.
    * GET persons/{id}: show the person's info having the given id.
    * PUT persons/{id}: update the person's info having the given id (dni, firstName and lastName1) are required.
    * DELETE persons/{id}: delete the person with the given id.
4. Try all the methods with Postman. Remember to include Content-Type: application/json in the Headers.

## https://github.com/santiagoaldanondo/personapi
