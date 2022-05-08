import entities.CitiesEntity;
import util.DataBaseEM;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main (String[] argv){
        EntityManagerFactory entityManagerFactory = DataBaseEM.getInstance();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        //EntityTransaction transaction = entityManager.getTransaction();
        CitiesEntity city = entityManager.find(CitiesEntity.class, 3);
        System.out.println(city);
    }
}
