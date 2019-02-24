package main.Excercises_web_app.Servlets;

import main.Excercises_web_app.JEE.User;
import main.Excercises_web_app.JEE.UsersDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/daos")
public class DAOServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
        response.setContentType("text/plain; charset=utf-8");
        UsersDAO dao = new UsersDAO();
        List<User> list = dao.getAll();
        for (User u : list){
            response.getWriter().println(u.getName() + " " + u.getSurname());
        }

    }
}
