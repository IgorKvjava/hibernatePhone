package ua.kvelinskyi;

import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class HibernateSessionFactory1 {
    private static SessionFactory sessionFactory = buildSessionFactory();
    private static EntityManager entityManager;

    private static SessionFactory buildSessionFactory() {
        SessionFactory sessionFactory = (SessionFactory)
                Persistence.createEntityManagerFactory
                        ("org.hibernate.tutorial.jpa");
        entityManager = sessionFactory.createEntityManager();
        return sessionFactory;
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    // Close caches and connection pools
    public static void shutdown() {
        getSessionFactory().close();
    }

    public static  EntityManager getEntityManager() {

        return entityManager;
    }
}
