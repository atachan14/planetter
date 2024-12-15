package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.TileDAO;
import model.data.AccountData;

/**
 * Servlet implementation class MainSideServlet
 */
@WebServlet("/mainSide")
public class MainSideServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String PATH_main = "WEB-INF/jsp/main.jsp";
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MainSideServlet() {
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
		switch(request.getParameter("button")) {
		case "分解する":
			TileDAO.disassembly((AccountData)request.getSession().getAttribute("acd"));
			response.sendRedirect("main");
			return;
		}
		
		AccountData acd = (AccountData) request.getSession().getAttribute("acd");
		

		request.getRequestDispatcher(PATH_main).forward(request, response);
	}

}
