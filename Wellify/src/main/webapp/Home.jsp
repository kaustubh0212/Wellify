<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Welcome to Wellify</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Component/Home.css">
</head>
<body>
    <%@include file = "/Component/navbar.jsp"%>
    <div class="home-main">
        <div class="home-content-block">
            <h1 class="home-title">Welcome to <span class="brand">Wellify</span></h1>
            <p class="home-quote">
                Making healthcare simple, accessible, and personal. Connecting patients and doctors for a healthier tomorrow.
            </p>
            <a href="bookAppointment.jsp" class="cta-btn">Book Appointment</a>
        </div>
        <div class="home-image-block">
            <img src="${pageContext.request.contextPath}/image/team.jpg" alt="Healthcare Team" class="home-image">
        </div>
    </div>
</body>
</html>
