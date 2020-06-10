package com.capgemini.capstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.capstore.bean.CommonFeedbackBean;
import com.capgemini.capstore.bean.OrderBean;
import com.capgemini.capstore.bean.OrderHistoryBean;
import com.capgemini.capstore.bean.ProductFeedbackBean;
import com.capgemini.capstore.exception.CapstoreException;
import com.capgemini.capstore.response.CapstoreResponse;
import com.capgemini.capstore.service.CustomerService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@PostMapping(path = "/insertCommonFeedback")
	public CapstoreResponse insertCommonFeedback(@RequestBody CommonFeedbackBean commonFeedbackBean) {
		CapstoreResponse response = new CapstoreResponse();
		boolean result = customerService.insertCommonFeedback(commonFeedbackBean);
		if (result) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setDescription("Feedback added successfully!");
		} else {
			throw new CapstoreException("Feedback can't be added :(");
		}
		return response;
	}
	
	@PostMapping(path="/insertProductFeedback")
	public CapstoreResponse insertProductFeedback(@RequestBody ProductFeedbackBean productFeedbackBean){
		CapstoreResponse response = new CapstoreResponse();
		boolean result = customerService.insertProductFeedback(productFeedbackBean);
		if(result) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setDescription("Common feedback list displayed");
		} else {
			throw new CapstoreException("Feedback can't be added");
		}
		return response;
	}
	
	@GetMapping("/orderdetails")
	public CapstoreResponse orderdetails(@RequestParam String email) {
		List<OrderBean> orderList = customerService.orderdetails(email);
		CapstoreResponse capstoreResponse = new CapstoreResponse();
		capstoreResponse.setStatusCode(210);
		capstoreResponse.setMessage("success");
		capstoreResponse.setDescription("OrderList Found SuccessFul");
		capstoreResponse.setOrderList(orderList);
		return capstoreResponse;
	}
	
	@GetMapping("/orderHistory")
	public CapstoreResponse orderHistory(@RequestParam String email) {
		List<OrderHistoryBean> orderList = customerService.orderHistory(email);
		CapstoreResponse capstoreResponse = new CapstoreResponse();
		capstoreResponse.setStatusCode(210);
		capstoreResponse.setMessage("success");
		capstoreResponse.setDescription("OrderList Found SuccessFul");
		capstoreResponse.setOrderhistorybean(orderList);
		return capstoreResponse;
	}

}
