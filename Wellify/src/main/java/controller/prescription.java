package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.doctor;
import serviceimpl.serviceUserImplement;

@WebServlet("/prescription")
public class prescription extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		
		System.out.println("inside prescriptionServlet()");
		HttpSession session = req.getSession();
		serviceUserImplement sui = new serviceUserImplement();
		
		int appointmentId = Integer.parseInt(req.getParameter("appointmentId"));
		int reportId = Integer.parseInt(req.getParameter("reportId"));
		doctor d = (doctor) session.getAttribute("d");
		int doctorId = d.getDoctorId();
		String doctorName = d.getName();
		String patientName = req.getParameter("patientName");
		String disease = req.getParameter("disease");
		String history = req.getParameter("history");
		String appointmentDate = req.getParameter("appointmentDate");
		
		String s = sui.serviceGetPrescription(reportId);
		System.out.println("s:" + s);
		req.setAttribute("medication", s);
		req.setAttribute("appointmentId", appointmentId);
		req.setAttribute("reportId", reportId);
		req.setAttribute("patientName", patientName);
		req.setAttribute("disease", disease);
		req.setAttribute("history", history);
		req.setAttribute("appointmentDate", appointmentDate);
		req.setAttribute("doctorName", doctorName);
		
		req.getRequestDispatcher("/prescription.jsp").forward(req, res);
	}
}
