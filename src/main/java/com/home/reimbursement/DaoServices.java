package com.home.reimbursement;

import java.io.FileWriter;

import java.io.IOException;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonArrayBuilder;
import javax.json.JsonBuilderFactory;

public class DaoServices {

	public static DaoServices service;
	public static int currentUser;

	public DaoServices getServices() {
		if (service == null) {
			service = new DaoServices();
		}

		return service;
	}

	public Member getMember(int mid) {
		return DaoImp.getDaoImp().getMember(mid);
	}

	public Member getMember(String username) {
		return DaoImp.getDaoImp().getMember(username);
	}

	public Member getMember(String username, String password) {
		return DaoImp.getDaoImp().getMember(username, password);
	}

	public List<Member> getAllEmp() {
		return DaoImp.getDaoImp().getAllEmployees();
	}

	public List<Member> getAllManagers() {
		return DaoImp.getDaoImp().getAllManagers();
	}

	public List<Member> getAllMembers() {
		return DaoImp.getDaoImp().getAllMembers();
	}

	public Member updateMember(String username, String pw, String email, int mid) {
		return DaoImp.getDaoImp().updateMember(username, pw, email, mid);
	}

	public void submitReimbursement(int mid, String reasonType, String reason, double amountRequested) {
		DaoImp.getDaoImp().addReimbursement(mid, reasonType, reason, amountRequested);
		writeToJsonFile(getJson());
	}
	
	public void submitReimbursement(int mid, String reason, double amountRequested) {
		DaoImp.getDaoImp().addReimbursement(mid, reason, amountRequested);
		writeToJsonFile(getJson());
	}


	public Reimbursement submitReimbursement(int rid, int mid, String reasonType, String reason,
			double amountRequested) {
		Reimbursement r = DaoImp.getDaoImp().addReimbursement(rid, mid, reasonType, reason, amountRequested);
		writeToJsonFile(getJson());
		return r;
	}

	public void approveReimbursementRequest(int rid, String approvedBy) {
		DaoImp.getDaoImp().approveRequest(rid, approvedBy);
	}

	public void denyReimbursementRequest(int rid, String approvedBy) {
		DaoImp.getDaoImp().denyRequest(rid, approvedBy);
	}

	public Reimbursement getReimbursement(int rid) {
		return DaoImp.getDaoImp().getReimbursement(rid);
	}

	public List<Reimbursement> getAllPendingReimbursements() {
		return DaoImp.getDaoImp().getAllPendingRmbRequest();
	}

	public List<Reimbursement> getAllApprovedReimbursements() {
		return DaoImp.getDaoImp().getAllApprovedRmbRequest();
	}

	public List<Reimbursement> getAllReimbursements() {
		return DaoImp.getDaoImp().getAllRmbRequest();
	}

	public List<Reimbursement> getAllReimbursements(Member m) {
		return DaoImp.getDaoImp().getAllRmbRequest(m);

	}

	public JsonObject toJson(Member m) {
		JsonObjectBuilder job = Json.createObjectBuilder();
		JsonObject json = job.add("FName", m.getFname()).add("Lname", m.getLname()).add("id", m.getMid())
				.add("Username", m.getUsername()).add("Password", m.getPw()).add("Email", m.getEmail())
				.add("MemStatus", m.getMemStatus()).build();
		return json;
	}

