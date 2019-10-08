package java_JDBC_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import oracle.jdbc.OracleDriver;

public class JDBC02_resultset
{
	public static void main(String[] args) throws Exception
	{
		DriverManager.registerDriver(new OracleDriver());
		System.out.println("Diver LOADED");
		
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
		System.out.println("Connection Established");
		
		Statement pst=con.createStatement();
		ResultSet rs= pst.executeQuery("select * from AA_PRACTICE01");
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
		}
		con.close();
		
	}
}
