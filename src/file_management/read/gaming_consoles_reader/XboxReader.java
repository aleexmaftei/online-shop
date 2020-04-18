package file_management.read.gaming_consoles_reader;

import domain.products.gaming_consoles.Xbox;
import exceptions.NotAdministratorException;
import file_management.read.GenericReadFile;
import file_management.read.ReadFile;
import permits.ActionType;
import permits.Administrator;

import java.util.List;

public final class XboxReader implements GenericReadFile<Xbox> {
    @Override
    public List<List<String>> read(Administrator admin, ReadFile readFile, Xbox type) throws NotAdministratorException {
        if (admin.getActionType() != ActionType.ADMIN_ACTION)
            throw new NotAdministratorException("Not an administrator! Can not READ files!");

        return readFile.read(type.getPath(), admin);
    }
}
