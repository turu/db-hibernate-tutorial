package pl.agh.turek.bazy.hibernate.repository;

import org.springframework.stereotype.Repository;
import pl.agh.turek.bazy.hibernate.model.OrderDetailsEntity;

@Repository
public class OrderDetailsDao extends GenericDao<OrderDetailsEntity, Long> {
    public OrderDetailsDao() {
        setType(OrderDetailsEntity.class);
    }
}
