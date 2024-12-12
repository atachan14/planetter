package servlet;

import java.io.IOException;

import dao.AccountDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.FootButtonExe;
import model.data.AccountData;
import model.display.MainInfoDisplay;
import model.display.MainCenterDisplay;

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
		
		MainCenterDisplay nowInfo = new MainCenterDisplay(session);
		

		request.getRequestDispatcher(PATH_main).forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		FootButtonExe fbe = new FootButtonExe(request);
		fbe.exe();

		doGet(request, response);
	}
}
