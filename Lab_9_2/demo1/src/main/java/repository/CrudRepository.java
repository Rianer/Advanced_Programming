package repository;

import java.util.Optional;

public interface CrudRepository {
    int count();

    void deleteAll();

    void deleteById(int id);

    boolean existsById(int id);

    Iterable<Object> findAll();

    Optional<Object> findById(int id);

    void save(Object o);

}
