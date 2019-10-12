package java_JDBC_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Savepoint;
import java.sql.Statement;

import oracle.jdbc.driver.OracleDriver;

public class JDBC09_SavePoint 
{
	public static void main(String[] args) throws Exception
	{Connection con=null;
	try {
		DriverManager.registerDriver(new OracleDriver());
		con=DriverManager.getConnection("jdbc:Oracle:thin:@localhost:1521:xe","system","system");
		
		con.setAutoCommit(false);
		Statement st=con.createStatement();
		st.executeUpdate("insert into EMPLOYE values(5,'sagar','Emp',3000)");
		Savepoint sp=con.setSavepoint();
		st.executeUpdate("insert into EMPLOYE values(6,'sumit','Emp',4000)");
		con.rollback(sp);
		st.executeUpdate("insert into EMPLOYE values(7,'betu','Emp',4000)");
		con.commit();
		System.out.println("Transation Successfull");
		}catch (Exception e) {
		try {
			con.rollback();
			System.out.println("Transaction Fail");
		} catch (Exception e2) {
			
		}
	}
		
	}
	
}
