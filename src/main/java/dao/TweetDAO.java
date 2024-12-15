package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.data.TweetData;

public class TweetDAO {
	private final static String DB_URL = "jdbc:mysql://localhost:3306/planetter";
	private final static String DB_USER = "root";
	private final static String DB_PASS = "root";

	public static TweetData tileIdToTweetData(int tileId) {
		try (Connection conn = DriverManager.getConnection(
				DB_URL, DB_USER, DB_PASS)) {
			String sql = "SELECT * FROM tweet WHERE tileId = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, tileId);

			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				return new TweetData(rs.getString("value"), rs.getString("criater"), rs.getString("date"));
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

	public static int insertTweetInTile(String value, String criater, int tileId) {
		int generatedId = -1;
		try (Connection conn = DriverManager.getConnection(
				DB_URL, DB_USER, DB_PASS)) {

			String sql = "UPDATE account SET stardust = stardust - 1,tweetCount=tweetCount+1 WHERE name = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, criater);

			int result = pStmt.executeUpdate();
			
			sql = "INSERT INTO `tweet`(`value`,`criater`,`tileId`) VALUES (?,?,?)";
			pStmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pStmt.setString(1, value);
			pStmt.setString(2, criater);
			pStmt.setInt(3, tileId);

			result = pStmt.executeUpdate();
			if (result > 0) {
				try (ResultSet generatedKeys = pStmt.getGeneratedKeys()) {
					if (generatedKeys.next()) {
						generatedId = generatedKeys.getInt(1);
					} else {
						System.out.println("insertTweet.generatedKeys.next()else");
					}
				}
			}
		} catch (SQLException e1) {
			System.out.println("insertTweet失敗2");
			e1.printStackTrace();
		}

		return generatedId;

	}

	public static int insertTweetInPage(String value, String criater, int pageId) {
		int generatedId = -1;
		try (Connection conn = DriverManager.getConnection(
				DB_URL, DB_USER, DB_PASS)) {
			
			String sql = "UPDATE account SET stardust = stardust - 1,tweetCount=tweetCount+1 WHERE name = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, criater);

			int result = pStmt.executeUpdate();
			System.out.println("tweetinpage stardust-1 result:"+result);
			
			sql = "INSERT INTO `tweet`(`value`,`criater`,`pageId`) VALUES (?,?,?)";
			pStmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pStmt.setString(1, value);
			pStmt.setString(2, criater);
			pStmt.setInt(3, pageId);

			result = pStmt.executeUpdate();
			if (result > 0) {
				try (ResultSet generatedKeys = pStmt.getGeneratedKeys()) {
					if (generatedKeys.next()) {
						generatedId = generatedKeys.getInt(1);
					} else {
						System.out.println("insertTweet.generatedKeys.next()else");
					}
				}
			}
		} catch (SQLException e1) {
			System.out.println("insertTweet失敗2");
			e1.printStackTrace();
		}
		return generatedId;
	}

	public static void updatePageId(int pageId, int tileId) {
		try (Connection conn = DriverManager.getConnection(
				DB_URL, DB_USER, DB_PASS)) {
			String sql = "UPDATE `tweet` SET `pageId`=? WHERE tileId=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, pageId);
			pStmt.setInt(2, tileId);

			int result = pStmt.executeUpdate();
			if (result != 1) {

				System.out.println("tweetDAO updatePageId:しっぱい１");
				System.out.println("pageId:" + pageId + "tileId" + tileId);
			}
		} catch (SQLException e) {
			System.out.println("tweetDAO updatePageId:しっぱい2");
			System.out.println("pageId:" + pageId + "tileId" + tileId);
			e.printStackTrace();
		}
	}
}
