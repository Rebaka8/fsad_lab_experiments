# Hibernate HQL Lab - Advanced Data Retrieval

**Name:** Rebaka Meda  
**ID Number:** 2400032563  

---

## Project Overview

This project demonstrates advanced data retrieval using Hibernate Query Language (HQL).
It covers sorting, pagination, filtering, and aggregate functions using the Hibernate ORM 
framework with an H2 in-memory database.

---

## Technology Stack

- Java 11
- Hibernate ORM 5.6.15.Final
- H2 In-Memory Database 2.2.224
- Maven
- Eclipse IDE

---

## Project Structure
```
HibernateHQL/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/hibernate/
│       │       ├── entity/     → Product.java
│       │       ├── util/       → HibernateUtil.java
│       │       └── main/       → MainApp.java
│       └── resources/
│           └── hibernate.properties
└── pom.xml
```

---

## Tasks Implemented

### Task 1 - Product Entity
- Created a `Product` entity with fields: id, name, description, price, quantity

### Task 2 - Insert Records
- Inserted 8 product records into the database

### Task 3 - Sorting by Price
- **3a:** Retrieved all products sorted by price in ascending order
- **3b:** Retrieved all products sorted by price in descending order

### Task 4 - Sorting by Quantity
- Retrieved all products sorted by quantity in descending order (highest first)

### Task 5 - Pagination
- **5a:** Retrieved first 3 products using `setFirstResult(0)` and `setMaxResults(3)`
- **5b:** Retrieved next 3 products using `setFirstResult(3)` and `setMaxResults(3)`

### Task 6 - Aggregate Functions
- **6a:** Counted total number of products → Result: 8
- **6b:** Counted products where quantity > 0 → Result: 6
- **6c:** Counted products grouped by description
- **6d:** Found minimum price (45.0) and maximum price (1200.0)

### Task 7 - GROUP BY
- Grouped products by description with count and average price

### Task 8 - WHERE Filter
- Filtered products with price between 500 and 2000

### Task 9 - LIKE Queries
- **9a:** Names starting with 'L' → Laptop, LaptopStand
- **9b:** Names ending with 'e' → Phone, Headphone, Mouse
- **9c:** Names containing 'on' → Phone, Headphone, Monitor
- **9d:** Names with exactly 6 characters → Laptop, Webcam

---

## Sample Output
```
===== Products Inserted Successfully =====

===== TASK 3a: Price Ascending =====
Product [id=5, name=Mouse, description=Accessories, price=45.0, quantity=0]
Product [id=7, name=LaptopStand, description=Accessories, price=60.0, quantity=20]
Product [id=4, name=Keyboard, description=Accessories, price=75.0, quantity=30]
...

===== TASK 6a: Total Products =====
Total Products: 8

===== TASK 6d: Min and Max Price =====
Min Price: 45.0
Max Price: 1200.0

===== All Tasks Completed Successfully =====
```

---

## How to Run

1. Clone the repository:
```
   git clone https://github.com/yourusername/HibernateHQL.git
```
2. Open in **Eclipse IDE**
3. Right-click project → **Maven → Update Project**
4. Right-click `MainApp.java` → **Run As → Java Application**
5. View output in the **Console tab**

---

## HQL Queries Used

| Task | HQL Query |
|------|-----------|
| Sort by price ASC | `FROM Product ORDER BY price ASC` |
| Sort by price DESC | `FROM Product ORDER BY price DESC` |
| Sort by quantity | `FROM Product ORDER BY quantity DESC` |
| Count all | `SELECT COUNT(p) FROM Product p` |
| Count in stock | `SELECT COUNT(p) FROM Product p WHERE p.quantity > 0` |
| Min/Max price | `SELECT MIN(p.price), MAX(p.price) FROM Product p` |
| Group by | `SELECT p.description, COUNT(p) FROM Product p GROUP BY p.description` |
| Price range | `FROM Product p WHERE p.price BETWEEN :min AND :max` |
| LIKE pattern | `FROM Product p WHERE p.name LIKE :pattern` |

---

## Database

This project uses **H2 In-Memory Database** — no installation required.
The database is automatically created when the application starts and 
dropped when it shuts down.