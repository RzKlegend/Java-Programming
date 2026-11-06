<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%
    int id = Integer.parseInt(request.getParameter("id"));
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab_db", "root", "akashbhavsar");
        PreparedStatement ps = conn.prepareStatement("DELETE FROM employee WHERE id = ?");
        ps.setInt(1, id);
        ps.executeUpdate();
        conn.close();
        response.sendRedirect("employee_list.jsp");
    } catch (Exception e) {
        out.println("Error: " + e.getMessage());
    }
%>