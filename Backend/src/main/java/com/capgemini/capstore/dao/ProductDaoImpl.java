package com.capgemini.capstore.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.capstore.bean.ProductFeedbackBean;
import com.capgemini.capstore.exception.CapstoreException;

@Repository
public class ProductDaoImpl implements ProductDao {

	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;

	public List<ProductFeedbackBean> getProductFeedback(int productId) {

		List<ProductFeedbackBean> productFeedbackList = null;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpql = "from ProductFeedbackBean where productId=:productId";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("productId", productId);
		try {
			productFeedbackList = query.getResultList();
		} catch (Exception e) {
			throw new CapstoreException("Something went wrong...products feedback not found");
		}
		return productFeedbackList;
	}

	@Override
	public double getAverageRating(int productId) {
		double averageRating = 0.0;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpql = "select avg(rating) from ProductFeedbackBean where productId=:productId";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("productId", productId);
		try {
			averageRating = (double) query.getSingleResult();
		} catch (Exception e) {
			throw new CapstoreException("Something went wrong...");
		}
		return averageRating;
	}

}
