# User Service REST API

This is a Spring Boot-based User Service REST API with three different levels of authentication: Basic Authentication, JWT-based authentication, and OTP-based JWT token generation. This API provides secure access to user services, with layered authentication for enhanced security.

## Features

- **Basic Authentication** with bcrypt encryption for password storage.
- **JWT Token Authentication** for stateless user sessions.
- **OTP-based JWT Token Generation** for added security through One-Time Passwords.

## Authentication Tiers

### 1. Basic Authentication

- Uses bcrypt to hash and store user passwords.
- Accesses resources via username and password.
- To enable Basic Authentication, set `authentication.mode=basic` in `application.properties`.

### 2. JWT Token-Based Authentication

- Stateless authentication using JWT tokens.
- After logging in with valid credentials, users receive a JWT token to use in subsequent requests.
- Requires setting `authentication.mode=jwt` in `application.properties`.

### 3. OTP-Based JWT Token Generation

- Users receive a One-Time Password (OTP) to authenticate their JWT token.
- Designed for enhanced security; OTPs are valid for a limited time and are generated for each login attempt.
- Requires setting `authentication.mode=otp_jwt` in `application.properties`.

## Endpoints

| HTTP Method | Endpoint            | Description                       | Authentication Mode   |
|-------------|---------------------|-----------------------------------|-----------------------|
| `POST`      | `/signup`           | Register a new user               | Open                  |
| `POST`      | `/login`            | Authenticate a user               | Basic / JWT / OTP-JWT |
| `GET`       | `/user`             | Fetch user information            | Authenticated         |
| `POST`      | `/otp`              | Generate OTP for JWT              | OTP-JWT               |

### Sample Request/Response

**Login (JWT Authentication)**:
- **Request**:
    ```json
    POST /login
    {
        "username": "exampleUser",
        "password": "password123"
    }
    ```
- **Response**:
    ```json
    {
        "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJleGFtcGxlVXNlciIsImV4cCI6MTYzMz..."
    }
    ```

**OTP Generation (OTP-JWT Authentication)**:
- **Request**:
    ```json
    POST /otp
    {
        "username": "exampleUser"
    }
    ```
- **Response**:
    ```json
    {
        "otp": "123456"
    }
    ```

## Configuration

In `src/main/resources/application.properties`:

- **Database**:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/userdb
    spring.datasource.username=root
    spring.datasource.password=password
    ```
  
- **Authentication Mode**:
    ```properties
    authentication.mode=basic # Options: basic, jwt, otp_jwt
    ```

## Dependencies

- Spring Boot
- Spring Security
- JWT (Java JWT)
- BCrypt (Spring Security)
- MySQL

## Testing

You can test the API using tools like **Postman** or **cURL**.

## License

This project is licensed under the MIT License - see the LICENSE file for details.
