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

        Session session = sessionFactory.openSession();

        /**
         * Creating new object produces a transient object
         */
        TerritoriesEntity transientObject = new TerritoriesEntity();
        transientObject.setTerritoryId("Transient");
        transientObject.setTerritoryDescription("This is transient");

        /**
         * We wont receive any result - transient object is not persisted
         * Basically it is plain java object with no associated db record
         */
        TerritoriesEntity foundEntity =  (TerritoriesEntity) session.get(
                TerritoriesEntity.class,"Transient");
        System.out.println(foundEntity);

        /**
         * After object is saved it has persistent state
         * Persistent object has associated db record
         * Warning: it doesn't mean that record and object are always equal
         *      - you still need to session.update() when changes made
         */
        session.save(transientObject);
        session.flush();
        TerritoriesEntity persistentEntity =  (TerritoriesEntity) session.get(
                TerritoriesEntity.class,"Transient");
        System.out.println(persistentEntity.getTerritoryDescription());
        /**
         * What happens on subsequent runner execution?
         * Why you need: session.delete(transientObject);session.flush();
         * Hint: better practise is to use session.saveOrUpdate()
         */

        /**
         * After session is closed object is in detached state -
         * any changes won't be persisted but object is still valid
         * Warning: if you use dao methods you will open another session so
         *      that way you would persist changes
         */
        session.close();
        TerritoriesEntity detachedEntity = persistentEntity;
        persistentEntity.setTerritoryDescription("This is detached");
        System.out.println(detachedEntity.getTerritoryDescription());
    }


}
