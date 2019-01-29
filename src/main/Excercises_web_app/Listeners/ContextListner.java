package main.Excercises_web_app.Listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Date;

public class ContextListner implements ServletContextListener {

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        System.out.println("Koniec aplikacji" + new Date());
    }

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        System.out.println("Start aplikacji" + new Date());
    }
}
