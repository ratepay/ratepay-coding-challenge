# Ratepay Live Coding Challenge

## Description

This is the code for **Ratepay Live Coding Challenge**. Please read this README file and ensure beforehand that you are
able to import the project to an IDE of your choice, build and run it. You don't have to implement something in advance, just get a feeling of the
project, so you are mentally prepared for what we might ask you to do in our interview :)

### Dependencies

This project already includes:

* Spring Web
* Spring Data JPA
* H2 Database
* Lombok
* AssertJ

You don't have to include any other dependencies for this challenge (unless something is really needed by
you). And don't worry if something is unknown to you, you won't be asked to necessarily utilize all of these
dependencies.

### Database and testing data

Please note that some dummy data is populated to the H2 database on application startup for you to play around. This
behavior is implemented in `DatabaseInitializer.java` class.

H2 DB console is available to you at [http://localhost:8080/h2-console/](http://localhost:8080/h2-console/)

To login use credentials:

* user: sa
* password: password
* JDBC URL: jdbc:h2:mem:testdb

(you can check credentials in `application.properties` file)

### How to build, test, run

You should be able to build and start the application as you get the code from us.
The project includes [Maven Wrapper](https://maven.apache.org/wrapper/), which you can use to build and test the code,
e.g. by executing: `./mvnw clean verify`
To run the Spring Application either run the `main()` method in `Application.java`, or execute `./mvnw spring-boot:run`