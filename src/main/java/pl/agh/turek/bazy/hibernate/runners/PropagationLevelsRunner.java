package pl.agh.turek.bazy.hibernate.runners;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pl.agh.turek.bazy.hibernate.model.OrderDetailsEntity;
import pl.agh.turek.bazy.hibernate.model.OrdersEntity;
import pl.agh.turek.bazy.hibernate.model.ProductsEntity;
import pl.agh.turek.bazy.hibernate.repository.OrderDetailsDao;
import pl.agh.turek.bazy.hibernate.repository.OrdersDao;
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

    private void run() throws InterruptedException {
        addNewOrder();
    }

    @Transactional
    public void addNewOrder() throws InterruptedException {

        printTotalValueStatistic(orderDetailsDao, ordersDao);//before
        OrdersEntity randomOrder = ordersEntityFactory.createRandomOrder();
        ordersDao.create(randomOrder);
        printTotalValueStatistic(orderDetailsDao, ordersDao);//during
        OrderDetailsEntity detailsEntity = new OrderDetailsEntity();
        detailsEntity.setOrderid(randomOrder.getOrderid());
        setOtherOrderDeatilsFields(orderDetailsDao, detailsEntity);
        orderDetailsDao.create(detailsEntity);
        printTotalValueStatistic(orderDetailsDao, ordersDao);//after
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void printTotalValueStatistic(OrderDetailsDao orderDetailsDao, OrdersDao ordersDao) {
        double total = 0.;
        for (OrderDetailsEntity detail : orderDetailsDao.getAll()) {
            total += detail.getQuantity() * detail.getUnitprice();
        }
        System.out.println("Total value of " + total + " is in " + ordersDao.getAll().size() + " orders");
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
        ((PropagationLevelsRunner) ctx.getBean("propagationLevelsRunner")).run();
    }


}
