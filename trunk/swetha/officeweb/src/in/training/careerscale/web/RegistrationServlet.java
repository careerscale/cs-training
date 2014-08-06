package in.training.careerscale.web;

import in.training.careerscale.dao.OfficeDAO;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/hello1")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		boolean result=false;
		String firstName=request.getParameter("firstname");
		String lastName =request.getParameter("lastname");
		String gender =request.getParameter("sex");
		String address =request.getParameter("line1") + request.getParameter("line2");
		String state =request.getParameter("state");
		Integer zipCode=request.getParameter("zipcode");
		
		RegistrationDAO dao = new RegistrationDAO();
		try {
			result =dao.contactInfo(firstName,lastName,gender,address,state,zipCode);
			writer.write("Login result is " + result);

		} catch (SQLException e) {
			
			e.printStackTrace();
			writer.write("Login result is " + result);
		}
		
	}

}
