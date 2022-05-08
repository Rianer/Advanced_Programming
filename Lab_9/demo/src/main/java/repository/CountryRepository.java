package repository;

import entities.Countries;
import util.DataBaseEM;

import javax.persistence.EntityManager;
import java.util.Optional;

public class CountryRepository implements CrudRepository{
    @Override
    public void delete(Object Entity) {

    }

    @Override
    public Optional<Object> findById(int id) {
        EntityManager em = DataBaseEM.getInstance();
        Countries countries = em.find(Countries.class, id);
        return Optional.of(countries);
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public boolean existsById(int id) {
        return false;
    }

    @Override
    public void save(Object entity) {
        EntityManager em = DataBaseEM.getInstance();
        em.persist(entity);
    }

    @Override
    public void saveAll(Iterable<Object> entities) {

    }
}
