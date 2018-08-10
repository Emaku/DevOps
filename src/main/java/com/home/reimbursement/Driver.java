package com.home.reimbursement;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.util.Arrays;

import org.apache.log4j.Logger;

import org.apache.log4j.Logger;
public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DaoServices service = new DaoServices();
		
		Member m = service.login("RAYLLEN", "DaggerChamp");
		
//		service.writeToJsonFile(service.getJson());
		
//		System.out.println(service.getMember("RAYLLEN"));
//		
//		service.writeToJsonFile(service.getJson());
//		
//		service.writeToJsonFile(service.getJson(m.getMid()));
		
		service.getJson(m.getMid());
		
		System.out.println("Current User = " + service.currentUser);
		
//		System.out.println(service.getAllMembers());
		
		
		
//		System.out.println(service.getReimbursement(25));
//		System.out.println(service.getAllReimbursements());
		
		
		
		
		
		
		
		
		
		
		
		
//		 Logger Log = Logger.getLogger(Driver.class);
//		
//		
//			Log.info("Hello Adam");
//			Log.warn("Warning Not Connected");
//			Log.error("Error Found");
//			Log.debug("Check SQL");
//			// TODO Auto-generated method stub
		
		


	}

}
