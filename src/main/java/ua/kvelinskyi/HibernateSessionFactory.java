package ua.kvelinskyi;

import org.hibernate.SessionFactory;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class HibernateSessionFactory {
    private static HibernateSessionFactory instance = new HibernateSessionFactory();
    private SessionFactory sessionFactory;
    private EntityManager entityManager;

    public static HibernateSessionFactory getInstance() {
        return instance;
    }

    private HibernateSessionFactory() {
        sessionFactory = (SessionFactory)
                Persistence.createEntityManagerFactory
                        ("org.hibernate.tutorial.jpa");
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void createEntityManager(){
        entityManager = sessionFactory.createEntityManager();
    }

    public void endEntityManager(){
        entityManager.close();
    }

    public void endSessionFactory(){
        sessionFactory.close();
    }
}
