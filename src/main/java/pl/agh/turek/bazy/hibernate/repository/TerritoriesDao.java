package pl.agh.turek.bazy.hibernate.repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.agh.turek.bazy.hibernate.model.TerritoriesEntity;

@Repository
public class TerritoriesDao extends GenericDao<TerritoriesEntity, String> {

    @Autowired
    public TerritoriesDao(SessionFactory sessionFactory) {
        super(sessionFactory, TerritoriesEntity.class);
    }
}
