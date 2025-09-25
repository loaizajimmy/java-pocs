# 📘 Functional Requirements - Students Manager

This document describes the main functional requirements of the **Students Manager** system.  
The system manages three main entities:

- **Students**: Student registration and queries.
- **Subjects**: Subject registration and queries.
- **Enrollments**: Student enrollment into subjects.

---

## 1. Functional Requirements Overview

### Students
- Register a new student.
- Retrieve all students.
- Find a student by document.

### Subjects
- Register a new subject.
- Retrieve all subjects.
- Find a subject by code.

### Enrollments
- Register a new enrollment.
- Find an enrollment by student and subject.
- Find all enrollments by student.
- Find all enrollments by subject.

---

## 2. Use Case Diagram

The following diagram illustrates the **use cases** of the system:

[![](https://img.plantuml.biz/plantuml/svg/ZLJBJiCm4BplLwnwG73eBw2Y02Tw8UePkOa9GOuZsHka2lNVYOaThrtpE7fsl9xPsMHdIHYQ1WLAlXBIYARltWZRtiY6-b43Y8P6WmSh3O03XUwKn4rDKoirMTmBBJffi3vPaiC6Fm7nUW4na6vGM3nKB-7CATFnVUuQAVxCA0_QZ4eDl163u0pWrE5sUvkyaO2XAmTvav8rxwKoKj3g9IXOK0ywscElsq32umdlnsOQs0LNP_IdtXBUANKn8rTOFPnJOTv59cn1Cs4B68KjPoUi6bkPY8hKA2fBvLjKc64gYatHwtgMtKoVvnnBQxhYGqPqLHSX9p0CyIgtvhYHMjU5-vOr-E5Q5bb-zzSd_QZSoiLD2_kKhaI1m5UWK4wI1xQrsGDUH870uooKanGX_GBMBoLDg4ow2E9VjEZyRwut0JkfM_Tx-W80)](https://editor.plantuml.com/uml/ZLJBJiCm4BplLwnwG73eBw2Y02Tw8UePkOa9GOuZsHka2lNVYOaThrtpE7fsl9xPsMHdIHYQ1WLAlXBIYARltWZRtiY6-b43Y8P6WmSh3O03XUwKn4rDKoirMTmBBJffi3vPaiC6Fm7nUW4na6vGM3nKB-7CATFnVUuQAVxCA0_QZ4eDl163u0pWrE5sUvkyaO2XAmTvav8rxwKoKj3g9IXOK0ywscElsq32umdlnsOQs0LNP_IdtXBUANKn8rTOFPnJOTv59cn1Cs4B68KjPoUi6bkPY8hKA2fBvLjKc64gYatHwtgMtKoVvnnBQxhYGqPqLHSX9p0CyIgtvhYHMjU5-vOr-E5Q5bb-zzSd_QZSoiLD2_kKhaI1m5UWK4wI1xQrsGDUH870uooKanGX_GBMBoLDg4ow2E9VjEZyRwut0JkfM_Tx-W80)



## 3. Flow Diagram

The flow diagram below describes the interaction between the user and the system APIs:

```mermaid
flowchart TD
    A[User] -->|Manage Students| B{Students API}
    B -->|Get all| B1[GET /students]
    B -->|Create| B2[POST /students]
    B -->|Find by document| B3[GET /students/:document]

    A -->|Manage Subjects| C{Subjects API}
    C -->|Get all| C1[GET /subjects]
    C -->|Create| C2[POST /subjects]
    C -->|Find by code| C3[GET /subjects/:code]

    A -->|Manage Enrollments| D{Enrollments API}
    D -->|Register| D1[POST /enrollments]
    D -->|Find by student & subject| D2[GET /enrollments/:studentId/:subjectId]
    D -->|Find by student| D3[GET /enrollments/student/:studentId]
    D -->|Find by subject| D4[GET /enrollments/subject/:subjectId]
```


## ✅ Summary

The **Students Manager** system provides functionality to:
- Manage students and their information.
- Manage subjects and their codes.
- Manage student enrollments in subjects.

This documentation provides a functional view of the system with **use case diagrams** and **API flow diagrams**.
