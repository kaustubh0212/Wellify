<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Your Appointment</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css">
<!-- Font Awesome for icons -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css">
<!-- Your custom CSS -->
<link rel="stylesheet" href="styleBookAppointment.css">
</head>
<body class="appointment-bg">

	<div class="container-fluid appointment-container">
		<div class="row min-vh-100 align-items-center">
			<!-- Left: Form Section -->
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
						onclick="window.location.href='${pageContext.request.contextPath}/index.jsp'">
						<i class="fas fa-arrow-left"></i>
					</button>
			-->
					<h2 class="appointment-heading mb-0">Book Your Doctor</h2>
				</div>
				<form action="BookAppointmentServletOne" method="post"
					class="appointment-form">
					<div class="form-group">
						<label for="patientName">Disease</label> <input type="text"
							class="form-control" id="patientName" name="disease" required>
					</div>
					<!--
                <div class="form-group">
                    <label for="doctor">Choose Doctor</label>
                    <select class="form-control" id="doctor" name="doctor" required>
                        <option value="">Select Doctor</option>
                        <option value="Dr. Asha Sharma">Dr. Asha Sharma</option>
                        <option value="Dr. Rohan Mehta">Dr. Rohan Mehta</option>
                        <option value="Dr. Priya Kapoor">Dr. Priya Kapoor</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="appointmentDate">Date</label>
                    <input type="date" class="form-control" id="appointmentDate" name="appointmentDate" required>
                </div>
                <div class="form-group">
                    <label for="appointmentTime">Time</label>
                    <input type="time" class="form-control" id="appointmentTime" name="appointmentTime" required>
                </div>
                -->
					<div class="form-group">
						<label for="reason">Reason for Visit</label>
						<textarea class="form-control" id="reason" name="symptom" rows="3"
							placeholder="Describe your symptoms or reason for visit" required></textarea>
					</div>
					<div class="form-group">
						<label for="reason">Previous Treatment</label>
						<textarea class="form-control" id="reason" name="history" rows="3"
							placeholder="Details if any treatment recieved"></textarea>
					</div>
					<div class="mb-3">
						<button type="submit" class="btn appointment-submit-btn btn-block">Move
							Next</button>
					</div>
				</form>
			</div>
			<!-- Right: Image Section -->
			<div
				class="col-lg-6 col-md-5 d-none d-md-flex align-items-center justify-content-center appointment-image-section">
				<img src="${pageContext.request.contextPath}/image/consult5.avif"
					alt="Doctor Consultation" class="img-fluid appointment-image">
			</div>
		</div>
	</div>

</body>
</html>
