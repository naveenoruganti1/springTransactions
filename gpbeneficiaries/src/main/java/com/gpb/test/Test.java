package com.gpb.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gpb.controller.GrantController;
import com.gpb.form.GrantApplicationForm;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		GrantController grantController = context.getBean("grantController",GrantController.class);
		GrantApplicationForm applicationForm = new GrantApplicationForm();
		applicationForm.setAadharNo("44324523432");
		applicationForm.setBeneficiaryName("Michael");
		applicationForm.setDob("01/04/1998");
		applicationForm.setEmailAddress("michael@gmail.com");
		applicationForm.setGender("Male");
		applicationForm.setGrantAmount(124295);
		applicationForm.setGrantType("Housing Loan");
		applicationForm.setMobileNo("8375299593");
		applicationForm.setTenure(20);
		int grantAppNo = grantController.applyGrant(applicationForm);
		System.out.println(grantAppNo);
	}
}
