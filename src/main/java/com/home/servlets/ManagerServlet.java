package com.home.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.home.reimbursement.DaoServices;
import com.home.reimbursement.Member;
import com.home.reimbursement.Reimbursement;

/**
 * Servlet implementation class ManagerServlet
 */
public class ManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DaoServices service = new DaoServices();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManagerServlet() {
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
		
		Reimbursement rem = new Reimbursement();
		
		
		int rid = Integer.parseInt(request.getParameter("enterRID"));
		String status = request.getParameter("enterStatus");

		service.approveReimbursementRequest(rid, m.getUsername());
		service.writeToJsonFile(service.getJson(m.getMid()));

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
