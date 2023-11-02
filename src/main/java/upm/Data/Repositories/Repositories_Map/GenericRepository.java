package upm.Data.Repositories.Repositories_Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class GenericRepository<T> {
    private final HashMap<Integer, T> map;
    private int id;

    public GenericRepository() {
        this.map = new HashMap<>();
        this.id = 1;
    }

    public T create(T entity) {
        this.setId(entity, this.id);
        map.put(id, entity);
        this.id++;
        return entity;
    }

    public T read(Integer id) {
        return map.get(id);
    }

    protected T update(T entity) {
        map.put(getId(entity), entity);
        return entity;
    }


    public void delete(Integer id) {
        map.remove(id);

    }

    public List<T> findAll() {
        return new ArrayList<>(map.values());
    }

    protected abstract void setId(T entity, Integer id);

    protected abstract int getId(T entity);
}

