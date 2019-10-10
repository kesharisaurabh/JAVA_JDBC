package java_JDBC_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC04_update 
{
	public static void main(String[] args) throws Exception				
	{
		Class.forName("oracle.jdbc.OracleDriver");
		System.out.println("Driver Loaded Sucess");
		
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
		System.out.println("ConnectionEstablished");
		
		Statement cst=con.createStatement();
		String srt1="insert into AA_PRACTICE01 values(44,'Harsh','harshu@gmail.com','near mahunaka')";
		
		System.out.println("Statement Created");
		int st=cst.executeUpdate(srt1);
		System.out.println("Number of Row Effected "+st);
	
		ResultSet rs=cst.executeQuery("select * from AA_PRACTICE01");
		
		while(rs.next())
		{
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
			System.out.println(rs.getString(4));
			System.out.println();
		}
		
	}
}
