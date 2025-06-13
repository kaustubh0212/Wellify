package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.doctor;
import domain.patient;

@WebServlet("/logout")
public class userLogout extends HttpServlet {

	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		HttpSession session = req.getSession();
		System.out.println("Inside the logout servlet");
		patient patient = (patient)session.getAttribute("p");
		doctor doctor = (doctor)session.getAttribute("d");
		session.removeAttribute("isLogin");
		session.removeAttribute("p");
		session.removeAttribute("d");
		
		session.removeAttribute("userType");

		res.sendRedirect("login.jsp");
	}

}
