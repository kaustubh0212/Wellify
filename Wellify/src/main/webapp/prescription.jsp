<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Prescription</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Component/prescription.css">
</head>
<body>
<%
    String appointmentId = String.valueOf(request.getAttribute("appointmentId"));
    String patientName = (String) request.getAttribute("patientName");
    String disease = (String) request.getAttribute("disease");
    String history = (String) request.getAttribute("history");
    String reportId = String.valueOf(request.getAttribute("reportId"));
    String medication = (String) request.getAttribute("medication");
    String appointmentDate = (String) request.getAttribute("appointmentDate");
    String doctorName = (String) request.getAttribute("doctorName");
    
    String userType = (String) session.getAttribute("userType");
    System.out.println("userType in prescription page: " + userType);
%>
    <div class="prescription-overlay"></div>
    
    <!-- Prescription modal -->
    <div class="prescription-container">
        <button class="close-btn" onclick="redirect('<%= userType %>')">×</button>
        
        <div class="prescription-header">
            <h2>Medical Prescription</h2>
        </div>
        
        <div class="prescription-body">
        	<div class="prescription-detail">
                <span class="detail-label">Appointment ID:</span>
                <span class="detail-value"><%= appointmentId %></span>
            </div>
            <div class="prescription-detail">
                <span class="detail-label">Patient Name:</span>
                <span class="detail-value"><%= patientName %></span>
            </div>
            <div class="prescription-detail">
                <span class="detail-label">Disease:</span>
                <span class="detail-value"><%= disease %></span>
            </div>
            <div class="prescription-detail">
                <span class="detail-label">Medical History:</span>
                <span class="detail-value"><%= history %></span>
            </div>
            <!--
            <div class="prescription-detail">
                <span class="detail-label">Report ID:</span>
                <span class="detail-value"><%= reportId %></span>
            </div>
           	-->
            
            <div class="prescription-content">
                <div class="medication-label">Medication:</div>
                <div class="medication-text"><%= medication %></div>
            </div>
            
            <div class="signature-section">
                <div class="doctor-signature">Dr. <%= doctorName %></div>
                <div class="signature-date">Date: <%= appointmentDate %></div>
            </div>
        </div>
    </div>
    
    <script>
    function redirect(userType) {
        console.log(userType, " userType in javaScript");
        if(userType === "patient") {
            // Redirect to patient's history page instead of doctor's view
            window.location.href = "<%= request.getContextPath() %>/viewAppointment";
        }
        else if(userType === "doctor") {
            window.location.href = "<%= request.getContextPath() %>/viewPatient";
        }
    }
    // Close if clicked outside prescription
    document.querySelector('.prescription-overlay').addEventListener('click', function() {
    redirect("<%= userType %>");
    });
    </script>
</body>
</html>
