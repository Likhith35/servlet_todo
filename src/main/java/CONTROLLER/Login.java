package CONTROLLER;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Userdao;
import DTO.Myuser;
import DTO.Task;
@WebServlet("/welcome")
public class Login extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String email=req.getParameter("email");
	String password=req.getParameter("password");
	
	
	Userdao userdao=new Userdao();
	
	Myuser myuser=userdao.findByEmail(email);
	
	if(myuser==null) {
		resp.getWriter().print("<h1>Incorrect Email</h1>");
		req.getRequestDispatcher("welcome.html").include(req, resp);
	}
	else {
		if(myuser.getPassword().equals(password)){
			
			req.getSession().setAttribute("user", myuser);
			req.getSession().setMaxInactiveInterval(10);
			resp.getWriter().print("<h1>Login Success</h1>");
			
			req.setAttribute("list", myuser.getTasks());
			
			req.getRequestDispatcher("home.jsp").include(req, resp);
		
		}
		else{
			resp.getWriter().print("<h1>Incorrect Password</h1>");
			req.getRequestDispatcher("welcome.html").include(req, resp);
		}
	}
}
}
