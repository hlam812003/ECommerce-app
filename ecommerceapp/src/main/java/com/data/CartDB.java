package com.data;

import java.util.logging.Logger;
import com.model.Cart;
import com.model.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

public class CartDB {
    private static Logger logger = Logger.getLogger(CartDB.class.getName());

    public static void insert(Cart cart) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.persist(cart);
            trans.commit();
        } catch (Exception e) {
            logger.info(e.getMessage());
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static void update(Cart cart) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.merge(cart);
            trans.commit();
        } catch (Exception e) {
            logger.info(e.getMessage());
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static void delete(Cart cart) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.remove(em.merge(cart));
            trans.commit();
        } catch (Exception e) {
            logger.info(e.getMessage());
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static Cart findCartByUser(User user) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            TypedQuery<Cart> q = em.createQuery("SELECT c FROM Cart c WHERE c.user = :user", Cart.class);
            q.setParameter("user", user);
            return q.getSingleResult();
        } finally {
            em.close();
        }
    }
}
