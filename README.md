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

## Example of Use

This section provides a practical example of how to use the API to retrieve pricing information. This example demonstrates making a request to the /price endpoint to get the price of a product for a specific brand at a given time.

To fetch the price of a product, perform a GET request to the /price endpoint with the following parameters:

  - applicationDate: The date and time when the price is applicable, in ISO 8601 format (YYYY-MM-DDTHH:MM:SS).
  - productId: The ID of the product for which you're seeking the price.
  - brandId: The ID of the brand associated with the product.

Example using curl:

```bash
curl -X GET "http://localhost:8080/price?applicationDate=2020-06-14T10:00:00&productId=35455&brandId=1" -H "Accept: application/json"
```

A successful response will return a JSON object containing the price details for the requested product, brand, and application date. Here is an example of a successful response:

```json
{
  "brandId": 1,
  "startDate": "2020-06-14T00:00:00",
  "endDate": "2020-12-31T23:59:59",
  "priceList": 1,
  "productId": 35455,
  "amount": 35.5
}
```

If the request fails due to missing parameters, incorrect values, or server errors, the API will return an appropriate HTTP status code and JSON object containig a descriptive error message to help diagnose the problem. Here is an example of an error response:

```json
{
  "message":"The provided argument is not of the expected type.",
  "code":400
}
```
