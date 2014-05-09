package pl.agh.turek.bazy.hibernate.runners;

import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pl.agh.turek.bazy.hibernate.model.OrderDetailsEntity;
import pl.agh.turek.bazy.hibernate.model.OrdersEntity;
import pl.agh.turek.bazy.hibernate.model.ProductsEntity;
import pl.agh.turek.bazy.hibernate.repository.OrderDetailsDao;
import pl.agh.turek.bazy.hibernate.repository.OrdersDao;
import pl.agh.turek.bazy.hibernate.util.OrdersEntityFactory;
import pl.agh.turek.bazy.hibernate.util.RandomObjectFetcher;

public class NoTransactionRunner {
    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(SpringConfigRunner.class);

    public static void main(String[] args) {
        new NoTransactionRunner().run();
    }

    private void run() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
                "META-INF/applicationContext.xml");

        OrdersDao ordersDao = (OrdersDao) ctx.getBean("ordersDao");
        OrderDetailsDao orderDetailsDao = (OrderDetailsDao) ctx.getBean("orderDetailsDao");
        OrdersEntityFactory ordersEntityFactory = (
                OrdersEntityFactory) ctx.getBean("ordersEntityFactory");

        OrdersEntity randomOrder = ordersEntityFactory.createRandomOrder();
        ordersDao.create(randomOrder);

        OrderDetailsEntity detailsEntity = new OrderDetailsEntity();
        detailsEntity.setOrderid(randomOrder.getOrderid());
        setOtherOrderDeatilsFields(orderDetailsDao, detailsEntity);
        orderDetailsDao.create(detailsEntity);//what happens when if fails?
    }

    private void setOtherOrderDeatilsFields(OrderDetailsDao orderDetailsDao, OrderDetailsEntity detailsEntity) {
        ProductsEntity product = (ProductsEntity) RandomObjectFetcher.get(ProductsEntity.class, orderDetailsDao.getSession());
        detailsEntity.setProductid(product.getProductid());
        detailsEntity.setDiscount(.05);
        detailsEntity.setQuantity(100);
        detailsEntity.setUnitprice(56.);
    }


}
