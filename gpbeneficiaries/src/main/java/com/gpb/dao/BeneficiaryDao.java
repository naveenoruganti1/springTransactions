package com.gpb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.gpb.bo.BeneficiaryBo;

public class BeneficiaryDao {
	private static final String SQL_SAVE_BENEFICIARY ="insert into beneficiary(beneficiary_nm,aadhar_no,dob,gender,mobile_no,email_address) values(?,?,?,?,?,?)";
	private JdbcTemplate jdbcTemplate;
	
	public BeneficiaryDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int saveBeneficiary(BeneficiaryBo beneficiaryBo) {
		int beneficiaryNo = 0;
		KeyHolder kh = null;
		
		kh= new GeneratedKeyHolder();
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = null;
				pstmt = con.prepareStatement(SQL_SAVE_BENEFICIARY, new String[] {"beneficiarty_no"});
				pstmt.setString(1, beneficiaryBo.getBeneficiaryName());
				pstmt.setString(2, beneficiaryBo.getAadharNo());
				pstmt.setString(3, beneficiaryBo.getDob());
				pstmt.setString(4, beneficiaryBo.getGender());
				pstmt.setString(5, beneficiaryBo.getMobileNo());
				pstmt.setString(6, beneficiaryBo.getEmailAddress());
				return pstmt;
			}
		},kh);
		beneficiaryNo = kh.getKey().intValue();
		return beneficiaryNo;
	}
}
