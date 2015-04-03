<%@ page import="java.io.*,java.util.Locale" %>
<%@ page import="javax.servlet.*,javax.servlet.http.*" %>
<%@ page import="java.sql.*" %>

<!--  variable declaration -->
<% int day = 3; %>
<% int fontSize = 10; %>
<html>
<head><title>Test</title></head>
<body>
<p>
<!--  expression -->
	Today's date: <%= (new java.util.Date()) %>
	<!--  comments in JSP -->
	<%-- This comment will not be visible in the page source --%>
	<%
		out.println(request.getParameter("University"));
	%>
	
	
		<!-- scriplets in jsp -->
	<%

switch(day) {
case 0:
	out.println("It\'s Sunday.");
	break;
case 1:
	out.println("It\'s Monday.");
	break;
default:
	out.println("It's Saturday.");
}%>

<!--  START YOUR JAVA CODE HERE --><%
	for (fontSize = 1; fontSize <=10; fontSize++)
	{
	%>

	<!-- this is my html piece of code --> <font color="green" size=<%=fontSize %>">
	First JSP Examples
	</font><br />
	
	<!-- here again I need start java code to end loop --><%}
	%>
	
	<% if (day == 1 | day == 7) {  %>
		<p> Today is weekend </p>
	<% }else { %>
		<p> Today is not weekend </p>
	<% } %>
	
	</form>	
	
	
	
	

</body>
</html>
