package com.capgemini.capstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.capstore.bean.ProductFeedbackBean;
import com.capgemini.capstore.dao.ProductDao;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;

	@Override
	public List<ProductFeedbackBean> getProductFeedback(int productId) {
		return productDao.getProductFeedback(productId);
	}

	@Override
	public double getAverageRating(int productId) {
		return productDao.getAverageRating(productId);
	}

}
