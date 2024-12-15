package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.AccountDAO;
import model.data.PlanetData;
import model.tool.AroundPlanetsCriater;

/**
 * Servlet implementation class Galaxy
 */
@WebServlet("/galaxy")
public class GalaxyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String PATH_galaxyMap = "WEB-INF/jsp/galaxyMap.jsp";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GalaxyServlet() {
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
		case "小型ロケット":
			AccountDAO.rocketEntry((String) request.getSession().getAttribute("acName"));
			PlanetData[][] aroundPlanets = AroundPlanetsCriater.Exe(request.getParameter("plName"));
			request.setAttribute("aroundPlanets", aroundPlanets);
			request.getRequestDispatcher(PATH_galaxyMap).forward(request, response);
			return;
			
		case "アップデート":
			//あとで実装
			return;
		default:
			System.out.println("galaxy dopost switch default");
			return;
		}
	}

}
