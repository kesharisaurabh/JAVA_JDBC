package java_JDBC_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC03_resultset_BackwordFlow 
{
	public static void main(String[] args) throws Exception
	{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
		System.out.println("Connection Esatblished");
		
		Statement pst=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		ResultSet rs=pst.executeQuery("select * from AA_PRACTICE01");
		while(rs.previous())
		{
			System.out.println(rs.getInt(1));
		}
		con.close();
		System.out.println("Connection CLosed");
	}
}
