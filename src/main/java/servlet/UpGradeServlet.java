package servlet;

import java.io.IOException;

import dao.PlanetDAO;
import dao.UpGradeDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.data.AccountData;
import model.data.UpGradeData;
import model.display.MainCenterDisplay;
import model.upGrade.DestinyDrowManager;

/**
 * Servlet implementation class UpGrade
 */
@WebServlet("/upGrade")
public class UpGradeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String PATH_main = "WEB-INF/jsp/main.jsp";
	private final String PATH_colorChange = "/WEB-INF/jsp/mainCenter/action/colorChange.jsp";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpGradeServlet() {
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
		case "カラー変更":
			MainCenterDisplay md = (MainCenterDisplay) request.getSession().getAttribute("mainCenter");
			md.setJsp(PATH_colorChange);
			request.getRequestDispatcher(PATH_main).forward(request, response);
			return;
		case "変身っ！":
			AccountData acd = (AccountData) request.getSession().getAttribute("acd");
			PlanetDAO.changeColor("backGroundColor", request.getParameter("backGroundColor"), acd);
			response.sendRedirect("main");
			return;
		case "ディスティニードロー":
			AccountData acd2 = (AccountData) request.getSession().getAttribute("acd");
			UpGradeData ug = DestinyDrowManager.nomalExe(acd2.getPlanet());
			UpGradeDAO.insertUpGrade(ug.getDestiny(), ug.getUgName(), ug.getSd(), acd2, 10000);
			response.sendRedirect("main");
			return;
		case "ハイパーディスティニードロー":
			AccountData acd3 = (AccountData) request.getSession().getAttribute("acd");
			UpGradeData ug2 = DestinyDrowManager.hyperExe(acd3.getPlanet());
			UpGradeDAO.insertUpGrade(ug2.getDestiny(), ug2.getUgName(), ug2.getSd(), acd3, 20000);
			response.sendRedirect("main");
			return;
		default:
			System.out.println("UpGrade Servlet doPost:" + request.getParameter("button"));
			return;
		}
	}
}
