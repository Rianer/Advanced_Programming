package repository;

import entities.Clients;
import util.DBAccess;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Optional;

public class ClientsRepository implements CrudRepository{
    private EntityManager em = DBAccess.getInstance();
    @Override
    public int count() {

        Query countQuery = em.createNativeQuery("SELECT count(*) FROM clients");
        Object result = countQuery.getSingleResult();
        return ((BigInteger) result).intValue();
    }

    @Override
    public void deleteAll() {
        Query deleteQuery = em.createQuery("DELETE from Clients ");
        deleteQuery.executeUpdate();
    }

    @Override
    public void deleteById(int id) {
        Query deleteQuery = em.createQuery("DELETE from Clients where id = ?1");
        deleteQuery.setParameter(1,id);
        deleteQuery.executeUpdate();
    }

    @Override
    public boolean existsById(int id) {
        Query existsQuery = em.createNativeQuery("select count(*) FROM clients WHERE id = ?1");
        existsQuery.setParameter(1,id);
        Object result = existsQuery.getSingleResult();
        if ( ((BigInteger) result).intValue() == 0){
            return false;
        }
        return true;
    }

    @Override
    public Iterable<Object> findAll() {
        ArrayList<Object> resultList = new ArrayList<>();
        Query findQuerry = em.createNativeQuery("SELECT * FROM clients");
        for(Object iterator : findQuerry.getResultList()){
            resultList.add(iterator);
        }
        return resultList;
    }

    @Override
    public Optional<Object> findById(int id) {
        return Optional.empty();
    }

    @Override
    public void save(Object o) {

    }
}
