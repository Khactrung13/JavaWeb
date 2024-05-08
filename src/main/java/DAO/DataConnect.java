package DAO;
import java.sql.*;

public class DataConnect {
	public static Connection getConnect() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 return DriverManager.getConnection("jdbc:mysql://localhost:3306/wed_mysql","root", "");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public ResultSet getResult(String sql) {
		try {
			Statement stm = getConnect().createStatement();
			return stm.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	public int exculteNonQuery(String sql) {
		try {
			Statement stm = getConnect().createStatement();
			return stm.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
