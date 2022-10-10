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
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Product.class,id);
    }

    @Override
    public List<Product> findAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<Product> products = session.createQuery("FROM Product").list();
        return products;
    }

    @Override
    public void deleteByID(Long id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tr = session.beginTransaction();
        Product product = session.get(Product.class, id);
        session.delete(product);
        tr.commit();
        session.close();
    }

    @Override
    public Product saveOrUpdate(Product product) {
        Product newProduct;
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<Product> all = findAll();
        Optional<Product> optionalProduct = all.stream().filter(p -> p.getTitle().equals(product.getTitle())).findFirst();
        Transaction tr = session.beginTransaction();
        if (optionalProduct.isPresent()){
            newProduct = optionalProduct.get();
            newProduct.setTitle(product.getTitle());
            newProduct.setPrice(product.getPrice());
            session.update(newProduct);
        }
        else {
            session.save(product);
        }
        tr.commit();
        session.close();
        return product;
    }
}
