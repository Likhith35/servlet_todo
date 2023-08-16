package CONTROLLER;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Userdao;
import DTO.Myuser;
import DTO.Task;

@WebServlet("/changestatus")
public class Changestatus extends HttpServlet {
 @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 Myuser myuser=(Myuser) req.getSession().getAttribute("user");
	 if(myuser == null) {
		 resp.getWriter().print("<h1 style:'color:red'>Session Expired</h1>");
		 req.getRequestDispatcher("welcome.html").include(req, resp);
	 }
	 else {
		 //logic to fetch task object
		 int id=Integer.parseInt(req.getParameter("id"));
		 Userdao userdao=new Userdao();
		 Task task=userdao.fetchTask(id);
		 
		 //logic to change status
		 if(task.isStatus())
			 task.setStatus(false);
		 else
			 task.setStatus(true);
		 
		 //logic to update in database
		 userdao.update(task);
		 
		 //logic to update session
		 Myuser myuser1=userdao.findByEmail(myuser.getEmail()); 
		 req.getSession().setAttribute("user", myuser);
		 
		 resp.getWriter().print("<h1 style='color:green'>status changed sucess</h1>");
		 req.setAttribute("list", myuser.getTasks());
		 req.getRequestDispatcher("home.jsp").include(req, resp);
	 	}
	}
}
