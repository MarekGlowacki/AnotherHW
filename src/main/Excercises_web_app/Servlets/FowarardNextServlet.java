package main.Excercises_web_app.Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/fns")
public class FowarardNextServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain; charset=utf-8");
        response.getWriter().println("Helloł");
//        RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
//        rd.forward(request, response);
        response.sendRedirect("/AnotherHW_war_exploded/index.jsp");
    }

}
