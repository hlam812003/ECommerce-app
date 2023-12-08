package com.data;

import java.util.List;
import java.util.logging.Logger;

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
        String queryString = "SELECT p FROM Product p";
        TypedQuery<Product> query = em.createQuery(queryString, Product.class);
        try {
            return query.getResultList();
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    public static Product findProductById(Long productId) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            return em.find(Product.class, productId);
        } finally {
            em.close();
        }
    }

    public static List<Product> findProductsByName(String name) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        TypedQuery<Product> query = em.createQuery("SELECT p FROM Product p WHERE p.name LIKE :name", Product.class);
        query.setParameter("name", "%" + name + "%");
        return query.getResultList();
    }

}
