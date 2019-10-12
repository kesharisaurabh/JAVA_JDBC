package java_JDBC_01;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.ConnectionPoolDataSource;
import javax.sql.PooledConnection;

import oracle.jdbc.pool.OracleConnectionPoolDataSource;

public class JDBC08_ConnectionPool 
{
	public static void main(String[] args) throws Exception
	{
		OracleConnectionPoolDataSource cp=new OracleConnectionPoolDataSource();
		cp.setURL("jdbc:oracle:thin:@localhost:1521:xe");
		cp.setUser("system");
		cp.setPassword("system");
		PooledConnection pc=cp.getPooledConnection();
		Connection con=pc.getConnection();
		
		Statement cst=con.createStatement();
		ResultSet rs=cst.executeQuery("select * from EMPLOYE");
		while(rs.next())
		{
			System.out.println("Employe id "+rs.getInt(1));
			System.out.println("Employe Name "+rs.getString(2));
			System.out.println("Employe Designation "+rs.getString(3));
			System.out.println("Employe Salary "+rs.getInt(4));
			System.out.println();
		}
		
	}
}
