package com.me.finaldesignproject;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class DownloadResumeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String enrollmentNo = request.getParameter("enrollment_no");

        if (enrollmentNo == null || enrollmentNo.trim().isEmpty()) {
            response.getWriter().write("Enrollment number is missing.");
            return;
        }

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/design_engineering_portal", "root", "root");

            String sql = "SELECT resume_path FROM students WHERE enrollment_no = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, enrollmentNo);
            rs = stmt.executeQuery();

            if (rs.next()) {
                String resumePath = rs.getString("resume_path");
                if (resumePath != null && !resumePath.isEmpty()) {
                    // Replace backslashes with forward slashes
                    resumePath = resumePath.replace("\\", "/");

                    String fullPath = getServletContext().getRealPath("/") + resumePath;
                    File file = new File(fullPath);

                    if (file.exists()) {
                        response.setContentType(getServletContext().getMimeType(file.getName()));
                        response.setHeader("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");
                        FileInputStream inStream = new FileInputStream(file);
                        OutputStream outStream = response.getOutputStream();

                        byte[] buffer = new byte[4096];
                        int bytesRead;
                        while ((bytesRead = inStream.read(buffer)) != -1) {
                            outStream.write(buffer, 0, bytesRead);
                        }
                        inStream.close();
                        outStream.close();
                        return;
                    }
                }
            }

            response.getWriter().write("Resume file not found on server.");
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("Error: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
