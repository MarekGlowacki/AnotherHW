package main.Excercises_web_app.Servlets;

import main.Excercises_web_app.JEE.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/jpas")
public class JPAServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain; charset=utf-8");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AnotherHW");
        EntityManager em = emf.createEntityManager();
        User u = em.find(User.class, 1);
        response.getWriter().println((u.getImie() + " " + u.getNazwisko()));
        em.close();
        emf.close();
    }

}
