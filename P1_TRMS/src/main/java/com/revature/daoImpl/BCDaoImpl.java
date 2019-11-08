package com.revature.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.beans.BenefitsCoordinator;
import com.revature.dao.BCDao;
import com.revature.util.ConnFactory;

public class BCDaoImpl implements BCDao {
	ConnFactory cf = ConnFactory.getInstance();

	@Override
	public BenefitsCoordinator login(String user, String pw) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "select bc_id, username, pw" 
					+"from trms.benefits_coordinator"
					+"where username = ? and password = ?";
		PreparedStatement ps = conn.prepareStatement(sql);

		ps.setString(1, user);
		ps.setString(2, pw);
		ResultSet rs = ps.executeQuery();
		BenefitsCoordinator bc = null;
		while (rs.next()) {
			bc = new BenefitsCoordinator();
			bc.setBc_id(rs.getInt(1));
			bc.setUser(rs.getString(2));
			bc.setPw(rs.getString(3));
		}
		return bc;
	}

	@Override
	public BenefitsCoordinator getBcByUser(String user) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "select from trms.benefits_coordinator" 
					+"where user = ?";
		PreparedStatement ps = conn.prepareStatement(sql);

		ps.setString(1, user);
		ResultSet rs = ps.executeQuery();
		BenefitsCoordinator bc = null;
		while (rs.next()) {
			bc = new BenefitsCoordinator(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getString(5));
		}
		return bc;
	}

	// Return the benefits coordinator (should only be one)
	public BenefitsCoordinator getBenefitsCoordinator() throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "select fname, lname" 
					+"from trms.benefits_coordinator";
		PreparedStatement ps = conn.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();
		BenefitsCoordinator bc = null;
		while (rs.next()) {
			bc = new BenefitsCoordinator();
			bc.setfName(rs.getString(1));
			bc.setlName(rs.getString(2));
		}
		return bc;
	}

}
