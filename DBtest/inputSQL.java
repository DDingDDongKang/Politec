package DBtest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

public class inputSQL {

	public static String compare(String a) {
		Statement statement = null;
		ResultSet resultSet = null;
		Connection connection = null;
		String b = null;
		int columnSize = 0;
		String id = "root";
		String password = null;
		String useDB = null;

		String dbQuery = a;

		try {
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/" + useDB + "?useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Seoul&useSSL=false",
					id, password);
			statement = connection.createStatement();

			if (statement.execute(dbQuery)) { 
				resultSet = statement.getResultSet();
				ResultSetMetaData rsmd = (ResultSetMetaData) resultSet.getMetaData();
				columnSize = rsmd.getColumnCount();
				
			}
			
			while (resultSet != null && resultSet.next()) {
				for(int i = 1; i <= columnSize; i++) {
				String str = resultSet.getString(i);
				b = str;
				}
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return b;
	}
	
	public static void create(String a) {
		Statement statement = null;
		ResultSet resultSet = null;
		Connection connection = null;
		int columnSize = 0;
		String id = "root";
		String password = null;
		String useDB = null;
		String dbQuery = a;

		try {
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/" + useDB + "?useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Seoul&useSSL=false",
					id, password);
			statement = connection.createStatement();

			if (statement.execute(dbQuery)) { 
				resultSet = statement.getResultSet();
				ResultSetMetaData rsmd = (ResultSetMetaData) resultSet.getMetaData();
				columnSize = rsmd.getColumnCount();
				
			}

			while (resultSet != null && resultSet.next()) {
				for(int i = 1; i <= columnSize; i++) {
				String str = resultSet.getString(i);
				System.out.println(str);
				}
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
	
	public static void table(String database, String a) {
		Statement statement = null;
		ResultSet resultSet = null;
		Connection connection = null;
		int columnSize = 0;
		String id = "root";
		String password = "";
		String useDB = null;
		String dbQuery = a;

		try {
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/" + useDB + "?useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Seoul&useSSL=false",
					id, password);
			statement = connection.createStatement();

			if (statement.execute(dbQuery)) { 
				resultSet = statement.getResultSet();
				ResultSetMetaData rsmd = (ResultSetMetaData) resultSet.getMetaData();
				columnSize = rsmd.getColumnCount();
				
			}

			while (resultSet != null && resultSet.next()) {
				for(int i = 1; i <= columnSize; i++) {
				String str = resultSet.getString(i);
				System.out.println(str);
				}
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
	
	public static void insert(String database, String a) {
		Statement statement = null;
		ResultSet resultSet = null;
		Connection connection = null;
		int columnSize = 0;
		String id = "root";
		String password = null;
		String useDB = null;
		String dbQuery = a;

		try {
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/" + useDB + "?useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Seoul&useSSL=false",
					id, password);
			statement = connection.createStatement();

			if (statement.execute(dbQuery)) { 
				resultSet = statement.getResultSet();
				ResultSetMetaData rsmd = (ResultSetMetaData) resultSet.getMetaData();
				columnSize = rsmd.getColumnCount();
				
			}

			while (resultSet != null && resultSet.next()) {
				for(int i = 1; i <= columnSize; i++) {
				String str = resultSet.getString(i); 
				System.out.println(str);
				}
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (Exception e) { 
			e.printStackTrace();

		}
	}

	public static void select(String database, String a) {
		Statement statement = null;
		ResultSet resultSet = null;
		Connection connection = null;
		int columnSize = 0;
		String id = "root";
		String password = null;
		String useDB = null;
		String dbQuery = a;

		try {
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/" + useDB + "?useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Seoul&useSSL=false",
					id, password);
			statement = connection.createStatement();

			if (statement.execute(dbQuery)) { 
				resultSet = statement.getResultSet();
				ResultSetMetaData rsmd = (ResultSetMetaData) resultSet.getMetaData();
				columnSize = rsmd.getColumnCount();
				
			}

			while (resultSet != null && resultSet.next()) {
				for(int i = 1; i <= columnSize; i++) {
				String str = resultSet.getString(i); 
				System.out.println(str);
				}
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (Exception e) { 
			e.printStackTrace();

		}
	}
	
	public static void getsql(String a) {
		Statement statement = null;
		ResultSet resultSet = null;
		Connection connection = null;
		int columnSize = 0;
		String id = "root";
		String password = null;
		String useDB = null;
		String dbQuery = a;

		try {
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/" + useDB + "?useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Seoul&useSSL=false",
					id, password);
			statement = connection.createStatement();

			if (statement.execute(dbQuery)) { 
				resultSet = statement.getResultSet();
				ResultSetMetaData rsmd = (ResultSetMetaData) resultSet.getMetaData();
				columnSize = rsmd.getColumnCount();
				
			}

			while (resultSet != null && resultSet.next()) {
				for(int i = 1; i <= columnSize; i++) {
				String str = resultSet.getString(i);
				System.out.println(str);
				}
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
	
	public static void update(String a) {
		Statement statement = null;
		ResultSet resultSet = null;
		Connection connection = null;
		int columnSize = 0;
		String id = "root";
		String password = null;
		String useDB = null;
		String dbQuery = a;

		try {
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/" + useDB + "?useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Seoul&useSSL=false",
					id, password);
			statement = connection.createStatement();

			if (statement.execute(dbQuery)) { 
				resultSet = statement.getResultSet();
				ResultSetMetaData rsmd = (ResultSetMetaData) resultSet.getMetaData();
				columnSize = rsmd.getColumnCount();
				
			}

			while (resultSet != null && resultSet.next()) {
				for(int i = 1; i <= columnSize; i++) {
				String str = resultSet.getString(i);
				System.out.println(str);
				}
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
	
	
	public static void delete(String a) {
		Statement statement = null;
		ResultSet resultSet = null;
		Connection connection = null;
		int columnSize = 0;
		String id = "root";
		String password = null;
		String useDB = null;
		String dbQuery = a;

		try {
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/" + useDB + "?useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Seoul&useSSL=false",
					id, password);
			statement = connection.createStatement();

			if (statement.execute(dbQuery)) { 
				resultSet = statement.getResultSet();
				ResultSetMetaData rsmd = (ResultSetMetaData) resultSet.getMetaData();
				columnSize = rsmd.getColumnCount();
				
			}

			while (resultSet != null && resultSet.next()) {
				for(int i = 1; i <= columnSize; i++) {
				String str = resultSet.getString(i);
				System.out.println(str);
				}
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}
