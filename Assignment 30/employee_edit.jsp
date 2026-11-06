<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Employee</title>
</head>
<body>
    <%
        int id = Integer.parseInt(request.getParameter("id"));
        String name = "", dept = "";
        double salary = 0;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab_db", "root", "password");
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM employee WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                name = rs.getString("name");
                dept = rs.getString("department");
                salary = rs.getDouble("salary");
            }
            conn.close();
        } catch (Exception e) {
            out.println("Error: " + e.getMessage());
        }
    %>

    <h2>Edit Employee Details</h2>
    <form action="employee_edit.jsp" method="post">
        <input type="hidden" name="id" value="<%= id %>">
        Name: <input type="text" name="name" value="<%= name %>" required><br><br>
        Department: <input type="text" name="department" value="<%= dept %>" required><br><br>
        Salary: <input type="number" step="0.01" name="salary" value="<%= salary %>" required><br><br>
        <input type="submit" name="update" value="Update Employee">
    </form>

    <%
        if (request.getParameter("update") != null) {
            int empId = Integer.parseInt(request.getParameter("id"));
            String empName = request.getParameter("name");
            String empDept = request.getParameter("department");
            double empSalary = Double.parseDouble(request.getParameter("salary"));

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab_db", "root", "akashbhavsar");
                PreparedStatement ps = conn.prepareStatement("UPDATE employee SET name=?, department=?, salary=? WHERE id=?");
                ps.setString(1, empName);
                ps.setString(2, empDept);
                ps.setDouble(3, empSalary);
                ps.setInt(4, empId);
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