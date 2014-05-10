package pl.agh.turek.bazy.hibernate.repository;

import org.springframework.stereotype.Repository;
import pl.agh.turek.bazy.hibernate.model.OrdersEntity;

@Repository
public class OrdersDao extends GenericDao<OrdersEntity,Long>{
    public OrdersDao() {
        setType(OrdersEntity.class);
    }
}
