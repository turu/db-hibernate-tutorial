package pl.agh.turek.bazy.hibernate.repository;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.io.Serializable;
import java.util.List;

public class GenericDao<T, PK extends Serializable> extends HibernateDaoSupport implements Dao<T, PK> {

    private Class<T> type;

    public GenericDao(SessionFactory sessionFactory, Class<T> type) {
        super.setSessionFactory(sessionFactory);
        this.type = type;
    }

    public PK create(T o) {
        return (PK) getSession().save(o);
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
        getSession().update(o);
    }

    public void delete(T o) {
        getSession().delete(o);
    }

}