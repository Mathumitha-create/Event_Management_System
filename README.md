#  Event Management System

##  Project Title & Description
**Event Management System**  
A Java console-based application designed to manage events, participants, and registrations.  
The system allows admins to create and manage events, while users can register, view, and participate in events.  
It demonstrates object-oriented programming (OOP) principles and integrates with a SQL database for data storage.

---

##  Problem Statement & Target Users
### Problem Statement
Managing events manually is time-consuming and prone to errors. Traditional methods make it difficult to track registrations, schedules, and participants effectively.  

### Target Users
- **Event Organizers/Admins** – to create, update, and manage events.  
- **Participants/Attendees** – to browse events and register easily.  
- **Institutions/Organizations** – to handle multiple events efficiently.  

---

## Class Diagram (UML-style)
```
+-----------------+          +-----------------+
|     Event       |<>------->|   Participant   |
+-----------------+          +-----------------+
| - eventId       |          | - participantId |
| - name          |          | - name          |
| - date          |          | - email         |
| - location      |          | - phone         |
+-----------------+          +-----------------+
| + addEvent()    |          | + register()    |
| + updateEvent() |          | + updateInfo()  |
| + deleteEvent() |          |                 |
+-----------------+          +-----------------+

           ^
           |
           |
+-----------------+
|   Organizer     |
+-----------------+
| - organizerId   |
| - name          |
| - contactInfo   |
+-----------------+
| + createEvent() |
| + manageEvent() |
+-----------------+
```


##  OOP Concepts Used
- **Encapsulation**:  
  - Event, Participant, and Registration classes keep their data private and expose only necessary methods.  

- **Inheritance**:  
  - Future enhancements (e.g., Admin extending Participant with extra privileges).  

- **Polymorphism**:  
  - Method overloading (e.g., `createEvent()` with different parameters).  
  - Method overriding (e.g., `toString()` in different classes).  

- **Abstraction**:  
  - Interfaces could be used for `DatabaseOperations` to hide database details.  

---

## 🛠 Tech Stack

| Layer        | Technology Used |
|--------------|-----------------|
| **Frontend** | Java (Console-based UI) |
| **Backend**  | Java (Core OOP Concepts), JDBC (Java Database Connectivity) |
| **Database** | MySQL |

---

##  Features
- Role-based access for Admins and Participants  
- Search and filter events by name, date, or location  
- Event capacity limit to prevent overbooking  
- Auto-generated registration ID for participants  
- Update or cancel registrations easily  
- Persistent data storage using MySQL  
- Scalable design for adding future features  

---

