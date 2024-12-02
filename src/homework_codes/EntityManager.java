package src.homework_codes;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class EntityManager <T> {
    private List<T> entities;

    public EntityManager() {
        this.entities = new ArrayList<>();
    }

    public void addEntity(T entity) {
        entities.add(entity);
    }

    // Method to find an entity based on a criterion
    public T getEntityById(String id, Predicate<T> predicate) {
        for (T entity : entities) {
            if (predicate.test(entity)) {
                return entity;
            }
        }
        return null; // Gibt null zurück, falls kein Entity mit der ID gefunden wird
    }

    public List<T> getAllEntities() {
        return entities;
    }

    public List<T> filterEntities(Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T entity : entities) {
            if (predicate.test(entity)) {
                result.add(entity);
            }
        }
        return result;
    }
}
