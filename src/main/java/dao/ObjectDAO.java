package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ObjectDAO {
	private final String DB_URL = "jdbc:mysql://localhost:3306/planetter";
	private final String DB_USER = "root";
	private final String DB_PASS = "root";
	private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

	public String findNowPos(String planet,int x,int y) {
		String object=null;
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException(
					"JDBCドライバを読み込めませんでした");
		}

		ここ！
		
		try (Connection conn = DriverManager.getConnection(
				DB_URL, DB_USER, DB_PASS)) {
			String sql = "SELECT type FROM object WHERE x = ? AND y = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, x);
			pStmt.setInt(2, y);

			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				object = rs.getString("type");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return object;
	}
}
