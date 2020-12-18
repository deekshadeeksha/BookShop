<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="manager.Manager" %>
    <%@page import="javax.servlet.http.HttpSession" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String rw=request.getParameter("link");
String user=request.getParameter("user");
String title=request.getParameter("title");
System.out.println("uri"+rw);
System.out.println(user);
System.out.println(title);


String sqlQuery = "INSERT INTO book_list (userid,list_link,title) VALUES ('"+user+"', '"+rw+"', '"+title+"')";
int i=Manager.setDetails(sqlQuery);
if(i>0)
{
	%>
	<jsp:forward page = "MainPage.jsp" />
	<%
}


%>