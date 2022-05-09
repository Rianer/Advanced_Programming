package repository;

import java.util.Optional;

public interface CrudRepository<T> {
    int count();

    void deleteAll();

    void deleteById(int id);

    boolean existsById(int id);

    Iterable<T> findAll();

    Optional<T> findById(int id);

    void save(T o);

}
