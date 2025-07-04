package controller;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.Import;

import com.mysql.cj.Session;

import domain.doctor;
import domain.patient;
import serviceimpl.serviceUserImplement;

@WebServlet("/register")
public class UserRegister extends HttpServlet{

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException{
		
		System.out.println("inside main register servlet");
		boolean f = false;
		HttpSession session = req.getSession();
		serviceUserImplement usimp = new serviceUserImplement();
		
		String userType = req.getParameter("userType");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String a = req.getParameter("age");
		int age = Integer.parseInt(a);
		String phone = req.getParameter("phone");
		
		if("patient".equals(userType))
		{
			patient p = new patient(name, email, password, phone, age);
			f = usimp.registerPatient(p);
		}
		else
		{
			String qualification = req.getParameter("qualification");
			String address = req.getParameter("address");
			String specialization = req.getParameter("specialization");
			String fee = req.getParameter("fees");
			int fees = Integer.parseInt(fee);
			
			doctor d = new doctor(name, email, password, age, qualification,
					address, fees, specialization, phone);
			f = usimp.registerDoctor(d);
		}
		
		session.setAttribute("userType", userType);
		session.setAttribute("msg", f);
		
		res.sendRedirect("register.jsp");
	}
}