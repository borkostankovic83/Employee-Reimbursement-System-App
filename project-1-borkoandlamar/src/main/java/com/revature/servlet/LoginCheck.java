package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.repositories.EmployeeDao;
import com.revature.repositories.EmployeeDaoJDBC;

public class LoginCheck extends HttpServlet {
	
	 static String currentEmployee;

	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EmployeeDao employeeDao = new EmployeeDaoJDBC();
		String userName = req.getParameter("emp_username");
		String password = req.getParameter("emp_password");
		String submitType = req.getParameter("submit");
		if (employeeDao.getEmployee(userName, password) != null) {
			resp.sendRedirect("employee.html");
	            	  							    	  						
	      } else {
	    	  resp.sendRedirect("error.jsp");
	    	 			
		  }
	}
}
