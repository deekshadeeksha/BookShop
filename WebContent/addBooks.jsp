<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.ResultSet" %>
    <%@ page import="java.sql.Statement" %>
    <%@ page import="service.DbConnection" %>
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
				</ul>
			</div>
		</div>
		
		<div id="mainContent">
				<h1 class="l-heading">
					<span class="text-primary">Register</span> With Us
				</h1>
		
				<p>Please fill out the form below to register</p>
				<fieldset>
				<form action="BooksController" method="post" enctype="multipart/form-data">
		
						<table>
							<tr>
							<td>Genre</td>
							<td><select class="reg-input"  name="genId">
							<%
							Statement st=DbConnection.getStatementObject();
							ResultSet rs=st.executeQuery("select genre_id,genre from genres");
							while(rs.next())
							{
							%>
							<option value="<%=rs.getInt(1)%>"><%=rs.getString("genre") %></option>
							<% } %>
							</select></td>
							</tr>
							<tr>
							<td>Publications</td>
							
							<td><select class="reg-input"  name="pub_id">
							<%
							Statement st1=DbConnection.getStatementObject();
							ResultSet rs1=st1.executeQuery("select publication_id,publication_name from publications");
							while(rs1.next())
							{
							%>
							<option value="<%=rs1.getInt(1)%>"><%=rs1.getString("publication_name") %></option>
							<% } %>
							</select></td>
							</tr>
							<tr>
							<td>Author</td>
							
							<td><select class="reg-input"  name="auth_id">
							<%
							Statement st2=DbConnection.getStatementObject();
							ResultSet rs2=st2.executeQuery("select author_id,concat(firstName,' ',lastName) as name from author");
							while(rs2.next())
							{
							%>
							<option value="<%=rs2.getInt(1)%>"><%=rs2.getString("name") %></option>
							<% } %>
							</select></td>
							</tr>			
							<tr>
								<td>Title</td>
									<td><input class="reg-input" type="text" name="title"
										id="title" required></td>
								</tr>
								<tr>
								<td>Date Of Publication</td>
								<td><input class="reg-input" type="date" name="publication_date"
										id="publication_date" required></td>
								</tr>
								<tr>
								<td>Language</td>
								<td><input class="reg-input" type="text" name="language"
										id="language" required></td>
								</tr>
								<tr>
								<td>Price</td>
								<td><input class="reg-input" type="text" name="price"
										id="price" required></td>
								</tr>
								<tr>
								  <td> Portrait Photo:  </td>
			                    <td> <input type="file" class="reg-input" name="file" size="50" placeholder="Upload Your Image" required/></td>
							
							</tr>
						</table>
						
						<input class="reg-input" type="text" name="formType" value="gen" hidden> 
						
						<input class="contact-input" type="submit" value="Add Book Details"><br> <br>
					</form>
				</fieldset>
		</div>
		<% String message = (String)request.getAttribute("alertMsg");
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
                    <li><a class="icons-a" href="login.jsp">Products</a></li>
                </ul>
            </div>
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
                        <li class="foo-right-ul-li"><a class="icons-a" href="">Rate us</a></li>
                        <li class="foo-right-ul-li"><a class="icons-a" href="">Subscribe to us</a></li>
                        <li class="foo-right-ul-li"><a class="icons-a" href="">Contact Us</a></li>
                    </ul>
            </div>
    </footer>
	</body>
</html>