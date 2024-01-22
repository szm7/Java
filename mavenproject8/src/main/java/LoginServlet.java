/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author saninzulphi
 */
@WebServlet(urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/Login", "root", "");

            // Use a prepared statement for the SELECT query
            PreparedStatement pst = con.prepareStatement("SELECT * FROM Log WHERE username=? AND password=? ");
            pst.setString(1, username);
            pst.setString(2, password);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                String isLogged = rs.getString("isLogged");
                String imgUrl = rs.getString("imgUrl");
                HttpSession session = request.getSession();
                session.setAttribute("isLogged", isLogged);
                session.setAttribute("username", username);
                session.setAttribute("loginTime", new Date());
                System.out.println("Current Time: " + imgUrl);
                session.setAttribute("pP", imgUrl); 

                // Use equals() for string comparison
                if ("false".equals(isLogged)) {

                    // Update isLogged to true
                    PreparedStatement isLoggedP = con.prepareStatement("UPDATE Log SET isLogged='True' WHERE username=?");
                    isLoggedP.setString(1, username);
                    isLoggedP.executeUpdate();

                    // Insert login record
                    insertLoginRecord(con, username);

                    response.sendRedirect("welcome.jsp");
                } else {
                    PreparedStatement sessionTime = con.prepareStatement("SELECT * FROM user_sessions WHERE username=? ORDER BY login_time DESC LIMIT 1");
                    sessionTime.setString(1, username);

                    ResultSet resultSet = sessionTime.executeQuery();

                    if (resultSet.next()) {

                        Timestamp lastLoginTime = resultSet.getTimestamp("login_time");

                        session.setAttribute("lastLoginTime", lastLoginTime);
                        response.sendRedirect("session.jsp");
                    }

// Redirect to the session.jsp page
                }
            } else {
                // Login failed
                PrintWriter out = response.getWriter();
                out.println("Invalid username or password");
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
//        response.setContentType("text/html;charset=UTF-8");
//        response.setContentType("text/html;charset=UTF-8");
//
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        String isLogged = request.getParameter("isLogged");
//
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/Login", "root", "");
//
//            PreparedStatement pst = con.prepareStatement("SELECT * FROM Log WHERE username=? AND password=?");
//            pst.setString(1, username);
//            pst.setString(2, password);
//            pst.setString(3, isLogged);
//
//            ResultSet rs = pst.executeQuery();
//
//            if (rs.next()) {
//                HttpSession session = request.getSession();
//                session.setAttribute("username", username);
//                session.setAttribute("loginTime", new Date());
//                session.setAttribute("isLogged", isLogged);
//                if (isLogged == "false") {
//                    pst = con.prepareStatement("UPDATE stu set isLogged='True' where username=?");
//                    pst.setString(1, username);
//                    pst.executeUpdate();
//                    insertLoginRecord(con, username);
//                    response.sendRedirect("welcome.jsp");
//                } else {
//                    PrintWriter out = response.getWriter();
//                    out.println("User Already Have Logged Session");
//                }
//            } else {
//                // Login failed
//                PrintWriter out = response.getWriter();
//                out.println("Invalid username or password");
//            }
//
//            con.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    private void insertLoginRecord(Connection con, String username) throws Exception {
        String query = "INSERT INTO user_sessions (username, login_time) VALUES (?, ?)";
        try (PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, username);
            pst.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
            pst.executeUpdate();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     *
     *
     * /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
