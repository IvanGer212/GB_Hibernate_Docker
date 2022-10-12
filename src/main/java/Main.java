import dao.CustomerDao;
import dao.ProductDao;
import dao.impl.CustomerDaoImpl;
import dao.impl.ProductDaoImpl;
import entity.Customer;
import entity.Product;
import org.flywaydb.core.Flyway;
import service.impl.CustomerServiceImpl;
import service.impl.ProductServiceImpl;
import utils.HibernateSessionFactoryUtil;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;


public class Main {
    public static void main(String[] args) {
         //Create the Flyway instance and point it to the database
//        Flyway flyway = Flyway.configure()
//                .dataSource("jdbc:postgresql://localhost:5432/simple-app", "postgres", "postgrespass").load();
//
//         //Start the migration
//        flyway.migrate();

        HibernateSessionFactoryUtil hibernateSessionFactoryUtil = new HibernateSessionFactoryUtil();
        hibernateSessionFactoryUtil.init();

        try {
        //init
        ProductDao productDao = new ProductDaoImpl(hibernateSessionFactoryUtil);
        CustomerDao customerDao = new CustomerDaoImpl(hibernateSessionFactoryUtil);
        CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl(customerDao);
        ProductServiceImpl productServiceImpl = new ProductServiceImpl(productDao);

        //
        //productServiceImpl.findByID(1L);


        // Optional<Customer> customerById = customerService.findCustomerById(1L);
        // System.out.println(customerById.get().toString());

//       System.out.println(productServiceImpl.findAll().toString());

        //Find all Customer who buy Product with Id
       List<Customer> customerById = productServiceImpl.findCustomerById(7L);
       System.out.println(customerById.toString());
//      customerById.stream().findFirst().ifPresent(p-> System.out.println(p));
        //-------------------------------------------------------
        // Add new or update existing product in BD
        //productServiceImpl.saveOrUpdate(new Product("Product12", 58));
        //-------------------------------------------------------
        // Find and print Product by Id
        // Optional<Product> productOptional = productServiceImpl.findByID(8L);
        // System.out.println(productOptional.get());
        //---------------------------------------------------------------------
        // Delete Product from BD by Id and print all Products from BD
        // productServiceImpl.deleteByID(6L);
        // System.out.println(productServiceImpl.findAll().toString());
        //--------------------------------------------
        // Find all buying product For Customer
        List<Product> productsById = customerServiceImpl.findAllProductsBuyingCustomerByCustomerId(2L);
        System.out.println(productsById.toString());

        //System.out.println(productsById.toString());

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            hibernateSessionFactoryUtil.shutdown();
        }


    }
}
