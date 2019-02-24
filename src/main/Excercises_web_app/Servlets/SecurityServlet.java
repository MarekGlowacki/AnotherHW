package main.Excercises_web_app.Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.HttpMethodConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/hws", "/hahaha", "/okejok"}, name = "Hello, world")
@ServletSecurity(httpMethodConstraints = {@HttpMethodConstraint(value = "GET", rolesAllowed = {"admin", "moderator"}, transportGuarantee = ServletSecurity.TransportGuarantee.NONE)})
public class SecurityServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain; charset=utf-8");
        response.getWriter().println("Hello, world!");
    }

}
