package file_management.read.alcohol_reader;

import domain.products.alcohol.Wine;
import exceptions.NotAdministratorException;
import file_management.read.GenericReadFile;
import file_management.read.ReadFile;
import permits.ActionType;
import permits.Administrator;

import java.util.List;

public final class WineReader implements GenericReadFile<Wine> {
    @Override
    public List<List<String>> read(Administrator admin, ReadFile readFile, Wine type) throws NotAdministratorException {
        if (admin.getActionType() != ActionType.ADMIN_ACTION)
            throw new NotAdministratorException("Not an administrator! Can not READ files!");

        return readFile.read(type.getPath(), admin);
    }
}
