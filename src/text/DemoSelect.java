package text;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class DemoSelect {
public static void main(String[] args) {
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","tiger");
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select* from student01");
		ResultSetMetaData rm=rs.getMetaData();
		int n=rm.getColumnCount();
		for(int i=1;i<=n;i++)
		{
			System.out.println(rm.getColumnName(i));
		}
		System.out.println();
		while(rs.next())
		{
			for(int i=1;i<=n;i++)
			{
				System.out.println(rs.getString(i)+"\t");
			}
			System.out.println();
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}
}
