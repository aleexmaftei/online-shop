package persistence;

import exceptions.InvalidDataException;
import exceptions.NotAdministratorException;
import permits.Administrator;

public interface GenericRepository<T> {

    void add(T entity, Administrator admin) throws NotAdministratorException;

    void delete(Administrator admin) throws NotAdministratorException;

    void delete(int index, Administrator admin) throws InvalidDataException, NotAdministratorException;

    void printAllRepository();

}
