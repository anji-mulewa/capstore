package com.capgemini.capstore.response;

import java.util.List;

import com.capgemini.capstore.bean.CommonFeedbackBean;
import com.capgemini.capstore.bean.OrderBean;
import com.capgemini.capstore.bean.OrderHistoryBean;
import com.capgemini.capstore.bean.ProductFeedbackBean;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CapstoreResponse {

	private int statusCode;
	private String message;
	private String description;
	private List<CommonFeedbackBean> commonFeedbackList;
	private List<ProductFeedbackBean> productFeedbackList;
	private List<OrderBean> orderList;
	private List<OrderHistoryBean> orderhistorybean;
	private double averageRating;

	
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<CommonFeedbackBean> getCommonFeedbackList() {
		return commonFeedbackList;
	}
	public void setCommonFeedbackList(List<CommonFeedbackBean> commonFeedbackList) {
		this.commonFeedbackList = commonFeedbackList;
	}
	public List<ProductFeedbackBean> getProductFeedbackList() {
		return productFeedbackList;
	}
	public void setProductFeedbackList(List<ProductFeedbackBean> productFeedbackList) {
		this.productFeedbackList = productFeedbackList;
	}
	public List<OrderBean> getOrderList() {
		return orderList;
	}
	public void setOrderList(List<OrderBean> orderList) {
		this.orderList = orderList;
	}
	public List<OrderHistoryBean> getOrderhistorybean() {
		return orderhistorybean;
	}
	public void setOrderhistorybean(List<OrderHistoryBean> orderhistorybean) {
		this.orderhistorybean = orderhistorybean;
	}
	public double getAverageRating() {
		return averageRating;
	}
	public void setAverageRating(double averageRating) {
		this.averageRating = averageRating;
	}

	
	
}