package com.gpb.service;

import java.util.Date;

import com.gpb.bo.BeneficiaryBo;
import com.gpb.bo.GrantApplicationBo;
import com.gpb.dao.BeneficiaryDao;
import com.gpb.dao.GrantApplicationDao;
import com.gpb.form.GrantApplicationForm;

public class GrantService {
	private BeneficiaryDao beneficiaryDao;
	private GrantApplicationDao grantApplicationDao;
	
	public GrantService(BeneficiaryDao beneficiaryDao, GrantApplicationDao grantApplicationDao) {
		this.beneficiaryDao = beneficiaryDao;
		this.grantApplicationDao = grantApplicationDao;
	}

	public int applyForGrant(GrantApplicationForm grantApplicationForm) {
		int grantApplicationNo = 0;
		BeneficiaryBo beneficiaryBo = null;
		int beneficiaryNo =0;
		GrantApplicationBo grantApplicationBo = null;
		
		beneficiaryBo = new BeneficiaryBo();
		beneficiaryBo.setAadharNo(grantApplicationForm.getAadharNo());
		beneficiaryBo.setBeneficiaryName(grantApplicationForm.getBeneficiaryName());
		beneficiaryBo.setDob(grantApplicationForm.getDob());
		beneficiaryBo.setEmailAddress(grantApplicationForm.getEmailAddress());
		beneficiaryBo.setGender(grantApplicationForm.getGender());
		beneficiaryBo.setMobileNo(grantApplicationForm.getMobileNo());
		
		beneficiaryNo = beneficiaryDao.saveBeneficiary(beneficiaryBo);
		
		grantApplicationBo = new GrantApplicationBo();
		grantApplicationBo.setAppliedDate(new Date());
		grantApplicationBo.setBeneficiaryNo(beneficiaryNo);
		grantApplicationBo.setGrantAmount(grantApplicationForm.getGrantAmount());
		grantApplicationBo.setGrantType(grantApplicationForm.getGrantType());
		grantApplicationBo.setIntrestRate(3.2f);
		grantApplicationBo.setTenure(grantApplicationForm.getTenure());
		
		grantApplicationNo = grantApplicationDao.saveGrantApplication(grantApplicationBo);
		return grantApplicationNo;
	}
}
