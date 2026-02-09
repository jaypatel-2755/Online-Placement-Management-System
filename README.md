# Expense Tracker Web Application

A full-stack Expense Tracker web application built using **Java, JSP, Servlets, and MySQL**.  
This project allows users to manage their income and expenses efficiently with authentication and reporting features.

---

## 🚀 Features
- User Registration & Login
- Session-based Authentication
- Forgot Password & Reset Password
- Add Income & Add Expense
- Monthly Expense Report
- Logout functionality
- Secure database connectivity using JDBC

---

## 🛠️ Technologies Used
- Java (JDK 8+)
- JSP & Servlets
- JDBC
- MySQL
- Apache Tomcat
- HTML, CSS

---

## 🗂️ Project Modules
- Authentication Module
- Expense Management Module
- Income Management Module
- Monthly Reporting Module
- Password Recovery Module

---

## ⚙️ Setup Instructions

### 1️⃣ Database Setup
Create a database in MySQL:

```sql
CREATE DATABASE expense_tracker;
USE expense_tracker;
```

Create table:

```sql
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    password VARCHAR(100)
);
```

---

### 2️⃣ Configure Database Connection
Update `DBConnection.java`:

```java
String url = "jdbc:mysql://localhost:3306/expense_tracker";
String username = "root";
String password = "root";
```

---

### 3️⃣ Run Project
- Import project into **NetBeans / Eclipse**
- Configure **Apache Tomcat**
- Run project
- Open browser:
```
http://localhost:8080/ExpenseTracker
```

---

## 👤 Author
**Jay Patel**

---

## 📜 License
This project is for learning and educational purposes.

© 2026 Expense Tracker
