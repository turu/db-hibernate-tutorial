package pl.agh.turek.bazy.hibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pl.agh.turek.bazy.hibernate.model.OrderDetailsEntity;
import pl.agh.turek.bazy.hibernate.repository.OrderDetailsDao;
import pl.agh.turek.bazy.hibernate.repository.OrdersDao;

/**
 * Author: Piotr Turek
 */
@Service
public class OrdersValueService {
    @Autowired
    private OrderDetailsDao orderDetailsDao;

    @Autowired
    private OrdersDao ordersDao;

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE)
    public void printTotalValueStatistic() {
        double total = 0.;
        for (OrderDetailsEntity detail : this.orderDetailsDao.getAll()) {
            total += detail.getQuantity() * detail.getUnitprice();
        }
        System.out.println("Total value of " + total + " is in " + this.ordersDao.getAll().size() + " orders");
    }

}
