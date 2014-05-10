package pl.agh.turek.bazy.hibernate.repository;

import org.springframework.stereotype.Repository;
import pl.agh.turek.bazy.hibernate.model.TerritoriesEntity;

@Repository
public class TerritoriesDao extends GenericDao<TerritoriesEntity, String> {
    public TerritoriesDao() {
        setType(TerritoriesEntity.class);
    }
}
