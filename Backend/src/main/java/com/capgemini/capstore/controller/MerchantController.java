package com.capgemini.capstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.capstore.bean.CommonFeedbackBean;
import com.capgemini.capstore.exception.CapstoreException;
import com.capgemini.capstore.response.CapstoreResponse;
import com.capgemini.capstore.service.MerchantService;

@RestController
public class MerchantController {

	@Autowired
	private MerchantService merchantService;
	
	@GetMapping(path = "/getCommonFeedback")
	public CapstoreResponse getCommonFeedback(@RequestParam String email) {
		CapstoreResponse response = new CapstoreResponse();
		List<CommonFeedbackBean> commonFeedbackList = merchantService.getCommonFeedbackList(email);
		if (commonFeedbackList != null && !commonFeedbackList.isEmpty()) {
			response.setStatusCode(200);
			response.setMessage("Success");
			response.setDescription("Common feedback list displayed");
			response.setCommonFeedbackList(commonFeedbackList);
		} else {
			throw new CapstoreException("The feedbacks can't be displayed");
		}
		return response;
	}

}
