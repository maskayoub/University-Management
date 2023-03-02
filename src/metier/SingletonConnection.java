package metier;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnection {
	private static Connection connection;
	static {
		String url= "jdbc:mysql://localhost:3306/td10?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String user="root";
		String password="ziad-00l";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 
			connection=DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}
		
	}
	public static Connection getConnection() {
		return connection;
	}
	
	

}
