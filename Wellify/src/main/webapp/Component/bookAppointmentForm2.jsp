<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="domain.docAppoint"%>
<%@ page import="domain.Appointment"%>

<%
List<docAppoint> doctors = (List<docAppoint>) session.getAttribute("doctors");
//Appointment appointment = (Appointment) session.getAttribute("appointment");
%>
<!DOCTYPE html>
<html>
<head>
<title>Select Doctor</title>]
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css">
<!-- Font Awesome for icons -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css">
<!-- Your custom CSS -->
<link rel="stylesheet" href="styleBookAppointment.css">
<script>
	// Doctor fees display logic
	function updateFees() {
		var select = document.getElementById("doctorSelect");
		var fees = select.options[select.selectedIndex]
				.getAttribute("data-fees");
		document.getElementById("doctorFees").innerText = fees ? "Fees: ₹"
				+ fees : "";
	}
</script>
</head>
<body class="appointment-bg">
	<div class="container-fluid appointment-container">
		<div class="row min-vh-100 align-items-center">
			<div
				class="col-lg-6 col-md-7 col-12 appointment-form-section d-flex flex-column justify-content-center px-5">
				<div class="d-flex align-items-center mb-2 mt-3">
					<!--
                <button class="btn back-btn mr-3" onclick="history.back()">
                    <i class="fas fa-arrow-left"></i>
                </button>
            -->
            <!-- 
					<button class="btn back-btn mr-3"
						onclick="window.location.href='Component/bookAppointmentForm1.jsp'">
						<i class="fas fa-arrow-left"></i>
					</button>
			-->
					<h2 class="appointment-heading mb-0">Choose Your Doctor & Slot</h2>
				</div>
				<%
				String success = (String) request.getAttribute("success");
				String error = (String) request.getAttribute("error");
				if (success != null)
				{
				%>
				<div class="alert alert-success"><%=success%></div>
				<%
				}
				if (error != null) {
				%>
				<div class="alert alert-danger"><%=error%></div>
				<%
				}
				%>
				<form action="bookAppointmentServletTwo" method="post"
					class="appointment-form">
					<div class="form-group">
						<label for="doctorSelect">Select Doctor</label> <select
							class="form-control" id="doctorSelect" name="doctorId"
							onchange="updateFees()" required>
							<option value="">Select Doctor</option>
							<%
							for (docAppoint doc : doctors) {
							%>
							<option value="<%=doc.getDoctorId()%>"
								data-fees="<%=doc.getFees()%>"><%=doc.getDoctorName()%></option>
							<%
							}
							%>
						</select>
					</div>
					<div class="mb-2" id="doctorFees"
						style="font-weight: bold; color: #31a67a;"></div>
					<div class="form-group">
						<label for="appointmentDate">Date</label> <input type="date"
							class="form-control" id="appointmentDate" name="appointmentDate"
							required min="<%=java.time.LocalDate.now()%>">
					</div>
					<div class="form-group">
						<label for="appointmentTime">Time Slot</label> <select
							class="form-control" id="appointmentTime" name="appointmentTime"
							required>
							<%-- Generate 15-min slots from 12:00 to 17:00 --%>
							<%
							for (int h = 12; h <= 16; h++) {
								for (int m = 0; m < 60; m += 15) {
									String hour = String.format("%02d", h);
									String minute = String.format("%02d", m);
									String slot = hour + ":" + minute;
							%>
							<option value="<%=slot%>"><%=slot%></option>
							<%
							}
							}
							%>
							<option value="17:00">17:00</option>
						</select>
					</div>
					<button type="submit" class="btn appointment-submit-btn btn-block">Confirm
						Appointment</button>
				</form>
			</div>
			<div
				class="col-lg-6 col-md-5 d-none d-md-flex align-items-center justify-content-center appointment-image-section">
				<img src="${pageContext.request.contextPath}/image/consult5.avif"
					alt="Doctor Consultation" class="img-fluid appointment-image">
			</div>
		</div>
	</div>
	<script>
		// Set min date to today
		document.getElementById('appointmentDate').min = new Date()
				.toISOString().split('T')[0];
		// Optionally, filter time slots based on current time if date is today
	</script>
</body>
</html>
