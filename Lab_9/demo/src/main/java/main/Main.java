package main;

import entity.Cities;
import entity.Continents;
import entity.Countries;
import repository.CitiesRepository;
import repository.ContinentsRepository;
import repository.CountriesRepository;
import util.DBAccess;
import util.DataFiller;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManager em = DBAccess.getInstance();
        EntityTransaction transaction = em.getTransaction();

        try{
            transaction.begin();

            ContinentsRepository cr = new ContinentsRepository();
            CountriesRepository cntrR = new CountriesRepository();
            CitiesRepository cityR = new CitiesRepository();

            /*Continents continents = new Continents();
            continents.setName("Asia");

            Countries country = new Countries();
            country.setName("China");
            country.setCode("CH");
            country.setReferencedContinent(continents);

            Cities city = new Cities();
            city.setName("Beijing");
            city.setLatitude("116.3975");
            city.setLongitude("39.906667");
            city.setReferencedCountry(country);*/


            DataFiller df = new DataFiller(5000);
            df.fillData();
            System.out.println("Total cities: " + cityR.count());

            transaction.commit();
        }finally {
            if(transaction.isActive()){
                transaction.rollback();
            }
            DBAccess.closeConnection();
        }


    }
}
