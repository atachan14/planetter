package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.data.AccountData;

public class WearingCraftDAO {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/planetter";
	private static final String DB_USER = "root";
	private static final String DB_PASS = "root";

	public static void insertWearingCraft(int destiny, String crName, AccountData acd, int cost) {
		try (Connection conn = DriverManager.getConnection(
				DB_URL, DB_USER, DB_PASS)) {
			String sql = "INSERT INTO `wearingCraft`(destiny,`crName`, `acName`) VALUES (?,?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, destiny);
			pStmt.setString(2, crName);
			pStmt.setString(3, acd.getName());

			int result = pStmt.executeUpdate();
			if (result != 1) {
				System.out.println("insertWearingCraft失敗1" + result);
			}
			sql = "UPDATE account SET stardust = stardust-? WHERE name = ?";
			pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, cost);
			pStmt.setString(2, acd.getName());
			result = pStmt.executeUpdate();
			if (result != 1) {
				System.out.println("insertWearingCraft cost失敗:" + result);
			}

		} catch (SQLException e1) {
			System.out.println("insertWearingCraft失敗2");
			e1.printStackTrace();
		}
	}

	public static boolean checkWearingCraft(String targetAcName,String crName) {
		try (Connection conn = DriverManager.getConnection(
				DB_URL, DB_USER, DB_PASS)) {
			String sql = "SELECT COUNT(*) FROM wearingCraft WHERE acName = ? AND crName = ?";
;
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, targetAcName);
			pStmt.setString(2, crName);

			ResultSet rs = pStmt.executeQuery();
			  if (rs.next()) {
		            int count = rs.getInt(1);
		            return count > 0; // 条件に一致する行が存在するかどうか
		        }
			  return false;
		} catch (SQLException e1) {
			System.out.println("checkSelfDestruction失敗2");
			e1.printStackTrace();
		}
		return false;
	}
}
