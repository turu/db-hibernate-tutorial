package pl.agh.turek.bazy.hibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.agh.turek.bazy.hibernate.model.OrderDetailsEntity;
import pl.agh.turek.bazy.hibernate.model.OrderDetailsEntityPK;
import pl.agh.turek.bazy.hibernate.model.ProductsEntity;
import pl.agh.turek.bazy.hibernate.repository.OrderDetailsDao;
import pl.agh.turek.bazy.hibernate.repository.ProductsDao;

import java.util.Collection;

/**
 * Author: Piotr Turek
 */
@Service
public class CascadeTypeService {
    @Autowired
    private ProductsDao productsDao;

    @Autowired
    private OrderDetailsDao orderDetailsDao;

    @Transactional
    public OrderDetailsEntityPK modifyFirstOrderDetailsDiscount(ProductsEntity product) {
        System.out.println("Updating discount of first order detail of product id: " + product.getProductid());
        final Collection<OrderDetailsEntity> orderDetails = product.getOrderDetailsesByProductid();
        final OrderDetailsEntity firstOrderDetail = orderDetails.iterator().next();
        final OrderDetailsEntityPK pk = getOrdersPK(firstOrderDetail);
        final double discount = firstOrderDetail.getDiscount();
        System.out.println("Will try to fetch order detail id:" + pk + " with discount "
                + discount);
        firstOrderDetail.setDiscount(discount + 0.1);
        System.out.println("New discount set to: " + firstOrderDetail.getDiscount());
        productsDao.update(product);
        return pk;
    }

    @Transactional
    public void verifyOrderDetailsDiscount(OrderDetailsEntityPK pk) {
        final OrderDetailsEntity refetchedOrderDetail = orderDetailsDao.get(pk);
        System.out.println("Order details id " + pk + " has discount " + refetchedOrderDetail.getDiscount());
    }

    private OrderDetailsEntityPK getOrdersPK(OrderDetailsEntity orderDetail) {
        final long orderid = orderDetail.getOrderid();
        final long productid = orderDetail.getProductid();
        final OrderDetailsEntityPK pk = new OrderDetailsEntityPK();
        pk.setOrderid(orderid);
        pk.setProductid(productid);
        return pk;
    }
}
