package com.capgemini.capstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.capstore.bean.CartBean;
import com.capgemini.capstore.bean.CommonFeedbackBean;
import com.capgemini.capstore.bean.LoginBean;
import com.capgemini.capstore.bean.OrderBean;
import com.capgemini.capstore.bean.OrderHistoryBean;
import com.capgemini.capstore.bean.ProductFeedbackBean;
import com.capgemini.capstore.bean.WishlistBean;
import com.capgemini.capstore.dao.CustomerDao;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDao customerDao;

	@Override
	public boolean insertCommonFeedback(CommonFeedbackBean commonFeedbackBean) {
		return customerDao.insertCommonFeedback(commonFeedbackBean);
	}

	@Override
	public boolean insertProductFeedback(ProductFeedbackBean productFeedbackBean) {
		return customerDao.insertProductFeedback(productFeedbackBean);
	}

	@Override
	public List<OrderBean> orderdetails(String email) {

		return customerDao.orderdetails(email);
	}

	@Override
	public LoginBean viewprofile(String email) {

		return customerDao.viewprofile(email);
	}

	@Override
	public boolean updateProfile(LoginBean loginBean) {

		return customerDao.updateProfile(loginBean);
	}

	@Override
	public List<CartBean> getCartList(String email) {
		return customerDao.getCartList(email);
	}

	@Override
	public List<WishlistBean> getWishlist(String email) {
		return customerDao.getWishlist(email);
	}

}
