package main.Excercises_web_app.Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/cookie1")
public class Cookie1 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        PrintWriter pw = response.getWriter();
        if (request.getCookies() != null) {
            for (int i = 0; i < request.getCookies().length; i++){
                javax.servlet.http.Cookie c = request.getCookies()[i];
                if (c.getName().equals("imie")){
                    pw.println("Witaj, " + c.getValue());
                    return;
                }
            }
        }
        pw.println("<html><head><title>Tytuł</title></head>");
        pw.println("<body>");
        pw.println("<p>Siema śięma</p>");
        pw.println("<p>Drugi wiersz</p>");
        pw.println("<form method=\"post\">");
        pw.println("<p>Podaj imię:</p><input name=\"imie\" /><input type=\"submit\" value=\"OK\" />");
        pw.println("</form>");
        pw.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html; charset=utf-8");
        PrintWriter pw = response.getWriter();

        String imie = request.getParameter("imie");
        if (imie != null && !"".equals(imie)){
            javax.servlet.http.Cookie ciastko = new javax.servlet.http.Cookie("imie", imie);
            ciastko.setMaxAge(3600);
            response.addCookie(ciastko);
            pw.println("Witaj, " + imie);
        }
    }

}
