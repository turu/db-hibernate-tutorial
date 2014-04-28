package pl.agh.turek.bazy.hibernate.repository;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.proxy.HibernateProxy;

import java.io.Serializable;
import java.util.List;

public class GenericDao<T, PK extends Serializable> implements Dao<T, PK> {

    private Class<T> type;
    private SessionFactory sessionFactory;

    public GenericDao(SessionFactory sessionFactory, Class<T> type) {
        this.sessionFactory = sessionFactory;
        this.type = type;
    }

    public PK create(T o) {
        Session session = getSession();
        Serializable pk = session.save(o);
        session.flush();
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
            return sessionFactory.openSession();
        }
    }
}