package com.capgemini.capstore.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.capstore.bean.CommonFeedbackBean;
import com.capgemini.capstore.bean.MerchantPermanentBean;
import com.capgemini.capstore.exception.CapstoreException;
@Repository
public class MerchantDaoImpl implements MerchantDao {

	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;
	
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

}
