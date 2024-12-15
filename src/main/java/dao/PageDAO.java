package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Comparator;

import model.data.PageData;
import model.data.TweetData;

public class PageDAO {
	private final static String DB_URL = "jdbc:mysql://localhost:3306/planetter";
	private final static String DB_USER = "root";
	private final static String DB_PASS = "root";

	public static PageData criatePageDate(int tileId) {
		PageData pageData = null;
		try (Connection conn = DriverManager.getConnection(
				DB_URL, DB_USER, DB_PASS)) {
			String sql = "SELECT * FROM page WHERE tileId = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, tileId);

			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				pageData = new PageData(rs.getInt("id"), rs.getString("name"), rs.getString("criater"),
						rs.getString("date"));
			} else {
				System.out.println("PageDAO.findPageDate else");
				return null;
			}

			sql = "SELECT * FROM tweet WHERE pageid = ?";
			pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, pageData.getId());

			rs = pStmt.executeQuery();
			while (rs.next()) {
				pageData.getTweetList()
						.add(new TweetData(rs.getString("value"), rs.getString("criater"), rs.getString("date")));
			}
		} catch (SQLException e) {
			System.out.println("PageDAO.findPageDate SQLE");
			e.printStackTrace();
			return null;
		}
		pageData.getTweetList().sort(Comparator.comparing(TweetData::getDate).reversed());

		return pageData;
	}

	public static int insertPage(String pageName, String criater, int tileId) {
		int generatedId = -1;
		try (Connection conn = DriverManager.getConnection(
				DB_URL, DB_USER, DB_PASS)) {
			String sql = "UPDATE account SET stardust = stardust - 10,pageCount=pageCount+1 WHERE name = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, criater);

			int result = pStmt.executeUpdate();
			
			sql = "INSERT INTO `page`(`name`,`criater`,`tileId`) VALUES (?,?,?)";
			pStmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pStmt.setString(1, pageName);
			pStmt.setString(2, criater);
			pStmt.setInt(3, tileId);

			result = pStmt.executeUpdate();
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

	public static int tileIdToPageId(int tileId) {
		try (Connection conn = DriverManager.getConnection(
				DB_URL, DB_USER, DB_PASS)) {
			String sql = "SELECT id FROM page WHERE tileId = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, tileId);

			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				return rs.getInt("Id");
			} else {
				System.out.println("tileIdToPageId rs not");
				return -1;
			}
		} catch (SQLException e1) {
			System.out.println("tileIdToPageId失敗2");
			e1.printStackTrace();
			return -1;
		}

	}
}