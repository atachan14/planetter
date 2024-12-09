package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDAO {
	private final String DB_URL = "jdbc:mysql://localhost:3306/planetter";
	private final String DB_USER = "root";
	private final String DB_PASS = "root";
	private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

	private String name;
	private String pass;

	public AccountDAO(String name, String pass) {
		this.name = name;
		this.pass = pass;
	}

	public boolean AccountCheck() {
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException(
					"JDBCドライバを読み込めませんでした");
		}

		try (Connection conn = DriverManager.getConnection(
				DB_URL, DB_USER, DB_PASS)) {

			String sql = "SELECT COUNT(*) FROM NAME WHERE NAME = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, name);

			ResultSet rs = pStmt.executeQuery();
			if (rs.next() && rs.getInt(1) > 0) {
				System.out.println("USERNAMEが存在します。");
				return true;
			} else {
				System.out.println("USERNAMEが存在しません。");
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public String getPass(String name) {
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException(
					"JDBCドライバを読み込めませんでした");
		}

		try (Connection conn = DriverManager.getConnection(
				DB_URL, DB_USER, DB_PASS)) {
			String sql = "SELECT PASS FROM NAME WHERE NAME = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, name);

			ResultSet rs = pStmt.executeQuery();
			return rs.getString("PASS");
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	public boolean register() {
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException(
					"JDBCドライバを読み込めませんでした");
		}

		try (Connection conn = DriverManager.getConnection(
				DB_URL, DB_USER, DB_PASS)) {
			String sql = "INSERT INTO `account`(`name`, `pass`, `stardust`, `nowPlanet`, `x`, `y`, `direction`) "
					+ "VALUES (?,?,?,?,?,?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, name);
			pStmt.setString(2, pass);
			pStmt.setInt(3, 10000);
			pStmt.setString(4, "beginerPlanet");
			pStmt.setInt(5, 5);
			pStmt.setInt(6, 5);
			pStmt.setInt(7, 2);

			int result = pStmt.executeUpdate();
			if (result != 1) {
				return false;
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
			return false;
		}

		return true;

	}

}
