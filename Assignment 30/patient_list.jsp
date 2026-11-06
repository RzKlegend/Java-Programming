<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Patient Management System</title>
</head>
<body>
    <h2>Patient Records</h2>
    <a href="patient_add.jsp">Add New Patient</a><br><br>

    <table border="1" cellpadding="8" cellspacing="0">
        <tr>
            <th>Patient ID</th>
            <th>Name</th>
            <th>Age</th>
            <th>Disease</th>
            <th>Treatment Status</th>
            <th>Actions</th>
        </tr>
        <%
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab_db", "root", "akashbhavsar");
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM patient");

                while (rs.next()) {
        %>
        <tr>
            <td><%= rs.getInt("patient_id") %></td>
            <td><%= rs.getString("name") %></td>
            <td><%= rs.getInt("age") %></td>
            <td><%= rs.getString("disease") %></td>
            <td><%= rs.getString("treatment_status") %></td>
            <td>
                <a href="patient_edit.jsp?id=<%= rs.getInt("patient_id") %>">Edit</a> |
                <a href="patient_delete.jsp?id=<%= rs.getInt("patient_id") %>" onclick="return confirm('Delete patient record?')">Delete</a>
            </td>
        </tr>
        <%
                }
                conn.close();
            } catch (Exception e) {
                out.println("Error: " + e.getMessage());
            }
        %>
    </table>
</body>
</html>