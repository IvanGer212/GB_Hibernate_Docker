package dao;

import entity.Product;

import java.util.List;

public interface ProductDao {
    Product findByID(Long id);


    List<Product> findAll();


    void deleteByID(Long id);


    Product saveOrUpdate(Product product);

}
