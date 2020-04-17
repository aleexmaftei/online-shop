package file_management.read;

import exceptions.NotAdministratorException;
import permits.ActionType;
import permits.Administrator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class ReadFile {
    private static ReadFile READ_INSTANCE = null;

    private ReadFile() {
    }

    public static synchronized ReadFile getReadFileInstance() {
        if (READ_INSTANCE == null) {
            READ_INSTANCE = new ReadFile();
        }
        return READ_INSTANCE;
    }

    public List<String> getLine(String line, Administrator admin) throws NotAdministratorException {
        if (admin.getActionType() != ActionType.ADMIN_ACTION)
            throw new NotAdministratorException("Not an administrator! Can not READ files!");

        List<String> lineValues = new ArrayList<>();
        try (Scanner row = new Scanner(line)) {
            row.useDelimiter(",");
            while (row.hasNext()) {
                lineValues.add(row.next());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lineValues;
    }

    public List<List<String>> read(String path, Administrator admin) throws NotAdministratorException {
        if (admin.getActionType() != ActionType.ADMIN_ACTION)
            throw new NotAdministratorException("Not an administrator! Can not READ files!");

        List<List<String>> records = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(path))) {
            while (scanner.hasNextLine()) {
                records.add(getLine(scanner.nextLine(), admin));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return records;
    }
}
