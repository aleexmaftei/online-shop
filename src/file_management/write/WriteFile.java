package file_management.write;

import exceptions.NotAdministratorException;
import permits.ActionType;
import permits.Administrator;
import service.TimeStampWriterService;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

public final class WriteFile {
    private static WriteFile WRITE_INSTANCE = null;

    private WriteFile() {
    }

    public static synchronized WriteFile getWriteFileInstance() {
        if (WRITE_INSTANCE == null) {
            WRITE_INSTANCE = new WriteFile();
        }
        return WRITE_INSTANCE;
    }

    // general write function
    public void write(String writePath, List<String> whatToWrite, WriteFile writeFile, Administrator admin) throws NotAdministratorException {
        if (admin.getActionType() != ActionType.ADMIN_ACTION)
            throw new NotAdministratorException("Not an administrator! Can not WRITE file!");

        try (FileWriter outputFile = new FileWriter(writePath, true);
             PrintWriter printWriter = new PrintWriter(outputFile)) {
            for (String data : whatToWrite) {
                printWriter.append(String.join(",", data));
            }
            printWriter.append("\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // time stamp write
    public static void writeStampCSV(String whatToWrite, Administrator admin) throws NotAdministratorException {
        if (admin.getActionType() != ActionType.ADMIN_ACTION)
            throw new NotAdministratorException("Not an administrator! Can not add entity!");

        List<String> action = new LinkedList<>();
        action.add(whatToWrite);

        TimeStampWriterService.timeStampWrite(action, WriteFile.getWriteFileInstance(), admin);
    }
}
