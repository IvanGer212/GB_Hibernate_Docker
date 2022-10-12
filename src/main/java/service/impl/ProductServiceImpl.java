package service.impl;

import dao.ProductDao;
import entity.Customer;
import entity.Product;
import service.ProductService;

import java.util.List;
import java.util.Optional;

public class ProductServiceImpl implements ProductService {

    private ProductDao productDao;

    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public Optional<Product> findByID(Long id) {
        return productDao.findByID(id);
    }

    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    public void deleteByID(Long id) {
        productDao.deleteByID(id);
    }

    @Override
    public Product saveOrUpdate(Product product) {
        return productDao.saveOrUpdate(product);
    }

    @Override
    public List<Customer> findCustomerById(Long id){
        return productDao.findCustomerById(id);
    }

}
