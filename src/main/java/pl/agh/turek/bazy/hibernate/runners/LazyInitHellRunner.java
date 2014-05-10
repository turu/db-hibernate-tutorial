package pl.agh.turek.bazy.hibernate.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import pl.agh.turek.bazy.hibernate.model.OrderDetailsEntity;
import pl.agh.turek.bazy.hibernate.model.ProductsEntity;
import pl.agh.turek.bazy.hibernate.service.LazyInitHellService;

import java.util.Collection;

/**
 * Author: Piotr Turek
 */
@Component
public class LazyInitHellRunner {
    @Autowired
    private LazyInitHellService lazyInitHellService;

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("META-INF/applicationContext.xml");
        ((LazyInitHellRunner) ctx.getBean("lazyInitHellRunner")).run();
    }

    private void run() {
        final ProductsEntity product = lazyInitHellService.extractProduct();
        displayOrderDetails(product);
    }

    private void displayOrderDetails(ProductsEntity product) {
        final Collection<OrderDetailsEntity> orderDetails = product.getOrderDetailsesByProductid();
        final OrderDetailsEntity firstDetail = orderDetails.iterator().next();
        System.out.println("Discount for a product: " + firstDetail.getDiscount());
    }
}
