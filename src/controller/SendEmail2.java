package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;  
import javax.mail.*;  
import javax.mail.internet.*;  
import javax.activation.*; 

/**
 * Servlet implementation class SendEmail
 */
@WebServlet("/SendEmail2")
public class SendEmail2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendEmail2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
		  // Get a Properties object
		     Properties props = System.getProperties();
		     props.setProperty("mail.smtp.host", "smtp.gmail.com");
		     props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
		     props.setProperty("mail.smtp.socketFactory.fallback", "false");
		     props.setProperty("mail.smtp.port", "465");
		     props.setProperty("mail.smtp.socketFactory.port", "465");
		     props.put("mail.smtp.auth", "true");
		     props.put("mail.debug", "true");
		     props.put("mail.store.protocol", "pop3");
		     props.put("mail.transport.protocol", "smtp");
		     final String username = "ecommercebooksshop@gmail.com";//your email
		     final String password = "Books_1234";//your password;
		     String email=(String)request.getAttribute("email");
		     System.out.println(email);
		     try{
		     Session session = Session.getDefaultInstance(props, 
		                          new Authenticator(){
		                             protected PasswordAuthentication getPasswordAuthentication() {
		                                return new PasswordAuthentication(username, password);
		                             }});

		   // -- Create a new message --
		     Message msg = new MimeMessage(session);

		  // -- Set the FROM and TO fields --
		     msg.setFrom(new InternetAddress("ecommercebooksshop@gmail.com"));
		     msg.setRecipients(Message.RecipientType.TO, 
		                      InternetAddress.parse(email,false));
		     msg.setSubject("Hello,");
		     msg.setText("This is a confirmation mail..You can order has been placed ..we are here to answer your calls");
		     msg.setSentDate(new Date());
		     Transport.send(msg);
		     System.out.println("Message sent.");
		     request.setAttribute("msg","Email has been sent..");
		     request.getRequestDispatcher("finalPage.jsp").forward(request, response);
		     }catch (MessagingException e){ 
			 request.setAttribute("msg","Sorry your email address is invalid!!..");
		     request.getRequestDispatcher("finalPage.jsp").forward(request, response); 
			  
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
