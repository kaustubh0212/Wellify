package util;
import java.sql.Connection;
import java.sql.DriverManager;

public class dbConnect {
	static String url = "jdbc:mysql://localhost:3306/wellify"; // 
	static String u = "root";
	static String p = "root";
	
	private static Connection con;

	public static Connection getConn()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			
			con = DriverManager.getConnection(url, u, p);
			
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return con;
	}
}
