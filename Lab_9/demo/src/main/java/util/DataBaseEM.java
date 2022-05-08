package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DataBaseEM {
    static private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    static private EntityManager em = entityManagerFactory.createEntityManager();

    public static EntityManager getInstance(){
        return  em;
    }
}
