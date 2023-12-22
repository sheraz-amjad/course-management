import java.sql.Connection;
import java.sql.DriverManager;

public class AccessConnectivity {
	
	static boolean connected = false;
	static Connection connection;
	
	static String studentInfoTable = "StudentInfo";
	static String studentCoursesTable = "StudentCourses";

	static void connectToDatabase() {
		
		try {
			
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			connection = DriverManager.getConnection("jdbc:ucanaccess://D:\\java\\java\\Course Management\\Database11.accdb");
			System.out.println("Database connected successfully");
			connected = true;
			
		}
		catch(Exception e) {
			System.out.println("Database is not connected");
			connected = false;
		}
		
	}

}
