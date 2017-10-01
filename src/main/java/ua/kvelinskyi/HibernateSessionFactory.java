package ua.kvelinskyi;

import org.hibernate.SessionFactory;
import javax.persistence.Persistence;

public class HibernateSessionFactory {
    private static SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        SessionFactory sessionFactory = (SessionFactory)
                Persistence.createEntityManagerFactory
                        ("org.hibernate.tutorial.jpa");
        return sessionFactory;
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        // Close caches and connection pools
        getSessionFactory().close();
    }
}
