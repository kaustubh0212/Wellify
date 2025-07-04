<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	
<%@include file="allCss.jsp"%>
<div class="container mt-5" style="max-width: 800px;">
	<div class="card shadow-lg">
		<div class="card-header bg-black text-white">
			<h4 class="text-center mb-0">REGISTRATION</h4>
		</div>
		<div class="card-body">
			<!-- Role Toggle -->
			<div class="text-center mb-4">
				<div class="btn-group" role="group">
					<button type="button" class="btn btn-outline-dark active"
						id="patientBtn">Patient</button>
					<button type="button" class="btn btn-outline-dark" id="doctorBtn">Doctor</button>
				</div>
			</div>

			<%
			String userType = (String) session.getAttribute("userType");
			Boolean f = (Boolean) session.getAttribute("msg");
			if (userType != null) {
				if (f) {
			%>
			<p class="text-success">User registered successfully!</p>
			<%
			} else if (!f) {
			%>
			<p class="text-danger">Something Went Wrong!</p>
			<%
			}

			session.removeAttribute("userType");
			session.removeAttribute("f");
			}
			%>

			<form id="regForm"
				action="${pageContext.request.contextPath}/register" method="POST">
				<input type="hidden" name="userType" id="userType" value="patient">
				<div class="form-group mb-3">
					<label>Full Name</label> <input type="text" class="form-control"
						name="name" required>
				</div>
				<div class="form-group mb-3">
					<label>Email</label> <input type="email" class="form-control"
						name="email" required>
				</div>
				<div class="form-group mb-3">
					<label>Password</label> <input type="password" class="form-control"
						name="password" required>
				</div>
				<div class="form-group mb-3">
					<label>Phone</label> <input type="tel" class="form-control"
						name="phone" pattern="[0-9]{10}" required>
				</div>
				<div class="form-group mb-3">
					<label>Age</label> <input type="number" class="form-control"
						name="age" required>
				</div>

				<!-- Patient Fields -->

				<div id="patientFields">
					<!--
                    <div class="form-group mb-3">
                        <label>Medical History (if any)</label>
                        <textarea class="form-control" name="medicalHistory" rows="2"></textarea>
                    </div>
                    -->
				</div>


				<!-- Doctor Fields -->
				<div id="doctorFields" style="display: none;">
					<div class="form-group mb-3">
						<label>Specialization</label> <select class="form-control"
							name="specialization">
							<option value="" disabled selected>Select specialization</option>
							<option value="Cardiology">Cardiology</option>
							<option value="Dermatology">Dermatology</option>
							<option value="Endocrinology">Endocrinology</option>
							<option value="Gastroenterology">Gastroenterology</option>
							<option value="Hematology">Hematology</option>
							<option value="Infectious Disease">Infectious Disease</option>
							<option value="Nephrology">Nephrology</option>
							<option value="Neurology">Neurology</option>
							<option value="Oncology">Oncology</option>
							<option value="Ophthalmology">Ophthalmology</option>
							<option value="Orthopedics">Orthopedics</option>
							<option value="Otolaryngology">Otolaryngology</option>
							<option value="Pediatrics">Pediatrics</option>
							<option value="Psychiatry">Psychiatry</option>
							<option value="Pulmonology">Pulmonology</option>
							<option value="Rheumatology">Rheumatology</option>
							<option value="Urology">Urology</option>
							<option value="Gynecology">Gynecology</option>
							<option value="Immunology">Immunology</option>
							<option value="Hepatology">Hepatology</option>
							<option value="General Physician">General Physician</option>
							<option value="General Surgery">General Surgery</option>
							<!-- Add more as needed -->
						</select>
					</div>
					<div class="form-group mb-3">
						<label>Qualifications</label> <input type="text"
							class="form-control" name="qualification">
					</div>
					<div class="form-group mb-3">
						<label>Clinic/Hospital Address</label>
						<textarea class="form-control" name="address" rows="2"></textarea>
					</div>
					<div class="form-group mb-3">
						<label>Fees</label> <input type="number" class="form-control"
							name="fees">
					</div>
				</div>


				<button type="submit" class="btn btn-dark btn-block">Register</button>
			</form>
		</div>
	</div>
</div>

<script>
document.getElementById('patientBtn').addEventListener('click', () => {
    document.getElementById('patientFields').style.display = 'block';
    document.getElementById('doctorFields').style.display = 'none';
    document.getElementById('userType').value = 'patient';
    document.getElementById('patientBtn').classList.add('active');
    document.getElementById('doctorBtn').classList.remove('active');
    const a = document.getElementById('userType')
    console.log("patient userType: " , a.value)
});

document.getElementById('doctorBtn').addEventListener('click', () => {
    document.getElementById('patientFields').style.display = 'none';
    document.getElementById('doctorFields').style.display = 'block';
    document.getElementById('userType').value = 'doctor';
    document.getElementById('doctorBtn').classList.add('active');
    document.getElementById('patientBtn').classList.remove('active');
    const a = document.getElementById('userType')
    console.log("doctor userType: " , a.value)
});
</script>
