package persistence;

import java.util.List;

public interface InterfaceDAO<T> extends AutoCloseable {
    List<T> findAll();

    T findById(Integer id);

    boolean add(T object);

    boolean delete(Integer id);

    T update (T object);
}