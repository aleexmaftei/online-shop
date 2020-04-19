package service;

import exceptions.NotAdministratorException;
import file_management.write.WriteFile;
import permits.ActionType;
import permits.Administrator;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public final class TimeStampWriterService {
    public static void timeStampWrite(List<String> whatToWrite, WriteFile fileWriter, Administrator admin) throws NotAdministratorException {
        if (admin.getActionType() != ActionType.ADMIN_ACTION)
            throw new NotAdministratorException("Not an administrator! Can not WRITE file!");

        // day and time stamp
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        whatToWrite.add(",");
        whatToWrite.add(dateFormat.format(date));

        fileWriter.write("src/files/action_stamp/action-timeStamp", whatToWrite, fileWriter, admin);
    }
}
