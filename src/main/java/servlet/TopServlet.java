package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TopServlet
 */
@WebServlet("/Top")
public class TopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String PATH_top = "WEB-INF/jsp/top.jsp";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TopServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher(PATH_top).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String acount = request.getParameter("acount");
		String pass = request.getParameter("pass");

		switch (request.getParameter("action")) {
		case "登録":
			registerCheck(acount, pass);
			request.setAttribute("acount",acount);
			response.sendRedirect("main");
			break;

		case "ログイン":
			roginCheck(acount, pass);
			request.setAttribute("acount",acount);
			response.sendRedirect("main");
			break;

		default:
			System.out.println("top.doPost default");
			break;
		}
	}

	protected void registerCheck(String name, String pass) {
	}

	protected void roginCheck(String name, String pass) {

	}
}
