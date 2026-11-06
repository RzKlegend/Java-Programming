<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Registration Result</title>
</head>
<body>
    <h2>Submitted Details:</h2>
    <p><strong>Name:</strong> <%= request.getParameter("name") %></p>
    <p><strong>Email:</strong> <%= request.getParameter("email") %></p>
    <p><strong>Phone Number:</strong> <%= request.getParameter("phone") %></p>
    <p><strong>Password:</strong> <%= request.getParameter("password") %></p>
</body>
</html>