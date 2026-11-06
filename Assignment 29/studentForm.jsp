<%-- THIS IS THE INPUT FORM --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Student Information Form</title>
</head>
<body>
    <h2>Enter Student Details</h2>
    <form action="studentResult.jsp" method="post">
        Student Name: <input type="text" name="studentName"><br><br>
        Roll Number: <input type="text" name="rollNo"><br><br>
        Course: <input type="text" name="course"><br><br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>