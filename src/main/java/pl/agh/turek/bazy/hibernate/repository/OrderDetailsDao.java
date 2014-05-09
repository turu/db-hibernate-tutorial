package pl.agh.turek.bazy.hibernate.repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.agh.turek.bazy.hibernate.model.OrderDetailsEntity;

@Repository
public class OrderDetailsDao extends GenericDao<OrderDetailsEntity, Long> {
    @Autowired
    public OrderDetailsDao(SessionFactory sessionFactory) {
        super(sessionFactory, OrderDetailsEntity.class);
    }
}
