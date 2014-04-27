package pl.agh.turek.bazy.hibernate.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Author: Piotr Turek
 */
@Component
public class DaoSeedExample {
    private final SessionFactory sessionFactory;

    @Autowired
    public DaoSeedExample(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void useSessionFactory() {
        final Session session = sessionFactory.openSession();
        //use session to manipulate data in database
        //...
    }
}
