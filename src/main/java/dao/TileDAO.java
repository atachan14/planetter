package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.data.AccountData;
import model.data.TileData;

public class TileDAO {
	private final static String DB_URL = "jdbc:mysql://localhost:3306/planetter";
	private final static String DB_USER = "root";
	private final static String DB_PASS = "root";
	private final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";

	public static void updateTileData(TileData pos) {
		String planet = pos.getPlName();
		int x = pos.getX();
		int y = pos.getY();

		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException(
					"JDBCドライバを読み込めませんでした");
		}

		try (Connection conn = DriverManager.getConnection(
				DB_URL, DB_USER, DB_PASS)) {
			String sql = "SELECT id,type,objectid FROM tile WHERE planet = ? AND x = ? AND y = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, planet);
			pStmt.setInt(2, x);
			pStmt.setInt(3, y);

			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				pos.setId(rs.getInt("id"));
				pos.setType(rs.getString("type"));
				pos.setObjectId(rs.getInt("objectId"));
			} else {
				pos.setType("no objects");
			}

		} catch (SQLException e) {
			System.out.println("ObjectDAO.findType SQLE" + x + "," + y);
			e.printStackTrace();
		}
	}

	public static void insertTile(String type, int id, AccountData acd) {
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException(
					"JDBCドライバを読み込めませんでした");
		}

		try (Connection conn = DriverManager.getConnection(
				DB_URL, DB_USER, DB_PASS)) {
			String sql = "INSERT INTO `tile`(`type`, `objectID`, `planet`, `x`, `y`) VALUES (?,?,?,?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, type);
			pStmt.setInt(2, id);
			pStmt.setString(3, acd.getPlanet());
			pStmt.setInt(4, acd.getX());
			pStmt.setInt(5, acd.getY());

			int result = pStmt.executeUpdate();
			if (result != 1) {
				System.out.println("insertTile:しっぱい１");
			}
		} catch (SQLException e) {
			System.out.println("insertTile:しっぱい2");
			e.printStackTrace();
		}
	}
}
