
# Interview Preparation Tracker

## Description
The **Interview Preparation Tracker** is a backend application built using **Java** and **Spring Boot** to help candidates prepare for job interviews by tracking the questions they have practiced. The application allows users to perform CRUD operations on interview questions, including viewing, adding, updating, and deleting questions. 

## Features
- **CRUD Operations**: Create, Read, Update, and Delete interview questions.
- **Search**: Search for interview questions based on specific keywords.
- **Swagger UI**: Integrated Swagger UI for easy testing and API documentation.
- **PostgreSQL Database**: Stores interview questions and related details.
  
## Technologies Used
- **Java 21** 
- **Spring Boot 3.x**
- **Spring Data JPA** for ORM
- **PostgreSQL** for database
- **Swagger UI** for API documentation
- **JUnit 5** for testing

## Setup Instructions

### Prerequisites:
- JDK 21 or higher
- Maven
- PostgreSQL database set up and running

### Clone the Repository:
```bash
git clone https://github.com/your-username/Interview-tracker.git
```

### Configure the Database:
1. Create a PostgreSQL database, e.g., `interview_tracker`.
2. Update the `application.properties` file with the correct database credentials.

### Run the Application:
1. Navigate to the project directory and run the application using Maven:
    ```bash
    mvn spring-boot:run
    ```

2. The application will start on port 8080 by default.

### Access Swagger UI:
Once the application is running, you can access the Swagger UI at:
```
http://localhost:8080/swagger-ui.html
```

## Endpoints
- `GET /questions` - Get all questions.
- `POST /questions` - Add a new question.
- `PUT /questions/{id}` - Update an existing question.
- `DELETE /questions/{id}` - Delete a question.
- `GET /questions/search?keyword={keyword}` - Search for questions.

## Testing
- Unit tests are written using **JUnit 5**.
- To run the tests:
    ```bash
    mvn test
    ```

## License
This project is open-source and available under the [MIT License](LICENSE).

## Author
Your Name
