package file_management.read.non_alcohol_reader;

import domain.products.non_alcohol.Water;
import exceptions.NotAdministratorException;
import file_management.read.GenericReadFile;
import file_management.read.ReadFile;
import permits.ActionType;
import permits.Administrator;

import java.util.List;

public final class WaterReader implements GenericReadFile<Water> {
    @Override
    public List<List<String>> read(Administrator admin, ReadFile readFile, Water type) throws NotAdministratorException {
        if (admin.getActionType() != ActionType.ADMIN_ACTION)
            throw new NotAdministratorException("Not an administrator! Can not READ files!");

        return readFile.read(type.getPath(), admin);
    }
}
