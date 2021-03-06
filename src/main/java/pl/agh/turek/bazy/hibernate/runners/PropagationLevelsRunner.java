package pl.agh.turek.bazy.hibernate.runners;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.agh.turek.bazy.hibernate.model.OrderDetailsEntity;
import pl.agh.turek.bazy.hibernate.model.OrdersEntity;
import pl.agh.turek.bazy.hibernate.model.ProductsEntity;
import pl.agh.turek.bazy.hibernate.repository.OrderDetailsDao;
import pl.agh.turek.bazy.hibernate.repository.OrdersDao;
import pl.agh.turek.bazy.hibernate.service.OrdersValueService;
import pl.agh.turek.bazy.hibernate.util.OrdersEntityFactory;
import pl.agh.turek.bazy.hibernate.util.RandomObjectFetcher;

@Component
public class PropagationLevelsRunner {
    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(SpringConfigRunner.class);

    @Autowired
    private OrderDetailsDao orderDetailsDao;

    @Autowired
    private OrdersDao ordersDao;

    @Autowired
    private OrdersEntityFactory ordersEntityFactory;

    @Autowired
    private OrdersValueService ordersValueService;

    @Transactional
    public void addNewOrder() throws InterruptedException {
        ordersValueService.printTotalValueStatistic(); //before
        OrdersEntity randomOrder = ordersEntityFactory.createRandomOrder();
        ordersDao.create(randomOrder);
        ordersValueService.printTotalValueStatistic(); //during
        OrderDetailsEntity detailsEntity = new OrderDetailsEntity();
        detailsEntity.setOrderid(randomOrder.getOrderid());
        setOtherOrderDeatilsFields(orderDetailsDao, detailsEntity);
        orderDetailsDao.create(detailsEntity);
    }

    private void setOtherOrderDeatilsFields(OrderDetailsDao orderDetailsDao, OrderDetailsEntity detailsEntity) {
        ProductsEntity product = (ProductsEntity) RandomObjectFetcher.get(ProductsEntity.class, orderDetailsDao.getSession());
        detailsEntity.setProductid(product.getProductid());
        detailsEntity.setDiscount(.05);
        detailsEntity.setQuantity(1000000);
        detailsEntity.setUnitprice(5600000.);
    }

    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("META-INF/applicationContext.xml");
        ((OrdersValueService)ctx.getBean("ordersValueService")).printTotalValueStatistic(); //before
        ((PropagationLevelsRunner) ctx.getBean("propagationLevelsRunner")).addNewOrder();
        ((OrdersValueService)ctx.getBean("ordersValueService")).printTotalValueStatistic(); //after
    }


}
