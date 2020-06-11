package com.capgemini.capstore.service;

import java.util.List;

import com.capgemini.capstore.bean.CartBean;
import com.capgemini.capstore.bean.CommonFeedbackBean;
import com.capgemini.capstore.bean.LoginBean;
import com.capgemini.capstore.bean.OrderBean;
import com.capgemini.capstore.bean.OrderHistoryBean;
import com.capgemini.capstore.bean.ProductFeedbackBean;
import com.capgemini.capstore.bean.WishlistBean;

public interface CustomerService {
	public boolean insertCommonFeedback(CommonFeedbackBean commonFeedbackBean);

	public boolean insertProductFeedback(ProductFeedbackBean productFeedbackBean);

	public List<OrderBean> orderdetails(String email);

	public LoginBean viewprofile(String email);

	public boolean updateProfile(LoginBean loginBean);

	public List<CartBean> getCartList(String email);

	public List<WishlistBean> getWishlist(String email);

}
