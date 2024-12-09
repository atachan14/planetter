package servlet;

import java.io.IOException;

import dao.AccountDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Account;
import model.AccountSetupper;

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
		AccountSetupper acsu=new AccountSetupper(request);
		acsu.exe();
		
		response.sendRedirect("main");
	

	
	}

	protected void setAcount(HttpServletRequest request) {
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		
		AccountDAO adad = new AccountDAO(name,pass);
	

		Account acount = new Account(name);
		request.setAttribute("acount",acount);
	}
	
	protected void register() {
		
	}

}
