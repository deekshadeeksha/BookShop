<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
				  <li><a href="login.jsp">Login</a></li>
				</ul>
			</div>
		</div>
		
		<div id="loginContent">
			<h1 class="l-heading">
				<span class="text-primary">Forget Password</span>
			</h1>
	
			<p>Please fill out the form below to register</p>
			<fieldset>
	
	
				<form action="UserController" method="get">
	
					<table>
						<tr>
							<td><input class="contact-input" type="text" name="userId"
								id="userId" placeholder="Enter User Id" required></td>
						</tr>
	
						<tr>
							<td><label class="reg-input">Security Question</label> <select
								class="reg-input-select" name="sques">
									<option value="What is your favorite color?">What is
										your favorite color?</option>
									<option value="What is your favorite food?">What is
										your favorite food?</option>
									<option value="What is your favorite memory?">What is
										your favorite memory?</option>
							</select></td>
						</tr>
	
						<tr>
							<td><input class="contact-input" type="text" name="sanswer"
								id="sanswer" placeholder="Security Answer" required></td>
						</tr>
	
					</table>
					<input class="reg-input" type="text" name="formType" value="forget" hidden> 
						
					<input class="contact-input" type="submit" value="Submit"><br>
					<br>
				</form>
			</fieldset>
		</div>
		<% String message = (String)request.getAttribute("alertMsgForget");
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
</html>+