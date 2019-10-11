package java_JDBC_01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import oracle.jdbc.OracleDriver;

public class JDBC05_preparedstatement 
{
	public static void main(String[] args) throws Exception
	{
		DriverManager.registerDriver(new OracleDriver());
		
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
		
		PreparedStatement pst=con.prepareStatement("insert into AABTM values(?,?,?,?)");
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter name U want to Enter");
		String Name=bf.readLine();
		System.out.println("Enter Id");
		int id=Integer.parseInt(bf.readLine());
		System.out.println("Enter Email Id");
		String email=bf.readLine();
		System.out.println("Enter Address");
		String addr=bf.readLine();
		
		
		pst.setInt(1, id);
		pst.setString(2, Name);
		pst.setString(3, email);
		pst.setString(4, addr);
		pst.execute();
		
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from AABTM");
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
