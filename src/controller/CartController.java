package controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import manager.Manager;
import service.DbConnection;

/**
 * Servlet implementation class CartController
 */
@WebServlet("/CartController")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int bookId=Integer.parseInt(request.getParameter("bookid"));
		HttpSession session1 = request.getSession(false);
		String userId="";
        if (session1.getAttribute("username")!=null) {
        	userId=(String)session1.getAttribute("username");
        }
        String sqlQuery = "select * from cart";
		ResultSet rs=Manager.fetchData(sqlQuery);
		int k=0;
		int cartId=0,quantity=0;;
		try {
			while(rs.next()){
				if(rs.getInt(3)==bookId && (rs.getString(4).equals(userId)) )
				{
					k++;
					cartId=rs.getInt(1);
					quantity=rs.getInt(2)+1;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(k==0)
		{
				HttpSession session2 = request.getSession(false);
	            if (session2.getAttribute("username")==null) { 
					RequestDispatcher rd=request.getRequestDispatcher("/signUp.jsp");  
					rd.include(request, response);
	            }
            
			String str="insert into cart (quantity,book_id,user_id) values(1,"+bookId+",'"+userId+"')";
			int i=Manager.setDetails(str);
			RequestDispatcher rd=request.getRequestDispatcher("/viewBooks.jsp");  
			rd.include(request, response);
		}
		else
		{
			sqlQuery = "UPDATE cart SET quantity = '"+quantity+"' WHERE cart_id = '"+cartId+"'";
			int i=DbConnection.getPreparedStatement(sqlQuery);
			if(i>0)
			{
				RequestDispatcher rd=request.getRequestDispatcher("/viewBooks.jsp");  
				rd.include(request, response);
			}
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
