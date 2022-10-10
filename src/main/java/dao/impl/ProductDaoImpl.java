package dao.impl;

import dao.ProductDao;
import entity.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;
import java.util.Optional;

public class ProductDaoImpl implements ProductDao {

    @Override
    public Product findByID(Long id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Product product = session.get(Product.class, id);
        session.getTransaction().commit();
        return product;
    }

    @Override
    public List<Product> findAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Product> products = session.createQuery("FROM Product").list();
        session.getTransaction().commit();
        return products;
    }

    @Override
    public void deleteByID(Long id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        //session.createQuery("SELECT p.title FROM Product p")
        session.createQuery("DELETE FROM Product p where p.id = :product_id")
                     .setParameter("product_id",id).executeUpdate();

        session.getTransaction().commit();
    }

    @Override
    public Product saveOrUpdate(Product product) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(product);
        session.getTransaction().commit();
        return product;
        }

//        Product newProduct;
//        Session session = HibernateSessionFactoryUtil.getSession().openSession();
//        List<Product> all = findAll();
//        Optional<Product> optionalProduct = all.stream().filter(p -> p.getTitle().equals(product.getTitle())).findFirst();
//        Transaction tr = session.beginTransaction();
//        if (optionalProduct.isPresent()){
//            newProduct = optionalProduct.get();
//            newProduct.setTitle(product.getTitle());
//            newProduct.setPrice(product.getPrice());
//            session.update(newProduct);
//        }
//        else {
//            session.save(product);
//        }
//        tr.commit();
//        session.close();
//        return product;

}
