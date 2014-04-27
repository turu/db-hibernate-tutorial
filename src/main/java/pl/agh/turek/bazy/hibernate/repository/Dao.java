package pl.agh.turek.bazy.hibernate.repository;

import java.io.Serializable;
import java.util.List;

public interface Dao<T, PK extends Serializable> {

    PK create(T persistentObject);

    T get(PK id);

    List<T> getAll();

    void update(T persistentObject);

    void delete(T persistentObject);

}
