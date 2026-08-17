package interfaces;

import java.util.List;

// T is the type the service manages (for example, Student)
public interface Manageable<T> {
    void add(T entity);
    boolean remove(String id);
    List<T> getAll();
} 