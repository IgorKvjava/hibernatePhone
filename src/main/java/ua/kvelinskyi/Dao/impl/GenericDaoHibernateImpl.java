package ua.kvelinskyi.Dao.impl;

import org.hibernate.SessionFactory;
import ua.kvelinskyi.Dao.interfaces.GenericDao;
import ua.kvelinskyi.HibernateSessionFactory;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.List;


public class GenericDaoHibernateImpl <T, PK extends Serializable>
        implements GenericDao<T, PK> {
       // private SessionFactory sessionFactory;
        private EntityManager entityManager;
        private CriteriaBuilder criteriaBuilder;
        private Class anyClass;

    public GenericDaoHibernateImpl(Class anyClass) {
        this.anyClass = anyClass;
        //this.sessionFactory = HibernateSessionFactory.getInstance().getSessionFactory();
        entityManager = HibernateSessionFactory.getInstance().getEntityManager();
        criteriaBuilder = entityManager.getCriteriaBuilder();
    }


    public void CloseEntitymanager(){
        entityManager.close();
    }

    @Override
    public PK create(T newInstance) {
        entityManager.getTransaction().begin();
        entityManager.persist(newInstance);
        entityManager.getTransaction().commit();
        return null;
    }

    @Override
    public T read(PK id) {
        return null;
    }

    @Override
    public void update(T transientObject) {
        entityManager.getTransaction().begin();
        entityManager.merge(transientObject);
        entityManager.getTransaction().commit();

    }

    @Override
    public void delete(T persistentObject) {
        entityManager.getTransaction().begin();
        entityManager.remove(persistentObject);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<T> getAll() {
        CriteriaQuery<T> criteriaQuery =criteriaBuilder.createQuery(anyClass);
        Root<T> root = criteriaQuery.from(anyClass);
        TypedQuery<T> typedQuery =
                entityManager.createQuery(criteriaQuery);
        List<T> resultList =   typedQuery.getResultList();
        return resultList;
    }
}
