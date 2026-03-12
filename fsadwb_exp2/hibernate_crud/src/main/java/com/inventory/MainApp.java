package com.inventory;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class MainApp {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        // INSERT
        Product p1 = new Product("Laptop","Dell Laptop",60000,10);
        Product p2 = new Product("Mouse","Wireless Mouse",500,50);

        session.save(p1);
        session.save(p2);

        System.out.println("Products Inserted");

        // READ
        Product product = session.get(Product.class,1);
        System.out.println("Product Name: " + product.getName());

        // UPDATE
        product.setPrice(55000);
        session.update(product);

        System.out.println("Price Updated");

        // DELETE
        Product deleteProduct = session.get(Product.class,2);
        session.delete(deleteProduct);

        System.out.println("Product Deleted");

        tx.commit();
        session.close();
    }
}