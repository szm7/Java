<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Date, java.text.SimpleDateFormat" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Welcome Page</title>
    </head>
    <body>
        <%
            HttpSession session1 = request.getSession(false);

       
            if (session1 != null && session1.getAttribute("username") != null && session1.getAttribute("lastLoginTime") != null) {
                String username = (String) session1.getAttribute("username");

                
        Date lastLoginTime = (Date) session.getAttribute("lastLoginTime");

              
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String formattedLastLoginTime = dateFormat.format(lastLoginTime);

       
        %>
        <h2>User Already Logged In</h2>
        <p>Last Login Time: <%= formattedLastLoginTime %></p>
        <!-- Add your content for the welcome page here -->
        <a href="logout.jsp">Logout From Previous Session</a>
        <%
            } else {
                // Redirect to login page if the user is not logged in
                response.sendRedirect("index.html"); // Change to the appropriate page
            }
        %>
    </body>
</html>
