package com.revature.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Form;
import com.revature.dao.FormDao;
import com.revature.util.ConnFactory;

public class FormDaoImpl implements FormDao{
	ConnFactory cf = ConnFactory.getInstance();

	public List<Form> getAllForms() throws SQLException {
		List<Form> forms = new ArrayList<Form>();
		Form f = null;
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		//Query all forms and return list
		ResultSet rs = stmt.executeQuery("select * from trms.form");
		while(rs.next()) {
			f = new Form(rs.getInt(1), rs.getBoolean(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),
						 rs.getDate(5), rs.getDate(6), rs.getTime(7), rs.getTime(8), rs.getString(9), rs.getString(10),
						 rs.getDouble(11), rs.getDouble(12), rs.getBoolean(13), rs.getInt(14), rs.getInt(15),
						 rs.getInt(16)
						 );
			forms.add(f);
		}
		return forms;
	}//End of method getAllForms

	public Form getFormById(int id) throws SQLException {
		//Declare connection fields
		Form form = null;
		Connection conn = cf.getConnection();
		String sql = "select from trms.form where form_id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		
		//Query specific form by form_id and return
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			form = new Form(rs.getInt(1), rs.getBoolean(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),
					 rs.getDate(7), rs.getDate(8), rs.getTime(9), rs.getTime(10), rs.getString(11), rs.getString(12),
					 rs.getDouble(13), rs.getDouble(14), rs.getBoolean(15), rs.getInt(16), rs.getInt(17),
					 rs.getInt(18)
					 );
		}
		return form;
	}//End of method getFormById

	public void insertForm(Form form) throws SQLException {
		//Declare connection fields
		Connection conn = cf.getConnection();
		String sql = "insert into trms.form values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		//Set all form values except form_id since form_id is handled by database sequence
		ps.setBoolean(1, form.isUrgent());
		ps.setString(2, form.getEvent_type());
		ps.setString(3, form.getfName());
		ps.setString(4, form.getlName());
		ps.setString(5, form.getDept());
		ps.setDate(6, form.geteDate());
		ps.setDate(7, form.geteDate());
		ps.setTime(8, form.geteTime());
		ps.setTime(9, form.geteTime());
		ps.setString(10, form.getGradeFormat());
		ps.setString(11, form.getGradeCutoff());
		ps.setDouble(12, form.getCost());
		ps.setDouble(13, form.getReimbursement());
		ps.setBoolean(14, form.isPresentation());
		ps.setInt(15, form.getsAccept());
		ps.setInt(16, form.getDhAccept());
		ps.setInt(17, form.getBcAccept());
		ps.execute();
		
		//commit the database changes
		ps = conn.prepareStatement("commit");
		ps.execute();
		
	}//End of method insertForm

	public void updateForm(int form_id, String acceptType, int result) throws SQLException {
		//Declare connection variables
		Connection conn = cf.getConnection();
		String sql = "update trms.form set ? = ? where form_id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		//Set updated form values and update database
		ps.setInt(1, form_id);
		ps.setString(2, acceptType);
		ps.setInt(3, result);
		ps.execute();
		
		//Commit database changes
		ps = conn.prepareStatement("commit");
		ps.execute();
		
	}//End of method updateForm
	
}//End of Class FormDaoImpl