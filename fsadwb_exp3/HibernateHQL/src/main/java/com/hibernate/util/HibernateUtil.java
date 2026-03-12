package com.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.hibernate.entity.Product;
import java.util.Properties;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    static {
        try {
            Properties props = new Properties();
            props.load(HibernateUtil.class
                .getClassLoader()
                .getResourceAsStream("hibernate.properties"));

            Configuration config = new Configuration();
            config.addProperties(props);
            config.addAnnotatedClass(Product.class);

            sessionFactory = config.buildSessionFactory();

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error creating SessionFactory: " + e.getMessage());
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        if (sessionFactory != null) sessionFactory.close();
    }
}