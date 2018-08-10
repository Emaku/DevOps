package com.home.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.home.reimbursement.DaoServices;
import com.home.reimbursement.Member;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

/**
 * Servlet implementation class MyServlet
 */
public class MyServlet extends HttpServlet {
	DaoServices service = new DaoServices();

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MyServlet() {
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
		
//		HttpSession session = request.getSession();
		

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		//Test User
//		String username = "RAYLLEN";
//		String password = "DaggerChamp";

	
//		String username = "BWilliams";
//		String password = "BWill";

		Member m = service.login(username, password);
		if (m != null) {

//
			request.setAttribute("myUsername", username);
			request.setAttribute("myPassword", password);
			
			String s = (String) request.getAttribute("myUsername");
//			System.out.println(s);
			
//			session.setAttribute("sessionUsername", username);

			if (m.getMemStatus().equalsIgnoreCase("Employee")) {
				response.setStatus(response.SC_MOVED_TEMPORARILY);
				System.out.println("Moving to EmployeeHome");
				response.setHeader("Location", "EmployeeHome.html");
				service.writeToJsonFile(service.getJson(m.getMid()));
				System.out.println(service.getJson(m.getMid()));
//				RequestDispatcher r = request.getRequestDispatcher("EmpServlet");
//				r.forward(request, response);
				

			} else {
				response.setStatus(response.SC_MOVED_TEMPORARILY);
				System.out.println("Moving to ManagerHome");
				response.setHeader("Location", "ManagerHome.html");
				service.writeToJsonFile(service.getJson(m.getMid()));
				System.out.println(service.getJson(m.getMid()));
//				RequestDispatcher r = request.getRequestDispatcher("ManagerServlet");
//				r.forward(request, response);

			}
		} else {
			response.getWriter().println("Something went wrong");
		}
		System.out.println("Still Here");
		
//		response.setContentType("text/html");
		
//		response.getWriter().println("<script type = 'text/javascript'> console.log('Coming From Java'); </script><h2>Hell</h2>");

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
