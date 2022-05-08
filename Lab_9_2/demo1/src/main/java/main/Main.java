package main;

import entities.Clients;
import entities.Companies;
import entities.Products;
import repository.ClientsRepository;
import util.DBAccess;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManager entityManager = DBAccess.getInstance();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            Clients client = new Clients();
            client.setName("John");

            Companies company = new Companies();
            company.setName("BMW");

            Products product = new Products();
            product.setReferencedClient(client);
            product.setReferencedCompany(company);
            product.setQuantity(4);
            product.setName("3 Series");

            /*entityManager.persist(company);
            entityManager.persist(client);
            entityManager.persist(product);*/

            System.out.println(entityManager.find(Clients.class, 3));
            System.out.println(entityManager.find(Products.class, 3));
            entityManager.persist(client);
            ClientsRepository cr = new ClientsRepository();
            System.out.println(cr.existsById(13));
            Iterable<Object> list = new ArrayList<>();
            list = cr.findAll();
            for(Object o : list){
                System.out.println(o);
            }
            transaction.commit();
        } finally {
            if(transaction.isActive()){
                transaction.rollback();
            }
            DBAccess.closeConnection();
        }
    }
}
