package java_JDBC_01;
import java.sql.*;
import oracle.jdbc.OracleDriver;


public class JDBC01 
{
	public static void main(String[] args) throws Exception,SQLException
	{
		DriverManager.registerDriver(new OracleDriver());
		System.out.println("DriverLodaded");
		
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
		System.out.println("ConnectedToOracel");
		
		Statement st=con.createStatement();
		String str1="insert into AA_PRACTICE01 values(11,'saurabh','keshari','bombay')";
		int i=st.executeUpdate(str1);
		System.out.println(i);
	}
}
