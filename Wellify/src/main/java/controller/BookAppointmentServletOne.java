package controller;

import java.io.IOException;
import java.net.Authenticator.RequestorType;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daoimpl.daoBookingImplement;
import domain.docAppoint;
import serviceimpl.serviceBookingImplementation;

@WebServlet("/BookAppointmentServletOne")
public class BookAppointmentServletOne extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
    	System.out.println("inside BookAppointmentServletOne()");
    	
    	HttpSession session = req.getSession();
    	
        String disease = req.getParameter("disease");
        String symptom = req.getParameter("symptom");
        String history = req.getParameter("history");
        

        // Basic validation
        if(disease == null || disease.isEmpty() || symptom == null || symptom.isEmpty()) {
            req.setAttribute("error", "Please fill all required fields.");
            req.getRequestDispatcher("bookAppointmentForm.jsp").forward(req, res);
            return;
        }
        session.setAttribute("disease", disease);
        session.setAttribute("symptom", symptom);
        session.setAttribute("history", history);
        
        serviceBookingImplementation sbi = new serviceBookingImplementation();
        List<docAppoint> doctors = sbi.serviceFetchDoctors(disease);
        System.out.println("size of doctors arrayList: " + doctors.size());
        
        session.setAttribute("doctors", doctors);
        //req.getRequestDispatcher("bookAppointment.jsp").forward(req, res);
        session.setAttribute("step", "step2");
        res.sendRedirect("bookAppointment.jsp");
    }
}
