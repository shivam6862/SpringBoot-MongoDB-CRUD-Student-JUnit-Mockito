# Spring Boot CRUD Operations with MongoDB and Security Features

This is a Spring Boot backend application for managing persons. It provides basic CRUD (Create, Read, Update, Delete) operations for a `Person` entity.

## Table of Contents

- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
- [Usage](#usage)
  - [API Endpoints](#api-endpoints)
- [Testing](#testing)

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

## Testing

To run the JUnit tests, Click on run button in this file:

```bash
src\test\java\com\shivam6862\LearningSpringBoot\testing\PersonRepoTest.java
```

### Thank You

Thank you for exploring this Spring Boot backend application! I hope you find it useful and informative. If you have any questions, issues, or suggestions, feel free to open an issue. Your feedback is greatly appreciated.

**Happy coding! 🚀**
