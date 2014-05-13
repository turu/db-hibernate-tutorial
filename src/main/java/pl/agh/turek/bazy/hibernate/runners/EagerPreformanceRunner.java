package pl.agh.turek.bazy.hibernate.runners;

import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pl.agh.turek.bazy.hibernate.model.OrderDetailsEntity;
import pl.agh.turek.bazy.hibernate.model.OrdersEntity;
import pl.agh.turek.bazy.hibernate.model.ProductsEntity;
import pl.agh.turek.bazy.hibernate.repository.OrderDetailsDao;
import pl.agh.turek.bazy.hibernate.repository.OrdersDao;
import pl.agh.turek.bazy.hibernate.repository.ProductsDao;
import pl.agh.turek.bazy.hibernate.service.EagerPerformanceRunnerHelperService;
import pl.agh.turek.bazy.hibernate.util.OrdersEntityFactory;

import java.util.Collection;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EagerPreformanceRunner {
    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(SpringConfigRunner.class);
    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    public static void main(String[] args) throws InterruptedException {
        new EagerPreformanceRunner().run();
    }

    private void run() throws InterruptedException {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("META-INF/applicationContext.xml");
        final OrdersDao ordersDao = (OrdersDao) ctx.getBean("ordersDao");
        final ProductsDao productsDao = (ProductsDao) ctx.getBean("productsDao");
        final OrderDetailsDao orderDetailsDao = (OrderDetailsDao) ctx.getBean("orderDetailsDao");
        OrdersEntityFactory ordersEntityFactory = (OrdersEntityFactory) ctx.getBean("ordersEntityFactory");
        EagerPerformanceRunnerHelperService service = (EagerPerformanceRunnerHelperService) ctx.getBean("eagerPerformanceRunnerHelperService");

        Collection<ProductsEntity> products = service.generateProducts(productsDao, 10000);
        OrdersEntity randomOrder = prepareOrdersEntityWithOrderDetails(ordersDao, products, ordersEntityFactory);
        service.createOrderDetailsFromOrderEntity(randomOrder);
        long time = System.nanoTime();
        System.out.println(ordersDao.get(randomOrder.getOrderid()).getOrderdate());
        System.out.println("Elapsed " + (System.nanoTime() - time) + "ns");
    }

    private OrdersEntity prepareOrdersEntityWithOrderDetails(OrdersDao ordersDao, Collection<ProductsEntity> products, OrdersEntityFactory ordersEntityFactory) {
        OrdersEntity randomOrder = ordersEntityFactory.createRandomOrder();
        ordersDao.create(randomOrder);
        LinkedList<OrderDetailsEntity> details = new LinkedList<OrderDetailsEntity>();
        for (ProductsEntity product : products) {
            OrderDetailsEntity detailsEntity = new OrderDetailsEntity();
            detailsEntity.setOrderid(randomOrder.getOrderid());
            setOtherOrderDeatilsFields(detailsEntity, product);
            details.add(detailsEntity);
        }
        randomOrder.setOrderDetailsesByOrderid(details);
        return randomOrder;
    }


    private void setOtherOrderDeatilsFields(OrderDetailsEntity detailsEntity, ProductsEntity product) {
        detailsEntity.setProductid(product.getProductid());
        detailsEntity.setDiscount(.05);
        detailsEntity.setQuantity(1);
        detailsEntity.setUnitprice(product.getUnitprice());
    }


}
