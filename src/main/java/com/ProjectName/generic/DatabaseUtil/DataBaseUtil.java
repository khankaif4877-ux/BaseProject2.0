package com.ProjectName.generic.DatabaseUtil;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DataBaseUtil {
	private static final  String url = "";
	private static final  String userName = "";
	private static final  String password = "";
	Connection connection = null;
	
	public void getDataBaseconnection()  {
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			 connection = DriverManager.getConnection(url,userName,password);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void closeConnection()  {
		try {
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public ResultSet executeSelectQuery(String query) {
		ResultSet resSet = null;
		try {
			Statement statement = connection.createStatement();
			 resSet	 = statement.executeQuery(query);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resSet;
	}
	
	public int executeNonSelectQuery(String query){
		int res = 0;
		try {
			Statement statement = connection.createStatement();
			 res	 = statement.executeUpdate(query);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	

	

}