	public JsonObject getJson() {

		List<Member> list = DaoImp.getDaoImp().getAllMembers();
		List<Reimbursement> rlist = DaoImp.getDaoImp().getAllRmbRequest();

		JsonObjectBuilder rootBuilder = Json.createObjectBuilder();
		JsonObjectBuilder memBuilder = Json.createObjectBuilder();
		JsonObjectBuilder rmbBuilder = Json.createObjectBuilder();
		JsonObjectBuilder userBuilder = Json.createObjectBuilder();

		JsonArrayBuilder jUserBuilder = Json.createArrayBuilder();
		JsonArrayBuilder jRmbBuilder = Json.createArrayBuilder();

		JsonArray jUserArray = null, jRmbArray = null, jRootArray;

		JsonObjectBuilder jbuilder = Json.createObjectBuilder();

		JsonObject json, member, rmb;

		JsonObject[] jarr = new JsonObject[rlist.size()];
		JsonObject[] jMemArr = new JsonObject[list.size()];

		for (int i = 0; i < rlist.size(); i++) {

			jarr[i] = jbuilder.add("Rid", rlist.get(i).getRid() != 0 ? rlist.get(i).getRid() : -1)
					.add("Type", rlist.get(i).getReasonType() != null ? rlist.get(i).getReasonType() : "")
					.add("Reason", rlist.get(i).getReason() != null ? rlist.get(i).getReason() : "")
					.add("Status", rlist.get(i).getStatus() != null ? rlist.get(i).getStatus() : "")
					.add("Mid", rlist.get(i).getMid() != 0 ? rlist.get(i).getMid() : -1)
					.add("AmountResquested",
							rlist.get(i).getAmountRequested() != 0 ? rlist.get(i).getAmountRequested() : -1)
					.add("AmountRecieved", rlist.get(i).getAmountRecieved() > -1 ? rlist.get(i).getAmountRecieved() : 0)
					.add("Resolved By", rlist.get(i).getApprovedBy()).build();
		}
		for (int i = 0; i < list.size(); i++) {

			jMemArr[i] = userBuilder.add("FName", list.get(i).getFname() != null ? list.get(i).getFname() : "")
					.add("Lname", list.get(i).getLname() != null ? list.get(i).getLname() : "")
					.add("id", list.get(i).getMid() != 0 ? list.get(i).getMid() : -1)
					.add("Username", list.get(i).getUsername() != null ? list.get(i).getUsername() : "")
					.add("Password", list.get(i).getPw() != null ? list.get(i).getPw() : "")
					.add("Email", list.get(i).getEmail() != null ? list.get(i).getEmail() : "")
					.add("MemStatus", list.get(i).getMemStatus() != null ? list.get(i).getMemStatus() : "").build();
		}

		for (int i = 0; i < jarr.length - 1; i++) {
			System.out.println(jarr[i]);
			jRmbBuilder.add(jarr[i]);
		}

		for (int i = 0; i < jMemArr.length - 1; i++) {
			System.out.println(jMemArr[i]);
			jUserBuilder.add(jMemArr[i]);
		}

		jRmbArray = jRmbBuilder.build();
		jUserArray = jUserBuilder.build();

		for (int i = 0; i < jRmbArray.size(); i++) {
			System.out.println(jRmbArray.get(i));
		}
		for (int i = 0; i < jUserArray.size(); i++) {
			System.out.println(jUserArray.get(i));
		}

//		JsonObject jrmb = rmbBuilder.build();

//		jRmbArray = jRmbBuilder.build();

		JsonObject root = rootBuilder.add("Members", jUserArray).add("Reimbursements", jRmbArray).build();

		return root;
	}

