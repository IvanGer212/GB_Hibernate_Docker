package dao.impl;

import dao.CustomerDao;
import entity.Customer;
import entity.Product;
import org.hibernate.Session;
import org.springframework.stereotype.Component;
import utils.HibernateSessionFactoryUtil;

import java.util.List;
import java.util.Optional;
@Component()
public class CustomerDaoImpl implements CustomerDao {

    HibernateSessionFactoryUtil factory;

    public CustomerDaoImpl(HibernateSessionFactoryUtil factory) {
        this.factory = factory;
    }

    @Override
    public Optional<Customer> findCustomerById(Long id) {
        try(Session session = factory.getSession()){
            session.beginTransaction();
            Optional<Customer> optionalCustomer = Optional.ofNullable(session.get(Customer.class, id));
            session.getTransaction().commit();
            return optionalCustomer;
        }
    }

    @Override
    public List<Product> findAllProductsBuyingCustomerByCustomerId(Long customerId){
        try (Session session = factory.getSession()){
            session.beginTransaction();
            List<Product> products = session.createNativeQuery("SELECT * FROM product p JOIN product_customer ON p.id = product_customer.product_id where customer_id =:customer_id", Product.class)
                    .setParameter("customer_id", customerId)
                    .getResultList();
            session.getTransaction().commit();
            return products;
        }

    }
}
