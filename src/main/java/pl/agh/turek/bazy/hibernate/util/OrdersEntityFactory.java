package pl.agh.turek.bazy.hibernate.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.agh.turek.bazy.hibernate.model.CustomersEntity;
import pl.agh.turek.bazy.hibernate.model.EmployeesEntity;
import pl.agh.turek.bazy.hibernate.model.OrdersEntity;
import pl.agh.turek.bazy.hibernate.model.ShippersEntity;

import java.sql.Date;

@Component
public class OrdersEntityFactory {

    @Autowired
    private SessionFactory sessionFactory;

    public OrdersEntity createRandomOrder() {
        Session session = sessionFactory.getCurrentSession();
        OrdersEntity entity = new OrdersEntity();

        EmployeesEntity employee = (EmployeesEntity) RandomObjectFetcher.get(EmployeesEntity.class, session);
        entity.setEmployeeid(employee.getEmployeeid());
        CustomersEntity customer = (CustomersEntity) RandomObjectFetcher.get(CustomersEntity.class, session);
        entity.setCustomerid(customer.getCustomerid());
        ShippersEntity shipper = (ShippersEntity) RandomObjectFetcher.get(ShippersEntity.class, session);
        entity.setShipvia(shipper.getShipperid());

        entity.setFreight((System.nanoTime() % 100) / 731.);
        entity.setShipaddress("Burgerhoff " + System.nanoTime() % 100);
        entity.setShipname("Prince Aloff " + System.nanoTime() % 100);
        entity.setShippostalcode("MUT " + System.nanoTime() % 100);
        entity.setShipregion("-");
        entity.setShipcity("Mutenia");
        entity.setShipcountry("Mutenistan");

        entity.setOrderdate(getCurrentDateShifted(0));
        entity.setRequireddate(getCurrentDateShifted(900000000));

        return entity;
    }

    private Date getCurrentDateShifted(long miliDiff) {
        java.util.Calendar cal = java.util.Calendar.getInstance();
        java.util.Date utilDate = cal.getTime();
        return new Date(utilDate.getTime() + miliDiff);
    }
}
