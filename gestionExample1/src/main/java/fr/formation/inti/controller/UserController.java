package fr.formation.inti.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.formation.inti.controller.filter.FilterLog;
import fr.formation.inti.entity.User;
import fr.formation.inti.service.IUserService;
import fr.formation.inti.service.UserService;

/**
 * Servlet implementation class UserController
 */

@WebServlet("/login")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Log log = LogFactory.getLog(FilterLog.class);
    private IUserService service;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
        service = new UserService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.debug("doGet /login");
		HttpSession session = request.getSession(true);
		session.invalidate();
		response.sendRedirect("login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.debug("doPost /login");
		String login = request.getParameter("login");
		String password = request.getParameter("password");		
		User user = service.findByLoginAndPassword(login, password);
		if(user != null) {
			HttpSession session = request.getSession(true);
			session.setMaxInactiveInterval(300); // 30 secondes avant d�connexion auto
			session.setAttribute("user", user);
			request.getRequestDispatcher("/home.jsp").forward(request, response);
		}
		else
		{
			request.setAttribute("error", "login or password incorrect !");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	
	}

}
