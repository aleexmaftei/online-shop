package persistence;

import exceptions.InvalidDataException;

public interface GenericRepository<T> {
    void add(T entity);

    void printAllRepository();

    void delete();

    void delete(int index) throws InvalidDataException;
}
