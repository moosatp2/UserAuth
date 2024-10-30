# Project Tasks

## 1. Implement /login API for Basic Authentication

### Task Details
- **Objective**: Develop a `/login` API endpoint that authenticates users using Basic Authentication with bcrypt-encrypted passwords.
- **Description**:
    - Verify user credentials (username and password) against stored bcrypt-hashed passwords.
    - Return an appropriate response upon successful or failed authentication.
    - Include error handling for invalid credentials.
- **Expected Outcome**:
    - Successful login response with user details.
    - Appropriate error messages for failed login attempts.

### Steps
1. Set up Basic Authentication in the Spring Security configuration.
2. Create the `/login` endpoint in the controller.
3. Implement authentication logic using bcrypt to validate passwords.
4. Test the endpoint using Postman or cURL to ensure correct responses.

---

## 2. Create and Implement JWT Token-Based Authentication (Separate Branch)

### Task Details
- **Objective**: Develop JWT-based authentication using Spring Security and an auth server on a separate branch.
- **Description**:
    - Configure Spring Security to support JWT token generation and validation.
    - Implement an authentication server that issues JWTs for authenticated users.
    - Ensure stateless session management.
- **Expected Outcome**:
    - A `/login` endpoint that issues a JWT token upon successful authentication.
    - Authenticated endpoints that validate JWT tokens for access.

### Steps
1. **Create a new branch**:
   ```bash
   git checkout -b feature/jwt-auth
2. Set up Spring Security for JWT token-based authentication.
3.   Implement the auth server to issue JWTs.
4.   Modify endpoints to require JWT validation for access.
5.  Test endpoints with token-based authentication.

## 3. Implement OTP-Based JWT Token Authentication (Separate Branch)

### Task Details
- **Objective**: Develop an OTP-based JWT token authentication on a separate branch.
- **Description**:
    - Add OTP generation for user authentication.
    - Upon successful OTP validation, issue a JWT token to the user.
    - Implement OTP expiry and validation logic.
- **Expected Outcome**:
    - A `/otp` endpoint to generate and validate OTPs.
    - A JWT token issued upon valid OTP confirmation.

### Steps
1. **Create a new branch**:
   ```bash
   git checkout -b feature/otp-jwt-auth
2. Add OTP generation and validation logic.
3. Modify the authentication flow to use OTPs for JWT token issuance.
4. Test the OTP-based authentication flow for security and functionality.