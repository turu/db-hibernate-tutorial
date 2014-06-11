package pl.agh.turek.bazy.hibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.agh.turek.bazy.hibernate.model.ProductsEntity;
import pl.agh.turek.bazy.hibernate.repository.ProductsDao;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Author: Piotr Turek
 */
@Service
public class LazyInitHellService {
    @Autowired
    private ProductsDao productsDao;

    @Transactional
    public ProductsEntity extractProduct() {
        final List<ProductsEntity> all = productsDao.getAll();
        Collections.sort(all, new Comparator<ProductsEntity>() {
            @Override
            public int compare(ProductsEntity o1, ProductsEntity o2) {
                return (int) (o1.getProductid() - o2.getProductid());
            }
        });
        return all.get(0);
    }

    @Transactional
    public ProductsEntity extractProductWithOrderDetails() {
        final ProductsEntity product = extractProduct();
        System.out.println("... Product lazy proxy retrieved ...");
        product.getOrderDetailsesByProductid().size();
        return product;
    }
}
