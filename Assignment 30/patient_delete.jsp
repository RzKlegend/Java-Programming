<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%
    int pId = Integer.parseInt(request.getParameter("id"));
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab_db", "root", "akashbhavsar");
        PreparedStatement ps = conn.prepareStatement("DELETE FROM patient WHERE patient_id = ?");
        ps.setInt(1, pId);
        ps.executeUpdate();
        conn.close();
        response.sendRedirect("patient_list.jsp");
    } catch (Exception e) {
        out.println("Error: " + e.getMessage());
    }
%>