<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Our Services | Wellify</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Component/Services.css">
</head>
<body>
    <%@include file = "/Component/navbar.jsp"%>
    <div class="services-main">
        <h1 class="services-title">Our Services</h1>
        <p class="services-intro">
            At <span class="brand">Wellify</span>, we offer a range of healthcare services to make your life easier and healthier.
        </p>
        <div class="services-cards">
            <div class="service-card">
                <div class="service-icon">&#128137;</div>
                <h2 class="service-name">Book Appointments</h2>
                <p class="service-desc">
                    Schedule appointments with top doctors in just a few clicks. Choose your preferred time and specialist.
                </p>
            </div>
            <div class="service-card">
                <div class="service-icon">&#128104;&#8205;&#127973;</div>
                <h2 class="service-name">Consult Specialists</h2>
                <p class="service-desc">
                    Access a wide network of medical experts in various fields for in-person or online consultations.
                </p>
            </div>
            <div class="service-card">
                <div class="service-icon">&#128203;</div>
                <h2 class="service-name">Digital Prescriptions</h2>
                <p class="service-desc">
                    Receive and manage your prescriptions securely online, anytime and anywhere.
                </p>
            </div>
            <!-- 
            <div class="service-card">
                <div class="service-icon">&#128657;</div>
                <h2 class="service-name">Emergency Support</h2>
                <p class="service-desc">
                    Get quick access to emergency care and support when you need it the most.
                </p>
            </div>
            <div class="service-card">
                <div class="service-icon">&#128300;</div>
                <h2 class="service-name">Health Records</h2>
                <p class="service-desc">
                    Store and track your medical history and reports securely in one place.
                </p>
            </div>
            -->
        </div>
    </div>
</body>
</html>
