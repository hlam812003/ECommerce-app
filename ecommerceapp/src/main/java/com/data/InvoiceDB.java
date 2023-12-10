package com.data;

import java.util.logging.Logger;

import com.model.Invoice;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class InvoiceDB {
        private static Logger logger = Logger.getLogger(InvoiceDB.class.getName());

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

    public static Invoice findInvoiceById(String invoiceId) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            return em.find(Invoice.class, invoiceId);
        } finally {
            em.close();
        }
    }
}
