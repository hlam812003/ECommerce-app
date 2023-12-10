package com.data;

import com.model.OrderDetail;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class OrderDetailDB {
    public static void insert(OrderDetail detail) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.persist(detail);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static void update(OrderDetail detail) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.merge(detail);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static void delete(OrderDetail detail) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.remove(em.merge(detail));
            trans.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static OrderDetail findDetailById(Long invoiceId) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            return em.find(OrderDetail.class, invoiceId);
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }
}
