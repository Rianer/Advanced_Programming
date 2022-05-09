package repository;

import entity.Continents;
import entity.Countries;
import util.DBAccess;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class CountriesRepository implements CrudRepository<Countries>{
    private EntityManager em = DBAccess.getInstance();
    @Override
    public int count() {
        Query countQuery = em.createNativeQuery("SELECT count(*) FROM countries");
        Object result = countQuery.getSingleResult();
        return ((BigInteger) result).intValue();
    }

    @Override
    public void deleteAll() {
        Query deleteQuery = em.createNativeQuery("DELETE from countries");
        deleteQuery.executeUpdate();
        deleteQuery = em.createNativeQuery("DELETE from cities");
        deleteQuery.executeUpdate();
    }

    @Override
    public void deleteById(int id) {
        Query deleteQuery = em.createNativeQuery("DELETE from countries where id = ?1");
        deleteQuery.setParameter(1,id);
        deleteQuery.executeUpdate();
    }

    @Override
    public boolean existsById(int id) {
        Query existsQuery = em.createNativeQuery("select count(*) FROM countries WHERE id = ?1");
        existsQuery.setParameter(1,id);
        Object result = existsQuery.getSingleResult();
        if ( ((BigInteger) result).intValue() == 0){
            return false;
        }
        return true;
    }

    @Override
    public Iterable<Countries> findAll() {

        ContinentsRepository cr = new ContinentsRepository();

        ArrayList<Countries> resultList = new ArrayList<>();
        Query findQuery = em.createNativeQuery("SELECT * FROM countries");

        List<Object> result = (List<Object>) findQuery.getResultList();
        Iterator itr = result.iterator();
        while(itr.hasNext()){
            Countries country = new Countries();
            Object[] obj = (Object[]) itr.next();
            Integer country_id = Integer.parseInt(String.valueOf(obj[0]));
            String country_name = String.valueOf(obj[1]);
            String country_code = String.valueOf(obj[2]);

            String continent_id_value = String.valueOf(obj[3]);
            Integer continent_id;
            if(continent_id_value.isEmpty() || continent_id_value == "null"){
                continent_id = -1;
            }
            else{
                continent_id = Integer.parseInt(continent_id_value);
            }

            Continents continent = new Continents();
            Optional<Continents> continentObject = cr.findById(continent_id);
            if(continentObject.isPresent()){
                continent = continentObject.get();
            }
            else{
                continent = null;
            }

            country.setId(country_id);
            country.setName(country_name);
            country.setCode(country_code);
            country.setIdContinent(continent_id);
            country.setReferencedContinent(continent);
            resultList.add(country);
        }
        return resultList;
    }

    @Override
    public Optional<Countries> findById(int id) {

        ContinentsRepository cr = new ContinentsRepository();

        Query findQuery = em.createNativeQuery("SELECT * FROM countries WHERE id = ?1");
        findQuery.setParameter(1, id);

        List<Object> result = (List<Object>) findQuery.getResultList();
        Iterator itr = result.iterator();
        Countries country = new Countries();
        while(itr.hasNext()){
            Object[] obj = (Object[]) itr.next();
            Integer country_id = Integer.parseInt(String.valueOf(obj[0]));
            String country_name = String.valueOf(obj[1]);
            String country_code = String.valueOf(obj[2]);

            String continent_id_value = String.valueOf(obj[3]);
            Integer continent_id;
            if(continent_id_value.isEmpty() || continent_id_value == "null"){
                continent_id = -1;
            }
            else{
                continent_id = Integer.parseInt(continent_id_value);
            }

            Continents continent = new Continents();
            Optional<Continents> continentObject = cr.findById(continent_id);
            if(continentObject.isPresent()){
                continent = continentObject.get();
            }
            else{
                continent = null;
            }

            country.setId(country_id);
            country.setName(country_name);
            country.setCode(country_code);
            country.setIdContinent(continent_id);
            country.setReferencedContinent(continent);
        }
        return Optional.of(country);
    }

    @Override
    public void save(Countries o) {
        ContinentsRepository cr = new ContinentsRepository();
        Continents continent = o.getReferencedContinent();
        if(continent != null){
            cr.save(continent);
        }
        em.persist(o);
    }

    public Iterable<Countries> findByname(String name) {

        ContinentsRepository cr = new ContinentsRepository();

        ArrayList<Countries> resultList = new ArrayList<>();
        Query findQuery = em.createNativeQuery("SELECT * FROM countries WHERE name = ?1");
        findQuery.setParameter(1, name);

        List<Object> result = (List<Object>) findQuery.getResultList();
        Iterator itr = result.iterator();
        while(itr.hasNext()){
            Countries country = new Countries();
            Object[] obj = (Object[]) itr.next();
            Integer country_id = Integer.parseInt(String.valueOf(obj[0]));
            String country_name = String.valueOf(obj[1]);
            String country_code = String.valueOf(obj[2]);

            String continent_id_value = String.valueOf(obj[3]);
            Integer continent_id;
            if(continent_id_value.isEmpty() || continent_id_value == "null"){
                continent_id = -1;
            }
            else{
                continent_id = Integer.parseInt(continent_id_value);
            }

            Continents continent = new Continents();
            Optional<Continents> continentObject = cr.findById(continent_id);
            if(continentObject.isPresent()){
                continent = continentObject.get();
            }
            else{
                continent = null;
            }

            country.setId(country_id);
            country.setName(country_name);
            country.setCode(country_code);
            country.setIdContinent(continent_id);
            country.setReferencedContinent(continent);
            resultList.add(country);
        }
        return resultList;
    }

    public boolean existsByName(String name) {
        Query existsQuery = em.createNativeQuery("select count(*) FROM countries WHERE name = ?1");
        existsQuery.setParameter(1,name);
        Object result = existsQuery.getSingleResult();
        if ( ((BigInteger) result).intValue() == 0){
            return false;
        }
        return true;
    }
}
