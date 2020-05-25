package persistence.gaming_consoles_repository;

import domain.products.gaming_consoles.Xbox;
import exceptions.InvalidDataException;
import exceptions.NotAdministratorException;
import file_management.read.ReadFile;
import file_management.read.gaming_consoles_reader.XboxReader;
import file_management.write.WriteFile;
import file_management.write.gaming_console_writer.XboxWriter;
import permits.ActionType;
import permits.Administrator;
import persistence.GenericRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class XboxRepository implements GenericRepository<Xbox> {

    private Set<Xbox> xboxes = new HashSet<>();

    /* ----- Administrator privilege actions ----- */
    /* -------- CSV READER -------- */
    public void readFromCSV(Administrator admin, ReadFile readFile) throws NotAdministratorException {
        if (admin.getActionType() != ActionType.ADMIN_ACTION)
            throw new NotAdministratorException("Not an administrator! Can not add from CSV file!");

        XboxReader xboxReader = new XboxReader();
        Xbox oneXboxType = new Xbox();
        List<List<String>> records = xboxReader.read(admin, readFile, oneXboxType);

        for (List<String> line : records) {
            double param1 = 0;
            String param2 = null, param3 = null, param4 = null;
            int k = 1;
            for (String row : line) {
                if (k == 1) {
                    param1 = Double.parseDouble(row);
                } else if (k == 2) {
                    param2 = row;
                } else if (k == 3) {
                    param3 = row;
                } else param4 = row;
                k++;
            }
            Xbox oneXbox = new Xbox(param1, param2, param3, param4);
            add(oneXbox, admin);
        }

        WriteFile.writeStampCSV("READ ALL XBOXES FILES FROM CSV", admin);
    }

    /* -------- CSV WRITER -------- */
    public void writeToCSV(Administrator admin, WriteFile writeFile) throws NotAdministratorException {
        if (admin.getActionType() != ActionType.ADMIN_ACTION)
            throw new NotAdministratorException("Not an administrator! Can not add entity!");
        XboxWriter xboxWriter = new XboxWriter();
        //xboxWriter.write(xboxes, admin, writeFile);
    }

    /* -------- TO ADD ONE -------- */
    @Override
    public void add(Xbox entity, Administrator admin) throws NotAdministratorException {
        if (admin.getActionType() != ActionType.ADMIN_ACTION)
            throw new NotAdministratorException("Not an administrator! Can not add entity!");
        Xbox oneXbox = new Xbox(entity.getPrice(), entity.getName(), entity.getOriginCountry(), entity.getProductionYear());
        this.xboxes.add(oneXbox);

        WriteFile.writeStampCSV("added XBOX", admin);
    }

    /* -------- TO DELETE ALL -------- */
    @Override
    public void delete(Administrator admin) throws NotAdministratorException {
        if (admin.getActionType() != ActionType.ADMIN_ACTION)
            throw new NotAdministratorException("Not an administrator! Can not delete all entities!");
        xboxes.clear();

        WriteFile.writeStampCSV("deleted all XBOXES", admin);
    }

    /* -------- TO DELETE WITH A GIVEN INDEX -------- */
    @Override
    public void delete(int index, Administrator admin) throws InvalidDataException, NotAdministratorException {
        if (admin.getActionType() != ActionType.ADMIN_ACTION)
            throw new NotAdministratorException("Not an administrator! Can not delete the entity with a given index!");
        if (index < 0 || index > xboxes.size())
            throw new InvalidDataException("Indexul este invalid!");
        // TODO: xbox deletion index
        // WriteFile.writeStampCSV("deleted index: " + index + " from XBOXES", admin);
    }
    /* ----- END of Administrator privilege actions ----- */

    @Override
    public void printAllRepository() {
        for (Xbox xbox : this.xboxes)
            xbox.printProduct();
    }
}
