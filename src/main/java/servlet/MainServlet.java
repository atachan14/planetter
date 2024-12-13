package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import dao.AccountDAO;
import model.FootButtonExe;
import model.data.AccountData;
import model.display.MainCenterDisplay;
import model.display.MainInfoDisplay;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/main")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String PATH_main = "WEB-INF/jsp/main.jsp";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MainServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String acName = (String) session.getAttribute("acName");
		AccountDAO acdao = new AccountDAO(acName);

		AccountData acd = acdao.getAll();
		session.setAttribute("acd", acd);

		MainInfoDisplay mainInfo = new MainInfoDisplay(session);
		session.setAttribute("mainInfo", mainInfo);

		MainCenterDisplay mainCenter = new MainCenterDisplay(session);
		session.setAttribute("mainCenter", mainCenter);

		request.getRequestDispatcher(PATH_main).forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		switch (request.getParameter("formType")) {
		case "foot":
			FootButtonExe fbe = new FootButtonExe(request);
			fbe.exe();
			doGet(request, response);
		case "sdButton":
			MainCenterDisplay mainCenter = new MainCenterDisplay();
			mainCenter.selectSideButton(request.getParameter("button"));
			request.setAttribute("mainCenter", mainCenter);
			request.getRequestDispatcher(PATH_main).forward(request, response);
		}
	}
}
