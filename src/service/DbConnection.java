package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnection {
	
	private static String urlConnection ="jdbc:mysql://localhost:3306/books";
	private static String login = "root";
	private static String password = "";
	private static Connection dbConnection = null;
	private static Statement stmt;
	private static ResultSet rs;
	
	
	public static Connection getDBConnection() throws ClassNotFoundException, SQLException {
		if(dbConnection== null) {
			Class.forName("com.mysql.jdbc.Driver");
			dbConnection = DriverManager.getConnection(urlConnection, login, password);
		}
		
		return dbConnection;
	}
	
	
	public static Statement getStatementObject() {
		
		try {
			return  getDBConnection().createStatement();
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}
	
	public static int getPreparedStatement(String statement) {
		PreparedStatement ps = null;
		int i=0;
		 try {
			 ps = getDBConnection().prepareStatement(statement);
			 i=ps.executeUpdate(statement);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
				
		return i;
		
	}
	public static ResultSet fetchData(String sql) throws ClassNotFoundException, SQLException
	{
		stmt=getDBConnection().createStatement();
		rs=stmt.executeQuery(sql);
		return rs;
	}
	public static void closeDBConnection() {
		
		try {
			getDBConnection().close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
