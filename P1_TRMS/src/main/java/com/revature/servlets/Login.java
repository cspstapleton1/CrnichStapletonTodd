package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.BenefitsCoordinator;
import com.revature.beans.Employee;
import com.revature.beans.Supervisor;
import com.revature.daoImpl.BCDaoImpl;
import com.revature.daoImpl.EmployeeDaoImpl;
import com.revature.daoImpl.SupervisorDaoImpl;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init() throws ServletException{
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("In doPost");
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		SupervisorDaoImpl sdi = new SupervisorDaoImpl();
		BCDaoImpl bcdi = new BCDaoImpl();
		Employee e = null;
		Supervisor s = null;
		BenefitsCoordinator bc = null;
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//request.getRequestDispatcher("forms.html").include(request, response);
		
		String name = request.getParameter("user");
		String password = request.getParameter("pw");

		//Set login credentials. Only one of the three objects should return accurate login credentials
		try {
			e = edi.login(name, password);
			s = sdi.login(name, password);
			bc = bcdi.login(name, password);
			//If employee object 
			if (e.getUser() != null) {
				HttpSession session = request.getSession();
				e = edi.getEmployeeById(e.getEmp_id());
				session.setAttribute("usertype", "employee");
				session.setAttribute("username", name);
				session.setAttribute("Reimbursements", e.getTotalReimbursements());
				session.setAttribute("id", e.getEmp_id());
				session.setAttribute("lName", e.getlName());
				session.setAttribute("fName", e.getfName());
				session.setAttribute("Dept", e.getDeptName());
				response.sendRedirect("forms");
				request.getRequestDispatcher("forms.html").forward(request, response);
			} 
			 else if(s.getUser() != null){
				HttpSession session = request.getSession();
				s = sdi.getSupervisorByUser(s.getUser());
				session.setAttribute("usertype", "Manager");
				session.setAttribute("username", name);
				session.setAttribute("Reimbursements", e.getTotalReimbursements());
				session.setAttribute("id", e.getEmp_id());
				session.setAttribute("lName", e.getlName());
				session.setAttribute("fName", e.getfName());
				session.setAttribute("Dept", e.getDeptName());
				response.sendRedirect("forms");
				request.getRequestDispatcher("forms.html").forward(request, response);
			}
			  else if(bc.getUser() != null) {
				HttpSession session = request.getSession();
				bc = bcdi.getBcByUser(bc.getUser());
				session.setAttribute("usertype", "chairman");
				session.setAttribute("username", name);
				session.setAttribute("Reimbursements", e.getTotalReimbursements());
				session.setAttribute("id", e.getEmp_id());
				session.setAttribute("lName", e.getlName());
				session.setAttribute("fName", e.getfName());
				session.setAttribute("Dept", e.getDeptName());
				response.sendRedirect("forms");
			}
			   else {
				out.print("Incorrect login credentials. Please try again.");
				request.getRequestDispatcher("login.html").forward(request, response);
			}
			out.close();
		} catch (SQLException e1) {
			System.out.println("You broke it. Try again");
			e1.printStackTrace();
		}
	}// End of method doPost

}//End of Servlet Login 
