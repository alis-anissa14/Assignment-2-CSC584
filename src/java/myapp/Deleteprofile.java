package myapp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteProfileServlet")
public class Deleteprofile extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String studentId = request.getParameter("studentId");

        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection conn = DriverManager.getConnection(
               "jdbc:derby://localhost:1527/studentprofiles","app","app");

            String sql = "DELETE FROM PROFILES WHERE STUDENT_ID=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, studentId); 
            ps.executeUpdate();

            conn.close();
        } catch(Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("viewProfiles.jsp");
    }
}