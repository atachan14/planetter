package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import model.Pos;
import model.data.PlanetData;

public class PlanetDAO {
	private final static String DB_URL = "jdbc:mysql://localhost:3306/planetter";
	private final static String DB_USER = "root";
	private final static String DB_PASS = "root";

	public static Pos plNameToPos(String plName) {
		try (Connection conn = DriverManager.getConnection(
				DB_URL, DB_USER, DB_PASS)) {
			String sql = "SELECT x,y FROM planet WHERE NAME = ?;";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, plName);
			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				int x = rs.getInt("x");
				int y = rs.getInt("y");
				Pos pos = new Pos(x, y);
				return pos;
			} else {
				System.out.println("plNameToPos失敗 else");
			}
		} catch (SQLException e) {
			System.out.println("plNameToPos失敗 sqle");
			e.printStackTrace();
		}
		return null;
	}

	public static PlanetData posToAll(Pos pos) {
		try (Connection conn = DriverManager.getConnection(
				DB_URL, DB_USER, DB_PASS)) {
			String sql = "SELECT * FROM planet WHERE x = ? AND y = ?;";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, pos.getx());
			pStmt.setInt(2, pos.gety());
			
			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				String name = rs.getString("name");
				int xsize = rs.getInt("xsize");
				int ysize = rs.getInt("ysize");
				String criater = rs.getString("criater");
				int x = rs.getInt("x");
				int y = rs.getInt("y");
				Timestamp date = rs.getTimestamp("date");
				int nameDisplay = rs.getInt("nameDisplay");
				int stealth = rs.getInt("stealth");
				PlanetData pld = new PlanetData(name, xsize, ysize, criater, x, y, date, nameDisplay, stealth);
				return pld;
			} else {
				return new PlanetData("no planet");
			}
		} catch (SQLException e) {
			System.out.println("plNameToPos失敗 sqle");
			e.printStackTrace();
		}
		return null;
	}

	public static Pos getSize(String planet) {
		try (Connection conn = DriverManager.getConnection(
				DB_URL, DB_USER, DB_PASS)) {
			String sql = "SELECT xsize,ysize FROM planet WHERE NAME = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, planet);

			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				int x = rs.getInt("xsize");
				int y = rs.getInt("ysize");
				Pos pos = new Pos(x, y);
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
