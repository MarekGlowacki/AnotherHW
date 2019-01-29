package main.Excercises_web_app.Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(value = "/sqlu")
public class MySQLServletUpdate extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain; charset=utf-8");

        try {
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/AppJEE?useSSL=false&characterEncoding=utf8&useJDBCCompianttimezoneShift=true&useLegacyDatetimecode=false&serverTimezone=UTC", "root", "coderslab");

            PreparedStatement pstmt = connection.prepareStatement("INSERT INTO user VALUES (null, ?, ?, ?)");
            pstmt.setString(1, "Marko");
            pstmt.setString(2, "Marksowy");
            pstmt.setString(3, "Mar");

            if (pstmt.executeUpdate() > 0) {
                response.getWriter().println("Record added");
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}