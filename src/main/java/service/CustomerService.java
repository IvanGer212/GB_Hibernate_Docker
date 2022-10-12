package service;

import entity.Customer;
import entity.Product;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    Optional<Customer> findCustomerById (Long id);

    List<Product> findAllProductsBuyingCustomerByCustomerId(Long id);
}
