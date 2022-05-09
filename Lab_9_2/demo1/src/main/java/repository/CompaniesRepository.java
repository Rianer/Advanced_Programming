package repository;

import entities.Companies;
import util.DBAccess;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class CompaniesRepository implements CrudRepository<Companies>{

    private EntityManager em = DBAccess.getInstance();
    @Override
    public int count() {
        Query countQuery = em.createNativeQuery("SELECT count(*) FROM companies");
        Object result = countQuery.getSingleResult();
        return ((BigInteger) result).intValue();
    }

    @Override
    public void deleteAll() {
        Query deleteQuery = em.createNativeQuery("DELETE from companies ");
        deleteQuery.executeUpdate();
    }

    @Override
    public void deleteById(int id) {
        Query deleteQuery = em.createNativeQuery("DELETE from companies where id = ?1");
        deleteQuery.setParameter(1,id);
        deleteQuery.executeUpdate();
    }

    @Override
    public boolean existsById(int id) {
        Query existsQuery = em.createNativeQuery("select count(*) FROM companies WHERE id = ?1");
        existsQuery.setParameter(1,id);
        Object result = existsQuery.getSingleResult();
        if ( ((BigInteger) result).intValue() == 0){
            return false;
        }
        return true;
    }

    @Override
    public Iterable<Companies> findAll() {
        ArrayList<Companies> resultList = new ArrayList<>();
        Query findQuerry = em.createNativeQuery("SELECT * FROM companies");

        List<Object> result = (List<Object>) findQuerry.getResultList();
        Iterator itr = result.iterator();
        while(itr.hasNext()){
            Companies company = new Companies();
            Object[] obj = (Object[]) itr.next();
            Integer company_id = Integer.parseInt(String.valueOf(obj[0]));
            String company_name = String.valueOf(obj[1]);
            company.setName(company_name);
            company.setId(company_id);
            resultList.add(company);
        }
        return resultList;
    }

    @Override
    public Optional<Companies> findById(int id) {
        Query findQuery = em.createNativeQuery("SELECT * FROM companies WHERE id=?1");
        findQuery.setParameter(1, id);

        List<Object> result = (List<Object>) findQuery.getResultList();
        Iterator itr = result.iterator();
        Companies company = new Companies();
        while(itr.hasNext()){
            Object[] obj = (Object[]) itr.next();
            Integer company_id = Integer.parseInt(String.valueOf(obj[0]));
            String company_name = String.valueOf(obj[1]);
            company.setName(company_name);
            company.setId(company_id);
        }
        return Optional.of(company);
    }

    @Override
    public void save(Companies o) {
        em.persist(o);
    }

    public ArrayList<Companies> findByName(String name){
        ArrayList<Companies> resultList = new ArrayList<>();
        Query findQuerry = em.createNativeQuery("SELECT * FROM companies WHERE name = ?1");
        findQuerry.setParameter(1, name);

        List<Object> result = (List<Object>) findQuerry.getResultList();
        Iterator itr = result.iterator();
        while(itr.hasNext()){
            Companies company = new Companies();
            Object[] obj = (Object[]) itr.next();
            Integer company_id = Integer.parseInt(String.valueOf(obj[0]));
            String company_name = String.valueOf(obj[1]);
            company.setName(company_name);
            company.setId(company_id);
            resultList.add(company);
        }
        return resultList;
    }
}
