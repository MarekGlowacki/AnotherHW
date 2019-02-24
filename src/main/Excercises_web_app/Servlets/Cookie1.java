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
                if (c.getName().equals("name")){
                    pw.println("Hello, " + c.getValue());
                    return;
                }
            }
        }
        pw.println("<html><head><title>Title</title></head>");
        pw.println("<body>");
        pw.println("<p>First row</p>");
        pw.println("<p>Second Row</p>");
        pw.println("<form method=\"post\">");
        pw.println("<p>Write your name:</p><input name=\"name\" /><input type=\"submit\" value=\"OK\" />");
        pw.println("</form>");
        pw.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html; charset=utf-8");
        PrintWriter pw = response.getWriter();

        String name = request.getParameter("name");
        if (name != null && !"".equals(name)){
            javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie("name", name);
            cookie.setMaxAge(3600);
            response.addCookie(cookie);
            pw.println("Hello, " + name);
        }
    }

}
