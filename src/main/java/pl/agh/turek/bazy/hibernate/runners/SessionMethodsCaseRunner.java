package pl.agh.turek.bazy.hibernate.runners;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pl.agh.turek.bazy.hibernate.model.TerritoriesEntity;
import pl.agh.turek.bazy.hibernate.repository.TerritoriesDao;

public class SessionMethodsCaseRunner {
    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(SpringConfigRunner.class);

    public static void main(String[] args) {
        new SessionMethodsCaseRunner().run();
    }

    private void run() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("META-INF/applicationContext.xml");
        SessionFactory sessionFactory = (SessionFactory) ctx.getBean("sessionFactory");

        Session session = sessionFactory.openSession();

        TerritoriesEntity exampleEntity = new TerritoriesEntity();
        exampleEntity.setTerritoryId("Example");
        exampleEntity.setTerritoryDescription("This is Example");

        session.save(exampleEntity);
        session.flush();
        TerritoriesEntity foundEntity = (TerritoriesEntity) session.get(
                TerritoriesEntity.class, "Example");
        System.out.println(foundEntity.getTerritoryDescription());

        exampleEntity.setTerritoryDescription("This is still Example");

        session.update(exampleEntity);
        session.flush();
        foundEntity = (TerritoriesEntity) session.get(TerritoriesEntity.class, "Example");
        System.out.println(foundEntity.getTerritoryDescription());

        session.delete(exampleEntity);
        session.flush();
        foundEntity = (TerritoriesEntity) session.get(TerritoriesEntity.class, "Example");
        System.out.println(foundEntity);

        session.close();
    }


}
