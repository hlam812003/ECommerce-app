package com.data;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

import com.hash.Pbkdf2PasswordHashImpl;
import com.model.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

public class UserDB {
    private static Pbkdf2PasswordHashImpl verifyHash = new Pbkdf2PasswordHashImpl();

    public static void insert(User user) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.persist(user);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
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
            System.out.println(e.getMessage());
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
            System.out.println(e.getMessage());
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

    public static User getUserByEmail(String email) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            return em.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class)
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    public static User getUserByVerificationCode(String code) {
        String decodedCode = "";
        try {
            decodedCode = URLDecoder.decode(code, StandardCharsets.UTF_8.toString());
            System.out.println(decodedCode);
        } catch (UnsupportedEncodingException e) {
            return null;
        }
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String queryString = "SELECT u FROM User u";
        TypedQuery<User> query = em.createQuery(queryString, User.class);
        try {
            List<User> users = query.getResultList();

            String finalDecodedCode = decodedCode.replace(" ", "+");
            System.out.println(decodedCode);

            return users.stream().filter(
                    user -> verifyHash.verify((user.getEmail() + user.getVerificationCode()).toCharArray(),
                            finalDecodedCode))
                    .findFirst().orElse(null);
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }
}