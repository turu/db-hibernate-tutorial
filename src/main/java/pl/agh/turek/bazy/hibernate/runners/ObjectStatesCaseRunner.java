package pl.agh.turek.bazy.hibernate.runners;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pl.agh.turek.bazy.hibernate.model.TerritoriesEntity;
import pl.agh.turek.bazy.hibernate.repository.TerritoriesDao;

public class ObjectStatesCaseRunner {
    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(SpringConfigRunner.class);

    public static void main(String[] args) {
        new ObjectStatesCaseRunner().run();
    }

    private void run() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("META-INF/applicationContext.xml");
        SessionFactory sessionFactory = (SessionFactory) ctx.getBean("sessionFactory");
        TerritoriesDao territoriesDao = (TerritoriesDao) ctx.getBean("territoriesDao");

        Session session = sessionFactory.openSession();

        /**
         * creating new object produces a transient object
         */
        TerritoriesEntity transientObject = new TerritoriesEntity();
        transientObject.setTerritoryId("Transient");
        transientObject.setTerritoryDescription("This is transient");

        /**
         * we wont receive any result - transient object is not persisted
         */
        TerritoriesEntity foundEntity = territoriesDao.get("Transient");
        System.out.println(foundEntity);


    }


}
