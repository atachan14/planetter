package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.data.AccountData;
import model.data.TileData;

public class TileDAO {
	private final static String DB_URL = "jdbc:mysql://localhost:3306/planetter";
	private final static String DB_USER = "root";
	private final static String DB_PASS = "root";
	private final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";

	public static void posToTileData(TileData tile) {
		String planet = tile.getPlName();
		int x = tile.getX();
		int y = tile.getY();

		try (Connection conn = DriverManager.getConnection(
				DB_URL, DB_USER, DB_PASS)) {
			String sql = "SELECT id,type FROM tile WHERE planet = ? AND x = ? AND y = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, planet);
			pStmt.setInt(2, x);
			pStmt.setInt(3, y);

			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				tile.setId(rs.getInt("id"));
				tile.setType(rs.getString("type"));
			} else {
				tile.setType("no objects");
			}

		} catch (SQLException e) {
			System.out.println("ObjectDAO.findType SQLE" + x + "," + y);
			e.printStackTrace();
		}
	}

	public static int insertTile(String type, AccountData acd) {
		int generatedId = -1;
		try (Connection conn = DriverManager.getConnection(
				DB_URL, DB_USER, DB_PASS)) {
			String sql = "INSERT INTO `tile`(`type`, `planet`, `x`, `y`) VALUES (?,?,?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pStmt.setString(1, type);
			pStmt.setString(2, acd.getPlanet());
			pStmt.setInt(3, acd.getX());
			pStmt.setInt(4, acd.getY());

			int result = pStmt.executeUpdate();
			if (result > 0) {
				try (ResultSet generatedKeys = pStmt.getGeneratedKeys()) {
					if (generatedKeys.next()) {
						generatedId = generatedKeys.getInt(1);
					} else {
						System.out.println("insertTile.generatedKeys.next()else");
					}
				}
			}
		} catch (SQLException e) {
			System.out.println("insertTile:しっぱい2");
			e.printStackTrace();
		}
		return generatedId;
	}

	public static void updateType(String type, String id) {
		try (Connection conn = DriverManager.getConnection(
				DB_URL, DB_USER, DB_PASS)) {
			String sql = "UPDATE `tile` SET `type`=?, WHERE id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, type);
			pStmt.setString(2, id);

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
