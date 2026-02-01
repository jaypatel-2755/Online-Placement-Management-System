
# 🎓 Online Placement Management System

A **JSP + Servlet + MySQL** based web application for managing student placements.  
This system allows **Students**, **Admin**, and **Companies** to interact through a centralized portal for placement activities.

---

## 🚀 Features

### 👨‍🎓 Student Module
- Student Registration & Login
- View Profile
- Upload Resume
- Apply for Companies
- Track Application Status

### 👨‍💼 Admin Module
- Admin Login
- Add / Manage Companies
- View Student Applications
- Download Student Resumes

### 🏢 Company Module
- Company details management
- Job description posting

---

## 🛠️ Technologies Used

| Technology | Purpose |
|------------|---------|
| JSP & Servlet | Backend & frontend logic |
| MySQL | Database |
| Apache Tomcat | Server |
| HTML, CSS | UI Design |
| JDBC | Database Connectivity |

---

## 🗄️ Database Setup (MySQL)

### 1️⃣ Create Database

```sql
CREATE DATABASE design_engineering_portal;
USE design_engineering_portal;
```

### 2️⃣ Required Tables

#### Students Table

```sql
CREATE TABLE students (
    student_id INT AUTO_INCREMENT PRIMARY KEY,
    enrollment_no VARCHAR(20),
    full_name VARCHAR(100),
    email VARCHAR(100),
    password VARCHAR(100),
    dob DATE,
    branch VARCHAR(50),
    contact VARCHAR(20),
    gender VARCHAR(10),
    address TEXT,
    resume_path TEXT
);
```

#### Admins Table

```sql
CREATE TABLE admins (
    admin_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100),
    password VARCHAR(100)
);
```

#### Companies Table

```sql
CREATE TABLE companies (
    company_id INT AUTO_INCREMENT PRIMARY KEY,
    company_name VARCHAR(150),
    email VARCHAR(100),
    job_description TEXT,
    details TEXT,
    posted_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

#### Applications Table

```sql
CREATE TABLE applications (
    id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT,
    company_id INT,
    enrollment_no VARCHAR(20),
    application_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(50)
);
```

---

## 📁 Important Folder for Resume Uploads

Create this folder manually in your PC:

```
C:\FinalDesignProjectUploads\resumes\
```

---

## ⚙️ Project Configuration

Update DB connection in servlets:

```java
DriverManager.getConnection(
 "jdbc:mysql://localhost:3306/design_engineering_portal",
 "root",
 "YOUR_PASSWORD"
);
```

---

## ▶️ How to Run

1. Install MySQL & create database
2. Import project into NetBeans/Eclipse
3. Add project to Apache Tomcat
4. Start Tomcat
5. Open in browser:

```
http://localhost:8080/FinalDesignProject/
```

---

## 🔗 Resume Download Flow

- Resume is stored in:  
  `C:/FinalDesignProjectUploads/resumes/`
- DB stores absolute path
- `DownloadResumeServlet` streams file to browser

---

## 🔐 Default Admin Login

```
Email: admin@gmail.com
Password: admin123
```

---

## 👨‍💻 Author

**Jay**  
Final Year Engineering Project
