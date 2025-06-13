<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="allCss.jsp"%>
<div class="container mt-5" style="max-width: 500px;">
    <div class="card shadow-lg">
        <div class="card-header bg-black text-white">
            <h4 class="text-center mb-0">LOGIN</h4>
        </div>
        <div class="card-body">
            <!-- Role Toggle -->
            <div class="text-center mb-4">
                <div class="btn-group" role="group">
                    <button type="button" class="btn btn-outline-dark active" id="patientBtn">Patient</button>
                    <button type="button" class="btn btn-outline-dark" id="doctorBtn">Doctor</button>
                </div>
            </div>
            
            <%
            	String userType = (String) session.getAttribute("userType");
            	if(userType != null){
            	if(userType.equals("patient"))
            	{
            		//patient f = (patient) session.getAttribute("msg");
            %>
            		<p class="text-danger">Something went wrong. Please Try Again...</p>
            <%
            	}
            	else if(userType.equals("doctor"))
                {
            		//doctor f = (doctor) session.getAttribute("msg");
            %>
            		<p class="text-danger">Something went wrong. Please Try Again...</p>
            <%
                }
            	}
            	
            	session.removeAttribute("userType");
            %>
            <form id="loginForm" action="${pageContext.request.contextPath}/login" method="POST">
                <input type="hidden" name="userType" id="userType" value="patient">
                <div class="form-group mb-3">
                    <label>Email</label>
                    <input type="email" class="form-control" name="email" required>
                </div>
                <div class="form-group mb-3">
                    <label>Password</label>
                    <input type="password" class="form-control" name="password" required>
                </div>
                <button type="submit" class="btn btn-dark btn-block">Login</button>
            </form>
        </div>
    </div>
</div>
<script>
document.addEventListener('DOMContentLoaded', () => {
    const patientBtn = document.getElementById('patientBtn');
    const doctorBtn = document.getElementById('doctorBtn');
    const userTypeInput = document.getElementById('userType');

    patientBtn.addEventListener('click', () => {
        userTypeInput.value = 'patient';
        patientBtn.classList.add('active');
        doctorBtn.classList.remove('active');
    });

    doctorBtn.addEventListener('click', () => {
        userTypeInput.value = 'doctor';
        doctorBtn.classList.add('active');
        patientBtn.classList.remove('active');
    });
});
</script>
