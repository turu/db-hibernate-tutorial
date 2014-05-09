package pl.agh.turek.bazy.hibernate.util;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
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
        Session session = sessionFactory.openSession();
        OrdersEntity entity = new OrdersEntity();

        EmployeesEntity employee = (EmployeesEntity) getRandomObject(EmployeesEntity.class, session);
        entity.setEmployeeid(employee.getEmployeeid());
        CustomersEntity customer = (CustomersEntity) getRandomObject(CustomersEntity.class, session);
        entity.setCustomerid(customer.getCustomerid());
        ShippersEntity shipper = (ShippersEntity) getRandomObject(ShippersEntity.class, session);
        entity.setShipvia(shipper.getShipperid());

        session.close();

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

    private Object getRandomObject(Class clazz, Session session) {
        Criteria criteria = session.createCriteria(clazz);
        criteria.add(Restrictions.sqlRestriction("1=1 order by random()"));
        criteria.setMaxResults(1);
        return criteria.list().get(0);
    }
}
