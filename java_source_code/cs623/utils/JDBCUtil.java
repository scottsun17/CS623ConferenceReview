package cs623.utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Customized JDBC Tools class 
 *  	1. load driver class
 * 	 	2. get connection class
 * 	 	3. close connection
 * @author Ziteng (Scott) Sun
 *
 */
public class JDBCUtil {
	//JDBC driver properties and database credentials
	private static String url = "jdbc:mysql://localhost:3306/paperreview?useSSL=true";
	private static String user = "root";
	private static String password = "123456";
	private static String driverClass = "com.mysql.cj.jdbc.Driver";

	//static code block executes codes within the block when the class file is being loaded to the memory. 
	// we use this characteristic to to load db.propertyies when class file is loaded

	static {
		try {
			//Step 1: register JDBC Driver
			Class.forName(driverClass);

		} catch(ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Driver failed to load");
		}
	}

	/**
	 * get database connection object
	 * 
	 * @return Connection connection to the database
	 */
	public static Connection getConnection() {		
		Connection conn = null;

		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * close connection to the database, release statement resource 
	 * 
	 * @param conn Connection object to the database
	 * @param st   Statement object
	 */
	public static void close(Connection conn, Statement st) {
		try {
			if (st != null) {
				st.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// RuntimeException for user experience when encounter SQLException
			throw new RuntimeException(e);
		}
	}

	/**
	 * Close resource when there is a ResultSet
	 * 
	 * @param conn
	 * @param st
	 * @param set
	 */
	public static void close(Connection conn, Statement st, ResultSet set) {
		try {
			if (st != null) {
				st.close();
			}
			if (set != null) {
				set.close();
			}
			if (conn != null) {
				conn.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
			// RuntimeException for user experience when encounter SQLException
			throw new RuntimeException(e);
		}
	}
}
