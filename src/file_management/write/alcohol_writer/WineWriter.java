package file_management.write.alcohol_writer;

import domain.products.alcohol.Wine;
import exceptions.NotAdministratorException;
import file_management.write.GenericWriteFile;
import file_management.write.WriteFile;
import permits.ActionType;
import permits.Administrator;

import java.util.LinkedList;
import java.util.List;

public final class WineWriter implements GenericWriteFile<Wine> {

    @Override
    public void write(List<Wine> records, Administrator admin, WriteFile writeFile) throws NotAdministratorException {
        if (admin.getActionType() != ActionType.ADMIN_ACTION)
            throw new NotAdministratorException("Not an administrator! Can not WRITE file!");

        List<String> whatToWrite = new LinkedList<>();
        for (Wine wine : records) {
            whatToWrite.add(wine.getAlcoholPercentage().toString() + ",");
            whatToWrite.add(wine.getPrice().toString() + ",");
            whatToWrite.add(wine.getName() + ",");
            whatToWrite.add(wine.getOriginCountry() + ",");
            whatToWrite.add(wine.getIngredients() + ",");
            whatToWrite.add("\n");
        }

        writeFile.write(Wine.getWritePath(), whatToWrite, writeFile, admin);
    }
}
