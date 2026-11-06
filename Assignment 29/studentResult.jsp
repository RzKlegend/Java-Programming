// the processing page
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Student Information Result</title>
</head>
<body>
    <h2>Student Details Submitted:</h2>
    <%
        String name = request.getParameter("studentName");
        String roll = request.getParameter("rollNo");
        String course = request.getParameter("course");
    %>
    <p><strong>Name:</strong> <%= name %></p>
    <p><strong>Roll Number:</strong> <%= roll %></p>
    <p><strong>Course:</strong> <%= course %></p>
</body>
</html>