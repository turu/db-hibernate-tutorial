package pl.agh.turek.bazy.hibernate.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import pl.agh.turek.bazy.hibernate.model.OrderDetailsEntityPK;
import pl.agh.turek.bazy.hibernate.model.ProductsEntity;
import pl.agh.turek.bazy.hibernate.service.CascadeTypeService;
import pl.agh.turek.bazy.hibernate.service.LazyInitHellService;

/**
 * Author: Piotr Turek
 */
@Component
public class CascadeTypeRunner {
    @Autowired
    private LazyInitHellService lazyInitHellService;

    @Autowired
    private CascadeTypeService cascadeTypeService;

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("META-INF/applicationContext.xml");
        ((CascadeTypeRunner) ctx.getBean("cascadeTypeRunner")).run();
    }

    private void run() {
        final ProductsEntity productsEntity = lazyInitHellService.extractProductWithOrderDetails();
        final OrderDetailsEntityPK pk = cascadeTypeService.modifyFirstOrderDetailsDiscount(productsEntity);
        cascadeTypeService.verifyOrderDetailsDiscount(pk);
    }
}
