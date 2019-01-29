package main.Excercises_web_app.Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/session1")
public class Session1 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        PrintWriter pw = response.getWriter();
        HttpSession sesja = request.getSession();
        sesja.setMaxInactiveInterval(10);
        Integer licznik = (Integer) sesja.getAttribute("licznik");
        if (licznik == null) {
            licznik = 1;
        } else {
            licznik++;
        }
        sesja.setAttribute("licznik", licznik);
        pw.println("Licznik: " + licznik);
    }

}
