<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Patient</title>
</head>
<body>
    <h2>Add Patient Record</h2>
    <form action="patient_add.jsp" method="post">
        Name: <input type="text" name="name" required><br><br>
        Age: <input type="number" name="age" required><br><br>
        Disease: <input type="text" name="disease" required><br><br>
        Treatment Status: 
        <select name="treatment_status">
            <option value="Admitted">Admitted</option>
            <option value="Under Treatment">Under Treatment</option>
            <option value="Discharged">Discharged</option>
        </select><br><br>
        <input type="submit" name="submit" value="Add Patient">
    </form>

    <%
        if (request.getParameter("submit") != null) {
            String name = request.getParameter("name");
            int age = Integer.parseInt(request.getParameter("age"));
            String disease = request.getParameter("disease");
            String status = request.getParameter("treatment_status");

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab_db", "root", "akashbhavsar");
                PreparedStatement ps = conn.prepareStatement("INSERT INTO patient(name, age, disease, treatment_status) VALUES(?, ?, ?, ?)");
                ps.setString(1, name);
                ps.setInt(2, age);
                ps.setString(3, disease);
                ps.setString(4, status);
                ps.executeUpdate();
                conn.close();
                response.sendRedirect("patient_list.jsp");
            } catch (Exception e) {
                out.println("Error: " + e.getMessage());
            }
        }
    %>
</body>
</html>