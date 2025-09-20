#  Event Management System (Java + MySQL)

A **console-based Event Management System** built in **Java** with **MySQL database integration**.

---

##  Features
- Admin can create events
- Users can register for events
- View participants in each event
- Console-based interface
- MySQL database storage

---

## Setup Instructions

### 1. Database Setup
Run `database.sql` in MySQL.

### 2. Update Database Credentials
In `SQLDatabase.java`:
```java
String user = "root"; // your MySQL username
String pass = "root123"; // your MySQL password
```

### 3. Compile and Run
```bash
javac src/*.java
java -cp .:mysql-connector-java-8.0.xx.jar src/MainApp
```

---

## 📂 Project Structure
```
Event_Management_System/
 ├── src/
 │    ├── MainApp.java
 │    ├── User.java
 │    ├── Admin.java
 │    ├── Participant.java
 │    ├── Event.java
 │    ├── Registration.java
 │    ├── Database.java
 │    └── SQLDatabase.java
 ├── database.sql
 ├── README.md
 └── .gitignore
```
