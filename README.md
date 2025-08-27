# 📌 Event Management System  

## 📖 Project Title & Description  
**Event Management System** is a **Java console-based application** designed to manage **events, participants, and registrations**.  
The system allows **admins** to create and manage events, while **users** can register, view, and participate in events.  
It demonstrates **Object-Oriented Programming (OOP) principles** and integrates with a **SQL database** for data storage.  

---

## 🎯 Problem Statement  
Managing college, corporate, or personal events manually is time-consuming and error-prone.  
This system **automates event scheduling, registration, and participant tracking**, ensuring smooth management.  

---

## 👥 Target Users  
- **Admins** → Create, edit, and manage events.  
- **Users/Participants** → View events, register, and participate.  

---

## ⚡ Features  
- ✔️ Admin can create and delete events  
- ✔️ User can register for events  
- ✔️ Display list of participants for each event  
- ✔️ Secure login system for both admin and user  
- ✔️ Database connectivity for storing event and user details  
- ✔️ Console-based menu-driven interface  

---

## 🧑‍💻 OOP Concepts Used  

### 1. Classes & Objects  
- Classes: `Event`, `Participant`, `Registration`, `Database`, `MainApp`  
- Objects created for events and participants to manage their details.  

### 2. Encapsulation  
- Attributes like `eventName`, `date`, `participantName` are declared **private**.  
- Access provided using **getters & setters**.  

### 3. Inheritance  
- `User` (base class).  
- `Admin` and `Participant` (derived classes).  

### 4. Polymorphism  
- **Method Overloading** → Different ways of registering (by ID, by Name).  
- **Method Overriding** → `displayDetails()` customized for `Admin` and `Participant`.  

### 5. Abstraction  
- `Database` **interface** → `connect()`, `insert()`, `fetch()`.  
- Implemented by `SQLDatabase` class.  

---

## 🏗️ UML Class Diagram  

```mermaid
classDiagram
    class User {
      -String username
      -String password
      +login()
      +logout()
    }
    
    class Admin {
      +createEvent()
      +deleteEvent()
    }
    
    class Participant {
      +registerEvent()
      +viewEvents()
    }
    
    class Event {
      -String eventName
      -String date
      -String location
      +displayDetails()
    }
    
    class Database {
      <<interface>>
      +connect()
      +insert()
      +fetch()
    }
    
    User <|-- Admin
    User <|-- Participant
