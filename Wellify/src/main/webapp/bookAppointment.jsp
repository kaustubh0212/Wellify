<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Appointment</title>
<%@include file = "/Component/allCss.jsp" %>
</head>
<body>
<%
//List<Doctor> doctors = (List<Doctor>) request.getAttribute("doctors");
String step = (String) session.getAttribute("step");
if(step == null){
%>
<%@include file = "/Component/bookAppointmentForm1.jsp"%>
<%
}
else if(step.equals("step2"))
{
	session.removeAttribute("step");
%>

<%@include file = "/Component/bookAppointmentForm2.jsp"%>

<%
}
%>
</body>
</html>