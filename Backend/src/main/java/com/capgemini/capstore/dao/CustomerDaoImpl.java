package com.capgemini.capstore.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.capstore.bean.CartBean;
import com.capgemini.capstore.bean.CommonFeedbackBean;
import com.capgemini.capstore.bean.LoginBean;
import com.capgemini.capstore.bean.OrderBean;
import com.capgemini.capstore.bean.OrderHistoryBean;
import com.capgemini.capstore.bean.ProductBean;
import com.capgemini.capstore.bean.ProductFeedbackBean;
import com.capgemini.capstore.bean.WishlistBean;
import com.capgemini.capstore.exception.CapstoreException;

@Repository
public class CustomerDaoImpl implements CustomerDao {

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
	public boolean insertProductFeedback(ProductFeedbackBean productFeedbackBean) {
		boolean result = false;
		// System.out.println("product id:"+productFeedbackBean.getProductId());
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityManager entityManager2 = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		String jpql = "from ProductBean where productId=:productId";
		Query query = entityManager.createQuery(jpql);
		int productId = productFeedbackBean.getProductId();
		// System.out.println("new product id"+productId);
		query.setParameter("productId", productId);
		ProductBean productBean = (ProductBean) query.getSingleResult();
		productFeedbackBean.setEmail(productBean.getEmail());

		double oldRating = productBean.getProductRating();
		double newRating = (oldRating + productFeedbackBean.getRating()) / 2;
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
	public LoginBean viewprofile(String email) {
		LoginBean loginbean = null;
		try {
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction = entityManager.getTransaction();
			String jpql = "from LoginBean where email =:email";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("email", email);
			loginbean = (LoginBean) query.getSingleResult();

		} catch (Exception exception) {
			throw new CapstoreException("Unable to view profile");
		}
		return loginbean;
	}

	@Override
	public boolean updateProfile(LoginBean loginBean) {
		boolean isUpdated = false;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		LoginBean loginBean2 = entityManager.find(LoginBean.class, loginBean.getId());
		if (loginBean2 != null) {
			if (loginBean.getName() != null) {
				loginBean2.setName((loginBean.getName()));
			}

			if (loginBean.getPhoneNumber() != null) {
				loginBean2.setPhoneNumber((loginBean.getPhoneNumber()));
			}
		} else {
			throw new CapstoreException("Invalid CustomerId ");
		}
		try {
			entityTransaction.begin();
			entityManager.persist(loginBean2);
			entityTransaction.commit();
			isUpdated = true;
		} catch (Exception exception) {
			throw new CapstoreException("Unable to Update Customer");
		}
		return isUpdated;
	}

	@Override
	public List<CartBean> getCartList(String email) {

		try {
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			String jpql = "FROM CartBean WHERE email=:email";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("email", email);
			List<CartBean> information = query.getResultList();
			entityManager.close();
			return information;
		} catch (Exception exception) {
			System.out.println("Unable to fetch cart");
		}
		return null;
	}

	@Override
	public List<WishlistBean> getWishlist(String email) {
		try {
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			String jpql = "FROM WishlistBean WHERE email=:email";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("email", email);
			List<WishlistBean> information = query.getResultList();
			entityManager.close();
			return information;
		} catch (Exception exception) {
			System.out.println("Unable to fetch wishlist");
		}
		return null;
	}

}
