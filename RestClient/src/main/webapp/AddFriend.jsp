<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList"%>
	<%@page import="java.util.HashMap"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>


</head>
<body>
<% ArrayList<HashMap<String,String>> ans=(ArrayList<HashMap<String,String>>)request.getAttribute("listans"); %>
<form action="" method="post">
<table>
	<tr>
		<td>First Name</td>
		<td>Last Name</td>
		<td>Email Id</td>
					
	</tr>	
	<%	for(int i=0;i<ans.size();i++)
		{
		HashMap<String,String>hm= ans.get(i);		
			%><tr>
			<%
					%><td><%=hm.get("first_name") %></td><%
					%><td><%=hm.get("last_name") %></td><%
					%><td><%=hm.get("email") %></td>					
					<td>
					<a href="AddFriendb?username=<%=hm.get("username")%>">
					Add Friend
					</a>
					</td><%		
				%>
			</tr><% 
		}
		
		%>
</table>
</form>
<form action="welcome_page.jsp" method="post">
<p>

</p>
<input type="submit" name="add" value="Go to Home">
</form>


</body>
</html>