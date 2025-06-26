<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Prescribe</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Component/createReport.css">
<script>
function showPopup(message, redirectUrl) {
    if(confirm(message)) {
        if(redirectUrl) {
            window.location.href = redirectUrl;
        }
    }
}
</script>
</head>
<body>

<%
    int appointmentId = Integer.parseInt(request.getParameter("appointmentId"));
    String patientName = request.getParameter("patientName");
    String history = request.getParameter("history");
    String disease = request.getParameter("disease");
    Date appointmentDate = Date.valueOf(request.getParameter("appointmentDate"));
    
    String f = (String) request.getAttribute("f");
    System.out.println("f in createReport.jsp: " + f);
    
    if("true".equals(f)) {
%>
    <script>
    window.onload = function() {
        showPopup("Prescription saved successfully!", "viewPatient");
    };
    </script>
<%
    } else if("false".equals(f)) {
%>
    <script>
    window.onload = function() {
        showPopup("Failed to save prescription. Please try again.", null);
    };
    </script>
<%
    }
%>

<div class="prescribe-container">
    <h2 class="prescribe-title">Prescribe Medication</h2>
    <form action="createReport" method="post" class="prescribe-form">
        <div class="prescribe-details">
            <div class="detail-row">
                <span class="detail-label">Appointment ID:</span>
                <span class="detail-value"><%= appointmentId %></span>
                <input type="hidden" name="appointmentId" value="<%= appointmentId %>">
            </div>
            <div class="detail-row">
                <span class="detail-label">Patient Name:</span>
                <span class="detail-value"><%= patientName %></span>
                <input type="hidden" name="patientName" value="<%= patientName %>">
            </div>
            <div class="detail-row">
                <span class="detail-label">Disease:</span>
                <span class="detail-value"><%= disease %></span>
                <input type="hidden" name="disease" value="<%= disease %>">
            </div>
            <div class="detail-row">
                <span class="detail-label">History:</span>
                <span class="detail-value"><%= history %></span>
                <input type="hidden" name="history" value="<%= history %>">
            </div>
            <div class="detail-row">
                <span class="detail-label">Appointment Date:</span>
                <span class="detail-value"><%= appointmentDate %></span>
                <input type="hidden" name="appointmentDate" value="<%= appointmentDate %>">
            </div>
        </div>
        <div class="form-group">
            <label for="medication" class="detail-label">Medication/Prescription:</label>
            <textarea id="medication" name="medication" rows="4" class="medication-textarea" required placeholder="Enter medication or prescription details..."></textarea>
        </div>
        <div class="form-actions">
            <button type="submit" class="submit-btn">Submit Prescription</button>
        </div>
    </form>
</div>

</body>
</html>
