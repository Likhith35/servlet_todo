<%--this is directive tag --%>
<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>hi bye......</h1>

  <%-- this is scriplet tag --%>
    <%!int a=10;%>
    
    <% int a=5;%>
   
  <% System.out.println(this.a);%>
  
  <%--this is declarative tag --%>
 

  
  <h1><%=new Random().nextInt(-100,999) %></h1>
  

</body>
</html>