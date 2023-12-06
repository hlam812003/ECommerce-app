package com.data;

import java.util.logging.Logger;
import java.util.List;

import com.model.Product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

public class ProductDB {
    private static Logger logger = Logger.getLogger(ProductDB.class.getName());

    public static void insert(Product product) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.persist(product);
            trans.commit();
        } catch (Exception e) {
            logger.info(e.getMessage());
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static void update(Product product) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.merge(product);
            trans.commit();
        } catch (Exception e) {
            logger.info(e.getMessage());
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static void delete(Product product) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.remove(em.merge(product));
            trans.commit();
        } catch (Exception e) {
            logger.info(e.getMessage());
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static List<Product> getAllProducts() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String queryStr = "SELECT p FROM Product p";
        TypedQuery<Product> query = em.createQuery(queryStr, Product.class);
    
        List<Product> products;
        try {
            products = query.getResultList();
            if (products == null || products.isEmpty())
                products = null;
        } finally {
            em.close();
        }
        return products;
    }    

}
