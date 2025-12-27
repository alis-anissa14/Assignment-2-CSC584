package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.ProfileBean;

public final class display_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\n');
      out.write('\n');

    ProfileBean profile = (ProfileBean) request.getAttribute("profile");

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <title>Student Details</title>\n");
      out.write("    <style>\n");
      out.write("        * { margin:0;  \n");
      out.write("            padding:0;\n");
      out.write("            box-sizing: border-box; \n");
      out.write("            }\n");
      out.write("        body {\n");
      out.write("            font-family: \"Times New Roman\", serif;\n");
      out.write("            min-height: 100vh;\n");
      out.write("            background-image: url(\"images/profile.jpg\");\n");
      out.write("            background-size: cover;\n");
      out.write("            background-position: center;\n");
      out.write("            display: flex;\n");
      out.write("            justify-content: center;\n");
      out.write("            align-items: center;\n");
      out.write("            padding: 20px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .logo-title {\n");
      out.write("            position: absolute;\n");
      out.write("            top: 50px;\n");
      out.write("            left: 50%;\n");
      out.write("            transform: translateX(-50%);\n");
      out.write("            font-size: 32px;\n");
      out.write("            color: black;\n");
      out.write("            font-weight: bold;\n");
      out.write("            text-shadow: 2px 2px 8px rgba(0,0,0,0.7);\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .profile-box {\n");
      out.write("            width: 800px;          \n");
      out.write("            max-width: 95vw; \n");
      out.write("            max-height: 90vh;\n");
      out.write("            overflow-y: auto;\n");
      out.write("            background: rgba(255,255,255,0.95);\n");
      out.write("            padding: 30px 40px;\n");
      out.write("            border-radius: 15px;\n");
      out.write("            box-shadow: 0 0 15px rgba(0,0,0,0.3);\n");
      out.write("            border: 6px groove #666;\n");
      out.write("            text-align: left;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .uitm-small-logo {\n");
      out.write("            width: 170px;       \n");
      out.write("            margin-bottom: 0;\n");
      out.write("            display: block;\n");
      out.write("            margin-left: auto;\n");
      out.write("            margin-right: auto;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        h2 {\n");
      out.write("            color: #302b2b;\n");
      out.write("            margin: 25px 0 20px 0;\n");
      out.write("            text-align: center;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .line {\n");
      out.write("           width: 80%;\n");
      out.write("          height: 5px;\n");
      out.write("          background: #444;\n");
      out.write("          border-radius: 2px;\n");
      out.write("          box-shadow: 0 2px 4px rgba(0,0,0,0.3);\n");
      out.write("          margin: 20px auto;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .info-row {\n");
      out.write("            display: grid;\n");
      out.write("           grid-template-columns: 150px auto;\n");
      out.write("           margin-bottom: 12px;\n");
      out.write("           align-items: start;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .info-label {\n");
      out.write("            background: #d4d2d2;\n");
      out.write("            padding: 12px 18px;\n");
      out.write("            border-radius: 6px;\n");
      out.write("            font-weight: bold;\n");
      out.write("            font-size:20px;\n");
      out.write("            width:158px;  \n");
      out.write("            \n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .info-value {\n");
      out.write("            font-size: 20px;\n");
      out.write("            padding-left: 15px;\n");
      out.write("            overflow-wrap: break-word;\n");
      out.write("            word-break: break-word;\n");
      out.write("            color: #222;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<div class=\"container\">\n");
      out.write("    <h2>Profile Submitted</h2>\n");
      out.write("    <p><b>Name:</b> ");
      out.print( profile.getName() );
      out.write("</p>\n");
      out.write("    <p><b>Student ID:</b> ");
      out.print( profile.getStudentId() );
      out.write("</p>\n");
      out.write("    <p><b>Program:</b> ");
      out.print( profile.getProgram() );
      out.write("</p>\n");
      out.write("    <p><b>Email:</b> ");
      out.print( profile.getEmail() );
      out.write("</p>\n");
      out.write("    <p><b>Hobbies:</b> ");
      out.print( profile.getHobbies() );
      out.write("</p>\n");
      out.write("    <p><b>Introduction:</b> ");
      out.print( profile.getIntro() );
      out.write("</p>\n");
      out.write("\n");
      out.write("    <form action=\"viewProfiles.jsp\">\n");
      out.write("        <button type=\"submit\">View All Profiles</button>\n");
      out.write("    </form>\n");
      out.write("</div>\n");
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
