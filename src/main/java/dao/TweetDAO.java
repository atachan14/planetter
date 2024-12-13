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

	public static TweetData findTweetDate(int objectId) {
		try (Connection conn = DriverManager.getConnection(
				DB_URL, DB_USER, DB_PASS)) {
			String sql = "SELECT * FROM tweet WHERE id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, objectId);

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

	public static int insertTweet(String value, String criater) {
		int generatedId = -1;
		try (Connection conn = DriverManager.getConnection(
				DB_URL, DB_USER, DB_PASS)) {
			String sql = "INSERT INTO `tweet`(`value`,`criater`) VALUES (?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pStmt.setString(1, value);
			pStmt.setString(2, criater);

			int result = pStmt.executeUpdate();
			if (result > 0) {
				try (ResultSet generatedKeys = pStmt.getGeneratedKeys()) {
					if (generatedKeys.next()) {
						generatedId = generatedKeys.getInt(1);
					}else {
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

}
