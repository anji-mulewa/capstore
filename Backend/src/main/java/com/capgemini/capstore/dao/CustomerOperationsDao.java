package com.capgemini.capstore.dao;

import java.util.List;

import com.capgemini.capstore.bean.CommonFeedbackBean;
import com.capgemini.capstore.bean.OrderBean;
import com.capgemini.capstore.bean.OrderHistoryBean;
import com.capgemini.capstore.bean.ProductFeedbackBean;

public interface CustomerOperationsDao {

	public boolean insertCommonFeedback(CommonFeedbackBean commonFeedbackBean);

	public List<CommonFeedbackBean> getCommonFeedbackList(String email);
	
	public boolean insertProductFeedback(ProductFeedbackBean productFeedbackBean);
	
	public List<OrderBean> orderdetails(String email);
	
	public List<OrderHistoryBean> orderHistory(String email);

	
}
