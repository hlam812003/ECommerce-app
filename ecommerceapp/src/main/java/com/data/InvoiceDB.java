package com.data;

import com.model.Invoice;
import com.model.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

public class InvoiceDB {
    public static void insert(Invoice invoice) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.persist(invoice);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static void update(Invoice invoice) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.merge(invoice);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static void delete(Invoice invoice) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.remove(em.merge(invoice));
            trans.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static Invoice findInvoiceById(Long invoiceId) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            return em.find(Invoice.class, invoiceId);
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }

    public static Invoice findLastInvoiceByUser(User user) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String queryString = "SELECT i FROM Invoice i " + "WHERE i.user = :user " + "ORDER BY i.invoiceId desc";
        TypedQuery<Invoice> query = em.createQuery(queryString, Invoice.class);
        query.setParameter("user", user);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

}
