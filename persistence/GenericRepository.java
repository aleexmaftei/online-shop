package persistence;

import exceptions.InvalidDataException;

public interface GenericRepository<T> {
    public void add(T entity);

    public void printAllRepository();

    public void delete();

    public void delete(int index) throws InvalidDataException;
}
