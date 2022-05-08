package main;

import entities.Clients;
import entities.Companies;
import entities.Products;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            Clients client = new Clients();
            client.setName("John");

            Companies company = new Companies();
            company.setName("BMW");

            Products product = new Products();
            product.setClientsByIdClient(client);
            product.setCompaniesByIdCompany(company);
            product.setQuantity(4);
            product.setName("3 Series");

            entityManager.persist(company);
            entityManager.persist(client);
            entityManager.persist(product);

            System.out.println(entityManager.find(Clients.class, 3));
            System.out.println(entityManager.find(Products.class, 3));

            transaction.commit();
        } finally {
            if(transaction.isActive()){
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
