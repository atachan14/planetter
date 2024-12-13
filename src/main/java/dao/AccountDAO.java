package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import model.data.AccountData;

public class AccountDAO {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/planetter";
	private static final String DB_USER = "root";
	private static final String DB_PASS = "root";

	private String name;
	private String pass;

	public AccountDAO(String name) {
		this.name = name;
	}

	public AccountDAO(String name, String pass) {
		this.name = name;
		this.pass = pass;
	}

	public boolean AccountCheck() {
		//		try {
		//			Class.forName(JDBC_DRIVER);
		//		} catch (ClassNotFoundException e) {
		//			throw new IllegalStateException(
		//					"JDBCドライバを読み込めませんでした");
		//		}

		try (Connection conn = DriverManager.getConnection(
				DB_URL, DB_USER, DB_PASS)) {

			String sql = "SELECT COUNT(*) FROM ACCOUNT WHERE NAME = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, name);
			System.out.println(name);

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
		//		try {
		//			Class.forName(JDBC_DRIVER);
		//		} catch (ClassNotFoundException e) {
		//			throw new IllegalStateException(
		//					"JDBCドライバを読み込めませんでした");
		//		}

		try (Connection conn = DriverManager.getConnection(
				DB_URL, DB_USER, DB_PASS)) {
			String sql = "SELECT PASS FROM ACCOUNT WHERE NAME = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, name);

			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				return rs.getString("PASS");
			} else {
				System.out.println("acdao.getPass:データが見つかりません");
				return null;
			}
		} catch (SQLException e) {
			System.out.println("acdao.getPass:SQLException");
			e.printStackTrace();
			return null;
		}

	}

	public boolean register() {

		Random random = new Random();

		try (Connection conn = DriverManager.getConnection(
				DB_URL, DB_USER, DB_PASS)) {
			String sql = "INSERT INTO `account`(`name`, `pass`, `stardust`, `nowPlanet`, `x`, `y`, `direction`) VALUES (?,?,?,?,?,?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, name);
			pStmt.setString(2, pass);
			pStmt.setInt(3, 10000);
			pStmt.setString(4, "BeginersPlanet");
			pStmt.setInt(5, random.nextInt(10));
			pStmt.setInt(6, random.nextInt(10));
			pStmt.setInt(7, random.nextInt(4));

			int result = pStmt.executeUpdate();
			if (result != 1) {
				System.out.println("acdao.register失敗1");
				return false;
			}
		} catch (SQLException e1) {
			System.out.println("acdao.register失敗2");
			e1.printStackTrace();
			return false;
		}

		return true;
	}

	public String getPlanet() {
		try (Connection conn = DriverManager.getConnection(
				DB_URL, DB_USER, DB_PASS)) {
			String sql = "SELECT `nowPlanet` FROM `account` WHERE name=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, name);

			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				return rs.getString("nowPlanet");
			} else {
				System.out.println("acdao.getPlanet データが見つかりません");
				return null;
			}

		} catch (SQLException e1) {
			System.out.println("acdao.getPlanet失敗");
			e1.printStackTrace();
			return null;
		}
	}

	public AccountData getAll() {
		try (Connection conn = DriverManager.getConnection(
				DB_URL, DB_USER, DB_PASS)) {
			String sql = "SELECT * FROM `account` WHERE name=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, name);

			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				return new AccountData(rs.getString("name"), rs.getString("nowplanet"), rs.getInt("stardust"),
						rs.getInt("stomach"), rs.getInt("x"), rs.getInt("y"), rs.getInt("direction"));

			} else {
				System.out.println("acdao.getAll データが見つかりません");
				return null;
			}

		} catch (SQLException e1) {
			System.out.println("acdao.getAll失敗");
			e1.printStackTrace();
			return null;
		}
	}

	public static boolean updateInt(String calumn, int value, String name) {
		try (Connection conn = DriverManager.getConnection(
				DB_URL, DB_USER, DB_PASS)) {
			String sql = "UPDATE account SET " + calumn + " = ? WHERE name = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, value);
			pStmt.setString(2, name);

			int result = pStmt.executeUpdate();
			if (result != 1) {
				System.out.println("acdao.updateInt失敗1");
				return false;
			}
		} catch (SQLException e1) {
			System.out.println("acdao.updateInt失敗2");
			e1.printStackTrace();
			return false;
		}
		return true;
	}
}
