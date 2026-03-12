# Hibernate CRUD Operations – Retail Inventory System

## Student Details

**Name:** Rebaka Meda
**ID Number:** 2400032563

---

## Experiment: Hibernate CRUD Operations

This project demonstrates **CRUD operations (Create, Read, Update, Delete)** using **Hibernate ORM with JPA annotations**.
A simple **Retail Inventory System** is implemented where an admin can manage product details such as product name, description, price, and quantity.

---

## Technologies Used

* Java
* Hibernate ORM
* Maven
* H2 In-Memory Database
* Eclipse IDE

---

## Project Description

The application stores product details in a database and allows the following operations:

1. Insert new product records
2. Retrieve product information using product ID
3. Update product price or quantity
4. Delete discontinued products

Hibernate automatically maps the **Product entity class** to a database table using **JPA annotations**.

---

## Entity Fields

| Field | Description |
|------|-------------|
| id | Primary key |
| name | Product name |
| description | Product description |
| price | Product price |
| quantity | Product quantity |

---

## Hibernate ID Generation Strategy

Hibernate provides different strategies for generating primary keys:

* `GenerationType.AUTO`
* `GenerationType.IDENTITY`
* `GenerationType.SEQUENCE`

In this implementation, the **IDENTITY strategy** is used to automatically generate product IDs.

---

## Project Structure

```
hibernate_crud
│
├── src/main/java/com/inventory
│       Product.java
│       HibernateUtil.java
│       MainApp.java
│
├── src/main/resources
│       hibernate.cfg.xml
│
└── pom.xml
```

---

## CRUD Operations Implemented

### 1. Insert Product

Adds new product records into the database.

### 2. Retrieve Product

Fetches a product using its ID.

### 3. Update Product

Updates product price or quantity.

### 4. Delete Product

Removes discontinued products from the database.

---

## How to Run the Project

1. Clone the repository
2. Open the project in **Eclipse IDE**
3. Update Maven dependencies
4. Run `MainApp.java`

Hibernate will automatically create the required tables and perform CRUD operations.

---

## Output

The console will display Hibernate SQL queries and operation messages such as:

```
Products Inserted
Product Name: Laptop
Price Updated
Product Deleted
```

---

## Conclusion

This experiment demonstrates how Hibernate simplifies database operations using **Object Relational Mapping (ORM)**.
CRUD operations were successfully implemented using Hibernate and JPA annotations.

---
