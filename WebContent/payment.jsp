<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="manager.Manager"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
	<div id="header">
			<div id="logoDiv">
				<img src="images/open-book.png" width="50px" height="50px">
                    <h1>Ecommerce Books</h1>
			</div>
			<div id="navbar">
				<ul>
				  <li><a href="MainPage.jsp">Home</a></li>
				  <li><a href="viewBooks.jsp">Products</a></li>
				  <li><a href="booksLibrary.jsp">Library</a></li>
				  <li class="dropdown">
				    <a href="javascript:void(0)" class="dropbtn">Genre</a>
				    <div class="dropdown-content">
				      <a href="showProductsByGenre.jsp?genre=Fantasy">Fantasy</a>
				       <a href="showProductsByGenre.jsp?genre=Poetry">Poetry</a>
				       <a href="showProductsByGenre.jsp?genre=Fiction">Fiction</a>
				       <a href="showProductsByGenre.jsp?genre=Mystery">Mystery</a>
				    </div>
				  </li>
				  <% HttpSession session11 = request.getSession(false);
                        if (session11.getAttribute("username")==null) { %>
                        <li class="nav-li"><a href="login.jsp">Login</a></li> 
                   
                        <%  } else { %>
                        <li>
                        <div class="cart">
						<div class="popup">
							<div class="row checkout">
								<table>
									<tr>
										<th>Book ID</th>
										<th>Quantity</th>
									</tr>
									<%
										
									String username = "";
									if (session11.getAttribute("username") != null) {
										username = (String) session11.getAttribute("username");
									}
									System.out.print(username);

									String sqlQuery = "select * from cart where user_id='" + username + "'";
									ResultSet rs = Manager.fetchData(sqlQuery);
									while (rs.next()) {
									%>
									<tr>
										<td><%=rs.getInt(3)%></td>
										<td><%=rs.getInt(2)%></td>
										<td>
											<%
												}
											%>
										</td>
									</tr>
								</table>
							</div>
							<div class="row checkout">
								<span> <a class="checkout-button" href="viewCart.jsp">View
										Cart</a>
								</span> <span class="checkout-button" href="viewCart.jsp">Checkout</span>
							</div>
						</div>
					</div>
                        </li>
                        <li class="nav-li">
                            <div class="dropdown">
                                <button class="dropbtn"><%=session11.getAttribute("username")%></button>
                                    <div class="dropdown-content">
                                      <a href="./UserController?logout='logOut'">Log Out</a>
                                      <a href="changePassword.jsp">Change Password</a>
                                    </div>
                            </div>
                        </li>   
                        <%}%>
				</ul>
			</div>
		</div>

	<div id="loginContent">
		

		<fieldset>
		<legend><h1 id="paymenthead" >Payment & Checkout</h1></legend>
				<% %>
				<%
					HttpSession session1 = request.getSession(false);
					Double total=0.0;
					String username="",address="",email="";
					int phone=0;			
					if (session1.getAttribute("total") != null) {
						total = (Double) session1.getAttribute("total");
					}
					username = (String) session1.getAttribute("username");
				%>
				<p><b>Total Price : <%=total %></b></p>		
				<%
				String sqlQuery = "SELECT * FROM cart INNER JOIN users ON users.name=cart.user_id WHERE cart.user_id='"+username+"'";
				ResultSet rs = Manager.fetchData(sqlQuery);
				while(rs.next())
				{
					address=rs.getString(8);
					phone=rs.getInt(9);
					email=rs.getString(5);
				}
				%>
				<p><b >User Name :<%=username %></b></p>
				<p><b>Address :<%=address %></b></p>
				<p><b>Phone Number :<%=phone %></b></p>
				<p><b>Email :<%=email %></b></p>
				
				<form action="CheckoutController">
				<input type="text" value=<%=email %> name="email" hidden>
				<input type="text" value=<%=username %> name="user" hidden>
				<input type="submit" value="Chechout"></form>
				
		</fieldset>
	</div>
	<% String message = (String)request.getAttribute("alertMsgLogin");
			if(message!=null)
			{%>
	<script type="text/javascript">
			    var msg = "<%=message%>";
			    alert(msg);
			</script>
	<%}%>
	<%  message = (String)request.getAttribute("alertMsgChanged");
			if(message!=null)
			{%>
	<script type="text/javascript">
			    var msg = "<%=message%>";
			    alert(msg);
			</script>
	<%}%>
	<footer>
            <div class="foodiv left">
                <ul id="foo-left-ul">
                    <li><a class="icons-a" href="MainPage.jsp">Home</a></li>
                    <li><a class="icons-a" href="viewBooks.jsp">Products</a></li>
                </ul>
c            </div>
            <div class="foodiv center">
                <p>Furniture Point<p>
                <div id="icons">
                    <ul>
                        <a href="https://twitter.com/explore"> <i class="fa fa-twitter" style="font-size:24px"></i></a>
                        <a href="https://www.pinterest.ca/"><i class="fa fa-pinterest" style="font-size:24px"></i></a>
                        <a href="https://www.instagram.com/?hl=en"><i class="fa fa-instagram" style="font-size:24px"></i></i></a>
                    </ul>
                </div>
            </div>
            <div class="foodiv right">
                    <ul id="foo-right-ul">
                        <li class="foo-right-ul-li"><a class="icons-a" href="login.jsp">Login</a></li>
                        <li class="foo-right-ul-li"><a class="icons-a" href="contact.jsp">Contact Us</a></li>
                        </ul>
            </div>
    </footer>
</body>
</html>
+
