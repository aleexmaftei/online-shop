package persistence;

import exceptions.InvalidDataException;
import exceptions.NotAdministratorException;
import permits.Administrator;

import java.io.IOException;

public interface GenericRepository<T> {

    void add(T entity, Administrator admin) throws NotAdministratorException, IOException;

    void delete(Administrator admin) throws NotAdministratorException, IOException;

    void delete(int index, Administrator admin) throws InvalidDataException, NotAdministratorException, IOException;

    void printAllRepository();

}
