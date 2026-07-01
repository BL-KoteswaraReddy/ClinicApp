# ClinicOps

ClinicOps is a Java console-based application developed to manage the day-to-day operations of a small clinic. The application replaces manual record keeping by providing features for doctor management, patient registration, appointment booking, bulk data import, and audit logging.

The project is implemented incrementally through multiple use cases to demonstrate Java core concepts, object-oriented programming, collections, file handling, streams, logging, and exception handling.

---

## Features

### Admin Module
- Register Doctors
- Display Doctor Details
- Bulk Upload Doctors from CSV
- Prevent Duplicate Doctor Records
- Validate Doctor Specialization and Shift
- View Audit Logs
- Log Important System Events using Log4j2

### Front Desk Module
- Register Patients
- Prevent Duplicate Patient Registration using Mobile Number
- Validate Indian Mobile Numbers
- Display Patient Details
- Book Appointments
- Book Based on Doctor Specialization
- Book Based on Doctor Shift Availability
- Prevent Double Booking of Slots

---

## Technologies Used

- Java 17+
- Maven
- OpenCSV
- Log4j2
- Java Collections
- Java Streams API
- Exception Handling
- Enums
- File I/O

---

## Project Structure

```
ClinicOps
│
├── AdminMenu.java
├── FrontDeskMenu.java
├── ClinicApp.java
├── Doctor.java
├── Patient.java
├── Appointment.java
├── FileHandler.java
├── ScannerHelper.java
├── Specialization.java
├── Shift.java

```

---

## Implemented Use Cases

### User Story 1 - Doctor Management

- UC1 - Console Based Menu
- UC2 - Doctor Registration
- UC3 - Doctor Object & ArrayList
- UC4 - Enums for Shift & Specialization

---

### User Story 2 - Bulk Upload

- UC5 - CSV Import
- UC6 - OpenCSV Integration
- Invalid records are skipped
- Duplicate doctors are ignored

---

### User Story 3 - Patient Registration

- UC7 - Register Patient
- UC8 - Duplicate Patient Validation using Mobile Number

---

### User Story 4 - Appointment Booking

- UC9 - Appointment Booking
- UC10 - Booking based on Specialization
- UC11 - Shift Aware Appointment Booking

---

### User Story 5 - Audit Logging

- UC12 - Logging Infrastructure
- UC13 - Functional Business Logs
- UC14 - Error & Security Logging
- UC15 - Log4j2 Migration

---

## Learning Outcomes

This project helped in understanding:

- Object Oriented Programming
- Encapsulation
- Constructors
- Enums
- Collections
- Generics
- File Handling
- OpenCSV Library
- Exception Handling
- Java Streams API
- Functional Programming
- Logging using Log4j2
- Defensive Programming
- Maven Dependency Management

---

## How to Run

Clone the repository

```bash
git clone <repository-url>
```

Move into the project

```bash
cd ClinicOps
```

Build the project

```bash
mvn clean install
```

Run the application

```bash
mvn exec:java
```

Or run `ClinicApp.java` directly from IntelliJ IDEA.

---

## Sample CSV Format

```csv
John,CARDIOLOGIST,10,MORNING
David,GENERAL_PHYSICIAN,11,BOTH
Smith,INTERNAL_MEDICINE,8,EVENING
Robert,GYNAECOLOGIST,12,MORNING
William,CHILD_SPECIALIST,20,BOTH
```

---

## Future Enhancements

- MySQL Database Integration
- JDBC
- Hibernate / JPA
- Spring Boot Migration
- REST APIs
- Authentication & Authorization
- Unit Testing using JUnit
- Docker Support

---

## Author

**Koti Reddy**

Java | Spring Boot | Microservices Developer
