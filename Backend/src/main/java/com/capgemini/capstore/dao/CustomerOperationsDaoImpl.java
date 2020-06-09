package com.capgemini.capstore.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.capstore.bean.CommonFeedbackBean;
import com.capgemini.capstore.bean.MerchantPermanentBean;
import com.capgemini.capstore.bean.OrderBean;
import com.capgemini.capstore.bean.OrderHistoryBean;
import com.capgemini.capstore.bean.ProductBean;
import com.capgemini.capstore.bean.ProductFeedbackBean;
import com.capgemini.capstore.exception.CapstoreException;

@Repository
public class CustomerOperationsDaoImpl implements CustomerOperationsDao {

	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;

	@Override
	public boolean insertCommonFeedback(CommonFeedbackBean commonFeedbackBean) {
		boolean result = false;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			entityManager.persist(commonFeedbackBean);
			transaction.commit();
			result = true;
		} catch (Exception e) {
			throw new CapstoreException("Something went wrong... feedback can't be updated");
		}
		return result;
	}

	@Override
	public List<CommonFeedbackBean> getCommonFeedbackList(String email) {
		List<CommonFeedbackBean> commonFeedbackList = new ArrayList<CommonFeedbackBean>();
		MerchantPermanentBean merchantBean = null;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpqlForBrandName="from MerchantPermanentBean where email=:email";
		String jpql = "from CommonFeedbackBean where brandName=:brandName";
		try {
			Query queryForBrandName = entityManager.createQuery(jpqlForBrandName);
			queryForBrandName.setParameter("email", email);
			merchantBean=(MerchantPermanentBean)queryForBrandName.getSingleResult();
			Query query = entityManager.createQuery(jpql);
			query.setParameter("brandName", merchantBean.getBrandName());
			commonFeedbackList = query.getResultList();
		} catch (Exception e) {
			throw new CapstoreException("Something went wrong... feedback can't be fetched");
		}
		return commonFeedbackList;
	}

	@Override
	public boolean insertProductFeedback(ProductFeedbackBean productFeedbackBean) {
		boolean result = false;
		//System.out.println("product id:"+productFeedbackBean.getProductId());
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityManager  entityManager2 = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		String jpql = "from ProductBean where productId=:productId";
		Query query =entityManager.createQuery(jpql);
		int productId = productFeedbackBean.getProductId();
		//System.out.println("new product id"+productId);
		query.setParameter("productId", productId);
		ProductBean productBean = (ProductBean)query.getSingleResult();
		productFeedbackBean.setEmail(productBean.getEmail());
		
		double oldRating = productBean.getProductRating();
		double newRating = (oldRating+productFeedbackBean.getRating())/2;
		productBean.setProductRating(newRating);
		
		try {
			transaction.begin();
			entityManager.persist(productFeedbackBean);
			entityManager2.persist(productBean);
			transaction.commit();
			result = true;
		} catch (Exception e) {
			throw new CapstoreException("Something went wrong... feedback can't be inserted");
		}
		
		//String jpqlForRating = " from ProductBean where productId=:productId";
	//	Query queryForRating = entityManager.createQuery(jpqlForRating);
//		queryForRating.setParameter("productId", productFeedbackBean.getProductId());
//		ProductBean  productBeanOldRating = (ProductBean) queryForRating.getSingleResult();
//		double averageRating = (productBeanOldRating.getProductRating()+productFeedbackBean.getRating())/2;
//		productBeanOldRating.setProductRating(averageRating);
//		entityManager2.persist(productBeanOldRating);
	//	result = true;
		
		return result;
	}

	@Override
	public List<OrderBean> orderdetails(String email) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpql = "from OrderBean where email =:email";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("email", email);
		List<OrderBean> orderList = null;
		try {
			orderList = query.getResultList();
			if (orderList == null || orderList.isEmpty()) {
				throw new CapstoreException("Your order list is null");
			}
		} catch (Exception e) {
			throw new CapstoreException("You have no previous orders");
		}
		return orderList;
	}

	@Override
	public List<OrderHistoryBean> orderHistory(String email) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpql = "from OrderHistoryBean where email =:email";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("email", email);
		List<OrderHistoryBean> orderhistoryList = null;
		try {
			orderhistoryList = query.getResultList();
			if (orderhistoryList == null || orderhistoryList.isEmpty()) {
				throw new CapstoreException("Your order list is null");
			}
		} catch (Exception e) {
			throw new CapstoreException("You have no previous orders");
		}
		return orderhistoryList;
	}

}
