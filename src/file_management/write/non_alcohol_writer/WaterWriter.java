package file_management.write.non_alcohol_writer;

import domain.products.non_alcohol.Water;
import exceptions.NotAdministratorException;
import file_management.write.GenericWriteFile;
import file_management.write.WriteFile;
import permits.ActionType;
import permits.Administrator;

import java.util.LinkedList;
import java.util.List;

public final class WaterWriter implements GenericWriteFile<Water> {

    @Override
    public void write(List<Water> records, Administrator admin, WriteFile writeFile) throws NotAdministratorException {
        if (admin.getActionType() != ActionType.ADMIN_ACTION)
            throw new NotAdministratorException("Not an administrator! Can not WRITE file!");

        List<String> whatToWrite = new LinkedList<>();
        for (Water water : records) {
            whatToWrite.add(water.getPrice().toString() + ",");
            whatToWrite.add(water.getProducer() + ",");
            whatToWrite.add(water.getOriginCountry() + ",");
            whatToWrite.add("\n");
        }

        writeFile.write(Water.getWritePath(), whatToWrite, writeFile, admin);
    }
}
