<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.example.Login.LoginBean"%>
    <%@page import="com.example.Register.RegisterBean"%>
    <%@page import="java.util.List"%>
    <%@page import="java.util.ArrayList"%>
	<%@page import="java.util.HashMap"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="application/json">
<title>Insert title here</title>
<script type="text/javascript">
function alertName(){
alert("Added to cart Successfully");
} 
</script>
<script type="text/javascript">
function alertName1(){
alert("Item already exists");
} 

function redirect(elem){
    elem.setAttribute("action","welcome_page.jsp");
    elem.submit();
}
</script>  
</head>
<body>
<% 

	/*if (session == null)
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
		
	
%>
<p>You are successfully logged in!</p>
<% 

%>
<form action="SearchItemController" method="post">
<p>
<input type="text" name="query" />
</p>
<input type="submit" name="add" value="Search Items">
</form>
<br/>

<form action="CreateRegController" method="post">
<p>
<input type="text" name="query" />
</p>
<input type="submit" name="add" value="Create your registry">
</form>

<form action="Logout" method="post">

<input type="submit" name="add" value="Log out">
</form>


<form action="DisplayReg" method="post">
<p>
Please click here to view your registry
</p>
<input type="submit" name="add" value="Show Registry">
</form>

<form action="SearchUserController" method="post">
<p>
<input type="text" name="query" />
</p>
<input type="submit" name="add" value="Search Friends">
</form>
<form action="fetchprofile" method="post">
	<button class="btn btn-lg btn-primary btn-block" type="submit" value="Profile">Set Profile</button>
		<input type=hidden name="name" value="<%=session.getAttribute("USER")%>">
		</form>
<form action="sharedRegistry" method="post">
	<button class="btn btn-default" type="submit" value="Profile">Shared Registry</button>
		<input type=hidden name="name" value="<%=session.getAttribute("USER")%>">
		</form>	
<a href="showFriend?user=<%=session.getAttribute("USER")%>">Show Friends</a>


</body>
</html>