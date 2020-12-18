<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/css/materialize.min.css">
  <link rel="stylesheet" href="css/mystyle.css"/>
  
<title>Books Search Software</title>
</head>
<body class="#212121 blue lighten-3">
	<div id="search" class="#f5f5f5 grey lighten-4 z-depth-5">
		<form id="myform">
			<div class="input-field">
				<% HttpSession session1 = request.getSession(false);
	               String user=(String)session1.getAttribute("username");
	             %>
				<input type="search" id="books">
				<input type="hidden" id="user" value="<%=user%>">
				<label for="search">Search Books</label>
			</div>
			<button class="btn red">Search Books</button>
		</form>
	</div>
	<div id="result">
	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/js/materialize.min.js"></script>
	<script src="css/myscript.js"></script>
</body>

</html>