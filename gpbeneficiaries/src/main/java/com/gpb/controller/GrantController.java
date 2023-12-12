package com.gpb.controller;

import com.gpb.form.GrantApplicationForm;
import com.gpb.service.GrantService;

public class GrantController {
	private GrantService grantService;
	public GrantController(GrantService grantService) {
		this.grantService = grantService;
	}
	public int applyGrant(GrantApplicationForm applicationForm) {
		int grantApplicationNo = 0;
		grantApplicationNo = grantService.applyForGrant(applicationForm);
		return grantApplicationNo;
	}
}
