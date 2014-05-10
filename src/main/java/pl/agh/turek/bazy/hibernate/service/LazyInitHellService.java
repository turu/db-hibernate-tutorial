package pl.agh.turek.bazy.hibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.agh.turek.bazy.hibernate.model.ProductsEntity;
import pl.agh.turek.bazy.hibernate.repository.ProductsDao;

/**
 * Author: Piotr Turek
 */
@Service
public class LazyInitHellService {
    @Autowired
    private ProductsDao productsDao;

    @Transactional
    public ProductsEntity extractProduct() {
        return productsDao.getAll().get(0);
    }
}
