<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList"%>
	<%@page import="java.util.HashMap"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function alertName(){
alert("Item deleted from registry successfully");
} 
</script>
<script type="text/javascript">
function alertName1(){
alert("Item was not able to delete by some reason");
} 
</script>
</head>
<body>
<h1>Welcome to your registry</h1>
<% ArrayList<HashMap<String,String>> ans=(ArrayList<HashMap<String,String>>)request.getAttribute("listans"); %>
<form action="AddRegistryController" method="post">
<table>
	<tr>
		<td>Registry Name</td>
		<td>Product Name</td>
		<td>Product Description</td>
		<td>Product Price</td>
		<td>Category Name</td>
		<td>Brand Name</td>
		<td>Color Name</td>			
	</tr>	
	<%	for(int i=0;i<ans.size();i++)
		{
		HashMap<String,String>hm= ans.get(i);		
			%><tr>
			<%
					%><td><%=hm.get("reg_name") %></td><%
					%><td><%=hm.get("product_name") %></td><%
					%><td><%=hm.get("product_desc") %></td><%
					%><td><%=hm.get("product_price") %></td><%
					%><td><%=hm.get("product_category") %></td><%
					%><td><%=hm.get("product_brand") %></td><%
					%><td><%=hm.get("product_color") %></td><%		
					%><td>
					
					<a href="DeleteItemController?productid=<%=hm.get("product_id")%>&regid=<%=hm.get("registryid")%>">
					<input type="button" name="add<%=i %>" value="Delete from registry">
					</a>
					</td><%		
				%>
			</tr><% 
		}
		
		%>
</table>
</form>
<%  if(request.getAttribute("success")!=null)
	{%>
		<script type="text/javascript"> window.onload = alertName; </script>
	<% }%>
<%  if(request.getAttribute("failure")!=null)
	{%>
		<script type="text/javascript"> window.onload = alertName1; </script>
	<% }%>

<form action="welcome_page.jsp" method="post">
<p>

</p>
<input type="submit" name="add" value="Go to Home">
</form>

</body>
</html>