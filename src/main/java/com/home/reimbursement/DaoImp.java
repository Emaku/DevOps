package com.home.reimbursement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class DaoImp implements RmbDao {

	public static DaoImp imp;

	public DaoImp() {
		// TODO Auto-generated constructor stub
	}

	public static DaoImp getDaoImp() {
		if (imp == null)
			return imp = new DaoImp();
		return imp;
	}

	String sql = "";

	public Member getMember(int mid) {

		// TODO Auto-generated method stub

		try {
			Connection c = MyConnection.getConnection();

			sql = "select * from Member where mid = ?";

			PreparedStatement p = c.prepareStatement(sql);

			p.setInt(1, mid);
			ResultSet r = p.executeQuery();

			while (r.next()) {
				return new Member(r.getInt("mid"), r.getString("fname"), r.getString("lname"), r.getString("username"),
						r.getString("pw"), r.getString("email"), r.getString("memStatus"));
			}

		} catch (SQLException e) {
			// TODO: handle exception
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public Member getMember(String username) {

		try {
			Connection c = MyConnection.getConnection();

			sql = "select * from Member where username = ?";

			PreparedStatement p = c.prepareStatement(sql);

			p.setString(1, username);
			ResultSet r = p.executeQuery();

			while (r.next()) {
				return new Member(r.getInt("mid"), r.getString("fname"), r.getString("lname"), r.getString("username"),
						r.getString("pw"), r.getString("email"), r.getString("memStatus"));
			}

		} catch (SQLException e) {
			// TODO: handle exception
		} catch (Exception e) {
			// TODO: handle exception
		}

		return null;

	}
	
	final static Logger logs = Logger.getAnonymousLogger();

//	private void logRun(String parameter){
//		
//		if(logs.getName().toString() = parameter){
//			logs.debug("This is debug : " + parameter);
//		}
//		
//		if(logs.isInfoEnabled()){
//			logs.info("This is info : " + parameter);
//		}
//		
//		logs.warn("This is warn : " + parameter);
//		logs.error("This is error : " + parameter);
//		logs.fatal("This is fatal : " + parameter);
//		
//	}

	public Member getMember(String username, String password) {

		try {
			Connection c = MyConnection.getConnection();

			sql = "select * from Member where username = ? and pw = ?";

			PreparedStatement p = c.prepareStatement(sql);

			p.setString(1, username);
			p.setString(2, password);
			ResultSet r = p.executeQuery();

			while (r.next()) {
				return new Member(r.getInt("mid"), r.getString("fname"), r.getString("lname"), r.getString("username"),
						r.getString("pw"), r.getString("email"), r.getString("memStatus"));
			}

		} catch (SQLException e) {
			// TODO: handle exception
		} catch (Exception e) {
			// TODO: handle exception
		}

		return null;

	}

	public Member updateMember(String newUsername, String newPassword, String newEmail, int mid) {
		try {
			Connection c = MyConnection.getConnection();
			
			sql = "update member set username = ?, pw = ?, email = ? where mid = ?";
			
			PreparedStatement p = c.prepareStatement(sql);
			
			p.setString(1, newUsername);
			p.setString(2, newPassword);
			p.setString(3, newEmail);
			p.setInt(4, mid);
			
			ResultSet r = p.executeQuery();
			
			while (r.next()) {
				return new Member(r.getInt("mid"), r.getString("fname"), r.getString("lname"), r.getString("username"),
						r.getString("pw"), r.getString("email"), r.getString("memStatus"));
			}

		}catch (SQLException e) {
			e.printStackTrace();
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	

	public List<Member> getAllEmployees() {
		List<Member> list = new ArrayList<Member>();

		try {

			Connection c = MyConnection.getConnection();

			sql = "select * from member where memstatus = ?";

			PreparedStatement p = c.prepareStatement(sql);
			p.setString(1, "Employee");

			ResultSet r = p.executeQuery();

			while (r.next()) {
				list.add(new Member(r.getInt("mid"), r.getString("fname"), r.getString("lname"),
						r.getString("username"), r.getString("pw"), r.getString("email"), r.getString("memstatus")));
			}
			return list;

		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	public List<Member> getAllManagers() {
		List<Member> list = new ArrayList<Member>();

		try {

			Connection c = MyConnection.getConnection();

			sql = "select * from member where memstatus = ?";

			PreparedStatement p = c.prepareStatement(sql);
			p.setString(1, "Manager");

			ResultSet r = p.executeQuery();

			while (r.next()) {
				list.add(new Member(r.getInt("mid"), r.getString("fname"), r.getString("lname"),
						r.getString("username"), r.getString("pw"), r.getString("email"), r.getString("memstatus")));
			}
			return list;

		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	public List<Member> getAllMembers() {
		List<Member> list = new ArrayList<Member>();

		try {
			Connection c = MyConnection.getConnection();

			sql = "Select * from member";

			PreparedStatement p = c.prepareStatement(sql);

			ResultSet r = p.executeQuery();

			while (r.next()) {
				Member m = new Member(r.getInt("mid"), r.getString("fname"), r.getString("lname"),
						r.getString("username"), r.getString("pw"), r.getString("email"), r.getString("memstatus"));
				list.add(m);

			}
			return list;
		} catch (SQLException e) {
			// TODO: handle exception
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	public void addReimbursement(int mid, String reasonType, String reason, double amountRequested) {
		try {
			Connection c = MyConnection.getConnection();

			sql = "insert into reimbursement values(rmb_idSequence.nextval, ?, ?, default, ?, ?, default)";

			PreparedStatement p = c.prepareStatement(sql);

			p.setString(1, reasonType);
			p.setString(2, reason);
			p.setInt(3, mid);
			p.setDouble(4, amountRequested);
			;

			ResultSet r = p.executeQuery();

		} catch (SQLException e) {
			System.out.println("SQL Error");
			e.printStackTrace();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void addReimbursement(int mid, String reason, double amountRequested) {
		try {
			Connection c = MyConnection.getConnection();

			sql = "insert into reimbursement values(rmb_idSequence.nextval, default, ?, default, ?, ?, default, default)";

			PreparedStatement p = c.prepareStatement(sql);

			p.setString(1, reason);
			p.setInt(2, mid);
			p.setDouble(3, amountRequested);
			

			ResultSet r = p.executeQuery();
			
			System.out.println("New Rmb Added");

		} catch (SQLException e) {
			System.out.println("SQL Error");
			e.printStackTrace();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
	public boolean changeStatus(int rid, String status, String username) {
		try {
			Connection c = MyConnection.getConnection();

			sql = "update reimbursement set status = '?', approvedby = ? where rid = ?";

			PreparedStatement p = c.prepareStatement(sql);

			p.setString(1, status);
			p.setString(2, username);
			p.setInt(3, rid);

			ResultSet r = p.executeQuery();
			
			return true;			

		} catch (SQLException e) {
			System.out.println("SQL Error");
			e.printStackTrace();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
		
	}
	
	public Reimbursement addReimbursement(int rid, int mid, String reasonType, String reason, double amountRequested) {
		try {
			Connection c = MyConnection.getConnection();

			sql = "insert into reimbursement values(?, ?, ?, default, ?, ?, default)";

			PreparedStatement p = c.prepareStatement(sql);

			p.setInt(1, rid);
			p.setString(2, reasonType);
			p.setString(3, reason);
			p.setInt(4, mid);
			p.setDouble(5, amountRequested);
			

			ResultSet r = p.executeQuery();
			
			while (r.next()) {
				return new Reimbursement(r.getInt("rid"), r.getString("type"), r.getString("reason"),
						r.getString("status"), r.getInt("rmb_mid"), r.getInt("amountRequested"),
						r.getInt("AmountRecieved"), r.getString("approvedBy"));
			}

		} catch (SQLException e) {
			System.out.println("SQL Error");
			e.printStackTrace();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	public Reimbursement getReimbursement(int rid) {

		try {
			Connection c = MyConnection.getConnection();

			sql = "select * from reimbursement where rid = ?";

			PreparedStatement p = c.prepareStatement(sql);

			p.setInt(1, rid);

			ResultSet r = p.executeQuery();

			while (r.next()) {
				return new Reimbursement(r.getInt("rid"), r.getString("type"), r.getString("reason"),
						r.getString("status"), r.getInt("rmb_mid"), r.getInt("amountRequested"),
						r.getInt("AmountRecieved"), r.getString("approvedBy"));
			}

		} catch (SQLException e) {
			System.out.println("SQL Error");
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public void approveRequest(int rid, String managerUsername) {
		try {
			Connection c = MyConnection.getConnection();

			sql = "update reimbursement set status = 'Approved', approvedBy = ?, amountRecieved = ? where rid = ?";

			PreparedStatement p = c.prepareStatement(sql);

			p.setString(1, managerUsername);
			p.setDouble(2, getReimbursement(rid).getAmountRequested());
			p.setInt(3, rid);

			p.executeQuery();

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void denyRequest(int rid, String managerUsername) {
		try {
			Connection c = MyConnection.getConnection();

			sql = "update reimbursement set status = 'Denied', approvedBy = ?, amountRecieved = ? where rid = ?";

			PreparedStatement p = c.prepareStatement(sql);

			p.setString(1, managerUsername);
			p.setDouble(2, getReimbursement(rid).getAmountRequested());
			p.setInt(3, rid);

			p.executeQuery();

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public List<Reimbursement> getAllPendingRmbRequest() {
		List<Reimbursement> list = new ArrayList<Reimbursement>();

		try {
			Connection c = MyConnection.getConnection();

			sql = "Select * from Reimbursement where status = 'Pending...'";

			PreparedStatement p = c.prepareStatement(sql);

			ResultSet r = p.executeQuery();

			while (r.next()) {
				list.add(new Reimbursement(r.getInt("rid"), r.getString("type"), r.getString("reason"),
						r.getString("status"), r.getInt("rmb_mid"), r.getInt("amountRequested"),
						r.getInt("AmountRecieved"), r.getString("approvedBy")));
			}
			return list;
		} catch (SQLException e) {
			// TODO: handle exception
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;

	}

	public List<Reimbursement> getAllApprovedRmbRequest() {
		List<Reimbursement> list = new ArrayList<Reimbursement>();

		try {
			Connection c = MyConnection.getConnection();

			sql = "Select * from Reimbursement where status = 'Approved'";

			PreparedStatement p = c.prepareStatement(sql);

			ResultSet r = p.executeQuery();

			while (r.next()) {
				list.add(new Reimbursement(r.getInt("rid"), r.getString("type"), r.getString("reason"),
						r.getString("status"), r.getInt("rmb_mid"), r.getInt("amountRequested"),
						r.getInt("AmountRecieved"), r.getString("approvedBy")));
			}
			return list;
		} catch (SQLException e) {
			// TODO: handle exception
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;

	}

	public List<Reimbursement> getAllRmbRequest() {
		List<Reimbursement> list = new ArrayList<Reimbursement>();

		try {
			Connection c = MyConnection.getConnection();

			sql = "Select * from Reimbursement";

			PreparedStatement p = c.prepareStatement(sql);

			ResultSet r = p.executeQuery();

			while (r.next()) {
				list.add(new Reimbursement(r.getInt("rid"), r.getString("type"), r.getString("reason"),
						r.getString("status"), r.getInt("rmb_mid"), r.getInt("AmountRequested"),
						r.getInt("AmountRecieved"), r.getString("approvedBy")));
			}
			return list;
		} catch (SQLException e) {
			// TODO: handle exception
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return list;
	}

	public List<Reimbursement> getAllRmbRequest(Member m) {
		List<Reimbursement> list = new ArrayList<Reimbursement>();

		try {
			Connection c = MyConnection.getConnection();

			sql = "Select * from Reimbursement where mid = ?";

			PreparedStatement p = c.prepareStatement(sql);

			p.setInt(1, m.getMid());

			ResultSet r = p.executeQuery();

			while (r.next()) {
				list.add(new Reimbursement(r.getInt("rid"), r.getString("type"), r.getString("reason"),
						r.getString("status"), r.getInt("rmb_mid"), r.getInt("AmountRequested"),
						r.getInt("AmountRecieved"), r.getString("approvedBy")));
			}
			return list;
		} catch (SQLException e) {
			// TODO: handle exception
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

}
