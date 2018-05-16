package com.bunfly.test;

import static org.junit.Assert.*;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bunfly.model.Merchant;
import com.bunfly.service.impl.MerchantServiceImpl;

public class TestClass {

	
	@Test
	public void test() {
		Merchant mer = new Merchant();
		mer.setUsername("123");
		ApplicationContext ap = new ClassPathXmlApplicationContext("applicationcontext.xml");
		MerchantServiceImpl mer1 = (MerchantServiceImpl) ap.getBean("merchantServiceImpl");
		mer1.selectByName(mer);
	}

}
