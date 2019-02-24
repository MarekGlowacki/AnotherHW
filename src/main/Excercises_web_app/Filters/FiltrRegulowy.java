package main.Excercises_web_app.Filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;


@WebFilter(value = "/hws")
public class FiltrRegulowy implements Filter {

    @Override
    public void destroy(){

    }

    @Override
    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2) throws IOException, ServletException {
        String imie = arg0.getParameter("imie");
        if (imie != null && imie.equals("marek")) {
            arg2.doFilter(arg0, arg1);
        }
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {

    }

}
