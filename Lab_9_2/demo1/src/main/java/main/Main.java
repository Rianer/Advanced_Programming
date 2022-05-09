package main;

import entities.Clients;
import entities.Companies;
import entities.Products;
import repository.ClientsRepository;
import repository.CompaniesRepository;
import repository.CrudRepository;
import repository.ProductsRepository;
import util.DBAccess;
import util.DataFiller;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        EntityManager entityManager = DBAccess.getInstance();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            ProductsRepository pr = new ProductsRepository();
            ClientsRepository clientsRepository = new ClientsRepository();
            CompaniesRepository companiesRepository = new CompaniesRepository();
            
            DataFiller df = new DataFiller(5000);
            df.fillData();
            transaction.commit();
        } finally {
            if(transaction.isActive()){
                transaction.rollback();
            }
            DBAccess.closeConnection();
        }
    }
}
