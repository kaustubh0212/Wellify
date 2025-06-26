<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="domain.doctorHistory" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Appointment History</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Component/doctorHistory.css">
</head>
<body>
    <%@include file = "/Component/navbar.jsp"%>
    <div class="history-container">
        <div class="history-title">Your Appointments</div>
        <%
            ArrayList<doctorHistory> a = (ArrayList<doctorHistory>) request.getAttribute("doctorHistory");
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
                    doctorHistory dh = a.get(i);
                    String statusClass = "";
                    String status = dh.getStatus();
                    if ("completed".equalsIgnoreCase(status)) statusClass = "status-completed";
                    else if ("cancelled".equalsIgnoreCase(status)) statusClass = "status-cancelled";
                    else statusClass = "status-pending";
            %>
            <div class="history-card">
                <div class="card-header">
                    Appointment with <span class="patient-name"><%= dh.getPatientName() %></span>
                </div>
                <div class="card-row"><span class="card-label">Patient ID:</span> <%= dh.getPatientId() %></div>
                <div class="card-row"><span class="card-label">Age:</span> <%= dh.getAge() %></div>
                <div class="card-row"><span class="card-label">Email:</span> <%= dh.getEmail() %></div>
                <div class="card-row"><span class="card-label">Disease:</span> <%= dh.getDisease() %></div>
                <div class="card-row"><span class="card-label">Symptom:</span> <%= dh.getSymptom() %></div>
                <div class="card-row"><span class="card-label">Previous History:</span> <%= dh.getHistory() %></div>
                <div class="card-row"><span class="card-label">Date:</span> <%= dh.getAppointmentDate() %></div>
                <div class="card-row"><span class="card-label">Time:</span> <%= dh.getAppointmentTime() %></div>
                <div class="card-row">
                    <span class="card-label">Status:</span>
                    <span class="card-status <%= statusClass %>">
                        <%= status.substring(0,1).toUpperCase() + status.substring(1).toLowerCase() %>
                    </span>
                </div>
                <div class="card-row">
                    <% if (dh.getReportId() == -1 || dh.getReportId() == 0) { %>
                        <form action="createReport.jsp" method="post" style="display:inline;">
                            <input type="hidden" name="appointmentId" value="<%= dh.getAppointmentId() %>">
                            <input type="hidden" name="patientName" value="<%= dh.getPatientName() %>">
                            <input type="hidden" name="disease" value="<%= dh.getDisease() %>">
                            <input type="hidden" name="history" value="<%= dh.getHistory() %>">
                            <input type="hidden" name="appointmentDate" value="<%= dh.getAppointmentDate() %>">
                            <button type="submit" class="action-btn prescribe-btn">Prescribe</button>
                        </form>
                    <% } else { %>
                        <form action="prescription" method="post" style="display:inline;">
                            <input type="hidden" name="reportId" value="<%= dh.getReportId() %>">
                            <input type="hidden" name="appointmentId" value="<%= dh.getAppointmentId() %>">
                            <input type="hidden" name="patientName" value="<%= dh.getPatientName() %>">
                            <input type="hidden" name="disease" value="<%= dh.getDisease() %>">
                            <input type="hidden" name="history" value="<%= dh.getHistory() %>">
                            <input type="hidden" name="appointmentDate" value="<%= dh.getAppointmentDate() %>">
                            <button type="submit" class="action-btn prescription-btn">Prescription</button>
                        </form>
                    <% } %>
                </div>
            </div>
            <% } %>
        </div>
        <% } %>
    </div>
</body>
</html>
