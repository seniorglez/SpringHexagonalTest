# SpringHexagonaTest

This demo application is architected using the Hexagonal Architecture approach, also known as Ports and Adapters. It is setup with Spring Boot, utilizing Spring Data JPA for database interactions and H2 as an in-memory database for simplicity.

## Requirements

- JDK 17
- Maven 3.6+ 

Ensure JAVA_HOME environment variable is set to your JDK installation directory.

## Building the Application

To build the application, navigate to the root directory of the project (where the `pom.xml` file is located) and run the following command:

```bash
mvn clean compile
```

This command compiles the application.

## Running the Application

After building the application, you can run it using Maven with the following command:

```bash
mvn spring-boot:run
```

This command starts the Spring Boot application. By default, the application is accessible at http://localhost:8080.

## Running Tests

To run the tests you can use the following Maven command:

```bash
mvn test
```

This command executes all tests in the application and provides a summary of the test results.
