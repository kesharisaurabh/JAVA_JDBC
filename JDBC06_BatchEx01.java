package java_JDBC_01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBC06_BatchEx01 
{
	public static void main(String[] args) throws Exception
	{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
		Statement st=connection.createStatement();
	 	st.addBatch("insert into EMPLOYE values(555,'saurabh','Emp',12000)");
		st.addBatch("update EMPLOYE set ESAL=ESAL-500 where ESAL<1111");
		st.addBatch("delete from EMPLOYE where EID=5");
		int []ar=st.executeBatch();
		for(int i=0;i<ar.length;i++)
		{
			System.out.println(ar[i]);
		}
		
	}
}
