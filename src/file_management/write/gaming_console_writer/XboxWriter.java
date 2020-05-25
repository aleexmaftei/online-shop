package file_management.write.gaming_console_writer;

import domain.products.gaming_consoles.Xbox;
import exceptions.NotAdministratorException;
import file_management.write.GenericWriteFile;
import file_management.write.WriteFile;
import permits.ActionType;
import permits.Administrator;

import java.util.LinkedList;
import java.util.List;

public final class XboxWriter implements GenericWriteFile<Xbox> {

    @Override
    public void write(List<Xbox> records, Administrator admin, WriteFile writeFile) throws NotAdministratorException {
        if (admin.getActionType() != ActionType.ADMIN_ACTION)
            throw new NotAdministratorException("Not an administrator! Can not WRITE file!");

        List<String> whatToWrite = new LinkedList<>();
        for (Xbox xbox : records) {
            whatToWrite.add(xbox.getPrice().toString() + ",");
            whatToWrite.add(xbox.getName() + ",");
            whatToWrite.add(xbox.getOriginCountry() + ",");
            whatToWrite.add(xbox.getProductionYear() + ",");
            whatToWrite.add("\n");
        }

        writeFile.write(Xbox.getWritePath(), whatToWrite, writeFile, admin);
    }
}
