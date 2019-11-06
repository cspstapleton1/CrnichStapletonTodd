package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Form;

public interface FormDao {
	public List<Form> getAllForms() throws SQLException;
	public Form getFormById(int id) throws SQLException;
	public void insertForm(Form form) throws SQLException;
}
