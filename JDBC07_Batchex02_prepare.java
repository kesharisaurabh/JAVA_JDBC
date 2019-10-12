package java_JDBC_01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.swing.border.EmptyBorder;

public class JDBC07_Batchex02_prepare 
{
	public static void main(String[] args) throws Exception
	{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
		PreparedStatement st=con.prepareStatement("insert into EMPLOYE values(?,?,?,?)");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("How Many Employe wanna Enter");
		int num=Integer.parseInt(br.readLine());
		for(int i=0;i<num;i++)
		{
			System.out.println("Enter Employee Id");
			int eid=Integer.parseInt(br.readLine());
			
			System.out.println("Enter Employee name");
			String ename=br.readLine();
			
			System.out.println("Enter Employee Designation(Emp/Manager/Head)");
			String edsg=br.readLine();
			
			System.out.println("Enter Employe Salary");
			int esal=Integer.parseInt(br.readLine());
			
			st.setInt(1, eid);
			st.setString(2, ename);
			st.setString(3, edsg);
			st.setInt(4, esal);
			st.addBatch();
			
		}
		int[] bat=st.executeBatch();
		for(int i=0;i<bat.length;i++)
		{
			System.out.println(bat[i]);
		}
		
		con.close();	
	}

}
