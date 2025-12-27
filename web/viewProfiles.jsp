<%@ page import="java.sql.*" %>
<%
String keyword = request.getParameter("keyword");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>View All Profiles</title>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">

    <style>
        body {
            font-family: Arial, sans-serif;
            background-color:  #f8f2ec; 
            padding: 30px;
        }

        h2 {
            text-align: center;
            margin-bottom: 20px;
            color: #333;
        }

        .search-box {
            text-align: center;
            margin-bottom: 20px;
        }

        .search-box input[type=text] {
            padding: 8px;
            width: 250px;
            margin-right: 10px;
            border-radius: 5px;
            border: 1px solid #ccc;
        }

        .search-box button {
            padding: 8px 15px;
            border: none;
            background-color: #666699;
            color: white;
            border-radius: 5px;
            cursor: pointer;
        }

        .search-box button:hover {
            background-color: #666699;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            background-color: #fff;
            border-radius: 8px;
            overflow: hidden;
            box-shadow: 0 3px 10px rgba(0,0,0,0.1);
        }

        th {
            background-color: #9999ff;
            color: white;
            padding: 12px;
            text-align: left;
        }

        td {
            padding: 10px;
            text-align: left;
        }

        tr:nth-child(even) { background-color: #f2f2f2; }
        tr:hover { background-color:  #e4cdb4; }

        .trash-button {
            background: none;
            border: none;
            cursor: pointer;
            color: red;
            font-size: 18px;
        }

        .total-count {
            margin-top: 15px;
            font-weight: bold;
        }
    </style>
</head>
<body>

<h2>All Student Profiles</h2>

<div class="search-box">
    <form method="get" action="viewProfiles.jsp">
        <input type="text" name="keyword" placeholder="Search by Name or Student ID" value="<%= (keyword != null) ? keyword : "" %>">
        <button type="submit">Search</button>
    </form>
</div>

<table>
    <tr>
        <th>No</th>
        <th>Name</th>
        <th>Student ID</th>
        <th>Program</th>
        <th>Email</th>
        <th>Hobbies</th>
        <th>Introduction</th>
        <th>Action</th>
    </tr>

<%
int count = 0;
try {
    Class.forName("org.apache.derby.jdbc.ClientDriver");
    Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/studentprofiles", "app", "app");

    PreparedStatement ps;
    if(keyword != null && !keyword.trim().isEmpty()) {
        ps = conn.prepareStatement(
            "SELECT * FROM PROFILES WHERE LOWER(NAME) LIKE ? OR LOWER(STUDENT_ID) LIKE ? ORDER BY NAME"
        );
        ps.setString(1, "%" + keyword.toLowerCase() + "%");
        ps.setString(2, "%" + keyword.toLowerCase() + "%");
    } else {
        ps = conn.prepareStatement("SELECT * FROM PROFILES ORDER BY NAME");
    }

    ResultSet rs = ps.executeQuery();

    while(rs.next()) {
        count++;
%>
    <tr>
        <td><%= count %></td>
        <td><%= rs.getString("NAME") %></td>
        <td><%= rs.getString("STUDENT_ID") %></td>
        <td><%= rs.getString("PROGRAM") %></td>
        <td><%= rs.getString("EMAIL") %></td>
        <td><%= rs.getString("HOBBIES") %></td>
        <td><%= rs.getString("INTRO") %></td>
        <td>
            <form action="DeleteProfileServlet" method="post" onsubmit="return confirm('Are you sure want to delete this profile?');">
                <input type="hidden" name="studentId" value="<%= rs.getString("STUDENT_ID") %>">
                <button type="submit" class="trash-button">
                    <i class="fas fa-trash-alt"></i>
                </button>
            </form>
        </td>
    </tr>
<%
}
    rs.close();
    ps.close();
    conn.close();
} catch(Exception e) {
    out.println("<tr><td colspan='8'>Error: " + e.getMessage() + "</td></tr>");
}
%>
</table>

<p class="total-count">Total Profiles: <%= count %></p>

</body>
</html>