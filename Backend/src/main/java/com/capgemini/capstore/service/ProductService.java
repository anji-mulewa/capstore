package com.capgemini.capstore.service;

import java.util.List;

import com.capgemini.capstore.bean.ProductFeedbackBean;

public interface ProductService {
	public List<ProductFeedbackBean> getProductFeedback(int productId);
	
	public double getAverageRating(int productId);

}
