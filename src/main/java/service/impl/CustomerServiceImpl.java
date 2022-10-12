package service.impl;

import dao.CustomerDao;
import entity.Customer;
import entity.Product;
import service.CustomerService;

import java.util.List;
import java.util.Optional;

public class CustomerServiceImpl implements CustomerService {
    private CustomerDao customerDao;

    public CustomerServiceImpl(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public Optional<Customer> findCustomerById(Long id) {
        return customerDao.findCustomerById(id);
    }

    @Override
    public List<Product> findAllProductsBuyingCustomerByCustomerId (Long id){
        return customerDao.findAllProductsBuyingCustomerByCustomerId(id);
    }
}
