package repository;

import entity.Cities;
import entity.Countries;
import entity.Cities;
import util.DBAccess;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class CitiesRepository implements CrudRepository<Cities>{
    private EntityManager em = DBAccess.getInstance();
    @Override
    public int count() {
        Query countQuery = em.createNativeQuery("SELECT count(*) FROM cities");
        Object result = countQuery.getSingleResult();
        return ((BigInteger) result).intValue();
    }

    @Override
    public void deleteAll() {
        Query deleteQuery = em.createNativeQuery("DELETE from cities");
        deleteQuery.executeUpdate();
    }

    @Override
    public void deleteById(int id) {
        Query deleteQuery = em.createNativeQuery("DELETE from cities where id = ?1");
        deleteQuery.setParameter(1,id);
        deleteQuery.executeUpdate();
    }

    @Override
    public boolean existsById(int id) {
        Query existsQuery = em.createNativeQuery("select count(*) FROM cities WHERE id = ?1");
        existsQuery.setParameter(1,id);
        Object result = existsQuery.getSingleResult();
        if ( ((BigInteger) result).intValue() == 0){
            return false;
        }
        return true;
    }

    @Override
    public Iterable<Cities> findAll() {
        CountriesRepository cr = new CountriesRepository();

        ArrayList<Cities> resultList = new ArrayList<>();
        Query findQuery = em.createNativeQuery("SELECT * FROM cities");

        List<Object> result = (List<Object>) findQuery.getResultList();
        Iterator itr = result.iterator();
        while(itr.hasNext()){
            Cities city = new Cities();
            Object[] obj = (Object[]) itr.next();
            Integer city_id = Integer.parseInt(String.valueOf(obj[0]));
            String city_name = String.valueOf(obj[1]);
            String city_longitude = String.valueOf(obj[2]);
            String city_latitude = String.valueOf(obj[3]);
            String country_id_value = String.valueOf(obj[4]);

            Integer country_id;
            if(country_id_value.isEmpty() || country_id_value == "null"){
                country_id = -1;
            }
            else{
                country_id = Integer.parseInt(country_id_value);
            }

            Countries country = new Countries();
            Optional<Countries> countryObject = cr.findById(country_id);
            if(countryObject.isPresent()){
                country = countryObject.get();
            }
            else{
                country = null;
            }

            city.setId(city_id);
            city.setName(city_name);
            city.setLongitude(city_longitude);
            city.setLatitude(city_latitude);
            city.setIdCountry(country_id);
            city.setReferencedCountry(country);
            resultList.add(city);
        }
        return resultList;
    }

    @Override
    public Optional<Cities> findById(int id) {
        return Optional.empty();
    }

    @Override
    public void save(Cities o) {
        CountriesRepository cr = new CountriesRepository();
        Countries country = o.getReferencedCountry();
        if(country != null){
            cr.save(country);
        }
        em.persist(o);
    }
}
