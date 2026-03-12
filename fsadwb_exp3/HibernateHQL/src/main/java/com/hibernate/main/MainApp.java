package com.hibernate.main;

import com.hibernate.entity.Product;
import com.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.List;

public class MainApp {

    public static void main(String[] args) {

        insertProducts();

        System.out.println("\n===== TASK 3a: Price Ascending =====");
        Session s1 = HibernateUtil.getSessionFactory().openSession();
        List<Product> list1 = s1.createQuery("FROM Product ORDER BY price ASC", Product.class).list();
        for (Product p : list1) { System.out.println(p); }
        s1.close();

        System.out.println("\n===== TASK 3b: Price Descending =====");
        Session s2 = HibernateUtil.getSessionFactory().openSession();
        List<Product> list2 = s2.createQuery("FROM Product ORDER BY price DESC", Product.class).list();
        for (Product p : list2) { System.out.println(p); }
        s2.close();

        System.out.println("\n===== TASK 4: Quantity Highest First =====");
        Session s3 = HibernateUtil.getSessionFactory().openSession();
        List<Product> list3 = s3.createQuery("FROM Product ORDER BY quantity DESC", Product.class).list();
        for (Product p : list3) { System.out.println(p); }
        s3.close();

        System.out.println("\n===== TASK 5a: First 3 Products =====");
        Session s4 = HibernateUtil.getSessionFactory().openSession();
        Query<Product> q5a = s4.createQuery("FROM Product ORDER BY id ASC", Product.class);
        q5a.setFirstResult(0);
        q5a.setMaxResults(3);
        for (Product p : q5a.list()) { System.out.println(p); }
        s4.close();

        System.out.println("\n===== TASK 5b: Next 3 Products =====");
        Session s5 = HibernateUtil.getSessionFactory().openSession();
        Query<Product> q5b = s5.createQuery("FROM Product ORDER BY id ASC", Product.class);
        q5b.setFirstResult(3);
        q5b.setMaxResults(3);
        for (Product p : q5b.list()) { System.out.println(p); }
        s5.close();

        System.out.println("\n===== TASK 6a: Total Products =====");
        Session s6 = HibernateUtil.getSessionFactory().openSession();
        Long count1 = (Long) s6.createQuery("SELECT COUNT(p) FROM Product p").uniqueResult();
        System.out.println("Total Products: " + count1);
        s6.close();

        System.out.println("\n===== TASK 6b: Products with Quantity > 0 =====");
        Session s7 = HibernateUtil.getSessionFactory().openSession();
        Long count2 = (Long) s7.createQuery("SELECT COUNT(p) FROM Product p WHERE p.quantity > 0").uniqueResult();
        System.out.println("In-Stock Products: " + count2);
        s7.close();

        System.out.println("\n===== TASK 6c: Count Grouped by Description =====");
        Session s8 = HibernateUtil.getSessionFactory().openSession();
        List<Object[]> list6c = s8.createQuery(
            "SELECT p.description, COUNT(p) FROM Product p GROUP BY p.description").list();
        for (Object[] row : list6c) {
            System.out.println("Description: " + row[0] + " | Count: " + row[1]);
        }
        s8.close();

        System.out.println("\n===== TASK 6d: Min and Max Price =====");
        Session s9 = HibernateUtil.getSessionFactory().openSession();
        Object[] minmax = (Object[]) s9.createQuery(
            "SELECT MIN(p.price), MAX(p.price) FROM Product p").uniqueResult();
        System.out.println("Min Price: " + minmax[0]);
        System.out.println("Max Price: " + minmax[1]);
        s9.close();

        System.out.println("\n===== TASK 7: Group By Description =====");
        Session s10 = HibernateUtil.getSessionFactory().openSession();
        List<Object[]> list7 = s10.createQuery(
            "SELECT p.description, COUNT(p), AVG(p.price) FROM Product p GROUP BY p.description").list();
        for (Object[] row : list7) {
            System.out.println("Description: " + row[0] + " | Count: " + row[1] + " | Avg Price: " + row[2]);
        }
        s10.close();

        System.out.println("\n===== TASK 8: Price Between 500 and 2000 =====");
        Session s11 = HibernateUtil.getSessionFactory().openSession();
        Query<Product> q8 = s11.createQuery(
            "FROM Product p WHERE p.price BETWEEN :min AND :max", Product.class);
        q8.setParameter("min", 500.0);
        q8.setParameter("max", 2000.0);
        for (Product p : q8.list()) { System.out.println(p); }
        s11.close();

        System.out.println("\n===== TASK 9a: Names Starting with L =====");
        Session s12 = HibernateUtil.getSessionFactory().openSession();
        Query<Product> q9a = s12.createQuery(
            "FROM Product p WHERE p.name LIKE :pattern", Product.class);
        q9a.setParameter("pattern", "L%");
        for (Product p : q9a.list()) { System.out.println(p); }
        s12.close();

        System.out.println("\n===== TASK 9b: Names Ending with e =====");
        Session s13 = HibernateUtil.getSessionFactory().openSession();
        Query<Product> q9b = s13.createQuery(
            "FROM Product p WHERE p.name LIKE :pattern", Product.class);
        q9b.setParameter("pattern", "%e");
        for (Product p : q9b.list()) { System.out.println(p); }
        s13.close();

        System.out.println("\n===== TASK 9c: Names Containing on =====");
        Session s14 = HibernateUtil.getSessionFactory().openSession();
        Query<Product> q9c = s14.createQuery(
            "FROM Product p WHERE p.name LIKE :pattern", Product.class);
        q9c.setParameter("pattern", "%on%");
        for (Product p : q9c.list()) { System.out.println(p); }
        s14.close();

        System.out.println("\n===== TASK 9d: Names with Exactly 6 Characters =====");
        Session s15 = HibernateUtil.getSessionFactory().openSession();
        Query<Product> q9d = s15.createQuery(
            "FROM Product p WHERE p.name LIKE :pattern", Product.class);
        q9d.setParameter("pattern", "______");
        for (Product p : q9d.list()) { System.out.println(p); }
        s15.close();

        HibernateUtil.shutdown();
        System.out.println("\n===== All Tasks Completed Successfully =====");
    }

    private static void insertProducts() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.save(new Product("Laptop",      "Electronics", 1200.00, 10));
        session.save(new Product("Phone",       "Electronics", 800.00,  25));
        session.save(new Product("Headphone",   "Electronics", 150.00,  50));
        session.save(new Product("Keyboard",    "Accessories", 75.00,   30));
        session.save(new Product("Mouse",       "Accessories", 45.00,   0));
        session.save(new Product("Monitor",     "Electronics", 350.00,  15));
        session.save(new Product("LaptopStand", "Accessories", 60.00,   20));
        session.save(new Product("Webcam",      "Electronics", 120.00,  0));

        tx.commit();
        session.close();
        System.out.println("===== Products Inserted Successfully =====");
    }
}