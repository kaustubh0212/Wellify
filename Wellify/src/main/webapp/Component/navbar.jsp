<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="allCss.jsp"%>
<%@ page import="domain.patient"%>
<%@ page import="domain.doctor"%>


<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-dark bg-black fixed-top">
	<div class="container">
		<!-- Left: Brand -->
		<a class="navbar-brand font-weight-bold" href="#">Wellify</a>
		<!-- Toggler for mobile -->
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#wellifyNavbar" aria-controls="wellifyNavbar"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<!-- Center: Nav links -->
		<div class="collapse navbar-collapse justify-content-center"
			id="wellifyNavbar">
			<ul class="navbar-nav mx-auto">
				<li class="nav-item active"><a class="nav-link" href="Home.jsp">Home</a></li>
				<li class="nav-item active"><a class="nav-link" href="Services.jsp">Services</a></li>
				<li class="nav-item active"><a class="nav-link" href="AboutUs.jsp">About Us</a></li>
				<!--
				<li class="nav-item active"><a class="nav-link" href="#contact">Contact</a></li>
				-->
			</ul>
			<!-- Right: Login/Register -->
			<ul class="navbar-nav ml-auto">
				<%
				String ut = (String) session.getAttribute("userType");
				Boolean isLogin = (Boolean) session.getAttribute("isLogin");
				System.out.println("userType in navbar: " + ut);
				if(isLogin != null){
				if (ut != null && ut.equals("patient")) {
					patient p = (patient) session.getAttribute("p");
				%>

				<li class="nav-item active mr-2"><a class="nav-link" href="bookAppointment.jsp">Book Appointment</a></li>
				<li class="nav-item active mr-2"><a class="nav-link" href="viewAppointment">History</a></li>
				<li class="nav-item"><a class="btn btn-light text-black" href="logout">Logout</a></li>

				<%
				}
				else if(ut != null && ut.equals("doctor"))
				{
					doctor p = (doctor) session.getAttribute("d");
				%>
				
				<li class="nav-item active mr-2"><a class="nav-link" href="viewPatient">Appointments</a></li>
				<li class="nav-item"><a class="btn btn-light text-black" href="${pageContext.request.contextPath}/logout">Logout</a></li>
				
				<%
				}
				}
				else
				{
					session.removeAttribute("ut");
					session.removeAttribute("isLogin");
				%>
				
				<li class="nav-item"><a class="btn btn-outline-light mr-2" href="${pageContext.request.contextPath}/login.jsp">Login</a></li>
				<li class="nav-item"><a class="btn btn-light text-black" href="${pageContext.request.contextPath}/register.jsp">Register</a></li>
				
				<%
				}
				%>
				
			</ul>
		</div>
	</div>
</nav>

<!-- Page Sections -->
<section id="home" class="section-home">
	<!-- Home content here -->
</section>
<section id="services" class="section-services">
	<!-- Services content here -->
</section>
<section id="about" class="section-about">
	<!-- About Us content here -->
</section>
<section id="contact" class="section-contact">
	<!-- Contact content here -->
</section>
