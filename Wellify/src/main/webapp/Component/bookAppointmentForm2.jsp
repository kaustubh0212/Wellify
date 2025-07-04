<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="domain.docAppoint"%>
<%@ page import="domain.Appointment"%>

<%
List<docAppoint> doctors = (List<docAppoint>) session.getAttribute("doctors");
String success = (String) request.getAttribute("success");
String error = (String) request.getAttribute("error");
%>
<!DOCTYPE html>
<html>
<head>
<title>Select Doctor</title>
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
	
	// Reset form and clear messages after 3 seconds
	function resetForm() {
		document.getElementById("appointmentForm").reset();
		document.getElementById("doctorFees").innerText = "";
		
		// Clear messages after 3 seconds
		setTimeout(() => {
			const successDiv = document.getElementById("successMessage");
			const errorDiv = document.getElementById("errorMessage");
			if(successDiv) successDiv.style.display = 'none';
			if(errorDiv) errorDiv.style.display = 'none';
		}, 3000);
	}
	
	// Initialize on page load
	window.onload = function() {
		// Reset form if there's a success/error message
		if(<%= success != null || error != null %>) {
			resetForm();
		}
		
		// Set min date to today
		document.getElementById('appointmentDate').min = new Date()
				.toISOString().split('T')[0];
	};
</script>
</head>
<body class="appointment-bg">
	<div class="container-fluid appointment-container">
		<div class="row min-vh-100 align-items-center">
			<div
				class="col-lg-6 col-md-7 col-12 appointment-form-section d-flex flex-column justify-content-center px-5">
				<div class="d-flex align-items-center mb-2 mt-3">
					<h2 class="appointment-heading mb-0">Choose Your Doctor & Slot</h2>
				</div>
				
				<%-- Success and Error Messages --%>
				<% if (success != null) { %>
				<div id="successMessage" class="alert alert-success alert-dismissible fade show">
					<%=success%>
					<button type="button" class="close" data-dismiss="alert" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<% } %>
				<% if (error != null) { %>
				<div id="errorMessage" class="alert alert-danger alert-dismissible fade show">
					<%=error%>
					<button type="button" class="close" data-dismiss="alert" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<% } %>
				
				<form id="appointmentForm" action="bookAppointmentServletTwo" method="post"
					class="appointment-form">
					<div class="form-group">
						<label for="doctorSelect">Select Doctor</label> 
						<select
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
</body>
</html>
