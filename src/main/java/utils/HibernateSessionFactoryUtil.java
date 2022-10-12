package utils;

import entity.Customer;
import entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

@Component("session")
public class HibernateSessionFactoryUtil {

    private SessionFactory sessionFactory;

    public void init(){
        sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Product.class)
                .addAnnotatedClass(Customer.class)
                .buildSessionFactory();
    }

    public Session getSession() {return sessionFactory.openSession().getSession();}

    public void shutdown (){
        if(sessionFactory != null){
            sessionFactory.close();
        }
    }
    }
