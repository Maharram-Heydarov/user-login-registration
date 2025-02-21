# User Registration and Authentication System

## Overview
This project is a simple user registration and authentication system built using Spring Boot and MongoDB. It provides secure user authentication using JWT and role-based access control with Spring Security.

## Features
- **User Registration**: Users can register with a unique username and password.
- **User Login**: Users can log in and receive a JWT token for authentication.
- **Role-Based Access Control**: Users are assigned roles (`user` by default, `admin` for pre-created admin user).
- **Password Encryption**: User passwords are securely encrypted using BCrypt.
- **JWT Authentication**: Secure authentication using JSON Web Tokens.
- **Admin User Initialization**: The application creates a default admin user on startup.
- **API Documentation**: APIs are documented using Swagger/OpenAPI.

## Technologies Used
- **Java 17**
- **Spring Boot 3**
- **Spring Security**
- **MongoDB**
- **JWT (JSON Web Token)**
- **BCrypt Password Encoding**
- **Swagger/OpenAPI**

## Installation & Setup
### Prerequisites
- Java 17 or later
- MongoDB installed and running
- Maven

### Steps to Run the Application
1. Clone the repository:
   ```sh
   git clone <repository-url>
   cd user-authentication-system
   ```
2. Configure the MongoDB connection in `application.properties`:
   ```properties
   spring.data.mongodb.uri=mongodb://localhost:27017/authdb
   ```
3. Build the project:
   ```sh
   mvn clean install
   ```
4. Run the application:
   ```sh
   mvn spring-boot:run
   ```

## API Endpoints
### Authentication APIs
| Method | Endpoint | Description |
|--------|---------|-------------|
| `POST` | `/api/auth/register` | Register a new user |
| `POST` | `/api/auth/login` | Authenticate user and return JWT |

### User APIs (Protected by JWT)
| Method | Endpoint | Description |
|--------|---------|-------------|
| `GET` | `/api/users/me` | Get authenticated user details |

### Admin APIs (Role-Based Access Control)
| Method | Endpoint | Description |
|--------|---------|-------------|
| `GET` | `/api/admin/users` | Get all users (Admin only) |

## Security Implementation
- **Spring Security** is used for authentication and authorization.
- **JWT Tokens** are generated on successful login and required for accessing secured endpoints.
- **BCrypt** is used to securely hash and store user passwords.
- **Role-based authorization** ensures only admins can access certain endpoints.

## Default Admin User
On application startup, a default admin user is created:
- **Username**: `admin`
- **Password**: `admin`
- **Role**: `ADMIN`

## Swagger API Documentation
Once the application is running, you can access API documentation at:
```
http://localhost:8080/swagger-ui/index.html
```

## License
This project is licensed under the MIT License.

## Author
Developed by Maharram.

