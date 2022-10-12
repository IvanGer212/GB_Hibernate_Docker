package dao;

import entity.Customer;
import entity.Product;

import java.util.List;
import java.util.Optional;

public interface CustomerDao {
    Optional<Customer> findCustomerById (Long id);

    List<Product> findAllProductsBuyingCustomerByCustomerId(Long customerId);
}
