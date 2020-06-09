package com.capgemini.capstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.capstore.bean.ProductFeedbackBean;
import com.capgemini.capstore.exception.CapstoreException;
import com.capgemini.capstore.response.CapstoreResponse;
import com.capgemini.capstore.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	private ProductService productService;

	@GetMapping(path = "/getProductFeedbackList")
	public CapstoreResponse getProductFeedbackList(@RequestParam int productId) {
		CapstoreResponse response = new CapstoreResponse();
		List<ProductFeedbackBean> productFeedbackList = productService.getProductFeedback(productId);
		if (productFeedbackList != null && !productFeedbackList.isEmpty()) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setDescription("Product feedback list displayed");
			response.setProductFeedbackList(productFeedbackList);
		} else {
			throw new CapstoreException("The feedbacks can't be displayed");
		}
		return response;
	}

	@GetMapping(path="/getAverageRating")
	public CapstoreResponse getAverageRating(@RequestParam int productId) {
		CapstoreResponse response = new CapstoreResponse();
		Double averageRating = productService.getAverageRating(productId);
		response.setStatusCode(200);
		response.setMessage("Success");
		response.setDescription("Product average rating displayed");
		response.setAverageRating(averageRating);
		return response;
	}
}
