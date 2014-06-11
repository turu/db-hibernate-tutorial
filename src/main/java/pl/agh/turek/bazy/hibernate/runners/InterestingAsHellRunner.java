package pl.agh.turek.bazy.hibernate.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import pl.agh.turek.bazy.hibernate.model.OrderDetailsEntity;
import pl.agh.turek.bazy.hibernate.model.ProductsEntity;
import pl.agh.turek.bazy.hibernate.service.LazyInitHellService;

import java.util.Collection;
import java.util.Scanner;

/**
 * Author: Piotr Turek
 */
@Component
public class InterestingAsHellRunner {
    @Autowired
    private LazyInitHellService lazyInitHellService;

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("META-INF/applicationContext.xml");
        ((InterestingAsHellRunner) ctx.getBean("interestingAsHellRunner")).run();
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);
        doRun();
        System.out.println("Execute sql command: update order_details set discount=2*prev.discount from (select discount from order_details where productid=1 limit 1) as prev where productid=1; ");
        scanner.next();
        doRun();

    }

    private void doRun() {
        final ProductsEntity product = lazyInitHellService.extractProductWithOrderDetails();
        displayOrderDetails(product);
    }

    private void displayOrderDetails(ProductsEntity product) {
        final Collection<OrderDetailsEntity> orderDetails = product.getOrderDetailsesByProductid();
        final OrderDetailsEntity firstDetail = orderDetails.iterator().next();
        System.out.println("Discount for a product: " + firstDetail.getDiscount());
    }
}
