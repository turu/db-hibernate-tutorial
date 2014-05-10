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

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NoTransactionIsolationViolationRunner {
    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(SpringConfigRunner.class);
    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    public static void main(String[] args) throws InterruptedException {
        new NoTransactionIsolationViolationRunner().run();
    }

    private void run() throws InterruptedException {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("META-INF/applicationContext.xml");
        final OrdersDao ordersDao = (OrdersDao) ctx.getBean("ordersDao");
        final OrderDetailsDao orderDetailsDao = (OrderDetailsDao) ctx.getBean("orderDetailsDao");
        OrdersEntityFactory ordersEntityFactory = (
                OrdersEntityFactory) ctx.getBean("ordersEntityFactory");


        executor.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.currentThread().sleep(4000);
                    printTotalValueStatistic(orderDetailsDao,ordersDao);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        printTotalValueStatistic(orderDetailsDao, ordersDao);
        OrdersEntity randomOrder = ordersEntityFactory.createRandomOrder();
        ordersDao.create(randomOrder);
        Thread.currentThread().sleep(6000);//simulating time window
        OrderDetailsEntity detailsEntity = new OrderDetailsEntity();
        detailsEntity.setOrderid(randomOrder.getOrderid());
        setOtherOrderDeatilsFields(orderDetailsDao, detailsEntity);
        orderDetailsDao.create(detailsEntity);
        printTotalValueStatistic(orderDetailsDao,ordersDao);
    }

    private void printTotalValueStatistic(OrderDetailsDao orderDetailsDao, OrdersDao ordersDao) {
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
