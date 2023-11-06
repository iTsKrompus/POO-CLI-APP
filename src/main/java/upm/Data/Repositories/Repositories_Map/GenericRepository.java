package upm.Data.Repositories.Repositories_Map;

import upm.Data.Repositories.GenericRepositoryInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public abstract class GenericRepository<T> implements GenericRepositoryInterface<T> {
    private final HashMap<Integer, T> map;
    private int id;

    GenericRepository() {
        this.map = new HashMap<>();
        this.id = 1;
    }

    @Override
    public T create(T entity) {
        this.setId(entity, this.id);
        map.put(id, entity);
        this.id++;
        return entity;
    }

    @Override
    public Optional<T> read(Integer id) {
        return Optional.ofNullable(map.get(id));
    }

    @Override
    public T update(T entity) {
        map.put(getId(entity), entity);
        return entity;
    }

    @Override
    public void delete(Integer id) {
        map.remove(id);
    }

    @Override
    public List<T> findAll() {
        return new ArrayList<>(map.values());
    }

    protected abstract void setId(T entity, Integer id);

    protected abstract int getId(T entity);
}
