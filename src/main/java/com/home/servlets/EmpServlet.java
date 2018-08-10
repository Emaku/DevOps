package com.home.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.home.reimbursement.DaoServices;
import com.home.reimbursement.Member;

/**
 * Servlet implementation class EmpServlet
 */
public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmpServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		DaoServices service = new DaoServices();
		Member m = service.getMember(service.currentUser);

	
		
			service.updateMember(request.getParameter("newUname"), request.getParameter("newPw"), request.getParameter("newEmail"), m.getMid());
			service.writeToJsonFile(service.getJson(m.getMid()));
//			response.setStatus(response.SC_MOVED_TEMPORARILY);
//			System.out.println("Moving to EmployeeHome");
//			response.setHeader("Location", "EmployeeHome.html");
		
			
		
		

//		response.setStatus(response.SC_MOVED_TEMPORARILY);
//		response.setHeader("Location", "EmployeeHome.html");
	}

	public String createTableData(String s) {
		return "<td>" + s + "/td";
	}

	public String createTableData(int i) {
		return "<td>" + i + "/td";
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
