package com.home.servlets;

import java.io.IOException;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.home.reimbursement.DaoServices;
import com.home.reimbursement.Member;

/**
 * Servlet implementation class SubmitRmbServlet
 */
public class SubmitRmbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DaoServices service = new DaoServices();

	Member m = service.getMember(service.currentUser);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SubmitRmbServlet() {
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

		System.out.println("1");
		String reasonType = request.getParameter("Type");
		String reason = request.getParameter("reason");

		String amountRequested = request.getParameter("amountRequested");

		String submitURL = request.getLocalName();
		System.out.println("Get Local Name = " + submitURL);
		submitURL = request.getLocalAddr();
		System.out.println("Get Local Addr = " + submitURL);
		submitURL = request.toString();
		System.out.println("Request= " + submitURL);

		System.out.println("Attributes = " + request.getAttributeNames());

		System.out.println("ParaNames = " + request.getParameterNames());

		System.out.println(request.getQueryString());

		System.out.println("Type = " + reasonType + "\nReason = " + reason + "\nAmount Requested = " + amountRequested);

		String s = request.getParameter("Type");
		String[] sarr = request.getParameterValues("Type");

		System.out.println(sarr);

		service.submitReimbursement(m.getMid(), reason, Double.parseDouble(amountRequested));
		System.out.println("2");

		service.writeToJsonFile(service.getJson(m.getMid()));

		System.out.println("3");
		System.out.println(service.getJson(m.getMid()));
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
