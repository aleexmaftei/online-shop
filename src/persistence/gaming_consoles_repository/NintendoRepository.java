package persistence.gaming_consoles_repository;

import domain.products.gaming_consoles.Nintendo;
import exceptions.InvalidDataException;
import exceptions.NotAdministratorException;
import file_management.read.ReadFile;
import file_management.read.gaming_consoles_reader.NintendoReader;
import file_management.write.WriteFile;
import file_management.write.gaming_console_writer.NintendoWriter;
import permits.ActionType;
import permits.Administrator;
import persistence.GenericRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class NintendoRepository implements GenericRepository<Nintendo> {

    private Set<Nintendo> nintendos = new HashSet<>();

    /* ----- Administrator privilege actions ----- */
    /* -------- CSV READER -------- */
    public void readFromCSV(Administrator admin, ReadFile readFile) throws NotAdministratorException {
        if (admin.getActionType() != ActionType.ADMIN_ACTION)
            throw new NotAdministratorException("Not an administrator! Can not add from CSV file!");

        NintendoReader nintendoReader = new NintendoReader();
        Nintendo oneNintendoType = new Nintendo();
        List<List<String>> records = nintendoReader.read(admin, readFile, oneNintendoType);

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
            Nintendo oneNintendo = new Nintendo(param1, param2, param3, param4);
            add(oneNintendo, admin);
        }

        WriteFile.writeStampCSV("READ ALL NINTENDOS FILES FROM CSV", admin);
    }

    /* -------- CSV WRITER -------- */
    public void writeToCSV(Administrator admin, WriteFile writeFile) throws NotAdministratorException {
        if (admin.getActionType() != ActionType.ADMIN_ACTION)
            throw new NotAdministratorException("Not an administrator! Can not add entity!");
        NintendoWriter nintendoWriter = new NintendoWriter();
        //nintendoWriter.write(nintendos, admin, writeFile);
    }

    /* -------- TO ADD ONE -------- */
    @Override
    public void add(Nintendo entity, Administrator admin) throws NotAdministratorException {
        if (admin.getActionType() != ActionType.ADMIN_ACTION)
            throw new NotAdministratorException("Not an administrator! Can not add entity!");
        Nintendo oneNintendo = new Nintendo(entity.getPrice(), entity.getName(), entity.getOriginCountry(), entity.getProductionYear());
        this.nintendos.add(oneNintendo);

        WriteFile.writeStampCSV("added NINTENDO", admin);
    }

    /* -------- TO DELETE ALL -------- */
    @Override
    public void delete(Administrator admin) throws NotAdministratorException {
        if (admin.getActionType() != ActionType.ADMIN_ACTION)
            throw new NotAdministratorException("Not an administrator! Can not delete all entities!");
        nintendos.clear();

        WriteFile.writeStampCSV("deleted all NINTENDOS", admin);
    }

    /* -------- TO DELETE WITH A GIVEN INDEX -------- */
    @Override
    public void delete(int index, Administrator admin) throws InvalidDataException, NotAdministratorException {
        if (admin.getActionType() != ActionType.ADMIN_ACTION)
            throw new NotAdministratorException("Not an administrator! Can not delete the entity with a given index!");
        if (index < 0 || index > nintendos.size())
            throw new InvalidDataException("Indexul este invalid!");

        // TODO: deletion for gaming_consoles
        // WriteFile.writeStampCSV("deleted index: " + index + " from NINTENDO", admin);
    }
    /* ----- END of Administrator privilege actions ----- */

    @Override
    public void printAllRepository() {
        for (Nintendo nintendo : this.nintendos)
            nintendo.printProduct();
    }
}
