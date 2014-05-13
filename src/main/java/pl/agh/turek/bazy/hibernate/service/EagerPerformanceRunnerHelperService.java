package pl.agh.turek.bazy.hibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.agh.turek.bazy.hibernate.model.OrderDetailsEntity;
import pl.agh.turek.bazy.hibernate.model.OrdersEntity;
import pl.agh.turek.bazy.hibernate.model.ProductsEntity;
import pl.agh.turek.bazy.hibernate.repository.OrderDetailsDao;
import pl.agh.turek.bazy.hibernate.repository.OrdersDao;
import pl.agh.turek.bazy.hibernate.repository.ProductsDao;

import java.util.Collection;
import java.util.LinkedList;

@Service
public class EagerPerformanceRunnerHelperService {
    @Autowired
    private OrderDetailsDao orderDetailsDao;

    @Autowired
    private OrdersDao ordersDao;

    @Transactional
    public void createOrderDetailsFromOrderEntity(OrdersEntity ordersEntity) {
        for (OrderDetailsEntity orderDetailsEntity : ordersEntity.getOrderDetailsesByOrderid()) {
            orderDetailsDao.create(orderDetailsEntity);
        }
    }

    @Transactional
    public Collection<ProductsEntity> generateProducts(ProductsDao productsDao, long count) {
        LinkedList<ProductsEntity> list = new LinkedList<ProductsEntity>();
        for (long i = 0;i<count;i++) {
            ProductsEntity product = new ProductsEntity();
            product.setProductname("TEST");
            product.setUnitprice(.2);
            productsDao.create(product);
            list.add(product);
        }
        return list;
    }

}
