package com.data;

import java.util.logging.Logger;
import com.model.Favorites;
import com.model.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

public class FavoriteDB {
    private static Logger logger = Logger.getLogger(FavoriteDB.class.getName());

    public static void insert(Favorites favorites) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.persist(favorites);
            trans.commit();
        } catch (Exception e) {
            logger.info(e.getMessage());
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static void update(Favorites favorites) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.merge(favorites);
            trans.commit();
        } catch (Exception e) {
            logger.info(e.getMessage());
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static void delete(Favorites favorites) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.remove(em.merge(favorites));
            trans.commit();
        } catch (Exception e) {
            logger.info(e.getMessage());
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static Favorites findByUser(User user) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            TypedQuery<Favorites> q = em.createQuery("SELECT f FROM Favorites f WHERE f.user = :user", Favorites.class);
            q.setParameter("user", user);
            return q.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }
}
