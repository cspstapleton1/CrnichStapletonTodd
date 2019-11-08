package com.revature.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.beans.Supervisor;
import com.revature.dao.SupervisorDao;
import com.revature.util.ConnFactory;

public class SupervisorDaoImpl implements SupervisorDao {
	ConnFactory cf = ConnFactory.getInstance();

	@Override
	public Supervisor login(String user, String pw) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "select sup_id, username, pw " 
					+"from trms.supervisor " 
					+"where username = ? and pw = ?";
		PreparedStatement ps = conn.prepareStatement(sql);

		ps.setString(1, user);
		ps.setString(2, pw);
		ResultSet rs = ps.executeQuery();
		Supervisor s = null;
		while (rs.next()) {
			s = new Supervisor();
			s.setSup_id(rs.getInt(1));
			s.setUser(rs.getString(2));
			s.setPw(rs.getString(3));
		}
		return s;
	}// End of method login

	@Override
	public Supervisor getSupervisorByUser(String user) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "select from trms.supervisor " 
					+"where username = ?";
		PreparedStatement ps = conn.prepareStatement(sql);

		ps.setString(1, user);
		ResultSet rs = ps.executeQuery();
		Supervisor s = null;
		while (rs.next()) {
			s = new Supervisor(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
					rs.getString(6), rs.getBoolean(7));
		}
		return s;
	}// End of method getSupervisorByUser

	@Override
	// Return the name of the head of a given department
	public Supervisor getDeptHead(String dept) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "select fname, lname" 
					+" from trms.supervisor" 
					+" where deptname = ? and isdepthead = true";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, dept);
		ResultSet rs = ps.executeQuery();
		Supervisor s = null;
		while (rs.next()) {
			s = new Supervisor();
			s.setfName(rs.getString(1));
			s.setlName(rs.getString(2));
		}
		return s;
	}// End of method getDeptHead

}// End of Class SupervisorDaoImpl
