package utils;

import entity.Customer;
import entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

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

//        private HibernateSessionFactoryUtil() {}
//
//        public static SessionFactory getSessionFactory() {
//            if (sessionFactory == null) {
//                try {
//                    Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
//                    configuration.addAnnotatedClass(Product.class);
//                    StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
//                    sessionFactory = configuration.buildSessionFactory(builder.build());
//
//                } catch (Exception e) {
//                    System.out.println("Исключение!" + e);
//                }
//            }
//            return sessionFactory;
//        }
    }
