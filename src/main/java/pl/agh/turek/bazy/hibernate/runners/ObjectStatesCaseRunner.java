package pl.agh.turek.bazy.hibernate.runners;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pl.agh.turek.bazy.hibernate.model.TerritoriesEntity;
import pl.agh.turek.bazy.hibernate.repository.TerritoriesDao;

public class ObjectStatesCaseRunner {
    @Autowired
    private static TerritoriesDao dao;

    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(SpringConfigRunner.class);

    public static void main(String[] args) {
        new ObjectStatesCaseRunner().run();
    }

    private void run() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("META-INF/applicationContext.xml");
        SessionFactory sessionFactory = (SessionFactory) ctx.getBean("sessionFactory");
        Session session = sessionFactory.openSession();

        TerritoriesEntity transientObject = new TerritoriesEntity();
        transientObject.setTerritoryId("Transient");
        transientObject.setTerritoryDescription("This is transient");

        TerritoriesEntity foundEntity = dao.get("Transient");
        System.out.println(foundEntity);


    }


}
