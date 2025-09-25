# 🎓 Students Manager

A sample **Spring Boot microservice** built with **Clean Architecture principles**, designed to manage **students, subjects, and enrollments** in an academic system.

---

## 📖 Overview

The **Students Manager** service provides APIs to:
- Register and list **students**.
- Register and list **subjects**.
- Enroll students in subjects.
- Query enrollments by student.

The project is intended for **educational purposes**, mainly to demonstrate:
- Clean Architecture layers (domain, application, infrastructure, interfaces).
- Separation of concerns between business logic and technical implementation.
- A modular and testable design.

---

## 🏛️ Architecture

The project follows the **Clean Architecture** approach:

```
students-manager
│
├── application        -> Use cases (business orchestration)
│   └── service
│
├── domain             -> Entities and repository interfaces
│   ├── model
│   └── repository
│
├── infrastructure     -> Technical implementations (JPA, DB, mappers)
│   ├── entity
│   └── repository
│
├── interfaces         -> REST controllers (API layer)
│
└── StudentsManagerApplication.java
```

---

## 📑 Documentation

- [Functional Requirements](docs/functional_requirements.md)

___


## ⚙️ Technologies

- **Java 17+**
- **Spring Boot 3**
- **Spring Data JPA**
- **PostgreSQL Database**
- **Gradle**

---

## 🚀 Getting Started

1. Clone the monorepo
   ```bash
   git clone https://github.com/loaizajimmy/java-pocs.git
   cd java-pocs/students-manager
   ```
2. Run the Spring Boot application (You need a PostgreSQL database)
3. Test the endpoints using Postman o `curl`
4. You can import a Postman Collection from this URL: [Postman Collection](docs/resources/students_manager.postman_collection.json)

The service will be available at:  
👉 `http://localhost:8080`

---

## 📡 API Endpoints

### Students
- `GET /students` → Get all students
- `POST /students` → Create a new student
- `GET /students/{document}` → Get a student by document

### Subjects
- `GET /subjects` → Get all subjects
- `POST /subjects` → Create a new subject
- `GET /subjects/{code}` → Get a subject by code

---

## 🎯 Purpose

This project is **not production-ready**.  
It is a **demo for teaching Clean Architecture**, focusing on how to design modular, maintainable, and testable microservices.

---
