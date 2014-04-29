package pl.agh.turek.bazy.hibernate.runners;

import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pl.agh.turek.bazy.hibernate.model.TerritoriesEntity;
import pl.agh.turek.bazy.hibernate.repository.TerritoriesDao;

public class DAOCaseRunner {
    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(SpringConfigRunner.class);

    public static void main(String[] args) {
        new DAOCaseRunner().run();
    }

    private void run() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
                "META-INF/applicationContext.xml");
        TerritoriesDao territoriesDao = (TerritoriesDao) ctx.getBean("territoriesDao");

        TerritoriesEntity exampleEntity = new TerritoriesEntity();
        exampleEntity.setTerritoryid("Example");
        exampleEntity.setTerritorydescription("This is Example");

        territoriesDao.create(exampleEntity);
        TerritoriesEntity foundEntity = territoriesDao.get("Example");
        System.out.println(foundEntity.getTerritorydescription());

        exampleEntity.setTerritorydescription("This is still Example");

        territoriesDao.update(exampleEntity);
        foundEntity = territoriesDao.get("Example");
        System.out.println(foundEntity.getTerritorydescription());

        territoriesDao.delete(exampleEntity);
        foundEntity = territoriesDao.get("Example");
        System.out.println(foundEntity);
    }


}
