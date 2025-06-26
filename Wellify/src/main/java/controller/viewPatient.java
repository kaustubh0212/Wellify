package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.doctor;
import domain.doctorHistory;
import domain.patient;
import domain.patientHistory;
import serviceimpl.serviceUserImplement;

@WebServlet("/viewPatient")
public class viewPatient extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		System.out.println("inside viewPatientServlet()");
		HttpSession session = req.getSession();
		serviceUserImplement sui = new serviceUserImplement();
		doctor d = (doctor) session.getAttribute("d");
		
		int doctorId = d.getDoctorId();
		
		ArrayList<doctorHistory> a = sui.serviceViewPatient(doctorId);
		req.setAttribute("doctorHistory", a);
		System.out.println("doctorId: " + d.getDoctorId());
		req.getRequestDispatcher("/doctorHistory.jsp").forward(req, res);
	}
}
