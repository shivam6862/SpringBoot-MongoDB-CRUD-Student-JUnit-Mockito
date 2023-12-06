# Efficient Spring Boot: MongoDB CRUD with JUnit, Mockito Testing

This is a Spring Boot backend application for managing persons. It provides basic CRUD (Create, Read, Update, Delete) operations for a `Person` entity.

## Table of Contents

- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
- [Usage](#usage)
  - [API Endpoints](#api-endpoints)
- [Configuration](#configuration)
- [Testing](#testing)
  - [Testing with Junit](#testing-with-junit)
  - [Testing with Mockito](#testing-with-mockito)

## Getting Started

### Prerequisites

Make sure you have the following installed on your machine:

- Java (version 17.0.0)
- Maven (version 4.0.0)
- Your preferred IDE (e.g., IntelliJ, Eclipse , Vscode)

### Installation

1. Clone the repository:

```bash
git clone https://github.com/shivam6862/Learning-Spring-Boot.git
```

2. Navigate to the project directory:

```bash
cd Learning-Spring-Boot
```

3. Click on run button in this file

```
src\main\java\com\shivam6862\LearningSpringBoot\LearningSpringBootApplication.java
```

The application should now be running on http://localhost:8080.

## Usage

### API Endpoints

The following API endpoints are available:

- **GET /api/v1/personrepo**: Get a list of all persons.
- **GET /api/v1/personrepo/{id}**: Get details of a specific person by ID.
- **POST /api/v1/personrepo**: Create a new person.
  - Request body should be a JSON object with the person details.
- **PUT /api/v1/personrepo/{id}**: Update details of a specific person by ID.
  - Request body should be a JSON object with the updated person details.
- **DELETE /api/v1/personrepo/{id}**: Delete a specific person by ID.

Example request:

```http
POST /api/v1/personrepo
Content-Type: application/json

{
  "name":"Shivam kumar",
  "email":"shivam6862mau@gmail.com",
  "branch":"mechanical engineering",
  "semester":"6",
  "enrollment":"21117_ _ _",
  "college":"Indian Institute of Technology Roorkee"
}
```

## Configuration

The application requires configuration for MongoDB connection. Ensure that you have the following settings configured:

- MongoDB Connection URL
- Database Name

These configurations can be set in the `application.properties` file:

```properties
# MongoDB configuration
spring.data.mongodb.uri=mongodb://localhost:27017/your-database-name
```

## Testing

### Testing with JUnit

To run the JUnit tests, Click on run button in this file:

```bash
src\test\java\com\shivam6862\LearningSpringBoot\testing\PersonRepoTest.java
```

### Testing with Mockito

This project is thoroughly tested using Mockito, a powerful mocking framework for Java. The testing suite covers various aspects of unit testing and ensures the reliability and correctness of the codebase.

#### Features Tested:

- **Annotations:** Mockito annotations such as `@Mock`, `@InjectMocks`, and `@Spy` are extensively used to simplify the testing setup.

- **Stubbing:** The project includes comprehensive stubbing to mimic the behavior of dependencies during test cases, ensuring controlled and predictable test scenarios.

- **Verification:** Mockito's verification capabilities are employed to confirm the interactions between objects, validating that certain methods were called with the expected arguments.

- **Exception Handling:** The application's error-handling mechanisms are thoroughly tested to ensure that exceptions are appropriately thrown and caught when unexpected situations arise.

- **Argument Captor:** Mockito's `ArgumentCaptor` is utilized to capture and inspect arguments passed to methods during testing, facilitating more detailed verifications.

- **Mockito Spy:** The `Mockito.spy()` functionality is used to partially mock objects, allowing real methods to be called on a spy instance while still being under the control of Mockito.

- **Behavior-Driven Development (BDD):** Mockito supports a BDD style of testing, and the project leverages this approach to write expressive and readable test cases that focus on the behavior of the system.

- **Argument Matchers:** Mockito's argument matchers enhance the precision of test cases by allowing flexible matching of method arguments.

#### Running Tests:

To execute the Mockito tests, navigate to the test directory and run the test classes. For example:

```bash
src\test\java\com\shivam6862\LearningSpringBoot\testing\PersonRepoMockTest.java
```

Feel free to explore the test classes to gain insights into how different components of the application are rigorously tested using Mockito.

## Thank You

Thank you for exploring this Spring Boot backend application! I hope you find it useful and informative. If you have any questions, issues, or suggestions, feel free to open an issue. Your feedback is greatly appreciated.

# **Happy coding! 🚀**
