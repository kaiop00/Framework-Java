package framework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryRepository<T> implements CrudRepository<T> {
    private Map<Integer, T> storage = new HashMap<>();
    private int currentId = 1;

    @Override
    public void save(T entity) {
        storage.put(currentId++, entity);
    }

    @Override
    public T findById(int id) {
        return storage.get(id);
    }

    @Override
    public void update(T entity) {
        // Para simplificar, vamos assumir que o ID é conhecido e que o objeto é atualizado
        // Aqui você pode implementar lógica para atualizar o objeto baseado em algum identificador
    }

    @Override
    public void delete(int id) {
        storage.remove(id);
    }

    @Override
    public List<T> findAll() {
        return new ArrayList<>(storage.values());
    }
}