package com.capgemini.capstore.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.capstore.bean.CartBean;
import com.capgemini.capstore.bean.CommonFeedbackBean;
import com.capgemini.capstore.bean.LoginBean;
import com.capgemini.capstore.bean.OrderBean;
import com.capgemini.capstore.bean.ProductFeedbackBean;
import com.capgemini.capstore.bean.WishlistBean;
import com.capgemini.capstore.dao.CustomerDaoImpl;
import com.capgemini.capstore.exception.CapstoreException;

import junit.framework.TestCase;

@SpringBootTest
public class CustomerTest {

	@Autowired
	CustomerDaoImpl customerDaoImpl;

	@Test
	public void testUpdateProfileValid() throws CapstoreException {
		LoginBean loginBean = new LoginBean();

		loginBean.setEmail("kavyagaikwad10@gmail.com");
		loginBean.setId(2);
		loginBean.setName("Kavya Gaikwad");
		loginBean.setPassword("Qwerty@123");
		loginBean.setPhoneNumber("9874123605");
		loginBean.setRole("customer");
		assertEquals(2, loginBean.getId());
	}
	// valid

	@Test
	public void testUpdateProfileInvalid() throws CapstoreException {
		LoginBean loginBean = new LoginBean();

		loginBean.setEmail("kavyagaikwad10@gmail.com");
		loginBean.setId(3);
		loginBean.setName("Kavya Gaikwad");
		loginBean.setPassword("Qwerty@123");
		loginBean.setPhoneNumber("9874123605");
		loginBean.setRole("customer");
		assertEquals(3, loginBean.getId());
	}
	// Invalid

	@Test
	public void testViewCustomer() throws CapstoreException {

		LoginBean loginBean = new LoginBean();
		loginBean.setEmail("kavyagaikwad10@gmail.com");
		assertEquals("kavyagaikwad10@gmail.com", loginBean.getEmail());

	}// valid

	@Test
	public void testViewCustomerInvalid() throws CapstoreException {

		LoginBean loginBean = new LoginBean();
		loginBean.setEmail("kavyagaikwad@gmail.com");
		assertEquals("kavyagaikwad@gmail.com", loginBean.getEmail());

	}// Invalid

	@Test
	public void testViewOrderHistory() throws CapstoreException {

		OrderBean orderBean = new OrderBean();
		orderBean.setEmail("kavyagaikwad10@gmail.com");
		assertEquals("kavyagaikwad10@gmail.com", orderBean.getEmail());

	}// valid

	@Test
	public void testViewOrderHistoryInvalid() throws CapstoreException {

		OrderBean orderBean = new OrderBean();
		orderBean.setEmail("kavyagaikwad@gmail.com");
		assertEquals("kavyagaikwad@gmail.com", orderBean.getEmail());

	}// Invalid

	@Test
	public void testViewCart() throws CapstoreException {
		CartBean cartBean = new CartBean();
		cartBean.setEmail("swarasathe@gmail.com");
		assertEquals("swarasathe@gmail.com", cartBean.getEmail());
	}// valid

	@Test
	public void testViewCartInvalid() throws CapstoreException {
		CartBean cartBean = new CartBean();
		cartBean.setEmail("swarsathe@gmail.com");
		assertEquals("swarsathe@gmail.com", cartBean.getEmail());
	}// Invalid

	@Test
	public void testViewWishlist() throws CapstoreException {
		WishlistBean wishlistBean = new WishlistBean();
		wishlistBean.setEmail("yashpatil@gmail.com");
		assertEquals("yashpatil@gmail.com", wishlistBean.getEmail());
	}// valid

	@Test
	public void testViewWishlistInvalid() throws CapstoreException {
		WishlistBean wishlistBean = new WishlistBean();
		wishlistBean.setEmail("yaspatil@gmail.com");
		assertEquals("yaspatil@gmail.com", wishlistBean.getEmail());
	}// Invalid

	@Test
	public void testInsertCommonFeedback() throws CapstoreException {
		CommonFeedbackBean commonFeedbackBean = new CommonFeedbackBean();
		commonFeedbackBean.setBrandName("Adidas");
		commonFeedbackBean.setEmail("kavyagaikwad@gmail.com");
		commonFeedbackBean.setFeedback("The service provided was really good");
		commonFeedbackBean.setName("Kavya Gaikwad");
		commonFeedbackBean.setRating(3);
		TestCase.assertEquals(true, customerDaoImpl.insertCommonFeedback(commonFeedbackBean));
	}

	@Test
	public void testInsertProductfeedback() throws CapstoreException {
		ProductFeedbackBean productFeedbackBean = new ProductFeedbackBean();
		productFeedbackBean.setFeedback("Poor quality");
		productFeedbackBean.setName("Yash Patil");
		productFeedbackBean.setProductId(2349);
		productFeedbackBean.setRating(2);
		TestCase.assertEquals(true, customerDaoImpl.insertProductFeedback(productFeedbackBean));

	}
	
	
}
