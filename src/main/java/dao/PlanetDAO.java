package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Pos;

public class PlanetDAO {
	private final static String DB_URL = "jdbc:mysql://localhost:3306/planetter";
	private final static String DB_USER = "root";
	private final static String DB_PASS = "root";

	//	public static PlanetInfo getALL(String planet) {
	//		try (Connection conn = DriverManager.getConnection(
	//				DB_URL, DB_USER, DB_PASS)) {
	//			String sql = "SELECT * FROM planet WHERE NAME = ?";
	//			PreparedStatement pStmt = conn.prepareStatement(sql);
	//			pStmt.setString(1, planet);
	//
	//			
	//			return rs;
	//		} catch (SQLException e) {
	//			System.out.println("PlanetDAO.getAll失敗");
	//			e.printStackTrace();
	//		}
	//		return null;
	//	}

	public static Pos getSize(String planet) {
		try (Connection conn = DriverManager.getConnection(
				DB_URL, DB_USER, DB_PASS)) {
			String sql = "SELECT xsize,ysize FROM planet WHERE NAME = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, planet);

			ResultSet rs = pStmt.executeQuery();
			System.out.println("chek"+planet);
			if (rs.next()) {
				int x = rs.getInt("xsize");
				int y = rs.getInt("ysize");
				Pos pos = new Pos(x, y);
				System.out.println("getSize" + pos.getx());
				return pos;
			}
		} catch (SQLException e) {
			System.out.println("PlanetDAO.getSize SQLE");
			e.getStackTrace();
			return null;
		}
		System.out.println("getSize通ってない");
		return null;

	}
}
