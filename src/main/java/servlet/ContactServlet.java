package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.AccountDAO;
import dao.WearingCraftDAO;
import model.data.AccountData;

/**
 * Servlet implementation class ContaxtServlet
 */
@WebServlet("/contact")
public class ContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String PATH_contact = "WEB-INF/jsp/contact/contact.jsp";
	private final String PATH_result = "WEB-INF/jsp/contact/result.jsp";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ContactServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher(PATH_contact).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		switch (request.getParameter("kill")) {
		case "殺す":
			AccountData acd = AccountDAO.getAll((String) request.getSession().getAttribute("acName"));
			AccountData v8acd = AccountDAO.getAll((String) request.getParameter("v8acName"));
			AccountDAO.killAccount(acd, v8acd);
			boolean selfDestruction = WearingCraftDAO.checkWearingCraft(v8acd.getName(), "自爆装置(1w)");
			request.setAttribute("selfDestruction", selfDestruction);

			request.getRequestDispatcher(PATH_result).forward(request, response);
			return;
		}

	}

}
