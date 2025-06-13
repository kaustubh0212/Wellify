package controller;

import java.io.IOException;
import java.security.PublicKey;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.doctor;
import domain.patient;
import serviceimpl.serviceUserImplement;

@WebServlet("/login")
public class userLogin extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException{
		System.out.println("inside main login servlet");
		//Boolean f;
		serviceUserImplement usimp = new serviceUserImplement();
		HttpSession session = req.getSession();
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String userType = req.getParameter("userType");
		
		System.out.println("userType: " + userType);
		System.out.println(password);
		System.out.println(email);
		
		if("patient".equals(userType))
		{
			patient f = usimp.loginPatient(email, password);
			
			session.setAttribute("userType", userType);
			System.out.println("patient class: " + f);
			
			
			if(f.getName() != null)
			{
				session.setAttribute("isLogin", true);
				session.setAttribute("p", f);
				res.sendRedirect("index.jsp");
			}
			else {
				
				res.sendRedirect("login.jsp");
			}
		}
		else
		{
			doctor f = usimp.loginDoctor(email, password);
			
			session.setAttribute("userType", userType);
			System.out.println("doctor class: " + f);
			
			if(f.getName() != null)
			{
				session.setAttribute("isLogin", true);
				session.setAttribute("d", f);
				res.sendRedirect("index.jsp");
			}
			else {
				res.sendRedirect("login.jsp");
			}
		}
		
		//session.setAttribute("userType", userType);
		//session.setAttribute("msg", f);
	}
}
