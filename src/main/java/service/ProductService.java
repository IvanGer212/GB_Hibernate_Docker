package service;

import entity.Customer;
import entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Optional<Product> findByID(Long id);


    List<Product> findAll();


    void deleteByID(Long id);


    Product saveOrUpdate(Product product);

    List<Customer> findCustomerById(Long id);

}
