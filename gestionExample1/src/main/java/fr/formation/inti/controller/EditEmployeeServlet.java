package fr.formation.inti.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.formation.inti.entity.Employee;
import fr.formation.inti.service.EmployeeService;
import fr.formation.inti.service.IEmployeeService;

/**
 * Servlet implementation class EditEmployeeServlet
 */
@WebServlet("/edit")
public class EditEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Log log = LogFactory.getLog(EditEmployeeServlet.class);

	
	private IEmployeeService service;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditEmployeeServlet() {
        super();
        service = new EmployeeService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Employee emp = service.findEmployeeById(id);
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd"); 
		String date = dt.format(emp.getStartDate()); 
		try {
			emp.setStartDate(dt.parse(date));
		} catch (ParseException e) {
			e.printStackTrace();
		} 
		request.setAttribute("emp", emp);
		request.getRequestDispatcher("edit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		Date startDate = new Date();
		try {
			startDate =new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("startDate"));
		} catch (ParseException e) {
			e.printStackTrace();
		}  
		Employee emp = new Employee(id,firstName,lastName,startDate);
		service.updateEmployee(emp);
		response.sendRedirect("list");
	}

}
