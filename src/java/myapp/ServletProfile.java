package myapp;

import model.ProfileBean;
import java.io.IOException;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ProfileServlet")
public class ServletProfile extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        String studentId = request.getParameter("studentId");
        String program = request.getParameter("program");
        String email = request.getParameter("email");
        String hobbies = request.getParameter("hobbies");
        String intro = request.getParameter("intro");

        ProfileBean profile = new ProfileBean();
        profile.setName(name);
        profile.setStudentId(studentId);
        profile.setProgram(program);
        profile.setEmail(email);
        profile.setHobbies(hobbies);
        profile.setIntro(intro);

        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection conn = DriverManager.getConnection(
               "jdbc:derby://localhost:1527/studentprofiles","app","app");
            String sql = "INSERT INTO PROFILES (NAME, STUDENT_ID, PROGRAM, EMAIL, HOBBIES, INTRO) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, studentId);
            ps.setString(3, program);
            ps.setString(4, email);
            ps.setString(5, hobbies);
            ps.setString(6, intro);
            ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("profile", profile);
        RequestDispatcher rd = request.getRequestDispatcher("profile.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("Profile.html");
    }
}