# <h1 align="center">University Event Management </h1>
<p align="center">
  <a href="Java url">
    <img alt="Java" src="https://img.shields.io/badge/Java->=8-darkblue.svg" />
  </a>
  <a href="Maven url" >
    <img alt="Maven" src="https://img.shields.io/badge/maven-4.0-brightgreen.svg" />
  </a>
  <a href="Spring Boot url" >
    <img alt="Spring Boot" src="https://img.shields.io/badge/Spring Boot-3.1.3-brightgreen.svg" />
  </a>
   <img alt = "GPL v3" src="https://img.shields.io/badge/License-GPLv3-blue.svg" />
</p>

---

<p align="left">

Welcome to the University Event Management project! This Spring Boot application provides a robust and efficient solution for managing university events and student records. It leverages the power of Spring Boot and an H2 database to ensure seamless data storage and retrieval.

## Overview

In a dynamic university environment, managing events and student data efficiently is crucial. The University Event Management system simplifies this task by offering a set of well-defined APIs for administrators and staff to perform essential operations.

## Getting Started

To get started with the University Event Management system, follow these steps:

1. Clone or download this repository to your local environment.

2. Build and run the Spring Boot application.

3. Access the API endpoints using tools like Postman or swagger.

4. Explore the comprehensive functionality provided for managing students and events.


## **Here's a brief overview of the key components and features:**
### Student Management

- **Add Student**: Easily add new students to the system with detailed information, including their names, ages, and departments. The system ensures data integrity and validates inputs to maintain accurate records.

- **Update Student Department**: Change a student's department as needed. This feature is particularly useful when students switch majors or programs.

- **Delete Student**: Remove a student's record from the database when they graduate or leave the university.

- **Get All Students**: Retrieve a comprehensive list of all registered students in the system.

- **Get Student by ID**: Fetch specific student details using their unique identifier.

### Event Management

- **Add Event**: Create and record various university events, specifying event names, locations, dates, start times, and end times.

- **Update Event**: Modify event details, ensuring that the most up-to-date information is available.

- **Delete Event**: Remove events that are no longer relevant or have concluded.

- **Get All Events by Date**: Easily find events occurring on or before a specific date, streamlining event planning and coordination.

### Data Validation

The system incorporates robust data validation to maintain data quality and consistency. Key validation rules include:

- **Age**: Student age must be between 18 and 25, ensuring that only eligible students are registered.

- **First Name**: Student first names must start with a capital letter, adhering to naming conventions.

- **Department**: Departments are predefined as ME (Mechanical Engineering), ECE (Electrical and Computer Engineering), CIVIL (Civil Engineering), and CSE (Computer Science and Engineering), IT (Information Technology), EEE (Electrical and Electronics Engineering ), MECH (Mechanical). This ensures accurate departmental categorization.


## Dataflow
This section outlines the data flow within the University Event Management project, describing the key classes and their roles in processing data.

### Client (HTTP Request)

- The client, which can be a web browser, API client, or any HTTP-capable application, initiates the data flow by sending HTTP requests to the Spring Boot application's endpoints.

### Controller Classes

#### StudentController

- Responsible for managing student-related operations.
- Receives HTTP requests related to students (e.g., adding, updating, deleting, retrieving).
- Validates incoming data and delegates actions to the StudentService class.

#### EventController

- Manages event-related operations.
- Handles HTTP requests for events (e.g., adding, updating, deleting, retrieving).
- Validates incoming data and invokes the EventService class to perform actions on events.

### Service Classes

#### StudentService

- Implements business logic for student-related operations (e.g., addStudent, updateStudentDepartment, deleteStudent).
- Validates student data, including age and name format.
- Communicates with the StudentRepository for data storage and retrieval.

#### EventService

- Contains business logic for event-related operations (e.g., addEvent, updateEvent, deleteEvent).
- Validates event data.
- Interacts with the EventRepository for data storage and retrieval.

