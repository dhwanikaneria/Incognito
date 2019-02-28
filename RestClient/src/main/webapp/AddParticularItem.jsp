<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="java.util.List"%>
    <%@page import="java.util.ArrayList"%>
	<%@page import="java.util.HashMap"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js">
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
<script src="ddtf.js" type="text/javascript"></script>
</head>
<body>
<% ArrayList<HashMap<String,String>> products=(ArrayList<HashMap<String,String>>)request.getAttribute("Product_details"); %>


<form action="AddRegistryController" method="post">
<br/>
<table name="myTable" id="myTable">
	<tr>
		<th>Product Name</th>
		<th>Product Description</th>
		<th>Product Price</th>
		<th>Category Name</th>
		<th>Brand Name</th>
		<th>Color Name</th>			
	</tr>	
	<%
	int reg_id=Integer.parseInt(request.getAttribute("reg_id").toString());
	for(int i=0;i<products.size();i++)
		{
		HashMap<String,String>hm= products.get(i);		
			%><tr>
			<%
					%><td><%=hm.get("product_name") %></td><%
					%><td><%=hm.get("product_desc") %></td><%
					%><td><%=hm.get("product_price") %></td><%
					%><td><%=hm.get("category_name") %></td><%
					%><td><%=hm.get("brand_name") %></td><%
					%><td><%=hm.get("color_name") %></td><%		
					%><td>
					
					<a href="AddRegistryController?reg_id=<%=reg_id%>&product_id=<%=hm.get("product_id")%>">
					<input type="button" name="add<%=i %>" value="add to registry">
					</a>
					</td><%		
				%>
			</tr><% 
		}
		
		%>
</table>
<script>$('#myTable').ddTableFilter();</script>
</form>
<%  if(request.getAttribute("success")!=null)
	{%>
		<script type="text/javascript"> window.onload = alertName; </script>
	<% }%>
<%  if(request.getAttribute("failure")!=null)
	{%>
		<script type="text/javascript"> window.onload = alertName1; </script>
	<% }%>

</body>

<form action="welcome_page.jsp" method="post">
<p>

</p>
<input type="submit" name="add" value="Go to Home">
</form>

</html>