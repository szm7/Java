<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.Connection, java.sql.DriverManager, java.sql.PreparedStatement, java.sql.Timestamp, java.util.Date"%>

<%
    HttpSession session1 = request.getSession(false);
    Timestamp Ttime = null; 

    if (session1 != null && session1.getAttribute("username") != null) {
        String username = (String) session1.getAttribute("username");
        String isLogged = (String) session1.getAttribute("isLogged");

        if (isLogged != null && isLogged.equals("True")) {
            Date lastLoginTime = (Date) session1.getAttribute("lastLoginTime");
            Ttime = new Timestamp(lastLoginTime.getTime());
        } else {
            Date loginTime = (Date) session1.getAttribute("loginTime");
            Ttime = new Timestamp(loginTime.getTime());
        }

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/Login", "root", "");

            String query = "UPDATE user_sessions SET logout_time = ? WHERE username = ? AND login_time = ? ";

            try (PreparedStatement pst = con.prepareStatement(query)) {
                Timestamp currentTime = new Timestamp(System.currentTimeMillis());

                // Debug print statements
                System.out.println("Username: " + username);
                System.out.println("isLogged: " + isLogged);
                System.out.println("Ttime: " + Ttime);
                System.out.println("Current Time: " + currentTime);

                pst.setTimestamp(1, currentTime);
                pst.setString(2, username);
                pst.setTimestamp(3, Ttime);
                pst.executeUpdate();
            }

            PreparedStatement isLoggedP = con.prepareStatement("UPDATE Log set isLogged='false' where username=?");
            isLoggedP.setString(1, username);
            isLoggedP.executeUpdate();

            con.close();
        } catch (Exception e) {
            // Print the stack trace for debugging
            e.printStackTrace();
        }

        // Invalidate the session
        session1.invalidate();

        // Redirect to the login page
        response.sendRedirect("index.html"); // Change to the appropriate page
    }
%>
