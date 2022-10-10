package service;

import entity.Product;

import java.util.List;

public interface ProductService {
    Product findByID(Long id);


    List<Product> findAll();


    void deleteByID(Long id);


    Product saveOrUpdate(Product product);

}
