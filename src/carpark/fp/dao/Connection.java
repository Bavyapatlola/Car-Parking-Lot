package carpark.fp.dao;

import java.sql.DriverManager;

public class Connection {

	//Private variables for username, password etc
	private static Connection instance = null;
	private static final String PASSWORD = "ro143@HIT";
	private static final String USERNAME = "root";
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/dbfp?useSSL=false";

	/**
	 * private constructor used for singleton pattern
	 */
	private Connection() {
	}

	/**
	 * get the single instance of the Connection Object
	 *
	 * @return Connection Object
	 */
	public static Connection getInstance() {
		if (instance == null) {
			instance = new Connection();
		}
		return instance;
	}

	/**
	 * Used to create a JDBC connection
	 *
	 * @return returns the Connection Created
	 * @throws Exception Throws SQLException and other exceptions
	 */
	public java.sql.Connection getConnection() throws Exception {
		Class.forName(JDBC_DRIVER);
		return DriverManager.getConnection(URL, USERNAME, PASSWORD);
	}
}


	/*public static void main(String args[]) throws SQLException {
		Connection conn = null;
		Statement stmt = null;
		try {
			//STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			//STEP 3: Open a connection
			System.out.println("Connecting to a selected database...");
			conn = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("Connected database successfully...");
		} catch (SQLException se) {
			//Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			//Handle errors for Class.forName
			e.printStackTrace();
		}
	}
}
*/