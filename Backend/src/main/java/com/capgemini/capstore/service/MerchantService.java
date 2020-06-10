package com.capgemini.capstore.service;

import java.util.List;

import com.capgemini.capstore.bean.CommonFeedbackBean;

public interface MerchantService {
	public List<CommonFeedbackBean> getCommonFeedbackList(String email);

}
