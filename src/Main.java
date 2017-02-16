
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;


public class Main {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/test?user=root&password=root");

		Statement statement = connection.createStatement();
		
		ResultSet set=statement.executeQuery("select id as `Device ID`,name as `Name` from test");
		
		ResultSetMetaData data=set.getMetaData();
		
		int id=data.getColumnCount();
		
		for (int i = 1; i <= id; i++) {
			System.out.print(data.getColumnLabel(i)+" "+data.getColumnName(i));
		}
		System.out.println();
		
		while(set.next())
		{
			for (int i = 1; i <= id; i++) {
				System.out.print(set.getString(i));
			}
			
			
		}
		
		
	}
}
