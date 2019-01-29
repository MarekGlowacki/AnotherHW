package main.Excercises_web_app.Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(value = "/sqls")
public class MySqlServletSelect extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain; charset=utf-8");

        try {
            Driver ster = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(ster);
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/AppJEE?useSSL=false&characterEncoding=utf8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    "root", "coderslab");

            Statement stmt = connection.createStatement();
            if (stmt.execute("SELECT * from uzytkownik")) {
                ResultSet zbiorWynikow = stmt.getResultSet();
                while (zbiorWynikow.next()) {
                    response.getWriter().println(zbiorWynikow.getString("imie") + " " + zbiorWynikow.getString("nazwisko") + "\n");
                }
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
