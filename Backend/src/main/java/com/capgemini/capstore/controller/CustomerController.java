package com.capgemini.capstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.capstore.bean.CartBean;
import com.capgemini.capstore.bean.CommonFeedbackBean;
import com.capgemini.capstore.bean.LoginBean;
import com.capgemini.capstore.bean.OrderBean;
import com.capgemini.capstore.bean.ProductFeedbackBean;
import com.capgemini.capstore.bean.WishlistBean;
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

	@PostMapping(path = "/insertProductFeedback")
	public CapstoreResponse insertProductFeedback(@RequestBody ProductFeedbackBean productFeedbackBean) {
		CapstoreResponse response = new CapstoreResponse();
		boolean result = customerService.insertProductFeedback(productFeedbackBean);
		if (result) {
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
	
	@GetMapping(path = "/viewprofile")
	public CapstoreResponse viewprofile(@RequestParam String email) {

		LoginBean loginbean = customerService.viewprofile(email);
		CapstoreResponse capstoreResponse = new CapstoreResponse();
		if (loginbean != null) {
			capstoreResponse.setStatusCode(210);
			capstoreResponse.setMessage("success");
			capstoreResponse.setDescription("Customer details are...");
			capstoreResponse.setLoginbean(loginbean);

		} else {
			capstoreResponse.setStatusCode(401);
			capstoreResponse.setMessage("Failed");
			capstoreResponse.setDescription("unable to fetch the  profile!!!");
		}
		return capstoreResponse;
	}

	@PostMapping("/updateProfile")
	public CapstoreResponse updateProfile(@RequestBody LoginBean loginBean) {
		CapstoreResponse capstoreResponse = new CapstoreResponse();
		customerService.updateProfile(loginBean);
		if (loginBean != null) {
			capstoreResponse.setStatusCode(210);
			capstoreResponse.setMessage("sucess");
			capstoreResponse.setDescription("Information Updated Successfully");
		} else {
			capstoreResponse.setStatusCode(401);
			capstoreResponse.setMessage("failed");
			capstoreResponse.setDescription("Unable to update profile");
		}
		return capstoreResponse;
	}

	@GetMapping(path = "/viewcart")
	public CapstoreResponse viewCart(@RequestParam String email) {
		CapstoreResponse capstoreResponse = new CapstoreResponse();
		List<CartBean> cartList = customerService.getCartList(email);
		if (cartList != null && !cartList.isEmpty()) {
			capstoreResponse.setStatusCode(200);
			capstoreResponse.setMessage("Success");
			capstoreResponse.setDescription("cartlist displayed");
			capstoreResponse.setCartList(cartList);
		} else {
			throw new CapstoreException("cartList can't be fetched");
		}
		return capstoreResponse;
	}

	@GetMapping(path = "/viewWishlist")
	public CapstoreResponse viewWishlist(@RequestParam String email) {
		CapstoreResponse capstoreResponse = new CapstoreResponse();
		List<WishlistBean> wishlist = customerService.getWishlist(email);
		if (wishlist != null && !wishlist.isEmpty()) {
			capstoreResponse.setStatusCode(200);
			capstoreResponse.setMessage("Success");
			capstoreResponse.setDescription("wishlist displayed");
			capstoreResponse.setWishlist(wishlist);
		} else {
			throw new CapstoreException("wishlist can't be fetched");
		}
		return capstoreResponse;
	}


}
