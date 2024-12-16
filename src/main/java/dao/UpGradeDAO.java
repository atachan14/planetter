package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.data.AccountData;
import model.data.UpGradeData;

public class UpGradeDAO {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/planetter";
	private static final String DB_USER = "root";
	private static final String DB_PASS = "root";

	public static void insertUpGrade(int destiny, String ugName, int sd, AccountData acd, int cost) {
		try (Connection conn = DriverManager.getConnection(
				DB_URL, DB_USER, DB_PASS)) {
			String sql = "INSERT INTO `pl_upgrade`(destiny,`ugName`, `sd`, `plName`) VALUES (?,?,?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, destiny);
			pStmt.setString(2, ugName);
			pStmt.setInt(3, sd);
			pStmt.setString(4, acd.getPlanet());

			int result = pStmt.executeUpdate();
			if (result != 1) {
				System.out.println("insertUpGrade失敗1" + result);
			}
			sql = "UPDATE account SET stardust = stardust-? WHERE name = ?";
			pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, cost);
			pStmt.setString(2, acd.getName());
			result = pStmt.executeUpdate();
			if (result != 1) {
				System.out.println("insertUpGrade cost失敗:" + result);
			}

		} catch (SQLException e1) {
			System.out.println("insertUpGrade失敗2");
			e1.printStackTrace();
		}
	}

	public static List<UpGradeData> criateUgList(String plName) {
		List<UpGradeData> ugList = new ArrayList<>();
		ugList.add(new UpGradeData(98,"名前を表示",9000));
		ugList.add(new UpGradeData(99,"カラー変更",2000));
		
		try (Connection conn = DriverManager.getConnection(
				DB_URL, DB_USER, DB_PASS)) {
			String sql = "SELECT * FROM pl_upgrade WHERE plName = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, plName);

			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				ugList.add(new UpGradeData(rs.getInt("destiny"), rs.getString("ugName"), rs.getInt("sd")));
			}
		} catch (SQLException e1) {
			System.out.println("criateUgList失敗2");
			e1.printStackTrace();
		}
		return ugList;
	}

}
