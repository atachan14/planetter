package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.data.PageData;

public class PageDAO {
	private final static String DB_URL = "jdbc:mysql://localhost:3306/planetter";
	private final static String DB_USER = "root";
	private final static String DB_PASS = "root";

	public static PageData findPageDate(int id) {

		try (Connection conn = DriverManager.getConnection(
				DB_URL, DB_USER, DB_PASS)) {
			String sql = "SELECT * FROM page WHERE id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, id);

			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				return new PageData(rs.getString("name"), rs.getString("criater"), rs.getString("date"));
			} else {
				System.out.println("TweetDAO.findTweetDate else");
				return null;
			}

		} catch (SQLException e) {
			System.out.println("TweetDAO.findTweetDate SQLE");
			e.printStackTrace();
			return null;
		}
	}

	public static int insertPage(String pageName, String criater,String tileId) {
		int generatedId = -1;
		try (Connection conn = DriverManager.getConnection(
				DB_URL, DB_USER, DB_PASS)) {
			String sql = "INSERT INTO `page`(`value`,`criater`,`tileId`) VALUES (?,?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pStmt.setString(1, pageName);
			pStmt.setString(2, criater);
			pStmt.setString(3, tileId);
			

			int result = pStmt.executeUpdate();
			if (result > 0) {
				try (ResultSet generatedKeys = pStmt.getGeneratedKeys()) {
					if (generatedKeys.next()) {
						generatedId = generatedKeys.getInt(1);
					} else {
						System.out.println("insertPage.generatedKeys.next()else");
					}
				}
			}
		} catch (SQLException e1) {
			System.out.println("insertPage失敗2");
			e1.printStackTrace();
		}
		return generatedId;
	}

}
