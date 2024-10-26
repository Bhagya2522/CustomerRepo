# Customer Management Application

A Spring Boot application for managing customer data with a RESTful API. This application provides endpoints for creating, retrieving, and listing customers.

## Overview

This application provides a simple backend API for managing customer information. It includes basic CRUD operations, such as creating new customers and retrieving customer details by ID.

## Technologies Used

- **Spring Boot**: For building the REST API.
- **Kotlin**: Application language.
- **Spring Data JPA**: For database operations.
- **H2 Database**: In-memory database for development and testing.
- **JUnit and MockMvc**: For testing the REST API.

## API Documentation

### Endpoints

1. **GET /api/customers**
    - **Description**: Retrieves a list of all customers.
    - **Response**: JSON array of customer objects.

   **Example Response:**
   ```json
   [
       {
           "id": 1,
           "firstName": "Adhrit",
           "lastName": "Mane",
           "dob": "adhrit.mane@gmail.com"
       },
       {
           "id": 2,
           "firstName": "Bhagya",
           "lastName": "Jadhav",
           "dob": "bhagya.jadhav@gmail.com"
       }
   ]

2. **GET /api/customers/{id}**
- **Description**: Retrieves a specific customer by ID.
- **Path Parameter**:
    - `id` (Long): Customer's ID.
- **Response**: JSON object with customer details or 404 if not found.


**Example Response:**
```json
   {
      "id": 1,
      "firstName": "Adhrit",
      "lastName": "Mane",
      "dob": "adhrit.mane@gmail.com"
    } 
```

3. **POST /api/customers**
- **Description**: Creates a new customer.
- **Request Body**:
    - `firstName` (String): Customer's first name.
    - `lastName` (String): Customer's last name.
    - `dob` (String): Customer's date of birth.
- **Response**: JSON object of the created customer with status 201.

**Example Request:**

```json
{
    "firstName": "Lakshmi",
    "lastName": "Jadhav",
    "dob": "lakshmi.jadhav@gmail.com"
}
```

**Example Response:**

```json
{
    "firstName": "Lakshmi",
    "lastName": "Jadhav",
    "dob": "lakshmi.jadhav@gmail.com"
}
```