package controller;

import java.io.IOException;
import java.net.Authenticator.RequestorType;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import domain.doctor;
import domain.patient;
import domain.patientHistory;
import serviceimpl.serviceUserImplement;
@WebServlet("/viewAppointment")
public class viewAppointment extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		System.out.println("inside viewAppointmentServlet()");
		HttpSession session = req.getSession();
		serviceUserImplement sui = new serviceUserImplement();
		patient p = (patient) session.getAttribute("p");
		
		int patientId = p.getPatientId();
		
		
		ArrayList<patientHistory> a = sui.serviceViewAppointment(patientId);
		req.setAttribute("patientHistory", a);
		req.getRequestDispatcher("/patientHistory.jsp").forward(req, res);
	}
}
