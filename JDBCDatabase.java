
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
	public boolean establishConn(@NonNull String server, @NonNull String port, @NonNull String dbName, boolean useSSL, @NonNull String user, @NonNull String password) 
		throws SQLException{
		
		if(useSSL == null) useSSL = false;
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
			return false;
		}
		return conn != null; 
	}
	
	/***
  TODO: Create javadoc 
	@brief: Method to insert, update or delete data from db
  ***/
  public boolean update(@NonNull String query, Object[] params) throws SQLException{
  
    PreparedStatement preparedStatement = null;
		if(conn == null) {
			throws new SQLException("Connection is null, not able to manage data");
			return false;
		}
		try {
			preparedStatement = conn.prepareStatement(query);
			if(params != null)
				for(int i = 1 ; i<= params.length() ; i++) preparedStatement.setObject(i, params[i-1]);
						
			int result = preparedStatement.executeUpdate();
			preparedStatement.close();
			return result != 0;
			
		}catch(SQLException e ){
			throws new SQLException(e.getMessage());
			return false;
		}
  }
	
	/***
  TODO: Create javadoc 
	@brief: Method to mainly select data from db, also for create, update and drop tables. 
  ***/
	public ResultSet executeQuery(@NonNull String query, Object[] params) throws SQLException{
		
		PreparedStatement preparedStatement = null;
		if(conn == null) {
			throws new SQLException("Connection is null, not able to manage data");
			return null;
		}
		
		try{
			
			conn.prepareStatement(query);
			if(params != null)
				for(int i = 1 ; i<= params.length() ; i++) preparedStatement.setObject(i, params[i-1]);
			
			ResultSet rs = preparedStatement.executeQuery();
			preparedStatement.close();
			return rs;
			
		} catch (Exception e){
			throws new Exception(e.getMessage());
			return null;
		}
	}
	
	/***
  TODO: Create javadoc 
	@brief: Method to close connection with db
  ***/
	public boolean closeConn() throws SQLException{
		if(conn != null) {
			try{
				
				conn.close();
				conn = null;
				return true;
				
			}catch(Exception e){
				throws new SQLException(e.getMessage());
				return false;
			}
		}
		else{
			return true;
		}
	}
}
