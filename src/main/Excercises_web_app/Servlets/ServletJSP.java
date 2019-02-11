package main.Excercises_web_app.Servlets;

import main.Excercises_web_app.JEE.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

@WebServlet(value = "/sjsp")
public class ServletJSP extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User u = new User();
        u.setId(1);
        u.setName("Marek");
        u.setSurname("Marecky");
        request.setAttribute("user", u);
        User drugi = new User();
        drugi.setId(2);
        drugi.setName("Zenon");
        drugi.setSurname("Zenonowy");
        request.setAttribute("lista", Arrays.asList(u, drugi));
        request.setAttribute("kwota", 50.5);
        request.setAttribute("data", new Date());
        RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
        rd.forward(request,response);
    }

}
