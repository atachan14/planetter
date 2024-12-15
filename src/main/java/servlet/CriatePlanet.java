package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.PlanetDAO;

/**
 * Servlet implementation class CriatePlanet
 */
@WebServlet("/criatePlanet")
public class CriatePlanet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String PATH_criatePlanet = "WEB-INF/jsp/criatePlanet.jsp";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CriatePlanet() {
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
		switch (request.getParameter("type")) {
		case "toCriatePlanet":
			request.setAttribute("x", request.getParameter("x"));
			request.setAttribute("y", request.getParameter("y"));
			request.getRequestDispatcher(PATH_criatePlanet).forward(request, response);
			return;

		case "check":
			if (PlanetDAO.checkNewPlName(request.getParameter("plName"))) {
				System.out.println("Criate planet.check if");
				PlanetDAO.criateAndGoToPlanet(
						request.getParameter("plName"),
						Integer.parseInt(request.getParameter("xSize")),
						Integer.parseInt(request.getParameter("ySize")),
						(String) request.getSession().getAttribute("acName"),
						Integer.parseInt(request.getParameter("x")),
						Integer.parseInt(request.getParameter("y")));
				response.sendRedirect("main");
				return;
			} else {
				request.setAttribute("error", request.getParameter("already exists"));
				request.setAttribute("x", request.getParameter("x"));
				request.setAttribute("y", request.getParameter("y"));
				request.getRequestDispatcher(PATH_criatePlanet).forward(request, response);
			}

		case "completion":

		}
	}

}
