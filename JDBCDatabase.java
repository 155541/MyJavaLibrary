
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
    connString.append("?useSSL=");
    connString.append(useSSL ? "true" : "false");
    
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
  
  public long insert(){
  
    
    return 0L;
  }
  
}
