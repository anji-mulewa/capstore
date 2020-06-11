package com.capgemini.capstore.test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.capstore.bean.CommonFeedbackBean;
import com.capgemini.capstore.dao.MerchantDao;

@SpringBootTest
public class MerchantTest {

	@Autowired
	private MerchantDao merchantDao;
	
	@Test
	public void testGetCommonFeedbackList() {
		CommonFeedbackBean commonFeedbackBean = new CommonFeedbackBean();
		commonFeedbackBean.setEmail("yashpatil@gmail.com");
		assertEquals("yashpatil@gmail.com", commonFeedbackBean.getEmail());
	}

}

