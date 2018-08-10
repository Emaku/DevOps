package com.home.reimbursement;

public class Member {

	private String fname, lname, username, pw, accesstype, email, memStatus;

	private int mid;

	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Member(int mid, String fname, String lname, String username, String pw, String email, String memStatus) {
		super();
		this.mid = mid;
		this.fname = fname;
		this.lname = lname;
		this.username = username;
		this.pw = pw;
		this.email = email;
		this.memStatus = memStatus;

	}

	public int getMid() {
		return mid;
	}

	public void setmid(int mid) {
		this.mid = mid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setMemStatus(String i) {
		this.memStatus = i;
	}

	public String getMemStatus() {
		return memStatus;
	}

	@Override
	public String toString() {
		return "Member: \n mid = " + mid + "\n fname = " + fname + "\n lname = " + lname + "\n username = " + username
				+ "\n pw = " + pw + "\n email = " + email + "\n memStatus = " + memStatus + "\n\n";
	}

}
