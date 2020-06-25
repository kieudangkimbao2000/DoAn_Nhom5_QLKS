package UTILS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUTILS {
	public Connection getConnection() {
		String url = "jdbc:mysql://localhost:3306/qlks";
		String user = "root";
		String pass = "";
		try {
			return DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
