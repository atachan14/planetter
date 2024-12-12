package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Pos;

public class TileDAO {
	private final static String DB_URL = "jdbc:mysql://localhost:3306/planetter";
	private final static String DB_USER = "root";
	private final static String DB_PASS = "root";
	private final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";

	public static String findType(String planet, Pos pos) {
		String type = "no objects";
		int x = pos.getx();
		int y = pos.gety();

		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException(
					"JDBCドライバを読み込めませんでした");
		}

		try (Connection conn = DriverManager.getConnection(
				DB_URL, DB_USER, DB_PASS)) {
			String sql = "SELECT type FROM tile WHERE planet = ? AND x = ? AND y = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, planet);
			pStmt.setInt(2, x);
			pStmt.setInt(3, y);

			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				type = rs.getString("type");
				return type;
			} else {
//				System.out.println("ObjectDAO.findType null" + x + "," + y);
				return type;
			}

		} catch (SQLException e) {
			System.out.println("ObjectDAO.findType SQLE" + x + "," + y);
			e.printStackTrace();
			return null;
		}
	}

	public static boolean insertType(String planet, int x, int y, String type) {
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException(
					"JDBCドライバを読み込めませんでした");
		}

		try (Connection conn = DriverManager.getConnection(
				DB_URL, DB_USER, DB_PASS)) {
			String sql = "INSERT INTO `Tile`(`planet`, `x`, `y`,`type`) VALUES (?,?,?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, planet);
			pStmt.setInt(2, x);
			pStmt.setInt(3, y);
			pStmt.setString(4, type);

			int result = pStmt.executeUpdate();
			if (result != 1) {
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return true;

	}
}
