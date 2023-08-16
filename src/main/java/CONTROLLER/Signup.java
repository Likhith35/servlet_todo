package CONTROLLER;

import java.io.IOException;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Userdao;
import DTO.Myuser;

@WebServlet("/signup")
public class Signup extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String name=req.getParameter("name");
	String email=req.getParameter("email");
	String password=req.getParameter("password");
	String phone=req.getParameter("phone");
	String gender=req.getParameter("gender");
	String dob=req.getParameter("dob");
	String address=req.getParameter("address");
	String[] lang=req.getParameterValues("lang");
	
	
//	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("dev");
//	EntityManager entityManager=entityManagerFactory.createEntityManager();
//	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	
	Myuser myuser=new Myuser();
	myuser.setName(name);
	myuser.setEmail(email);
	myuser.setPassword(password);
	myuser.setPhone(Long.parseLong(phone));
	myuser.setGender(gender);
	myuser.setDob(LocalDate.parse(dob));
	myuser.setAddress(address);
	myuser.setLang(lang);
	
	
//	entityTransaction.begin();
//	entityManager.persist(myuser);
//	entityTransaction.commit();
	
	
	Userdao userdao=new  Userdao();
	
	 Myuser myuser1 =userdao.findByEmail(email);
	 if(myuser1==null) {
		 userdao.save(myuser);
		 resp.setContentType("text/html");
		 resp.getWriter().print("<h1 style='color:green'>Account created successfully</h1>");
		 req.getRequestDispatcher("welcome.html").include(req, resp);
	 }
	 else {
		 resp.getWriter().print("<h1>Email should not be repeated</h1>");
		 req.getRequestDispatcher("signup.html").include(req, resp);
	 }
	
	
//	System.out.println(name);
//	System.out.println(email);
//	System.out.println(password);
//	System.out.println(phone);
//	System.out.println(gender);
//	System.out.println(dob);
//	System.out.println(address);
//	System.out.println(lang);
	
	
	
}
}
