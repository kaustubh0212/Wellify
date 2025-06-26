package controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import domain.doctor;
import domain.doctorHistory;
import service.serviceUserInterface;
import serviceimpl.serviceUserImplement;

/**
 * Servlet implementation class createReport
 */
@WebServlet("/createReport")
public class createReport extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("inside createReportServlet()");
		HttpSession session = req.getSession();
		serviceUserImplement sui = new serviceUserImplement();
		
		
		int appointmentId = Integer.parseInt(req.getParameter("appointmentId"));
		doctor d = (doctor) session.getAttribute("d");
		int doctorId = d.getDoctorId();
		String patientName = req.getParameter("patientName");
		String disease = req.getParameter("disease");
		String history = req.getParameter("history");
		String medication = req.getParameter("medication");
		//Date appointmentDate = Date.valueOf("appointmentDate");
		
		Boolean f = sui.serviceCreateReport(appointmentId, doctorId, medication);
		System.out.println("f:" + f);
		req.setAttribute("f", f.toString());
		req.getRequestDispatcher("/createReport.jsp").forward(req, res);
		
		
	}

}
