<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.Statement"%>
<%@ page import="service.DbConnection"%>
<%@ page import="manager.Manager"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
		<link rel="stylesheet" href="css/style.css" />
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
				  <% HttpSession session1 = request.getSession(false);
                        if (session1.getAttribute("username")==null) { %>
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
									if (session1.getAttribute("username") != null) {
										username = (String) session1.getAttribute("username");
									}

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
								</span><a class="checkout-button" href="payment.jsp">Checkout</a>
							</div>
						</div>
					</div>
                        </li>
                        <li class="nav-li">
                            <div class="dropdown">
                                <button class="dropbtn"><%=session1.getAttribute("username")%></button>
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
		
		<div id="mainContent">
		
				<div id="firstDiv">
					<h1 id="mainHeadH1">EXPLORE</h1>
				</div>
				
				<div id="textDiv">
					<h1>ITS NOT HOARDING IF ITS BOOKS</h1>
				</div>
					
				<div id="secondDiv">
					<div class="secondSubDiv">
						<img id="divimgone" src="images/fantasy.jpg" alt="Library" width="250px" height="250px">
						<div class="secondSubDivText">
							<p id="secondHeadP"><b>Fantasy</b></p>
							<p id="secondHeadP2">Dive into the deep realms of pixies, fairies,dragins and much more reading our latetst collection of fantasy genre.</p>
						</div>
					</div>
					
					<div class="secondSubDiv">
						<img id="divimgone" src="images/mystery.jpg" alt="Library" width="250px" height="250px">
						<div class="secondSubDivText">
							<p id="secondHeadP"><b>Mystery</b></p>
							<p>Indulge in crime thrillers and read how mystery unfolds through the eyes og the author.</p>
						</div>
					</div>
					<div class="secondSubDiv">
						<img id="divimgone" src="images/poetryPen.jpg" alt="Library" width="250px" height="250px">
						<div class="secondSubDivText">
							<p id="secondHeadP"><b>Poetry</b></p>
							<p>Explore different poetry with meanings in different languages</p>
						</div>
					</div>
				</div>
				
				<div id="thirdDiv">
					<div>
					</div>
				</div>
		</div>
		
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
                        <li class="foo-right-ul-li"><a class="icons-a" href="adminLogin.jsp">Admin</a></li>
                        </ul>
            </div>
    </footer>
	</body>
</html>