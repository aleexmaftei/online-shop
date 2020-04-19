package file_management.write.gaming_console_writer;

import domain.products.gaming_consoles.Nintendo;
import exceptions.NotAdministratorException;
import file_management.write.GenericWriteFile;
import file_management.write.WriteFile;
import permits.ActionType;
import permits.Administrator;

import java.util.LinkedList;
import java.util.List;

public final class NintendoWriter implements GenericWriteFile<Nintendo> {

    @Override
    public void write(List<Nintendo> records, Administrator admin, WriteFile writeFile) throws NotAdministratorException {
        if (admin.getActionType() != ActionType.ADMIN_ACTION)
            throw new NotAdministratorException("Not an administrator! Can not WRITE file!");

        List<String> whatToWrite = new LinkedList<>();
        for (Nintendo nintendo : records) {
            whatToWrite.add(nintendo.getPrice().toString() + ",");
            whatToWrite.add(nintendo.getProducer() + ",");
            whatToWrite.add(nintendo.getOriginCountry() + ",");
            whatToWrite.add(nintendo.getProductionYear() + ",");
            whatToWrite.add("\n");
        }

        writeFile.write(Nintendo.getWritePath(), whatToWrite, writeFile, admin);
    }
}
