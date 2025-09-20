# 🎉 Event Management System (Java + MySQL)

## 📌 Project Overview
The **Event Management System** is a **Java console-based application** designed to manage events, participants, and registrations.  
Admins can manage events, while users can register, view, and participate.  
All data is stored in a **MySQL database** for persistence.

---

## 🚀 Features

### 👨‍💼 Admin Features
- Create, update, and delete events.
- View all registered participants.
- Manage participant registrations.

### 👥 User Features
- Register for the system.
- Login securely.
- View available events.
- Register for events.

### 💾 Database Features
- Stores users, events, and registrations in **MySQL**.
- Ensures **data consistency** and **persistent storage**.

---

## 🛠️ Tech Stack
- **Language:** Java  
- **Database:** MySQL  
- **IDE:** IntelliJ IDEA / Eclipse / VS Code  
- **Version Control:** Git & GitHub


---

## 📊 UML Diagram
```mermaid
classDiagram
    class User {
      -username : String
      -password : String
      +login()
      +logout()
    }

    class Admin {
      +createEvent()
      +updateEvent()
      +deleteEvent()
      +viewParticipants()
    }

    class Participant {
      +viewEvents()
      +registerEvent()
    }

    class Event {
      -eventId : int
      -eventName : String
      -eventDate : String
      -eventLocation : String
      +displayDetails()
    }

    class Registration {
      -registrationId : int
      -participantId : int
      -eventId : int
      +confirmRegistration()
    }

    User <|-- Admin
    User <|-- Participant
    Admin --> Event : manages
    Participant --> Registration : creates
    Registration --> Event : belongs to
es
