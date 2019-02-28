<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.example.Login.LoginBean"%>
    <%@page import="com.example.Register.RegisterBean"%>
    <%@page import="java.util.List"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="application/json">
<title>Insert title here</title>
</head>
<body>
<% 

	
		String name=(String)session.getAttribute("USER");
		out.println("Welcome "+name);
	
%>
<p>You are successfully logged in!</p>
<form action="fetchprofile" method="post">
	<button class="btn btn-lg btn-primary btn-block" type="submit" value="Profile">Set Profile</button>
		<input type=hidden name="name" value="<%=session.getAttribute("USER")%>">
		</form>
<a href="showFriend?user=<%=session.getAttribute("USER")%>">Show Friends</a>



<table>

</table>
</body>
</html>