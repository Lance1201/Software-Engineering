import java.sql.*;
public class connection {
	private static Connection con;
	private static String url = "jdbc:mysql://localhost:3306/softwareengine";
	private static String driverName ="com.mysql.jdbc.Driver";
	private static String username ="root";
	private static String password ="";
	
	public static Connection getConnection() {
		try {
			Class.forName(driverName);
			try {
				con = DriverManager.getConnection(url,username,password);
			}
			catch(Exception e) {
				System.out.println("Failed to connect to the database.");
			}
		}
		catch(Exception e) {
			System.out.println("cant find driver");
		}
		return con;
	}
}
