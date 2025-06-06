# ✅ Task Management System – Java Swing (PT Assignment 1)

This project is a **Java Swing GUI-based application** developed for the **Fundamental Programming Techniques** course (Assignment 1), focused on **managing tasks assigned to employees** in a software company.

## 📌 Features

- Add employees
- Add tasks: `SimpleTask` (with duration), or `ComplexTask` (nested tasks)
- Assign tasks to employees
- View employees and their tasks
- Modify task status (Completed/Uncompleted)
- Statistics and filtering:
  - Total duration worked per employee (only completed tasks)
  - Filter employees working more than 40h
  - Number of completed/uncompleted tasks per employee

## 🧱 Technical Highlights

- **OOP Design**: Uses inheritance, polymorphism, sealed classes (`Task`)
- **Design Pattern**: Composite Pattern for nested `ComplexTask`s
- **GUI**: Developed using Java Swing
- **Persistence**: Java Serialization to save/load employees and tasks
- **Layered Architecture**: Separation of concerns between models, services, and UI
- **Code Quality**: Methods under 30 lines, naming conventions respected

## 🗂️ Project Structure

```
src/
├── model/
│   ├── Employee.java
│   ├── Task.java (sealed)
│   ├── SimpleTask.java
│   └── ComplexTask.java
├── service/
│   ├── TaskManagement.java
│   └── Utility.java
├── ui/
│   └── MainWindow.java
├── data/
│   └── serialized files
└── diagrams/
    ├── use_case.drawio
    ├── class_diagram.drawio
    └── package_diagram.drawio
```

## 📚 Technologies Used

- Java 17+ (for sealed classes)
- Java Swing
- Serialization (java.io)
- draw.io for UML diagrams

## 🧪 What I Learned

- How to implement a multi-layered architecture in Java
- Using Composite Pattern to model complex tasks
- Creating user interfaces in Java Swing
- Managing data using serialization
- Writing reusable utility methods for filtering and aggregation
- Applying sealed classes and following Java coding standards

## 📝 Grade

✅ **10/10** – Full implementation of all functional and technical requirements.

## 🧑‍💻 Author

**Maxim Francesco**  
**University**: Technical University of Cluj-Napoca  
**Course**: Fundamental Programming Techniques  
**Email**: maaximfrancesco@gmail.com  
**LinkedIn**: [linkedin.com/in/francescomaxim](https://www.linkedin.com/in/francescomaxim/)
