package file_management.read.gaming_consoles_reader;

import domain.products.gaming_consoles.Playstation;
import exceptions.NotAdministratorException;
import file_management.read.GenericReadFile;
import file_management.read.ReadFile;
import permits.ActionType;
import permits.Administrator;

import java.util.List;

public final class PlaystationReader implements GenericReadFile<Playstation> {
    @Override
    public List<List<String>> read(Administrator admin, ReadFile readFile, Playstation type) throws NotAdministratorException {
        if (admin.getActionType() != ActionType.ADMIN_ACTION)
            throw new NotAdministratorException("Not an administrator! Can not READ files!");

        return readFile.read(type.getPath(), admin);
    }
}
