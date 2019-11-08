package com.revature.dao;

import java.sql.SQLException;

import com.revature.beans.Supervisor;

public interface SupervisorDao {
	public Supervisor login(String user, String pw) throws SQLException;
	public Supervisor getSupervisorByUser(String user) throws SQLException;
	public Supervisor getDeptHead(String dept) throws SQLException;
}
