<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="domain.patientHistory" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>History</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Component/patientHistory.css">
</head>
<body>
    <%@include file = "/Component/navbar.jsp"%>

    <!-- Toast notification container -->
    <div id="toast" class="toast"></div>

    <div class="history-container">
    <!--
        <div class="history-title">Your Appointment History</div>
    -->
        <%
            ArrayList<patientHistory> a = (ArrayList<patientHistory>) request.getAttribute("patientHistory");
            String success = (String) session.getAttribute("success");
            String fail = (String) session.getAttribute("fail");
            
            if (a == null || a.size() == 0) {
        %>
            <div class="no-appointments">
                No appointments found.
            </div>
        <%
            } else {
        %>
        <div class="cards-wrapper">
            <%
                for (int i = 0; i < a.size(); i++) {
                    patientHistory ph = a.get(i);
                    String statusClass = "";
                    String status = ph.getStatus().toLowerCase();
                    if ("completed".equals(status)) statusClass = "status-completed";
                    else if ("cancelled".equals(status)) statusClass = "status-cancelled";
                    else statusClass = "status-pending";
            %>
            <div class="history-card">
                <div class="card-header">
                    Appointment with <span class="doctor-name"><%= ph.getName() %></span>
                </div>
                <div class="card-row"><span class="card-label">Doctor Specialization:</span> <%= ph.getSpecialization() %></div>
                <div class="card-row"><span class="card-label">Disease:</span> <%= ph.getDisease() %></div>
                <div class="card-row"><span class="card-label">Date:</span> <%= ph.getAppointmentDate() %></div>
                <div class="card-row"><span class="card-label">Time:</span> <%= ph.getAppointmentTime() %></div>
                <div class="card-row"><span class="card-label">Status:</span>
                    <span class="card-status <%= statusClass %>"><%= status.substring(0,1).toUpperCase() + status.substring(1) %></span>
                </div>
                <div class="card-row"><span class="card-label">Doctor Email:</span> <%= ph.getEmail() %></div>
                <div class="card-row"><span class="card-label">Doctor Phone:</span> <%= ph.getPhone() %></div>
                <div class="card-row"><span class="card-label">Doctor Address:</span> <%= ph.getAddress() %></div>
                <div class="card-row"><span class="card-label">Fees:</span> ₹<%= ph.getFees() %></div>
                
                <div class="card-actions">
                    <% if ("pending".equals(status)) { %>
                        <form action="cancelAppointment" method="post">
                            <input type="hidden" name="appointmentId" value="<%= ph.getAppointmentId() %>">
                            <button type="submit" class="cancel-btn">Cancel Appointment</button>
                        </form>
                    <% } else if ("completed".equals(status)) { %>
                        <form action="patientPrescription" method="post">
                            <input type="hidden" name="appointmentId" value="<%= ph.getAppointmentId() %>">
                            <input type="hidden" name="reportId" value="<%= ph.getReportId() %>">
                            <input type="hidden" name="disease" value="<%= ph.getDisease() %>">
                            <input type="hidden" name="history" value="<%= ph.getHistory() %>">
                            <input type="hidden" name="doctorId" value="<%= ph.getDoctorId() %>">
                            <input type="hidden" name="doctorName" value="<%= ph.getName() %>">
                            <input type="hidden" name="appointmentDate" value="<%= ph.getAppointmentDate() %>">
                            <button type="submit" class="prescription-btn">View Prescription</button>
                        </form>
                    <% } %>
                </div>
            </div>
            <% } %>
        </div>
        <% } %>
    </div>

    <script>
    // Show toast notification if there's a success or fail message
    window.onload = function() {
        <% if (success != null)
        {
        	session.removeAttribute("success");
        %>
            showToast('<%= success %>', 'success');
        <% } else if (fail != null)
        { 
        	session.removeAttribute("fail");
        %>
            showToast('<%= fail %>', 'error');
        <% } %>
    };
    
    function showToast(message, type) {
        const toast = document.getElementById('toast');
        toast.textContent = message;
        toast.className = 'toast ' + type + ' show';
        
        // Hide after 2 seconds
        setTimeout(() => {
            toast.classList.remove('show');
        }, 2000);
    }
    </script>
</body>
</html>
