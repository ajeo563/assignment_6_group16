# CodeCraft - Learning Progress API

A Spring Boot REST API implementing the View Learning Progress feature for the CodeCraft OOP learning platform.

## Feature
Returns a user's learning progress: modules completed, in progress, or not started, quiz scores, and total time spent. Supports performance testing under concurrent load.

## Running the Application
**Windows:**
```bash
mvnw.cmd spring-boot:run
```
**Mac/Linux:**
```bash
./mvnw spring-boot:run
```

## Endpoint
```
GET /api/progress/{userId}
```
Returns HTTP 200 with progress data, or 404 if the user is not found.

**Example:**
```
GET http://localhost:8080/api/progress/user1
```
