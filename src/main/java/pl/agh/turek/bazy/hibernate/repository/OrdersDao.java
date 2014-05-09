package pl.agh.turek.bazy.hibernate.repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.agh.turek.bazy.hibernate.model.OrdersEntity;

@Repository
public class OrdersDao extends GenericDao<OrdersEntity,Long>{
    @Autowired
    public OrdersDao(SessionFactory sessionFactory) {
        super(sessionFactory, OrdersEntity.class);
    }
}
