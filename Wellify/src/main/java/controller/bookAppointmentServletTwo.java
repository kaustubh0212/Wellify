package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.docAppoint;
import domain.patient;
import serviceimpl.serviceBookingImplementation;

@WebServlet("/bookAppointmentServletTwo")
public class bookAppointmentServletTwo extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
    	System.out.println("inside BookAppointmentServletTwo()");
    	
    	HttpSession session = req.getSession();
    	String disease = (String) session.getAttribute("disease");
    	String symptom = (String) session.getAttribute("symptom");
    	String history = (String) session.getAttribute("history");
    	int doctorId = Integer.parseInt(req.getParameter("doctorId"));
    	patient p = (patient) session.getAttribute("p");
    	int patientId = p.getPatientId();
    	String time = req.getParameter("appointmentTime");
    	String date = req.getParameter("appointmentDate");
    	
        //session.removeAttribute("doctors");
        
        /*
        // Basic validation
        if(disease == null || disease.isEmpty() || symptom == null || symptom.isEmpty()) {
            req.setAttribute("error", "Please fill all required fields.");
            req.getRequestDispatcher("bookAppointmentForm.jsp").forward(req, res);
            return;
        }
        */
        
        
        serviceBookingImplementation sbi = new serviceBookingImplementation();
        boolean f = sbi.serviceBookAppointment(disease, doctorId, patientId, time, date, symptom, history);
        
        //req.getRequestDispatcher("bookAppointment.jsp").forward(req, res);
        
        if(f)
        {
        	req.setAttribute("success", "Your appointment has been booked successfully!");
        }
        else
        {
        	req.setAttribute("error", "Appointment could not be booked. Please try again.");
		}
        
        req.getRequestDispatcher("/Component/bookAppointmentForm2.jsp").forward(req, res);
        
    } 
}
