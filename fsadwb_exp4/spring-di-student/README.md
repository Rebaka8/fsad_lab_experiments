# Spring Dependency Injection – Constructor & Setter Injection

## Experiment: SKILL - 4

### Objective

To demonstrate **Spring Dependency Injection (DI)** using **Constructor Injection** and **Setter Injection** with both **XML configuration** and **Annotation configuration**.

---

## Prerequisites

* Basic knowledge of Java
* Basic understanding of the Spring Framework
* Basic idea of Dependency Injection (DI) and Inversion of Control (IoC)

---

## Problem Statement

A training institute wants to automate the management of student information using a Spring application. The system should inject student details such as **studentId, name, course, and academic year** into objects without manually assigning values.

This experiment demonstrates how Spring injects dependencies using:

* Constructor Injection
* Setter Injection
* XML Configuration
* Annotation Configuration

---

## Technologies Used

* Java
* Spring Core
* Maven
* Eclipse IDE

---

## Project Structure

```
spring-di-student
│
├── pom.xml
│
├── src/main/java/com/fsad
│     ├── Student.java
│     ├── MainApp.java
│     ├── AppConfig.java
│     └── MainAnnotation.java
│
└── src/main/resources
      └── applicationContext.xml
```

---

## Implementation Steps

### 1. Create a POJO Class

A `Student` class is created with the following fields:

* studentId
* name
* course
* year

### 2. Constructor Injection

Spring injects values through the constructor when the bean is created.

### 3. Setter Injection

Setter methods are used to modify values after object creation.

### 4. XML Configuration

The bean is defined inside **applicationContext.xml** where Spring injects the constructor arguments.

### 5. Annotation Configuration

Annotations like `@Component`, `@Configuration`, and `@ComponentScan` are used to configure the Spring container.

---

## Running the Program

### XML Configuration

Run:

```
MainApp.java
```

Expected Output:

```
Student ID: 101
Name: Rebekah
Course: Computer Science
Year: 3
```

---

### Annotation Configuration

Run:

```
MainAnnotation.java
```

Expected Output:

```
Student ID: 102
Name: Rebekah
Course: AI
Year: 4
```

---

## Key Concepts

### Dependency Injection (DI)

Dependency Injection is a design pattern where objects receive their dependencies from an external source instead of creating them themselves.

### Inversion of Control (IoC)

IoC means the control of object creation and dependency management is transferred to the Spring container.

### POJO

A POJO (Plain Old Java Object) is a simple Java class that does not depend on any framework-specific features.

---

## Conclusion

This experiment demonstrates how Spring simplifies dependency management using Constructor and Setter Injection through both XML and Annotation-based configurations.
