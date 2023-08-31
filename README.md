# Spring Boot web application

  - Java 17
  - Maven
  - Spring Boot 3.1.3
  - This application uses two REST services: a number addition service and a merge search service

## Author

  - Markus Talvik

## How to run locally

  - Run `application.java`
  - To test number addition service. Navigate to `http://localhost:8080/api/addition?num1=5&num2=40` (you can change num1 and num2 values in the URL to change the outcome)
  - To test merge search service. Navigate to `http://localhost:8080/api/mergeSearch?searchNumber=70&sortOrder=ascending` (you can change Number value and sortOrder to ascending or descending)
