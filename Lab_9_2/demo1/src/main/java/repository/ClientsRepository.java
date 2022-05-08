package repository;

import java.util.Optional;

public class ClientsRepository implements CrudRepository{
    @Override
    public int count() {
        return 0;
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
    public Iterable<Object> findAll() {
        return null;
    }

    @Override
    public Optional<Object> findById(int id) {
        return Optional.empty();
    }

    @Override
    public void save(Object o) {

    }
}
