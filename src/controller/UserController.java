package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import entity.User;
import manager.Manager;
import service.DbConnection;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String formType=request.getParameter("formType");
		String logOut=request.getParameter("logout");
		String urlConnection ="jdbc:mysql://localhost:3306/books";
		String login = "root";
		String password = "";
		Statement statement;
		if(formType!=null) {
		if(formType.equals("signUp"))
		{
			String userId=request.getParameter("userId");
			String name=request.getParameter("username");
			String userPassword=request.getParameter("password");
			String userRePassword=request.getParameter("repassword");
			String security_ques=request.getParameter("sques");
			String security_ans=request.getParameter("sanswer");
			String address=request.getParameter("address");
			String phone=request.getParameter("phone");
			String dob=request.getParameter("dob");
			String gender=request.getParameter("gender");

			if(!(userPassword.equals(userRePassword)))
			{
				request.setAttribute("alertMsg", "Passwords Don't Match");
				RequestDispatcher rd=request.getRequestDispatcher("/signUp.jsp");  
				rd.include(request, response);
			}
				String sqlQuery = "INSERT INTO users (userID, password, name, address, phone, dob, gender, security_question, security_answer) VALUES ('"+userId+"', '"+userPassword+"', '"+name+"', '"+address+"', '"+phone+"', '"+dob+"', '"+gender+"', '"+security_ques+"', '"+security_ans+"')";
				int i=Manager.setDetails(sqlQuery);
				if(i>0)
				{
					HttpSession session = request.getSession();
				    session.setAttribute("username", name);
				    response.sendRedirect("MainPage.jsp");
				}
			
		}
		else if(formType.equals("login"))
		{
			String userId=request.getParameter("userId");
			String userPassword=request.getParameter("password");

			String sqlQuery = "select * from users where userID='"+userId+"'";
			

				ResultSet resultSet=Manager.fetchData(sqlQuery);
				 int k=0;
				 try {
					while(resultSet.next()) {
						 if(resultSet.getString("password").equals(userPassword)) {
							 HttpSession session = request.getSession();
							    session.setAttribute("username", resultSet.getString("name"));
							    response.sendRedirect("MainPage.jsp");
							    k++;
						 } 
					 }
				} catch (SQLException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 if(k==0)
				 {
					 request.setAttribute("alertMsgLogin", "Wrong username or Password!!");
						RequestDispatcher rd=request.getRequestDispatcher("/login.jsp");  
						rd.include(request, response);
				 }
		}
		else if(formType.equals("forget"))
		{
			String userId=request.getParameter("userId");
			String security_ques=request.getParameter("sques");
			String security_ans=request.getParameter("sanswer");

			String sqlQuery = "select * from users where userID='"+userId+"'";

				ResultSet resultSet=Manager.fetchData(sqlQuery);
				 int k=0;
				 try {
					while(resultSet.next()) {
						 if((resultSet.getString("security_question").equals(security_ques))&&(resultSet.getString("security_answer").equals(security_ans))) {
							response.sendRedirect("./changePassword.jsp");
						 } 
					 }
				} catch (SQLException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 if(k==0)
				 {
					 request.setAttribute("alertMsgForget", "Wrong security question or Security answer!!");
						RequestDispatcher rd=request.getRequestDispatcher("/forgetPassword.jsp");  
						rd.include(request, response);
				 }
		}
		else
		{
			String userId=request.getParameter("userId");
			String newpass=request.getParameter("newpassword");
			String newrepass=request.getParameter("newrepassword");

			if(!(newpass.equals(newrepass)))
			{
				request.setAttribute("alertMsgChanged", "Password Dont Match!!");
				RequestDispatcher rd=request.getRequestDispatcher("/changePassword.jsp");  
				rd.include(request, response);
			}
			String sqlQuery = "UPDATE users SET password = '"+newpass+"' WHERE (userID = '"+userId+"')";
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection connection = DriverManager.getConnection(urlConnection, login, password);	
				statement = connection.createStatement();
				statement.executeUpdate(sqlQuery);
				request.setAttribute("alertMsgChanged", "Password Changed!!");
				RequestDispatcher rd=request.getRequestDispatcher("/login.jsp");  
				rd.include(request, response);
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}
		if(logOut!=null)
		{
			 HttpSession session = request.getSession();
			session.removeAttribute("username");
			session.invalidate();
			response.sendRedirect("./MainPage.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
