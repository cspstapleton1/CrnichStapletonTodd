package com.revature.daoImpl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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

public class FormDaoImpl implements FormDao {
	ConnFactory cf = ConnFactory.getInstance();

	public List<Form> getAllForms() throws SQLException {
		List<Form> forms = new ArrayList<Form>();
		Form f = null;
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		// Query all forms and return list
		ResultSet rs = stmt.executeQuery("select * from trms.form");
		while (rs.next()) {
			f = new Form(rs.getInt(1), rs.getBoolean(2), rs.getString(3), rs.getString(4), rs.getString(5),
						 rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getDate(10),
						 rs.getDate(11), rs.getTime(12), rs.getTime(13), rs.getString(14), rs.getString(15), 
						 rs.getDouble(16), rs.getDouble(17), rs.getBoolean(18), rs.getInt(19), rs.getInt(20),
						 rs.getInt(21), rs.getString(22));
			forms.add(f);
		}
		return forms;
	}// End of method getAllForms

	public Form getFormById(int id) throws SQLException {
		// Declare connection fields
		Form form = null;
		Connection conn = cf.getConnection();
		String sql = "select from trms.form where form_id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);

		// Query specific form by form_id and return
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			form = new Form(rs.getInt(1), rs.getBoolean(2), rs.getString(3), rs.getString(4), rs.getString(5),
					 rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getDate(10),
					 rs.getDate(11), rs.getTime(12), rs.getTime(13), rs.getString(14), rs.getString(15), 
					 rs.getDouble(16), rs.getDouble(17), rs.getBoolean(18), rs.getInt(19), rs.getInt(20),
					 rs.getInt(21), rs.getString(22));
		}
		return form;
	}// End of method getFormById

	public void insertForm(Form form) throws SQLException {
		// Declare connection fields
		Connection conn = cf.getConnection();
		PreparedStatement ps = null;

		// First, insert the basic form information into the database
		String sql = "insert into trms.form(urgent, event_type, first_name, last_name, department,"
					+" email, loc, justification,"
					+" start_date, end_date, start_time, end_time, grade_format,"
					+" grade_cutoff, costs, reimbursement, presentation)"
					+" values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		ps = conn.prepareStatement(sql);

		// Set all form values except form_id since form_id is handled by database sequence 
		ps.setBoolean(1, form.isUrgent());
		ps.setString(2, form.getEvent_type());
		ps.setString(3, form.getfName());
		ps.setString(4, form.getlName());
		ps.setString(5, form.getDept());
		ps.setString(6, form.getEmail());
		ps.setString(7, form.getLocation());
		ps.setString(8, form.getJustification());
		ps.setDate(9, form.geteDate());
		ps.setDate(10, form.geteDate());
		ps.setTime(11, form.geteTime());
		ps.setTime(12, form.geteTime());
		ps.setString(13, form.getGradeFormat());
		ps.setString(14, form.getGradeCutoff());
		ps.setDouble(15, form.getCost());
		ps.setDouble(16, form.getReimbursement());
		ps.setBoolean(17, form.isPresentation());

		ps.execute();

		// If user attached a file to the form, instantiate input stream and send
		// the file to the database. On database, form.filename references file.filename
		if (form.getAttachment() != null) {
			try {
				FileInputStream fis = new FileInputStream(form.getAttachment());
				ps = conn.prepareStatement("insert into file values(?, ?");
				ps.setString(1, form.getAttachment().getName());
				ps.setBinaryStream(2, fis, form.getAttachment().length());
				ps.executeUpdate();
				fis.close();
			} catch (FileNotFoundException e) {
				System.out.println("Burning files in fio... try again");
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("How did you burn the IO? Try again...");
				e.printStackTrace();
			}
		}

		// commit the database changes
		ps = conn.prepareStatement("commit");
		ps.execute();

	}// End of method insertForm

	public void acceptForm(int form_id, String acceptType, int result) throws SQLException {
		// Declare connection variables
		Connection conn = cf.getConnection();
		String sql = "update trms.form set ? = ? where form_id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);

		// Set updated form values and update database
		ps.setString(1, acceptType);
		ps.setInt(2, result);
		ps.setInt(3, form_id);
		ps.execute();

		// Commit database changes
		ps = conn.prepareStatement("commit");
		ps.execute();

	}// End of method updateForm

	public void failForm(int form_id, String acceptType, int result, String failDesc) throws SQLException {
		// Declare connection variables
		Connection conn = cf.getConnection();
		String sql = "update trms.form set ? = ?, fail_desc = ? where form_id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);

		// Set updated form values and update database
		ps.setString(1, acceptType);
		ps.setInt(2, result);
		ps.setString(3, failDesc);
		ps.setInt(4, form_id);
		ps.execute();

		// Commit database changes
		ps = conn.prepareStatement("commit");
		ps.execute();
	}

}// End of Class FormDaoImpl