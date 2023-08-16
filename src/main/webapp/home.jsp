<%@page import="java.util.List"%>
<%@page import="DTO.Task"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ToDo Home</title>
</head>
<style>
		body {
			background-image:
				url("https://img.freepik.com/free-vector/hand-painted-watercolor-pastel-sky-background_23-2148902771.jpg");
			background-size: cover;
		}
		#a1{
    border:none;
    height: 45px;
    width: 80px;
    position: relative;
    left: 10px;
    bottom: 30px;
    color: whitesmoke;
    background-color: tomato;
    border-radius: 15%;
    font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
    font-size: large;
}
  #a1:hover{
        	box-shadow: 0px 0px 10px tomato;
        }
th{
	font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
    font-size: large;
}
h1{
	font-size: xx-large;
		font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
		color: red;
        font-weight: 400;
}
td{
		font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
    font-weight: 500;
}
button {
	border:1px solid gray;
	border-radius:10%;
	border:none;
	height: 30px;
	font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
	font-size: large;
	width: 80px;
	color: whitesmoke;
	background-color: gray;
}
 button:hover{
        	box-shadow: 0px 0px 10px gray;
        }
	</style>
</head>
<body>

    <%List<Task> tasks=(List<Task>) request.getAttribute("list");%>
	<h1 align="center">Welcome to TODO Home</h1>
	<center>
	<table border="3">
		<tr>
			<th>ID</th>
			<th>Task Name</th>
			<th>Description</th>
			<th>Task Date</th>
			<th>Task Completion Date</th>
			<th>Status</th>
			<th>Change Status</th>
			<th>Delete</th>
			<th>Update</th>
		</tr>
		<%for(Task task: tasks){
		%> 
		<tr>
			<td><%=task.getId() %></td>
			<td><%=task.getTaskname() %></td>
			<td><%=task.getTaskdescription() %></td>
			<td><%=task.getTaskdate() %></td>
			<td><%=task.getCompletiondate() %></td>
			<td><%if(task.isStatus())%>completed<%else %>not completed</td>
			<td><a href="changestatus?id=<%=task.getId() %>"><button>Change</button></a></td>
			<td><a href="deletetask?id=<%=task.getId() %>"><button>Delete</button></a></td>
			<td><a href="edittask?id=<%=task.getId() %>"><button>Update</button></a></td>
		</tr>
		<%}%>
	</table>
	<br>
	<br>
	<a href="tasksession"><button style="margin-left: 50px" id="a1">AddTask</button></a>
	<a href="logout"><button style="margin-left: 500px" id="a1">Logout</button></a>
	</center>
</body>
</html>