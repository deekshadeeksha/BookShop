package manager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import entity.User;
import service.DbConnection;

public class Manager {
	
	
	public static int setDetails(String statement)
	{
			int i=0;
			try
			{
					
				i=DbConnection.getPreparedStatement(statement);
	
			}
			catch(Exception ae)
			{
				System.out.println(ae);
				
			}
			return i;

	}
	public static ResultSet fetchData(String statement)
	{
		ResultSet rs=null;
		
		try {
			rs = DbConnection.fetchData(statement);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
}