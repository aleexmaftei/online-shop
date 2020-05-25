package file_management.write.alcohol_writer;

import domain.products.alcohol.Vodka;
import exceptions.NotAdministratorException;
import file_management.write.GenericWriteFile;
import file_management.write.WriteFile;
import permits.ActionType;
import permits.Administrator;

import java.util.LinkedList;
import java.util.List;

public final class VodkaWriter implements GenericWriteFile<Vodka> {

    @Override
    public void write(List<Vodka> records, Administrator admin, WriteFile writeFile) throws NotAdministratorException {
        if (admin.getActionType() != ActionType.ADMIN_ACTION)
            throw new NotAdministratorException("Not an administrator! Can not WRITE file!");

        List<String> whatToWrite = new LinkedList<>();
        for (Vodka vodka : records) {
            whatToWrite.add(vodka.getAlcoholPercentage().toString() + ",");
            whatToWrite.add(vodka.getPrice().toString() + ",");
            whatToWrite.add(vodka.getName() + ",");
            whatToWrite.add(vodka.getOriginCountry() + ",");
            whatToWrite.add(vodka.getIngredients() + ",");
            whatToWrite.add("\n");
        }

        writeFile.write(Vodka.getWritePath(), whatToWrite, writeFile, admin);
    }
}
