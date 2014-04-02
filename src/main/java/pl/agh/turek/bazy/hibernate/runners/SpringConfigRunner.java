package pl.agh.turek.bazy.hibernate.runners;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Author: Piotr Turek
 */
public class SpringConfigRunner {

    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(SpringConfigRunner.class);

    public static void main(String[] args) {
        new SpringConfigRunner().run();
    }

    private void run() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("META-INF/applicationContext.xml");
        SessionFactory sessionFactory = (SessionFactory) ctx.getBean("sessionFactory");
        Session session = sessionFactory.openSession();
        SQLQuery sqlQuery = session.createSQLQuery("SELECT * FROM customers");
        LOG.info(String.valueOf(sqlQuery.list()));
    }

}
