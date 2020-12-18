package controller;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import manager.Manager;

/**
 * Servlet implementation class contactController
 */
@WebServlet("/contactController")
public class ContactController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userId=request.getParameter("userId");
		String name=request.getParameter("name");
		String subject=request.getParameter("subject");
		String message=request.getParameter("message");
		String str="insert into contact (email,name,subject,message) values"
				+ "('"+userId+"','"+name+"','"+subject+"','"+message+"')";
		int i=Manager.setDetails(str);
			
		
		//request.setAttribute("msg","You have send message successfully!!");
		//request.getRequestDispatcher("ContactUs.jsp").forward(request, response);
		request.setAttribute("email",userId);
		request.getRequestDispatcher("SendEmail").forward(request, response);
		
		//response.sendRedirect("SendEmail");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
