package repository;

import entities.Clients;
import util.DBAccess;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class ClientsRepository implements CrudRepository<Clients>{
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
    public Iterable<Clients> findAll() {
        ArrayList<Clients> resultList = new ArrayList<>();
        Query findQuerry = em.createNativeQuery("SELECT * FROM clients");

        List<Object> result = (List<Object>) findQuerry.getResultList();
        Iterator itr = result.iterator();
        while(itr.hasNext()){
            Clients client = new Clients();
            Object[] obj = (Object[]) itr.next();
            Integer client_id = Integer.parseInt(String.valueOf(obj[0]));
            String client_name = String.valueOf(obj[1]);
            client.setName(client_name);
            client.setId(client_id);
            resultList.add(client);
        }
        return resultList;
    }

    @Override
    public Optional<Clients> findById(int id) {
        Query findQuery = em.createNativeQuery("SELECT * FROM clients WHERE id = ?1");
        findQuery.setParameter(1, id);

        Clients client = new Clients();
        List<Object> result = (List<Object>) findQuery.getResultList();
        Iterator itr = result.iterator();
        while(itr.hasNext()){
            Object[] obj = (Object[]) itr.next();
            Integer client_id = Integer.parseInt(String.valueOf(obj[0]));
            String client_name = String.valueOf(obj[1]);
            client.setName(client_name);
            client.setId(client_id);
        }
        return Optional.of(client);
    }

    @Override
    public void save(Clients o) {
        em.persist(o);
    }

    public ArrayList<Clients> findByName(String name){
        ArrayList<Clients> resultList = new ArrayList<>();
        Query findQuerry = em.createNativeQuery("SELECT * FROM clients WHERE name=?1");
        findQuerry.setParameter(1, name);

        List<Object> querryResultList = (List<Object>) findQuerry.getResultList();
        Iterator itr = querryResultList.iterator();
        while(itr.hasNext()){
            Clients client = new Clients();
            Object[] obj = (Object[]) itr.next();
            Integer client_id = Integer.parseInt(String.valueOf(obj[0]));
            String client_name = String.valueOf(obj[1]);
            client.setName(client_name);
            client.setId(client_id);
            resultList.add(client);
        }
        return resultList;
    }
}
