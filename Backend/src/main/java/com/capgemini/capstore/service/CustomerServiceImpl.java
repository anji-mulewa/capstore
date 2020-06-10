package com.capgemini.capstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.capstore.bean.CommonFeedbackBean;
import com.capgemini.capstore.bean.OrderBean;
import com.capgemini.capstore.bean.OrderHistoryBean;
import com.capgemini.capstore.bean.ProductFeedbackBean;
import com.capgemini.capstore.dao.CustomerDao;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDao customerOperationsDao;

	@Override
	public boolean insertCommonFeedback(CommonFeedbackBean commonFeedbackBean) {
		return customerOperationsDao.insertCommonFeedback(commonFeedbackBean);
	}

	@Override
	public boolean insertProductFeedback(ProductFeedbackBean productFeedbackBean) {
		return customerOperationsDao.insertProductFeedback(productFeedbackBean);
	}

	@Override
	public List<OrderBean> orderdetails(String email) {

		return customerOperationsDao.orderdetails(email);
	}

	@Override
	public List<OrderHistoryBean> orderHistory(String email) {

		return customerOperationsDao.orderHistory(email);
	}
}
