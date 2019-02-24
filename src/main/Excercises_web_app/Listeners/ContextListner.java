package main.Excercises_web_app.Listeners;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebListener;
import java.util.Date;

@WebListener
public class ContextListner implements ServletContextListener {

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        System.out.println("Koniec aplikacji" + new Date());
    }

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        System.out.println("Application start" + new Date());
        ServletRegistration.Dynamic servlet = arg0.getServletContext().addServlet("List", "main.Excercises_web_app.Servlets.UsersListServlet");
        servlet.addMapping("/list");
    }
}
