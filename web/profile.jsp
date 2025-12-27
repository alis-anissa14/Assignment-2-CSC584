<%@ page import="model.ProfileBean" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
    ProfileBean profile = (ProfileBean) request.getAttribute("profile");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Details</title>
    <style>
        * { margin:0;  
            padding:0;
            box-sizing: border-box; 
            }
        body {
            font-family: "Times New Roman", serif;
            min-height: 100vh;
            background-image: url("images/profile.jpg");
            background-size: cover;
            background-position: center;
            display: flex;
            justify-content: center;
            align-items: center;
            padding: 20px;
        }

        .logo-title {
            position: absolute;
            top: 50px;
            left: 50%;
            transform: translateX(-50%);
            font-size: 32px;
            color: black;
            font-weight: bold;
            text-shadow: 2px 2px 8px rgba(0,0,0,0.7);
        }

        .profile-box {
            width: 800px;          
            max-width: 95vw; 
            max-height: 90vh;
            overflow-y: auto;
            background: rgba(255,255,255,0.95);
            padding: 30px 40px;
            border-radius: 15px;
            box-shadow: 0 0 15px rgba(0,0,0,0.3);
            border: 6px groove #666;
            text-align: left;
        }

        .uitm-small-logo {
            width: 170px;       
            margin-bottom: 0;
            display: block;
            margin-left: auto;
            margin-right: auto;
        }

        h2 {
            color: #302b2b;
            margin: 25px 0 20px 0;
            text-align: center;
        }

        .line {
           width: 80%;
          height: 5px;
          background: #444;
          border-radius: 2px;
          box-shadow: 0 2px 4px rgba(0,0,0,0.3);
          margin: 20px auto;
        }

        .info-row {
            display: grid;
           grid-template-columns: 150px auto;
           margin-bottom: 12px;
           align-items: start;
        }

        .info-label {
            background: #d4d2d2;
            padding: 12px 18px;
            border-radius: 6px;
            font-weight: bold;
            font-size:20px;
            width:158px;  
            
        }

        .info-value {
            font-size: 20px;
            padding-left: 15px;
            overflow-wrap: break-word;
            word-break: break-word;
            color: #222;
        }
.btn {
    margin-top: 30px;
    padding: 12px 28px;
    font-size: 18px;
    font-family: "Times New Roman", serif;
    background: #1e3c72;
    background: linear-gradient(to right, #1e3c72, #2a5298);
    color: white;
    border: none;
    border-radius: 8px;
    cursor: pointer;
    display: block;
    margin-left: auto;
    margin-right: auto;
    box-shadow: 0 4px 8px rgba(0,0,0,0.3);
    transition: all 0.3s ease;
}

.btn:hover {
    background: linear-gradient(to right, #2a5298, #1e3c72);
    transform: translateY(-2px);
    box-shadow: 0 6px 12px rgba(0,0,0,0.4);
}

.btn:active {
    transform: translateY(0);
    box-shadow: 0 3px 6px rgba(0,0,0,0.3);
}
    </style>
</head>
<body>

    <div class="profile-box">

         <img src="images/uitm.jpg" class="uitm-small-logo">

    <h2>UITM Student Profile</h2>
        <div class="line"></div>

<div class="info-row">
            <div class="info-label">Name:</div>
            <div class="info-value"><%= profile.getName() %></div>
        </div>

        <div class="info-row">
            <div class="info-label">Student ID:</div>
            <div class="info-value"><%= profile.getStudentId() %></div>
        </div>

        <div class="info-row">
            <div class="info-label">Program:</div>
            <div class="info-value"><%= profile.getProgram() %></div>
        </div>

        <div class="info-row">
            <div class="info-label">Email:</div>
            <div class="info-value"><%= profile.getEmail() %></div>
        </div>

        <div class="info-row">
            <div class="info-label">Hobbies:</div>
            <div class="info-value"><%= profile.getHobbies() %></div>
        </div>

        <div class="info-row">
            <div class="info-label">Introduction:</div>
            <div class="info-value"><%= profile.getIntro() %></div>
        </div>

        <form action="viewProfiles.jsp">
            <button type="submit" class="btn">View All Profiles</button>
        </form>
    </div>

</body>
</html>