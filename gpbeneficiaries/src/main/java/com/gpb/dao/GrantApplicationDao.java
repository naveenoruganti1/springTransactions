package com.gpb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.gpb.bo.GrantApplicationBo;

public class GrantApplicationDao {
	private static final String SQL_SAVE_GRANT_APPLICATION = "insert into grant_application(beneficiary_no, grant_type,applied_date,grant_amount,tenure,interest_rate) values(?,?,?,?,?,?)";
	private JdbcTemplate jdbcTemplate;
	
	public GrantApplicationDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int saveGrantApplication(GrantApplicationBo grantApplicationBo) {
		int grantApplicationNo =0;
		KeyHolder kh = null;
		
		kh= new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = null;
				pstmt = con.prepareStatement(SQL_SAVE_GRANT_APPLICATION, new String[] {"grant_application_no"});
				pstmt.setInt(1, grantApplicationBo.getBeneficiaryNo());
				pstmt.setString(2, grantApplicationBo.getGrantType());
				pstmt.setDate(3, new java.sql.Date(grantApplicationBo.getAppliedDate().getTime()));
				pstmt.setFloat(4, grantApplicationBo.getGrantAmount());
				pstmt.setInt(5, grantApplicationBo.getTenure());
				pstmt.setFloat(6, grantApplicationBo.getIntrestRate());
				return pstmt;
			}
		},kh);
		grantApplicationNo = kh.getKey().intValue();
		return grantApplicationNo;
	}
}
