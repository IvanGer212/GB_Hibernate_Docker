import dao.ProductDao;
import dao.impl.ProductDaoImpl;
import entity.Product;
import service.impl.ProductServiceImpl;


public class Main {
    public static void main(String[] args) {
        // Create the Flyway instance and point it to the database
       // Flyway flyway = Flyway.configure()
       //         .dataSource("jdbc:postgresql://localhost:5432/simple-app", "postgres", "postgrespass").load();

        // Start the migration
       // flyway.migrate();

        ProductDao productDao = new ProductDaoImpl();
        ProductServiceImpl productServiceImpl = new ProductServiceImpl(productDao);
        //productServiceImpl.saveOrUpdate(new Product("Product7",(int) 28));
        //Product product = productServiceImpl.findByID((long) 1);        //System.out.println(product.getId() + " "+ product.getTitle()+ " " + product.getPrice());
        System.out.println(productServiceImpl.findAll().toString());

        // productServiceImpl.deleteByID((long)3);
        //System.out.println(productServiceImpl.findAll().toString());
    }
}
