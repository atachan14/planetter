package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
				return new TweetData(rs.getString("value"), rs.getString("criater"),rs.getString("date"));
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

}
