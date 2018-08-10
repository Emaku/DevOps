package com.home.reimbursement;

public class Reimbursement {

	
	private int rid, mid;
	private double amountRequested, amountRecieved;
	private String reasonType, status, reason, approvedBy;

	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reimbursement(int rid, String reasonType, String reason, String status, int mid, int amountRequested,
			int amountRecieved, String approvedBy) {
		super();
		this.rid = rid;
		this.mid = mid;
		this.amountRequested = amountRequested;
		this.amountRecieved = amountRecieved;
		this.reasonType = reasonType;
		this.status = status;
		this.reason = reason;
		this.approvedBy = approvedBy;
	}

	public String getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}

	public Reimbursement(String reasonType, String reason, String status, int mid, int amountRequested,
			int amountRecieved) {
		super();
		this.mid = mid;
		this.amountRequested = amountRequested;
		this.amountRecieved = amountRecieved;
		this.reasonType = reasonType;
		this.status = status;
		this.reason = reason;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public double getAmountRequested() {
		return amountRequested;
	}

	public void setAmountRequested(int amountRequested) {
		this.amountRequested = amountRequested;
	}

	public double getAmountRecieved() {
		return amountRecieved;
	}

	public void setAmountRecieved(int amountRecieved) {
		this.amountRecieved = amountRecieved;
	}

	public String getReasonType() {
		return reasonType;
	}

	public void setReasonType(String reasonType) {
		this.reasonType = reasonType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@Override
	public String toString() {
		return "Reimbursement: \n rid = " + rid + "\n mid = " + mid + "\n amountRequested = " + amountRequested + "\n amountRecieved = "
				+ amountRecieved + "\n reasonType = " + reasonType + "\n status = " + status + "\n reason = " + reason + "\n Approved By = " + approvedBy + "\n\n";
	}

}
