package repository;


import javax.swing.text.html.Option;
import java.util.Optional;

public interface CrudRepository{

    /*void delete(T Entity);

    void deleteAll();

    void deleteById(ID id);

    boolean existsById(ID id);

    Iterable<T> findAll();

    Optional<T> findById(ID id);

    <S extends T> void save(S entity);

    <S extends T> void saveAll(Iterable<S> entities);*/

    void delete(Object Entity);

    void deleteAll();

    void deleteById(int id);

    boolean existsById(int id);
    Optional<Object> findById(int id);

    void save(Object entity);

    void saveAll(Iterable<Object> entities);

}
