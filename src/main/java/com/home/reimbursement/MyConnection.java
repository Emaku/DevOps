package com.home.reimbursement;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class MyConnection {

	public MyConnection() {
		// TODO Auto-generated constructor stub
	}

	Connection c = MyConnection.getConnection();

	public static Connection getConnection() {

		InputStream in = null;

		try {

			Properties p = new Properties();
			in = new FileInputStream("C:\\STSWorkspace\\HomeProject\\src\\main\\resources\\connection.properties");
			p.load(in);

			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection c = null;

			// Strings need to be sent to Properties file. C & P string to enter property
			
			String endpoint = p.getProperty("jdbc.url"); // copy and paste endpoint url
			String username = p.getProperty("jdbc.username"); // enter username
			String password = p.getProperty("jdbc.password"); // enter password
			
//			String endpoint = p.getProperty("jdbc:oracle:thin:@mytestdb.cio7zurvpyvr.us-east-1.rds.amazonaws.com:1521:ORCL");
//			String username = p.getProperty("didsomebodysaycake141"); // enter username
//			String password = p.getProperty("ImNotSure141"); // enter password

//			c = DriverManager.getConnection(endpoint, username, password);

//			c = DriverManager.getConnection(
//					"jdbc:oracle:thin:@mytestdb.cvorypbhwmza.us-east-1.rds.amazonaws.com:1521:ORCL",
//					"LiL4321", "Birdman1!");

			c = DriverManager.getConnection(
					"jdbc:oracle:thin:@mytestdb.cio7zurvpyvr.us-east-1.rds.amazonaws.com:1521:ORCL",
					"didsomebodysaycake141", "ImNotSure141");
			
//			c = DriverManager.getConnection(
//					"jdbc:oracle:thin:@mytestdb.cilfcvnhzeaj.us-east-2.rds.amazonaws.com\r\n" + 
//					":1521:ORCL",
//					"LiL4321", "Birdman1!");

			System.out.println("Connection Made");

			return c;

		} catch (Exception e) {

			System.out.println("Connection Not Made");

			e.printStackTrace();

		}
		return null;
	}

}
