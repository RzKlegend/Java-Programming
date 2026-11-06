<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Patient</title>
</head>
<body>
    <%
        int pId = Integer.parseInt(request.getParameter("id"));
        String name = "", disease = "", status = "";
        int age = 0;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab_db", "root", "password");
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM patient WHERE patient_id = ?");
            ps.setInt(1, pId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                name = rs.getString("name");
                age = rs.getInt("age");
                disease = rs.getString("disease");
                status = rs.getString("treatment_status");
            }
            conn.close();
        } catch (Exception e) {
            out.println("Error: " + e.getMessage());
        }
    %>

    <h2>Update Patient Details</h2>
    <form action="patient_edit.jsp" method="post">
        <input type="hidden" name="id" value="<%= pId %>">
        Name: <input type="text" name="name" value="<%= name %>" required><br><br>
        Age: <input type="number" name="age" value="<%= age %>" required><br><br>
        Disease: <input type="text" name="disease" value="<%= disease %>" required><br><br>
        Treatment Status: 
        <select name="treatment_status">
            <option value="Admitted" <%= "Admitted".equals(status) ? "selected" : "" %>>Admitted</option>
            <option value="Under Treatment" <%= "Under Treatment".equals(status) ? "selected" : "" %>>Under Treatment</option>
            <option value="Discharged" <%= "Discharged".equals(status) ? "selected" : "" %>>Discharged</option>
        </select><br><br>
        <input type="submit" name="update" value="Update Patient">
    </form>

    <%
        if (request.getParameter("update") != null) {
            int patientId = Integer.parseInt(request.getParameter("id"));
            String pName = request.getParameter("name");
            int pAge = Integer.parseInt(request.getParameter("age"));
            String pDisease = request.getParameter("disease");
            String pStatus = request.getParameter("treatment_status");

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab_db", "root", "akashbhavsar");
                PreparedStatement ps = conn.prepareStatement("UPDATE patient SET name=?, age=?, disease=?, treatment_status=? WHERE patient_id=?");
                ps.setString(1, pName);
                ps.setInt(2, pAge);
                ps.setString(3, pDisease);
                ps.setString(4, pStatus);
                ps.setInt(5, patientId);
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