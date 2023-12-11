package com.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.model.Product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class ProductDB {
    public static void insert(Product product) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.persist(product);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
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
            System.out.println(e.getMessage());
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
            System.out.println(e.getMessage());
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
        } catch (Exception e) {
            return null;
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

    public static List<Product> getFilteredProducts(String[] categories, String[] brands, String color, String size,
        String[] tags, String minPrice, String maxPrice) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Product> cq = cb.createQuery(Product.class);

        Root<Product> product = cq.from(Product.class);
        List<Predicate> predicates = new ArrayList<>();

        if (categories != null && categories.length > 0) {
            predicates.add(product.get("category").in((Object[]) categories));
        }        

        if (brands != null && brands.length > 0) {
            predicates.add(product.get("brand").in((Object[]) brands));
        }

        if (tags != null && tags.length > 0) {
            predicates.add(product.get("tags").in((Object[]) tags));
        }

        if (color != null) {
            predicates.add(cb.equal(product.get("color"), color));
        }

        if (size != null) {
            predicates.add(cb.equal(product.get("size"), size));
        }

        // Thêm điều kiện cho khoảng giá
        if (minPrice != null && maxPrice != null) {
            Double minDouble = parseDouble(minPrice);
            Double maxDouble = parseDouble(maxPrice);

            predicates.add(cb.between(product.get("price"), minDouble, maxDouble));
        }

        cq.where(predicates.toArray(new Predicate[0]));
        TypedQuery<Product> query = em.createQuery(cq);
        return query.getResultList();
    }

    public static Double parseDouble(String value) {
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return null;
        }
    }

}
