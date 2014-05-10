package pl.agh.turek.bazy.hibernate.runners;

import org.hibernate.SessionFactory;
import org.slf4j.LoggerFactory;
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

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class PropagationLevelsRunner {
    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(SpringConfigRunner.class);
    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("META-INF/applicationContext.xml");
        SessionFactory sessionFactory = (SessionFactory) ctx.getBean("sessionFactory");
        sessionFactory.openSession();//todo is really needed?
        ((PropagationLevelsRunner) ctx.getBean("propagationLevelsRunner")).run();
    }

    private void run() throws InterruptedException {
        addNewOrder();
    }

    @Transactional
    public void addNewOrder() throws InterruptedException {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("META-INF/applicationContext.xml");
        final OrdersDao ordersDao = (OrdersDao) ctx.getBean("ordersDao");
        final OrderDetailsDao orderDetailsDao = (OrderDetailsDao) ctx.getBean("orderDetailsDao");
        OrdersEntityFactory ordersEntityFactory = (OrdersEntityFactory) ctx.getBean("ordersEntityFactory");

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


}
