package com.capgemini.capstore.dao;

import java.util.List;

import com.capgemini.capstore.bean.ProductFeedbackBean;

public interface ProductDao {
	public List<ProductFeedbackBean> getProductFeedback(int productId);
	
	public double getAverageRating(int productId);

}
