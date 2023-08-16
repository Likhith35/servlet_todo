package CONTROLLER;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Userdao;
import DTO.Myuser;
import DTO.Task;

@WebServlet("/addtask")
public class Addtask extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	if(req.getSession().getAttribute("myuser") == null) {
		 resp.getWriter().print("<h1 style:'color:red'>Session Expired,login agian</h1>");
		 req.getRequestDispatcher("welcome.html").include(req, resp);
	 }
	 else {
		
	String name=req.getParameter("name");
	String description=req.getParameter("description");
	int days=Integer.parseInt(req.getParameter("days"));
	
	Task task=new Task();
	task.setTaskname(name);
	task.setTaskdescription(description);
	task.setTaskdate(LocalDate.now());
	task.setCompletiondate(LocalDate.now().plusDays(days));
	
	Userdao userdao=new Userdao();
	userdao.save(task);
	
	Myuser myuser=(Myuser) req.getSession().getAttribute("user");
	List<Task> list=myuser.getTasks();
	if(list==null) 
		list=new ArrayList<Task>();
	list.add(task);
	myuser.setTasks(list);
	
	userdao.update(myuser);
	
	resp.getWriter().print("<h1 style='color:green'>task added successfully </h1>");
	req.setAttribute("list", myuser.getTasks());
	req.getRequestDispatcher("home.jsp").include(req, resp);
	
 }
	
}
}
