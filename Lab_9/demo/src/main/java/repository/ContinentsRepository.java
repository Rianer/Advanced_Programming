package repository;

import entity.Continents;
import util.DBAccess;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class ContinentsRepository implements CrudRepository<Continents>{
    private EntityManager em = DBAccess.getInstance();
    @Override
    public int count() {
        Query countQuery = em.createNativeQuery("SELECT count(*) FROM continents");
        Object result = countQuery.getSingleResult();
        return ((BigInteger) result).intValue();
    }

    @Override
    public void deleteAll() {
        Query deleteQuery = em.createNativeQuery("DELETE from continents");
        deleteQuery.executeUpdate();
        deleteQuery = em.createNativeQuery("DELETE from countries");
        deleteQuery.executeUpdate();
        deleteQuery = em.createNativeQuery("DELETE from cities");
        deleteQuery.executeUpdate();
    }

    @Override
    public void deleteById(int id) {
        Query deleteQuery = em.createNativeQuery("DELETE from continents where id = ?1");
        deleteQuery.setParameter(1,id);
        deleteQuery.executeUpdate();
    }

    @Override
    public boolean existsById(int id) {
        Query existsQuery = em.createNativeQuery("select count(*) FROM continents WHERE id = ?1");
        existsQuery.setParameter(1,id);
        Object result = existsQuery.getSingleResult();
        if ( ((BigInteger) result).intValue() == 0){
            return false;
        }
        return true;
    }

    @Override
    public Iterable<Continents> findAll() {
        ArrayList<Continents> resultList = new ArrayList<>();
        Query findQuery = em.createNativeQuery("SELECT * FROM continents");

        List<Object> result = (List<Object>) findQuery.getResultList();
        Iterator itr = result.iterator();
        while(itr.hasNext()){
            Continents continent = new Continents();
            Object[] obj = (Object[]) itr.next();
            Integer continent_id = Integer.parseInt(String.valueOf(obj[0]));
            String continent_name = String.valueOf(obj[1]);
            continent.setId(continent_id);
            continent.setName(continent_name);
            resultList.add(continent);
        }
        return resultList;
    }

    @Override
    public Optional<Continents> findById(int id) {
        Query findQuery = em.createNativeQuery("SELECT * FROM continents WHERE id = ?1");
        findQuery.setParameter(1, id);

        List<Object> result = (List<Object>) findQuery.getResultList();
        Iterator itr = result.iterator();
        Continents continent = new Continents();
        while(itr.hasNext()){
            Object[] obj = (Object[]) itr.next();
            Integer continent_id = Integer.parseInt(String.valueOf(obj[0]));
            String continent_name = String.valueOf(obj[1]);
            continent.setId(continent_id);
            continent.setName(continent_name);
        }
        return Optional.of(continent);
    }

    @Override
    public void save(Continents o) {
        em.persist(o);
    }
}
