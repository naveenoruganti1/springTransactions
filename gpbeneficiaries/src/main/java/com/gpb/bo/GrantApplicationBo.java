package com.gpb.bo;

import java.util.Date;

public class GrantApplicationBo {
	private int beneficiaryNo;
	private String grantType;
	private Date appliedDate;
	private float grantAmount;
	private int tenure;
	private float intrestRate;

	public int getBeneficiaryNo() {
		return beneficiaryNo;
	}
	public void setBeneficiaryNo(int beneficiaryNo) {
		this.beneficiaryNo = beneficiaryNo;
	}
	public String getGrantType() {
		return grantType;
	}
	public void setGrantType(String grantType) {
		this.grantType = grantType;
	}
	public Date getAppliedDate() {
		return appliedDate;
	}
	public void setAppliedDate(Date appliedDate) {
		this.appliedDate = appliedDate;
	}
	public float getGrantAmount() {
		return grantAmount;
	}
	public void setGrantAmount(float grantAmount) {
		this.grantAmount = grantAmount;
	}
	public int getTenure() {
		return tenure;
	}
	public void setTenure(int tenure) {
		this.tenure = tenure;
	}
	public float getIntrestRate() {
		return intrestRate;
	}
	public void setIntrestRate(float intrestRate) {
		this.intrestRate = intrestRate;
	}
}
