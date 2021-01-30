package hu.junior9.todolist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class AbstractDao {
	private static final String HOST = "localhost";
	private static final int PORT = 3306;
	private static final String DATABASE = "todo_list";
	private static final String URL = "jdbc:mysql://" + HOST + ":" + PORT
			+ "/" + DATABASE + "?useUnicode=true&serverTimezone=UTC";
	
	protected final Connection getConnection() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		return DriverManager.getConnection(URL, "root", "root_Admin");
	}
	
}
