package upm.Data.Repositories;

import java.util.List;
import java.util.Optional;

public interface GenericRepositoryInterface<T> {
    T create(T entity);


    T update(T entity);

    Optional<T> read(Integer id);

    List<T> findAll();

    void delete(Integer id);
}
