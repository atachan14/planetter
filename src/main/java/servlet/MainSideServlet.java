package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.HasCraftDAO;
import dao.TileDAO;
import dao.UpGradeDAO;
import model.data.AccountData;
import model.display.MainCenterDisplay;

/**
 * Servlet implementation class MainSideServlet
 */
@WebServlet("/mainSide")
public class MainSideServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String PATH_main = "WEB-INF/jsp/main.jsp";
	private final String PATH_upGrade = "/WEB-INF/jsp/mainCenter/action/upGrade.jsp";
	private final String PATH_craft = "/WEB-INF/jsp/mainCenter/action/craft.jsp";

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
		switch (request.getParameter("button")) {
		case "アップグレード":
			MainCenterDisplay mc = (MainCenterDisplay) request.getSession().getAttribute("mainCenter");
			AccountData acd = (AccountData) request.getSession().getAttribute("acd");
			mc.setJsp(PATH_upGrade);
			mc.setData(UpGradeDAO.criateUgList(acd.getPlanet()));
			request.getRequestDispatcher(PATH_main).forward(request, response);
			return;

		case "分解する":
			TileDAO.disassembly((AccountData) request.getSession().getAttribute("acd"));
			response.sendRedirect("main");
			return;
			
		case "クラフト":
			MainCenterDisplay mc2 = (MainCenterDisplay) request.getSession().getAttribute("mainCenter");
			AccountData acd2 = (AccountData) request.getSession().getAttribute("acd");
			mc2.setJsp(PATH_craft);
			mc2.setData(HasCraftDAO.criateCrList(acd2.getName()));
			request.getRequestDispatcher(PATH_main).forward(request, response);
			return;
		}

		

		request.getRequestDispatcher(PATH_main).forward(request, response);
	}

}
