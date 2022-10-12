import configuration.AppConfig;
import dao.CustomerDao;
import dao.ProductDao;
import dao.impl.CustomerDaoImpl;
import dao.impl.ProductDaoImpl;
import entity.Customer;
import entity.Product;
import org.flywaydb.core.Flyway;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.CustomerService;
import service.ProductService;
import service.impl.CustomerServiceImpl;
import service.impl.ProductServiceImpl;
import utils.HibernateSessionFactoryUtil;



public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ProductService productServiceImpl = context.getBean("product_service", ProductService.class);
        CustomerService customerServiceImpl = context.getBean("customer_service", CustomerService.class);
        HibernateSessionFactoryUtil session = context.getBean("session", HibernateSessionFactoryUtil.class);
        session.init();

        //Create the Flyway instance and point it to the database
//        Flyway flyway = Flyway.configure()
//                .dataSource("jdbc:postgresql://localhost:5432/simple-app", "postgres", "postgrespass").load();
//
//         //Start the migration
//        flyway.migrate();


        try {

        //    System.out.println(productServiceImpl.findByID(1L).get());


//         Optional<Customer> customerById = customerServiceImpl.findCustomerById(1L);
//         System.out.println(customerById.get().toString());

//       System.out.println(productServiceImpl.findAll().toString());

        //Find all Customer who buy Product with Id
//       List<Customer> customerById = productServiceImpl.findCustomerById(7L);
//       System.out.println(customerById.toString());

        //-------------------------------------------------------

        // Add new or update existing product in BD
//        productServiceImpl.saveOrUpdate(new Product("Product12", 58));
        //-------------------------------------------------------


        // Find and print Product by Id
//         Optional<Product> productOptional = productServiceImpl.findByID(8L);
//         System.out.println(productOptional.get());
        //---------------------------------------------------------------------


        // Delete Product from BD by Id and print all Products from BD
//         System.out.println(productServiceImpl.findAll().toString());
//         productServiceImpl.deleteByID(11L);
//         System.out.println(productServiceImpl.findAll().toString());
        //--------------------------------------------


        // Find all buying product For Customer
//        List<Product> productsById = customerServiceImpl.findAllProductsBuyingCustomerByCustomerId(2L);
//        System.out.println(productsById.toString());


        } catch (Exception e){
            e.printStackTrace();
        } finally {
            session.shutdown();
        }


    }
}
