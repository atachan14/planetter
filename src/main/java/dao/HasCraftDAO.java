package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.data.AccountData;
import model.data.CraftData;

public class HasCraftDAO {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/planetter";
	private static final String DB_USER = "root";
	private static final String DB_PASS = "root";

	public static void insertCraft(int destiny, String crName, int sd, AccountData acd, int cost) {
		try (Connection conn = DriverManager.getConnection(
				DB_URL, DB_USER, DB_PASS)) {
			String sql = "INSERT INTO `hasCraft`(destiny,`crName`, `sd`, `acName`) VALUES (?,?,?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, destiny);
			pStmt.setString(2, crName);
			pStmt.setInt(3, sd);
			pStmt.setString(4, acd.getName());

			int result = pStmt.executeUpdate();
			if (result != 1) {
				System.out.println("insertCraft失敗1" + result);
			}
			sql = "UPDATE account SET stardust = stardust-? WHERE name = ?";
			pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, cost);
			pStmt.setString(2, acd.getName());
			result = pStmt.executeUpdate();
			if (result != 1) {
				System.out.println("insertCraft cost失敗:" + result);
			}

		} catch (SQLException e1) {
			System.out.println("insertCraft失敗2");
			e1.printStackTrace();
		}
	}

	public static List<CraftData> criateCrList(String acName) {
		List<CraftData> crList = new ArrayList<>();
		crList.add(new CraftData(-1, 98, "自爆装置(1w)", 9000));

		try (Connection conn = DriverManager.getConnection(
				DB_URL, DB_USER, DB_PASS)) {
			String sql = "SELECT * FROM hasCraft WHERE acName = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, acName);

			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				crList.add(
						new CraftData(rs.getInt("id"), rs.getInt("destiny"), rs.getString("crName"), rs.getInt("sd")));
			}
		} catch (SQLException e1) {
			System.out.println("criateCrList失敗2");
			e1.printStackTrace();
		}
		
		return crList;
	}

}
