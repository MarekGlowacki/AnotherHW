package main.Excercises_web_app.JEE;

import javax.persistence.EntityManager;
import java.util.List;

public class UsersDAO {

    private EntityManager em;
    public UsersDAO() {
        this.em = DBConfig.getEntityManagerFactory().createEntityManager();
    }


    public List<User> getAll(){
        List<User> list = em.createQuery("select u from User u").getResultList();
        return list;
    }
}
