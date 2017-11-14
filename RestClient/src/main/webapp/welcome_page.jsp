<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.example.Login.LoginBean"%>
    <%@page import="com.example.Register.RegisterBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
	if (session == null)
  	{
    	String address = "/login-error.jsp";
    	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(address);
    	dispatcher.forward(request,response);
  	}
	else
	{
		String name=(String)session.getAttribute("USER");
		LoginBean bean=(LoginBean)request.getAttribute("bean");
		RegisterBean regbean=(RegisterBean)request.getAttribute("registerbean");
		if(bean!=null)
			out.print("Welcome, "+bean.getName());
			else
			out.print("Welcome,"+regbean.getName());
		/*if(name == null || bean == null ||regbean==null|| name.compareTo(bean.getName()) != 0)
		{
	    	String address = "/login-error.jsp";
	    	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(address);
	    	dispatcher.forward(request,response);
		}*/
		
	}
%>
<p>You are successfully logged in!</p>
</body>
</html>