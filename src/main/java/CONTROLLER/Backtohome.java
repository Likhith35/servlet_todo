package CONTROLLER;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.Myuser;

@WebServlet("/backtohome")
public class Backtohome extends HttpServlet{
			@Override
			protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				Myuser myuser=(Myuser) req.getSession().getAttribute("myuser");
				if(myuser==null) {
					resp.getWriter().print("<h1 style='color:red'>Session expired </h1>");
					req.getRequestDispatcher("welcome.html").include(req, resp);
				}
				else {
					req.setAttribute("list",myuser.getTasks());
					req.getRequestDispatcher("home.jsp").include(req, resp);
				}
			}
}
