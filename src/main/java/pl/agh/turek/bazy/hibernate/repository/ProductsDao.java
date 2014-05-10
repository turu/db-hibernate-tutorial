package pl.agh.turek.bazy.hibernate.repository;

import org.springframework.stereotype.Repository;
import pl.agh.turek.bazy.hibernate.model.ProductsEntity;

/**
 * Author: Piotr Turek
 */
@Repository
public class ProductsDao extends GenericDao<ProductsEntity, Long> {
    public ProductsDao() {
        setType(ProductsEntity.class);
    }
}
