package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.BenefitsCoordinator;
import com.revature.beans.Employee;
import com.revature.beans.Supervisor;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In doPost");
		Employee e = new Employee();
		Supervisor s = new Supervisor();
		BenefitsCoordinator bc = new BenefitsCoordinator();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		ObjectMapper mapper = new ObjectMapper();
		
		e = mapper.readValue(request.getInputStream(), Employee.class);
		System.out.println("Pre login: " + e.toString());
		s.setUser(e.getUser());
		s.setPw(e.getPw());
		System.out.println("Pre login: " + s.toString());
		bc.setUser(e.getUser());
		bc.setPw(e.getPw());
		System.out.println("Pre login: " + bc.toString() +"\n");

		e = ServletMethods.loginEmployee(e.getUser(), e.getPw());
		s = ServletMethods.loginSupervisor(s.getUser(), s.getPw());
		bc = ServletMethods.loginBC(bc.getUser(), bc.getPw());
		
		System.out.println("Post login: " + e.toString());
		System.out.println("Post login: " + s.toString());
		System.out.println("Post login: " + bc.toString());
		
		//If attempt did not match login credentials of any type of employee, redirect to login page 
		if (e.getUser() != null) {
			HttpSession session = request.getSession(true);
			ServletMethods.setEmployeeCredentials(e, session);
			response.sendRedirect("apps.html");
			
//			request.getRequestDispatcher("apps.html").forward(request, response);
		} 
		//If login credentials matched a supervisor, instantiate supervisor session credentials
		 else if(s.getUser() != null){
			 HttpSession session = request.getSession();
			 s = ServletMethods.getSupervisor(s);
			 ServletMethods.setSupervisorCredentials(s, session);
			 response.sendRedirect("apps.html");
		}
		//If login credentials match a benefits coordinator, instantiate bc session credentials
		  else if(bc.getUser() != null) {
			HttpSession session = request.getSession();
			bc =  ServletMethods.getBC(bc);
			ServletMethods.setBCCredentials(bc, session);
			response.sendRedirect("apps.html");
		}
		//If login credentials match an employee, instantiate employee session credentials
		   else {
				out.print("<p>Incorrect login credentials. Please try again.</p>");
				request.getRequestDispatcher("login.html").forward(request, response);
		}
		out.close();
	}// End of method doPost

}//End of Servlet Login 
