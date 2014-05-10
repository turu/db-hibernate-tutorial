package pl.agh.turek.bazy.hibernate.repository;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public class GenericDao<T, PK extends Serializable> implements Dao<T, PK> {

    private Class<T> type;

    private SessionFactory sessionFactory;

    public GenericDao() {
    }

    public GenericDao(SessionFactory sessionFactory, Class<T> type) {
        this.sessionFactory = sessionFactory;
        this.type = type;
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void setType(Class<T> type) {
        this.type = type;
    }


    public PK create(T o) {
        Session session = getSession();
        Serializable pk = session.save(o);
        return (PK) pk;
    }

    public T get(PK id) {
        T value = (T) getSession().get(type, id);
        if (value != null && value instanceof HibernateProxy) {
            Hibernate.initialize(value);
            value = (T) ((HibernateProxy) value).getHibernateLazyInitializer().getImplementation();
        }
        return value;
    }

    public List<T> getAll() {
        return getSession().createCriteria(type).list();
    }


    public void update(T o) {
        Session session = getSession();
        session.update(o);
        session.flush();
    }

    public void delete(T o) {
        Session session = getSession();
        session.delete(o);
        session.flush();
    }

    public Session getSession() {
        try {
            return sessionFactory.getCurrentSession();
        }catch (HibernateException e){
            System.out.println("!!!!!!!!! Couldn't find existing session for thread. Creating new one !!!!!!!!!");
            return sessionFactory.openSession();
        }
    }
}
