package com.capgemini.capstore.dao;

import java.util.List;

import com.capgemini.capstore.bean.CommonFeedbackBean;

public interface MerchantDao {
	public List<CommonFeedbackBean> getCommonFeedbackList(String email);
}
