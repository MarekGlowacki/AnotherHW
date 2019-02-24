package main.Excercises_web_app.Servlets;

import main.Excercises_web_app.JEE.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/jpts")
public class JPATransactionsServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/plain; charset=utf-8");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("NewPersistenceUnit");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        try {
            et.begin();
            User u = new User();
            u.setName("Kriss");
            u.setSurname("Kristofer");
            u.setCompany("hah");
            em.persist(u);
            et.commit();
            response.getWriter().println("Dodano użytkownika, ha ha!");
        } catch (Exception e) {

            if (et.isActive()) {
                et.rollback();
            }
        }

        em.close();
        emf.close();
    }

}
