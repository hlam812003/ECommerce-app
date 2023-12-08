package com.data;

import java.util.logging.Logger;

import com.model.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

public class UserDB {
    private static Logger logger = Logger.getLogger(UserDB.class.getName());

    public static void insert(User user) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.persist(user);
            trans.commit();
        } catch (Exception e) {
            logger.info(e.getMessage());
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static void update(User user) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.merge(user);
            trans.commit();
        } catch (Exception e) {
            logger.info(e.getMessage());
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static void delete(User user) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.remove(em.merge(user));
            trans.commit();
        } catch (Exception e) {
            logger.info(e.getMessage());
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static User selectUser(String email) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String queryString = "SELECT u FROM User u " + "WHERE u.email = :email";
        TypedQuery<User> query = em.createQuery(queryString, User.class);
        query.setParameter("email", email);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    public static boolean isEmailExists(String email) {
        User u = selectUser(email);
        return u != null;
    }

    public static User getUserByVerificationCode(String code) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            return em.createQuery("SELECT u FROM User u WHERE u.verificationCode = :code", User.class)
                     .setParameter("code", code)
                     .getSingleResult();
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }    
}