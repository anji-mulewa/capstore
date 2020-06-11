package com.capgemini.capstore.test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.capstore.bean.ProductFeedbackBean;
import com.capgemini.capstore.dao.ProductDao;

@SpringBootTest
public class ProductTest {

	@Autowired
	private ProductDao productDao;

	@Test
	public void testGetProductFeedback() {
		ProductFeedbackBean productFeedbackBean = new ProductFeedbackBean();
		productFeedbackBean.setProductId(2349);
		assertEquals("2349", productFeedbackBean.getProductId());
	}
}
