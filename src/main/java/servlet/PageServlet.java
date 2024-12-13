package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.PageDAO;
import dao.TileDAO;
import dao.TweetDAO;

/**
 * Servlet implementation class PageServlet
 */
@WebServlet("/PageServlet")
public class PageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PageServlet() {
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
		String pageName = request.getParameter("pageName");
		if (!checkValueSize(pageName)) {
			//あとで実装 フォワードで戻してエラーフラグを受け取らせる予定。
		}
		int pageId = PageDAO.insertPage(pageName, request.getParameter("acName"), request.getParameter("tileId"));
		System.out.println("pageServlet.pageId:" + pageId);

		TweetDAO.updatePageId(pageId, request.getParameter("tileId"));
		TileDAO.updateType("page", request.getParameter("tileId"));

		response.sendRedirect("main");
	}

	boolean checkValueSize(String value) {
		if (value.length() > 16) {
			return false;
		}
		return true;
	}
}
