package com.revature.dao;

import java.sql.SQLException;

import com.revature.beans.BenefitsCoordinator;

public interface BCDao {
	public BenefitsCoordinator login(String user, String pw) throws SQLException;
	public BenefitsCoordinator getBcByUser(String user) throws SQLException;
	public BenefitsCoordinator getBenefitsCoordinator() throws SQLException;
}
