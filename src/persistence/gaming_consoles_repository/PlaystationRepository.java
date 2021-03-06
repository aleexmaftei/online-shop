package persistence.gaming_consoles_repository;

import domain.products.gaming_consoles.Playstation;
import exceptions.InvalidDataException;
import exceptions.NotAdministratorException;
import file_management.read.ReadFile;
import file_management.read.gaming_consoles_reader.PlaystationReader;
import file_management.write.WriteFile;
import file_management.write.gaming_console_writer.PlaystationWriter;
import permits.ActionType;
import permits.Administrator;
import persistence.GenericRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class PlaystationRepository implements GenericRepository<Playstation> {

    private Set<Playstation> playstations = new HashSet<>();

    /* ----- Administrator privilege actions ----- */
    /* -------- CSV READER -------- */
    public void readFromCSV(Administrator admin, ReadFile readFile) throws NotAdministratorException {
        if (admin.getActionType() != ActionType.ADMIN_ACTION)
            throw new NotAdministratorException("Not an administrator! Can not add from CSV file!");

        PlaystationReader playstationReader = new PlaystationReader();
        Playstation onePlaystationType = new Playstation();
        List<List<String>> records = playstationReader.read(admin, readFile, onePlaystationType);

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
            Playstation onePlaystation = new Playstation(param1, param2, param3, param4);
            add(onePlaystation, admin);
        }

        WriteFile.writeStampCSV("READ ALL PLAYSTATIONS FILES FROM CSV", admin);
    }

    /* -------- CSV WRITER -------- */
    public void writeToCSV(Administrator admin, WriteFile writeFile) throws NotAdministratorException {
        if (admin.getActionType() != ActionType.ADMIN_ACTION)
            throw new NotAdministratorException("Not an administrator! Can not add entity!");
        PlaystationWriter playstationWriter = new PlaystationWriter();
        //playstationWriter.write(playstations, admin, writeFile);
    }

    /* -------- TO ADD ONE -------- */
    @Override
    public void add(Playstation entity, Administrator admin) throws NotAdministratorException {
        if (admin.getActionType() != ActionType.ADMIN_ACTION)
            throw new NotAdministratorException("Not an administrator! Can not add entity!");
        Playstation onePlaystation = new Playstation(entity.getPrice(), entity.getName(), entity.getOriginCountry(), entity.getProductionYear());
        this.playstations.add(onePlaystation);

        WriteFile.writeStampCSV("added PLAYSTATION", admin);
    }

    /* -------- TO DELETE ALL -------- */
    @Override
    public void delete(Administrator admin) throws NotAdministratorException {
        if (admin.getActionType() != ActionType.ADMIN_ACTION)
            throw new NotAdministratorException("Not an administrator! Can not delete all entities!");
        playstations.clear();

        WriteFile.writeStampCSV("deleted all PLAYSTATIONS", admin);
    }

    /* -------- TO DELETE WITH A GIVEN INDEX -------- */
    @Override
    public void delete(int index, Administrator admin) throws InvalidDataException, NotAdministratorException {
        if (admin.getActionType() != ActionType.ADMIN_ACTION)
            throw new NotAdministratorException("Not an administrator! Can not delete the entity with a given index!");
        if (index < 0 || index > playstations.size())
            throw new InvalidDataException("Indexul este invalid!");
        // TODO: deletion index for playstation
        // WriteFile.writeStampCSV("deleted index: " + index + " from PLAYSTATIONS", admin);
    }
    /* ----- END of Administrator privilege actions ----- */

    @Override
    public void printAllRepository() {
        for (Playstation playstation : this.playstations)
            playstation.printProduct();
    }
}
