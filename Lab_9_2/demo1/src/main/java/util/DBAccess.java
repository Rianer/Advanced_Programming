package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBAccess {
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    private static EntityManager entityManager = entityManagerFactory.createEntityManager();

    public static EntityManager getInstance(){
        return entityManager;
    }

    public static void closeConnection(){
        entityManager.close();
        entityManagerFactory.close();
    }
}
