package file_management.write.non_alcohol_writer;

import domain.products.non_alcohol.Soda;
import exceptions.NotAdministratorException;
import file_management.write.GenericWriteFile;
import file_management.write.WriteFile;
import permits.ActionType;
import permits.Administrator;

import java.util.LinkedList;
import java.util.List;

public final class SodaWriter implements GenericWriteFile<Soda> {

    @Override
    public void write(List<Soda> records, Administrator admin, WriteFile writeFile) throws NotAdministratorException {
        if (admin.getActionType() != ActionType.ADMIN_ACTION)
            throw new NotAdministratorException("Not an administrator! Can not WRITE file!");

        List<String> whatToWrite = new LinkedList<>();
        for (Soda soda : records) {
            whatToWrite.add(soda.getPrice().toString() + ",");
            whatToWrite.add(soda.getName() + ",");
            whatToWrite.add(soda.getOriginCountry() + ",");
            whatToWrite.add(soda.getIngredients());
            whatToWrite.add("\n");
        }

        writeFile.write(Soda.getWritePath(), whatToWrite, writeFile, admin);
    }
}
