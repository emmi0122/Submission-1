package se.yrgo.test;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import se.yrgo.domain.Category;
import se.yrgo.domain.Product;

public class hibernateTest {

    private static SessionFactory sessionFactory = null;

    public static void main(String[] args) {

        SessionFactory sf = getSessionFactory();
        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();

        /* Category hairCare = new Category("Hair Care");
        Product p1 = new Product(1234, "Schampoo", "Maria Nila", 570);
        Product p2 = new Product(1235, "Conditioner", "Maria Nila", 530);
        Product p3 = new Product(1236, "Heat Spray", "Maria Nila", 309);

        hairCare.addProductsToList(p1);
        hairCare.addProductsToList(p2);
        hairCare.addProductsToList(p3);

        session.save(hairCare);
        session.save(p1);
        session.save(p2);
        session.save(p3); */

        Category getCategory = (Category)session.get(Category.class, 1);
        List<Product> productList = getCategory.getProducts();

        for (Product p : productList) {
            System.out.println(p);
        }

        tx.commit();
        session.close();
    }

    private static SessionFactory getSessionFactory() {
        if(sessionFactory == null) {
            Configuration configuration = new Configuration();
            configuration.configure();
            sessionFactory = configuration.buildSessionFactory();
        }
        return sessionFactory;
    }
}