### Repository Classes

#### StudentRepository

- Provides methods for CRUD operations on student data (e.g., save, findById, delete).
- Uses Spring Data JPA to interact with the H2 database.

#### EventRepository

- Manages CRUD operations on event data (e.g., save, findById, delete).
- Utilizes Spring Data JPA for database interactions.

### Data Validation

- Data validation rules for age, name format, and department are enforced using validation annotations in the Student class.
- Additional validation can be implemented in the service layer.

### H2 Database

- The H2 in-memory database stores student and event data persistently.

### HTTP Responses

- Controller classes construct HTTP responses based on the results of service and repository interactions.
- HTTP responses are sent back to the client to complete the request-response cycle.

### Client (HTTP Response)

- The client receives the HTTP response from the Spring Boot application, which may include data, success messages, or error messages.

This class-based data flow demonstrates how data is processed and managed within your University Event Management project, from client requests to data validation, business logic, database interactions, and finally, HTTP responses to the client. This structure ensures that your application follows the principles of separation of concerns and maintains modularity and maintainability.


## Endpoints

### Student Endpoints

**Add Student**: 
```
POST /api/student
```

**Update Student Department**: 
```
PUT /api/student/id/{studentId}/updateDepartment
```

**Delete Student**: 
```
DELETE /api/student/id/{studentId}
```

**Get All Students**: 

```
GET /api/students
```
**Get Student by ID**: 
```
GET /api/id/{studentId}
```
## Sample Student Data
```
[
    {
        "studentId": 1,
        "firstName": "John",
        "lastName": "Doe",
        "age": 20,
        "department": "ME"
    },
    {
        "studentId": 2,
        "firstName": "Alice",
        "lastName": "Smith",
        "age": 22,
        "department": "ECE"
    },
    {
        "studentId": 3,
        "firstName": "Bob",
        "lastName": "Johnson",
        "age": 19,
        "department": "CIVIL"
    },
    {
        "studentId": 4,
        "firstName": "Emily",
        "lastName": "Davis",
        "age": 25,
        "department": "CSE"
    },
    {
        "studentId": 5,
        "firstName": "Michael",
        "lastName": "Brown",
        "age": 21,
        "department": "IT"
    }
]
```

### Event Endpoints

**Add Event**: 
```
POST /api/event`
```
**Update Event**: 
```
PUT /api/{eventId}
```
**Delete Event**: 
```
DELETE /api/{eventId}
```
**Get All Events by Date**: 
```
GET /api/byDate
```
## Sample Event Data

```
[
  {
    "eventId": 1,
    "eventName": "Sports Day",
    "locationOfEvent": "Stadium",
    "date": "2023-10-15",
    "startTime": "09:00:00",
    "endTime": "14:00:00"
  },
  {
    "eventId": 2,
    "eventName": "Music Concert",
    "locationOfEvent": "Concert Hall",
    "date": "2023-11-05",
    "startTime": "18:30:00",
    "endTime": "22:00:00"
  },
  {
    "eventId": 3,
    "eventName": "Science Fair",
    "locationOfEvent": "Exhibition Center",
    "date": "2023-09-28",
    "startTime": "10:00:00",
    "endTime": "16:00:00"
  },
  {
    "eventId": 4,
    "eventName": "Art Exhibition",
    "locationOfEvent": "Art Gallery",
    "date": "2023-12-10",
    "startTime": "11:00:00",
    "endTime": "17:00:00"
  },
  {
    "eventId": 5,
    "eventName": "Tech Conference",
    "locationOfEvent": "Conference Center",
    "date": "2023-10-20",
    "startTime": "09:30:00",
    "endTime": "17:30:00"
  }
]
```

## Contributors

- **Raj Anand** : [rajanandXXXX@gmail.com]()

We welcome contributions and feedback to improve and expand this project.

Thank you for choosing the University Event Management system for your university's event planning and student management needs!
