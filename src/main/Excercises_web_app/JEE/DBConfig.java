package main.Excercises_web_app.JEE;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class DBConfig implements ServletContextListener {

    private static EntityManagerFactory emf;

    public static EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        if (emf != null) {
            emf.close();
        }
    }

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        emf = Persistence.createEntityManagerFactory("NewPersistenceUnit");

    }
}
