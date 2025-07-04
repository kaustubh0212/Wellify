<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>About Us | Wellify</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Component/AboutUs.css">
</head>
<body>
    <%@include file = "/Component/navbar.jsp"%>
    <section class="about-main">
        <div class="about-mission">
            <h2>Our Mission</h2>
            <p>
                Wellify is a healthcare platform built to bridge the gap between patients and doctors. We believe that quality healthcare should be accessible, transparent, and convenient for everyone—regardless of location or background.
            </p>
        </div>
        <div class="about-values">
            <h2>What Makes Us Different?</h2>
            <div class="about-values-cards">
                <div class="about-value-card">
                    <div class="about-value-icon">&#128187;</div>
                    <h3>Technology-Driven</h3>
                    <p>
                        We leverage technology to make appointment booking, digital prescriptions, and health record management seamless and secure.
                    </p>
                </div>
                <div class="about-value-card">
                    <div class="about-value-icon">&#128100;&#128104;</div>
                    <h3>Inclusive Platform</h3>
                    <p>
                        Wellify is not tied to any one hospital or clinic. We aggregate a diverse network of verified doctors and specialists from across the region.
                    </p>
                </div>
                <div class="about-value-card">
                    <div class="about-value-icon">&#128172;</div>
                    <h3>Support & Trust</h3>
                    <p>
                        Our support team is here to help, and all interactions are private, secure, and built on trust.
                    </p>
                </div>
            </div>
        </div>
        <div class="about-cta">
            <h2>Join the Wellify Community</h2>
            <p>
                Whether you’re a patient seeking care or a doctor looking to connect with more people, Wellify is your trusted healthcare partner.
            </p>
            <a href="bookAppointment.jsp" class="about-btn">Book Appointment</a>
        </div>
    </section>
</body>
</html>
