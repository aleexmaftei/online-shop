package file_management.write.alcohol_writer;

import domain.products.alcohol.Beer;
import exceptions.NotAdministratorException;
import file_management.write.GenericWriteFile;
import file_management.write.WriteFile;
import permits.ActionType;
import permits.Administrator;

import java.util.LinkedList;
import java.util.List;

public final class BeerWriter implements GenericWriteFile<Beer> {

    @Override
    public void write(List<Beer> records, Administrator admin, WriteFile writeFile) throws NotAdministratorException {
        if (admin.getActionType() != ActionType.ADMIN_ACTION)
            throw new NotAdministratorException("Not an administrator! Can not WRITE file!");

        List<String> whatToWrite = new LinkedList<>();
        for (Beer beer : records) {
            whatToWrite.add(beer.getAlcoholPercentage().toString() + ",");
            whatToWrite.add(beer.getPrice().toString() + ",");
            whatToWrite.add(beer.getName() + ",");
            whatToWrite.add(beer.getOriginCountry() + ",");
            whatToWrite.add(beer.getIngredients() + ",");
            whatToWrite.add("\n");
        }

        writeFile.write(Beer.getWritePath(), whatToWrite, writeFile, admin);
    }
}
