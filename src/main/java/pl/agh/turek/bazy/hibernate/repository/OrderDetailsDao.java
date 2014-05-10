package pl.agh.turek.bazy.hibernate.repository;

import org.springframework.stereotype.Repository;
import pl.agh.turek.bazy.hibernate.model.OrderDetailsEntity;
import pl.agh.turek.bazy.hibernate.model.OrderDetailsEntityPK;

@Repository
public class OrderDetailsDao extends GenericDao<OrderDetailsEntity, OrderDetailsEntityPK> {
    public OrderDetailsDao() {
        setType(OrderDetailsEntity.class);
    }
}
