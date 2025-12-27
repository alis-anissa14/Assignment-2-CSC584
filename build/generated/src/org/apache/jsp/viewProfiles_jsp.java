package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class viewProfiles_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <title>All Student Profiles</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("<h2>All Student Profiles</h2>\n");
      out.write("\n");
      out.write("<table border=\"1\" cellpadding=\"8\">\n");
      out.write("<tr>\n");
      out.write("    <th>No</th>\n");
      out.write("    <th>Name</th>\n");
      out.write("    <th>Student ID</th>\n");
      out.write("    <th>Program</th>\n");
      out.write("    <th>Email</th>\n");
      out.write("    <th>Hobbies</th>\n");
      out.write("    <th>Introduction</th>\n");
      out.write("</tr>\n");
      out.write("\n");

int count = 0;

Class.forName("com.mysql.cj.jdbc.Driver");
Connection conn = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/studentprofiles",
    "root",
    ""
);

Statement stmt = conn.createStatement();
ResultSet rs = stmt.executeQuery("SELECT * FROM profiles");

while(rs.next()){
    count++;

      out.write("\n");
      out.write("<tr>\n");
      out.write("    <td>");
      out.print( count );
      out.write("</td>\n");
      out.write("    <td>");
      out.print( rs.getString("name") );
      out.write("</td>\n");
      out.write("    <td>");
      out.print( rs.getString("student_id") );
      out.write("</td>\n");
      out.write("    <td>");
      out.print( rs.getString("program") );
      out.write("</td>\n");
      out.write("    <td>");
      out.print( rs.getString("email") );
      out.write("</td>\n");
      out.write("    <td>");
      out.print( rs.getString("hobbies") );
      out.write("</td>\n");
      out.write("    <td>");
      out.print( rs.getString("intro") );
      out.write("</td>\n");
      out.write("</tr>\n");

}
conn.close();

      out.write("\n");
      out.write("</table>\n");
      out.write("\n");
      out.write("<p><b>Total Profiles:</b> ");
      out.print( count );
      out.write("</p>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