	public JsonObject getJson(int mid) {

		List<Member> list = DaoImp.getDaoImp().getAllMembers();
		List<Reimbursement> rlist = DaoImp.getDaoImp().getAllRmbRequest();

		JsonObjectBuilder rootBuilder = Json.createObjectBuilder();
		JsonObjectBuilder memBuilder = Json.createObjectBuilder();
		JsonObjectBuilder rmbBuilder = Json.createObjectBuilder();
		JsonObjectBuilder userBuilder = Json.createObjectBuilder();

		JsonArrayBuilder jUserBuilder = Json.createArrayBuilder();
		JsonArrayBuilder jRmbBuilder = Json.createArrayBuilder();

		JsonArray jUserArray = null, jRmbArray = null, jRootArray;

		JsonObjectBuilder jbuilder = Json.createObjectBuilder();

		JsonObject json, member, rmb;

		JsonObject[] jarr = new JsonObject[rlist.size()];
		JsonObject[] jMemArr = new JsonObject[list.size()];

		for (int i = 0; i < rlist.size(); i++) {

			jarr[i] = jbuilder.add("Rid", rlist.get(i).getRid() != 0 ? rlist.get(i).getRid() : -1)
					.add("Type", rlist.get(i).getReasonType() != null ? rlist.get(i).getReasonType() : "")
					.add("Reason", rlist.get(i).getReason() != null ? rlist.get(i).getReason() : "")
					.add("Status", rlist.get(i).getStatus() != null ? rlist.get(i).getStatus() : "")
					.add("Mid", rlist.get(i).getMid() != 0 ? rlist.get(i).getMid() : -1)
					.add("AmountResquested",
							rlist.get(i).getAmountRequested() != 0 ? rlist.get(i).getAmountRequested() : -1)
					.add("AmountRecieved", rlist.get(i).getAmountRecieved() > -1 ? rlist.get(i).getAmountRecieved() : 0)
					.add("Resolved By", rlist.get(i).getApprovedBy()).build();
		}
		for (int i = 0; i < list.size(); i++) {

			jMemArr[i] = userBuilder.add("FName", list.get(i).getFname() != null ? list.get(i).getFname() : "")
					.add("Lname", list.get(i).getLname() != null ? list.get(i).getLname() : "")
					.add("id", list.get(i).getMid() != 0 ? list.get(i).getMid() : -1)
					.add("Username", list.get(i).getUsername() != null ? list.get(i).getUsername() : "")
					.add("Password", list.get(i).getPw() != null ? list.get(i).getPw() : "")
					.add("Email", list.get(i).getEmail() != null ? list.get(i).getEmail() : "")
					.add("MemStatus", list.get(i).getMemStatus() != null ? list.get(i).getMemStatus() : "").build();
		}

		for (int i = 0; i < jarr.length - 1; i++) {
			System.out.println(jarr[i]);
			jRmbBuilder.add(jarr[i]);
		}

		for (int i = 0; i < jMemArr.length - 1; i++) {
			System.out.println(jMemArr[i]);
			jUserBuilder.add(jMemArr[i]);
		}

		jRmbArray = jRmbBuilder.build();
		jUserArray = jUserBuilder.build();

		for (int i = 0; i < jRmbArray.size(); i++) {
			System.out.println(jRmbArray.get(i));
		}
		for (int i = 0; i < jUserArray.size(); i++) {
			System.out.println(jUserArray.get(i));
		}

//		JsonObject jrmb = rmbBuilder.build();

//		jRmbArray = jRmbBuilder.build();

		JsonObjectBuilder currentMem = Json.createObjectBuilder();
		JsonObject thisMember = currentMem.add("CurrentMid", mid).build();
		System.out.println(thisMember);

		JsonObject root = rootBuilder.add("Members", jUserArray).add("Reimbursements", jRmbArray)
				.add("CurrentUser", thisMember).build();

		currentUser = Integer.parseInt(root.get("CurrentUser").toString().substring(14, 15));
		return root;
	}

	public void writeToJsonFile(JsonObject json) {
		try {
			FileWriter jfile = new FileWriter("C:\\STSWorkspace\\HomeProject\\src\\main\\webapp\\MyServlet.json");
			FileWriter jjfile = new FileWriter("C:\\STSWorkspace\\HomeProject\\src\\main\\resources\\MyServlet.json");

			jfile.write(json.toString());
			jjfile.write(json.toString());
			jfile.flush();
			jjfile.flush();
			jjfile.close();
			jfile.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Had some trouble writing to JSON File");
			e.printStackTrace();
		}

	}

//	public void logRun(String log) {
//		DaoImp.getDaoImp().logRun(log);
//	}
//	
	public Member login(String username, String password) {

		Member m = new Member();
		try {
			m = DaoImp.getDaoImp().getMember(username, password);
			if (m != null)
				System.out.println("Login Successful");
			return m;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("invalid Username or Password");
		}
		return m = null;

	}

	public void logout(Member m) {
		m = null;
		System.exit(1);
	}
}
