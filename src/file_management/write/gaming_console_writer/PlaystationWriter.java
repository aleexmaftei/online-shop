package file_management.write.gaming_console_writer;

import domain.products.gaming_consoles.Playstation;
import exceptions.NotAdministratorException;
import file_management.write.GenericWriteFile;
import file_management.write.WriteFile;
import permits.ActionType;
import permits.Administrator;

import java.util.LinkedList;
import java.util.List;

public final class PlaystationWriter implements GenericWriteFile<Playstation> {

    @Override
    public void write(List<Playstation> records, Administrator admin, WriteFile writeFile) throws NotAdministratorException {
        if (admin.getActionType() != ActionType.ADMIN_ACTION)
            throw new NotAdministratorException("Not an administrator! Can not WRITE file!");

        List<String> whatToWrite = new LinkedList<>();
        for (Playstation playstation : records) {
            whatToWrite.add(playstation.getPrice().toString() + ",");
            whatToWrite.add(playstation.getProducer() + ",");
            whatToWrite.add(playstation.getOriginCountry() + ",");
            whatToWrite.add(playstation.getProductionYear() + ",");
            whatToWrite.add("\n");
        }

        writeFile.write(Playstation.getWritePath(), whatToWrite, writeFile, admin);
    }
}
