package util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DataBaseEM {
    static private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");

    public static EntityManagerFactory getInstance(){
        return  entityManagerFactory;
    }
}
