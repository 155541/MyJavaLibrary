package com.revolhope.deepdev.myjavalibrary.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCDatabase {
	 
	private Connection conn = null;
	private static JDBCDatabase instance;
	private JDBCDatabase(){  }
	
	public static JDBCDatabase getInstance(){
		if(instance == null) instance = new JDBCDatabase();
		return instance;
	}
	/***
	TODO: Create javadoc 
	***/
	public boolean establishConn(String server,  String port,  String dbName, boolean useSSL,  String user,  String password) 
		throws SQLException{
		
		StringBuilder connString = new StringBuilder();
		connString.append("jdbc:mysql://");
		connString.append(server);
		connString.append(":");
		connString.append(port);
		connString.append("/");
		connString.append(dbName);
		if(useSSL){
			connString.append("?verifyServerCertificate=false");
			connString.append("&useSSL=true");
			connString.append("&requireSSL=true");
		}
		else{
			connString.append("?useSSL=false");
		}
		
		Properties connectionProps = new Properties();
		connectionProps.put("user", user);
		connectionProps.put("password", password);
		try {
			conn = DriverManager.getConnection(connString.toString(), connectionProps);
		} catch (SQLException e) {
			throw new SQLException(e.getMessage());
		}
		return conn != null; 
	}
	
	/***
  TODO: Create javadoc 
	@brief: Method to insert, update or delete data from db
  ***/
  public boolean update(String query, Object[] params) throws SQLException{
  
    PreparedStatement preparedStatement = null;
		if(conn == null) {
			throw new SQLException("Connection is null, not able to manage data");
		}
		try {
			preparedStatement = conn.prepareStatement(query);
			if(params != null)
				for(int i = 1 ; i<= params.length ; i++) preparedStatement.setObject(i, params[i-1]);
						
			int result = preparedStatement.executeUpdate();
			preparedStatement.close();
			return result != 0;
			
		}catch(SQLException e ){
			throw new SQLException(e.getMessage());
		}
  }
	
	/***
  TODO: Create javadoc 
	@brief: Method to mainly select data from db, also for create, update and drop tables. 
  ***/
	public ResultSet executeQuery(String query, Object[] params) throws SQLException{
		
		PreparedStatement preparedStatement = null;
		if(conn == null) {
			throw new SQLException("Connection is null, not able to manage data");
		}
		
		try{
			
			conn.prepareStatement(query);
			if(params != null)
				for(int i = 1 ; i<= params.length ; i++) preparedStatement.setObject(i, params[i-1]);
			
			ResultSet rs = preparedStatement.executeQuery();
			preparedStatement.close();
			return rs;
			
		} catch (SQLException e){
			throw new SQLException(e.getMessage());
		}
	}
	
	/***
  	TODO: Create javadoc 
	@brief: Method to close connection with databas
  ***/
	public boolean closeConn() throws SQLException{
		if(conn != null) {
			try{
				
				conn.close();
				conn = null;
				return true;
				
			}catch(Exception e){
				throw new SQLException(e.getMessage());
			}
		}
		else{
			return true;
		}
	}
}
