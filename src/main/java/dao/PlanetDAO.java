package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Random;

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
				return new PlanetData("no planet", pos.getx(), pos.gety());
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

	public static boolean checkNewPlName(String plName) {
		try (Connection conn = DriverManager.getConnection(
				DB_URL, DB_USER, DB_PASS)) {
			String sql = "SELECT COUNT(*) FROM planet WHERE NAME = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, plName);

			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				int count = rs.getInt(1);
				if (count > 0) {
					return false;
				} else {
					return true;
				}
			}
		} catch (SQLException e) {
			System.out.println("checkPlName SQLE");
			e.getStackTrace();
			return false;
		}
		System.out.println("checkPlName 3");
		return false;
	}

	public static void criateAndGoToPlanet(String plName, int xSize, int ySize, String acName, int x,
			int y) {
		try (Connection conn = DriverManager.getConnection(
				DB_URL, DB_USER, DB_PASS)) {
			String sql = "INSERT INTO `planet`(`name`, `xsize`, `ysize`, `criater`, `x`, `y`) VALUES (?,?,?,?,?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, plName);
			pStmt.setInt(2, xSize);
			pStmt.setInt(3, ySize);
			pStmt.setString(4, acName);
			pStmt.setInt(5, x);
			pStmt.setInt(6, y);

			int result = pStmt.executeUpdate();
			if (result != 1) {
				System.out.println("criateAndGoToPlanet失敗1:"+result);
			}

			Random random = new Random();
			int cost = (xSize + ySize) * 1000;
			sql = "UPDATE account SET stardust=stardust-?,nowPlanet=?,x=?,y=?,direction=?, planetCount=planetCount+1 WHERE name=?";
			pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, cost);
			pStmt.setString(2, plName);
			pStmt.setInt(3, random.nextInt(xSize));
			pStmt.setInt(4, random.nextInt(ySize));
			pStmt.setInt(5, random.nextInt(4));
			pStmt.setString(6, acName);
			
			result = pStmt.executeUpdate();
			if (result != 1) {
				System.out.println("criateAndGoToPlanet updateAccount失敗:result"+result);
			}

		} catch (SQLException e1) {
			System.out.println("criateAndGoToPlanet失敗2");
			e1.printStackTrace();
		}
	}
}
