package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import model.data.AccountData;
import model.data.TileData;

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
						rs.getInt("stomach"), rs.getInt("x"), rs.getInt("y"), rs.getInt("direction"),
						rs.getTimestamp("date"),rs.getInt("walkCount"), rs.getInt("eatCount"), rs.getInt("tweetCount"), 
						rs.getInt("pageCount"), rs.getInt("dsasseCount"),rs.getInt("planetCount"),
						rs.getInt("killCount"));
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

	public static AccountData getAll(String name) {
		try (Connection conn = DriverManager.getConnection(
				DB_URL, DB_USER, DB_PASS)) {
			String sql = "SELECT * FROM `account` WHERE name=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, name);

			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				return new AccountData(rs.getString("name"), rs.getString("nowplanet"), rs.getInt("stardust"),
						rs.getInt("stomach"), rs.getInt("x"), rs.getInt("y"), rs.getInt("direction"),
						rs.getTimestamp("date"),rs.getInt("walkCount"), rs.getInt("eatCount"), rs.getInt("tweetCount"), 
						rs.getInt("pageCount"), rs.getInt("dsasseCount"),rs.getInt("planetCount"),
						rs.getInt("killCount"));

			} else {
				System.out.println("acdao.getAll データが見つかりません:" + name);
				return null;
			}

		} catch (SQLException e1) {
			System.out.println("acdao.getAll失敗:" + name);
			e1.printStackTrace();
			return null;
		}
	}

	public static boolean moveShaftIntAcd(String shaft, int point, AccountData acd) {
		try (Connection conn = DriverManager.getConnection(
				DB_URL, DB_USER, DB_PASS)) {

			int stomach = acd.getStomach() - 1;

			String sql = "UPDATE account SET stomach = ?,walkCount =walkCount+1 WHERE name = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, stomach);
			pStmt.setString(2, acd.getName());

			int result = pStmt.executeUpdate();
			if (result != 1) {
				System.out.println("move stomach update失敗1");
				return false;
			}

			sql = "UPDATE account SET " + shaft + " = ? WHERE name = ?";
			pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, point);
			pStmt.setString(2, acd.getName());

			result = pStmt.executeUpdate();
			if (result != 1) {
				System.out.println("move Int失敗1");
				return false;
			}
		} catch (SQLException e1) {
			System.out.println("move Int失敗2");
			e1.printStackTrace();
			return false;
		}
		return true;
	}

	public static AccountData posTileSearchAccount(TileData posTile) {
		try (Connection conn = DriverManager.getConnection(
				DB_URL, DB_USER, DB_PASS)) {
			String sql = "SELECT * FROM `account` WHERE nowPlanet=? AND x=? AND y=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, posTile.getPlName());
			pStmt.setInt(2, posTile.getX());
			pStmt.setInt(3, posTile.getY());

			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				return new AccountData(rs.getString("name"), rs.getString("nowplanet"), rs.getInt("stardust"),
						rs.getInt("stomach"), rs.getInt("x"), rs.getInt("y"), rs.getInt("direction"),
						rs.getTimestamp("date"),rs.getInt("walkCount"), rs.getInt("eatCount"), rs.getInt("tweetCount"), 
						rs.getInt("pageCount"), rs.getInt("dsasseCount"),rs.getInt("planetCount"),
						rs.getInt("killCount"));
			} else {
				return new AccountData();
			}

		} catch (SQLException e1) {
			System.out.println("posTileSearchAccount sqle失敗");
			e1.printStackTrace();
			return new AccountData();
		}
	}

	public static void deleteAccount(String acName) {
		try (Connection conn = DriverManager.getConnection(
				DB_URL, DB_USER, DB_PASS)) {
			String sql = "DELETE FROM `account` WHERE name=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, acName);

			int result = pStmt.executeUpdate();
			if (result != 1) {
				System.out.println("deleteAccount失敗1");
			}
		} catch (SQLException e1) {
			System.out.println("deleteAccount失敗2");
			e1.printStackTrace();
		}
	}

	public static void killAccount(AccountData acd, AccountData v8acd) {
		try (Connection conn = DriverManager.getConnection(
				DB_URL, DB_USER, DB_PASS)) {

			//stardustとstomach保存
			int stardust = acd.getStardust() + v8acd.getStardust();
			int stomach = acd.getStomach() + v8acd.getStomach();

			//delete
			String sql = "DELETE FROM `account` WHERE name=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, v8acd.getName());

			int result = pStmt.executeUpdate();
			if (result != 1) {
				System.out.println("killAccount delete失敗");
			}

			//stardust,stomach更新
			sql = "UPDATE `account` SET `stardust`=?, `stomach`=?,killCount=killCount+1 WHERE name=?";
			pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, stardust);
			pStmt.setInt(2, stomach);
			pStmt.setString(3, acd.getName());

			result = pStmt.executeUpdate();
			if (result != 1) {
				System.out.println("killAccount update失敗");
			}
		} catch (SQLException e1) {
			System.out.println("killAccount SQLE失敗");
			e1.printStackTrace();
		}
	}

	public static String acNameToPlName(String name) {
		try (Connection conn = DriverManager.getConnection(
				DB_URL, DB_USER, DB_PASS)) {
			String sql = "SELECT planet FROM `account` WHERE name=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, name);

			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				return rs.getString("planet");
			} else {
				System.out.println("acdao.acNameToPlName データが見つかりません:" + name);
				return null;
			}

		} catch (SQLException e1) {
			System.out.println("acdao.acNameToPlName 失敗:" + name);
			e1.printStackTrace();
			return null;
		}
	}

	public static void landingPlanet(String acName, String plName) {
		try (Connection conn = DriverManager.getConnection(
				DB_URL, DB_USER, DB_PASS)) {
			int xSize = 0;
			int ySize = 0;

			String sql = "SELECT xsize,ysize FROM planet WHERE name=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, plName);

			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				xSize = rs.getInt("xsize");
				ySize = rs.getInt("ysize");
			} else {
				System.out.println("acdao.landingPlanet planetSizeがみつからｎ plName:" + plName);
			}

			sql = "UPDATE account SET nowPlanet=?,x=?,y=? WHERE name = ?";
			pStmt = conn.prepareStatement(sql);

			Random random = new Random();
			pStmt.setString(1, plName);
			pStmt.setInt(2, random.nextInt(xSize));
			pStmt.setInt(3, random.nextInt(ySize));
			pStmt.setString(4, acName);

			int result = pStmt.executeUpdate();
			if (result != 1) {
				System.out.println("acdao landingPlanet update失敗");
			}
		} catch (SQLException e1) {
			System.out.println("acdao landingPlanet SQLE失敗");
			e1.printStackTrace();
		}
	}

	public static void rocketEntry(String acName) {
		try (Connection conn = DriverManager.getConnection(
				DB_URL, DB_USER, DB_PASS)) {

			String sql = "UPDATE account SET stardust=stardust-100 WHERE name = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, acName);

			int result = pStmt.executeUpdate();
			if (result != 1) {
				System.out.println("acdao rocketEntry update失敗");
			}
		} catch (SQLException e1) {
			System.out.println("acdao rocketEntry SQLE失敗");
			e1.printStackTrace();
		}
	}
}
