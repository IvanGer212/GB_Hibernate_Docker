package service.impl;

import dao.CustomerDao;
import entity.Customer;
import entity.Product;
import org.springframework.stereotype.Component;
import service.CustomerService;

import java.util.List;
import java.util.Optional;

@Component("customer_service")
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
