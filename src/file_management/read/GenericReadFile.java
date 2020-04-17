package file_management.read;

import exceptions.NotAdministratorException;
import permits.Administrator;

import java.util.List;

public interface GenericReadFile<T> {
    List<List<String>> read(Administrator admin, ReadFile readFile, T type) throws NotAdministratorException;
}
