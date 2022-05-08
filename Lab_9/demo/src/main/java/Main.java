import entities.Continents;
import entities.Countries;
import repository.CountryRepository;
import util.DataBaseEM;

import javax.persistence.EntityManager;

public class Main {
    public static void main (String[] argv){
        EntityManager entityManager = DataBaseEM.getInstance();
        //EntityTransaction transaction = entityManager.getTransaction();
        /*CitiesEntity city = entityManager.find(CitiesEntity.class, 3);
        System.out.println(city);*/
        CountryRepository cr = new CountryRepository();
        System.out.println(cr.findById(5));
        //Countries countries = new Countries(300, "China", "Asia", "Code");
        //cr.save(countries);
        /*Continents continent = new Continents();
        continent.setId(8);
        continent.setName("Pangaea");
        DataBaseEM.getInstance().persist(continent);*/

    }
}
