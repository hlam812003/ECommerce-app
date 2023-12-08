package com.data;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

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

    public static List<Product> getFilteredProducts(String category, String brand, String color, String size,
            String tags, String minPrice, String maxPrice) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Product> cq = cb.createQuery(Product.class);

        Root<Product> product = cq.from(Product.class);
        List<Predicate> predicates = new ArrayList<>();

        if (category != null) {
            predicates.add(cb.equal(product.get("category"), category));
        }

        if (brand != null) {
            predicates.add(cb.equal(product.get("brand"), brand));
        }

        if (color != null) {
            predicates.add(cb.equal(product.get("color"), color));
        }

        if (size != null) {
            predicates.add(cb.equal(product.get("size"), size));
        }

        if (tags != null) {
            predicates.add(cb.equal(product.get("tags"), tags));
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
