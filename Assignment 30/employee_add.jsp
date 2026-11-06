<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Employee</title>
</head>
<body>
    <h2>Add New Employee</h2>
    <form action="employee_add.jsp" method="post">
        Name: <input type="text" name="name" required><br><br>
        Department: <input type="text" name="department" required><br><br>
        Salary: <input type="number" step="0.01" name="salary" required><br><br>
        <input type="submit" name="submit" value="Save Employee">
    </form>

    <%
        if (request.getParameter("submit") != null) {
            String name = request.getParameter("name");
            String dept = request.getParameter("department");
            double salary = Double.parseDouble(request.getParameter("salary"));

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab_db", "root", "akashbhavsar");
                PreparedStatement ps = conn.prepareStatement("INSERT INTO employee(name, department, salary) VALUES(?, ?, ?)");
                ps.setString(1, name);
                ps.setString(2, dept);
                ps.setDouble(3, salary);
                ps.executeUpdate();
                conn.close();
                response.sendRedirect("employee_list.jsp");
            } catch (Exception e) {
                out.println("Error: " + e.getMessage());
            }
        }
    %>
</body>
</html>