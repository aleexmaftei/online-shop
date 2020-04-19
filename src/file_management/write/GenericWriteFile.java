package file_management.write;

import exceptions.NotAdministratorException;
import file_management.read.ReadFile;
import permits.Administrator;

import java.util.List;

public interface GenericWriteFile<T> {
    void write(List<T> records, Administrator admin, WriteFile writeFile) throws NotAdministratorException;
}
