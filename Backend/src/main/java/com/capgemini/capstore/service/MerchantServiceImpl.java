package com.capgemini.capstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.capstore.bean.CommonFeedbackBean;
import com.capgemini.capstore.dao.MerchantDao;

@Service
public class MerchantServiceImpl implements MerchantService {

	@Autowired
	private MerchantDao merchantDao;

	@Override
	public List<CommonFeedbackBean> getCommonFeedbackList(String email) {
		return merchantDao.getCommonFeedbackList(email);
	}
	
	
}
