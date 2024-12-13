package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.TileDAO;
import dao.TweetDAO;
import model.data.AccountData;

/**
 * Servlet implementation class TweetServlet
 */
@WebServlet("/tweet")
public class TweetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TweetServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String value = request.getParameter("tweet");
		if (!checkValueSize(value)) {
			//あとで実装 フォワードで戻してエラーフラグを受け取らせる かも。
		}
		int tileId = TileDAO.insertTile("tweet",(AccountData)request.getSession().getAttribute("acd"));
		TweetDAO.insertTweet(value, request.getParameter("acName"),tileId);

		response.sendRedirect("main");
	}

	boolean checkValueSize(String value) {
		if (value.length() > 64) {
			return false;
		}
		return true;
	}

}
