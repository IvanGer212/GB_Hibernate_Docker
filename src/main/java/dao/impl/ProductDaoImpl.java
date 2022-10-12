package dao.impl;

import dao.ProductDao;
import entity.Customer;
import entity.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;
import utils.HibernateSessionFactoryUtil;

import java.util.List;
import java.util.Optional;
@Component
public class ProductDaoImpl implements ProductDao {
    private HibernateSessionFactoryUtil hibernateSessionFactoryUtil;

    public ProductDaoImpl(HibernateSessionFactoryUtil hibernateSessionFactoryUtil) {
        this.hibernateSessionFactoryUtil = hibernateSessionFactoryUtil;
    }

    @Override
    public Optional<Product> findByID(Long id) {
        try (Session session = hibernateSessionFactoryUtil.getSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            Optional<Product> optionalProduct = Optional.ofNullable(product);
            session.getTransaction().commit();
            return optionalProduct;
        }
    }

    @Override
    public List<Product> findAll() {
        try(Session session = hibernateSessionFactoryUtil.getSession()) {
            session.beginTransaction();
            List<Product> products = session.createQuery("FROM Product").list();
            session.getTransaction().commit();
            return products;
        }
    }

    @Override
    public void deleteByID(Long id) {
        try (Session session = hibernateSessionFactoryUtil.getSession()) {
            session.beginTransaction();
            session.createQuery("DELETE FROM Product p where p.id = :product_id")
                    .setParameter("product_id", id).executeUpdate();

            session.getTransaction().commit();
        }
    }

    @Override
    public Product saveOrUpdate(Product product) {
        try(Session session = hibernateSessionFactoryUtil.getSession()) {
            session.beginTransaction();
            session.saveOrUpdate(product);
            session.getTransaction().commit();
            return product;
        }
        }

    @Override
    public List<Customer> findCustomerById(Long id) {
        try (Session session = hibernateSessionFactoryUtil.getSession()) {
            session.beginTransaction();
            List<Customer> customers = session.createNativeQuery("SELECT * FROM customer c JOIN product_customer ON c.id = product_customer.customer_id where product_id =:prod_id", Customer.class)
                    .setParameter("prod_id", id)
                    .getResultList();
            //Product product = session.get(Product.class, id);
            //List<Customer> customers = product.getCustomers();
            //System.out.println(customers.toString());
            session.getTransaction().commit();

            return customers;
        }
    }
}
