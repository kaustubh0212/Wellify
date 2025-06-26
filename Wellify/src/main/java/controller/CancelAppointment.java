package controller;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import serviceimpl.serviceUserImplement;

@WebServlet("/cancelAppointment")
public class CancelAppointment extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException{
		System.out.println("inside CancelAppointmentServlet()");
		HttpSession session = req.getSession();
		serviceUserImplement sui= new serviceUserImplement();
		
		int appointmentId = Integer.parseInt(req.getParameter("appointmentId"));
		
		boolean f = sui.serviceCancelAppointment(appointmentId);
		if(f)
		{
			session.setAttribute("success", "Appointment Cancelled. Your Refund Will Be Initiated");
			res.sendRedirect("viewAppointment");
		}
		else
		{
			session.setAttribute("fail", "Something Went Wrong. Please Try Again");
			res.sendRedirect("viewAppointment");
		}
	}
}
