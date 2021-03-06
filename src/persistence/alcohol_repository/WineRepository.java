package persistence.alcohol_repository;

import domain.products.alcohol.Wine;
import exceptions.InvalidDataException;
import exceptions.NotAdministratorException;
import file_management.read.ReadFile;
import file_management.read.alcohol_reader.WineReader;
import file_management.write.WriteFile;
import file_management.write.alcohol_writer.WineWriter;
import permits.ActionType;
import permits.Administrator;
import persistence.GenericRepository;

import java.util.LinkedList;
import java.util.List;

public final class WineRepository implements GenericRepository<Wine> {

    private List<Wine> wines = new LinkedList<>();

    /* ----- Administrator privilege actions ----- */
    /* -------- CSV READER -------- */
    public void readFromCSV(Administrator admin, ReadFile readFile) throws NotAdministratorException {
        if (admin.getActionType() != ActionType.ADMIN_ACTION)
            throw new NotAdministratorException("Not an administrator! Can not add from CSV file!");

        WineReader wineReader = new WineReader();
        Wine oneWineType = new Wine();
        List<List<String>> records = wineReader.read(admin, readFile, oneWineType);

        for (List<String> line : records) {
            int param1 = 0;
            double param2 = 0;
            String param3 = null, param4 = null, param5 = null;
            int k = 1;
            for (String row : line) {
                if (k == 1) {
                    param1 = Integer.parseInt(row);
                } else if (k == 2) {
                    param2 = Double.parseDouble(row);
                } else if (k == 3) {
                    param3 = row;
                } else if (k == 4) {
                    param4 = row;
                } else param5 = row;
                k++;
            }
            Wine oneWine = new Wine(param1, param2, param3, param4, param5);
            add(oneWine, admin);
        }

        WriteFile.writeStampCSV("READ ALL WINES FILES FROM CSV", admin);
    }

    /* -------- CSV WRITER -------- */
    public void writeToCSV(Administrator admin, WriteFile writeFile) throws NotAdministratorException {
        if (admin.getActionType() != ActionType.ADMIN_ACTION)
            throw new NotAdministratorException("Not an administrator! Can not add entity!");
        WineWriter wineWriter = new WineWriter();
        wineWriter.write(wines, admin, writeFile);
    }

    /* -------- TO ADD ONE -------- */
    @Override
    public void add(Wine entity, Administrator admin) throws NotAdministratorException {
        if (admin.getActionType() != ActionType.ADMIN_ACTION)
            throw new NotAdministratorException("Not an administrator! Can not add entity!");
        Wine oneWine = new Wine(entity.getAlcoholPercentage(), entity.getPrice(), entity.getName(), entity.getOriginCountry(), entity.getIngredients());
        this.wines.add(oneWine);

        WriteFile.writeStampCSV("added WINE", admin);
    }

    /* -------- TO DELETE ALL -------- */
    @Override
    public void delete(Administrator admin) throws NotAdministratorException {
        if (admin.getActionType() != ActionType.ADMIN_ACTION)
            throw new NotAdministratorException("Not an administrator! Can not delete all entities!");
        wines.clear();
    }

    /* -------- TO DELETE WITH A GIVEN INDEX -------- */
    @Override
    public void delete(int index, Administrator admin) throws InvalidDataException, NotAdministratorException {
        if (admin.getActionType() != ActionType.ADMIN_ACTION)
            throw new NotAdministratorException("Not an administrator! Can not delete the entity with a given index!");
        if (index < 0 || index > wines.size())
            throw new InvalidDataException("Invalid index!");
        wines.remove(index);

        WriteFile.writeStampCSV("deteled wine with index: " + index + " from WINES", admin);
    }
    /* ----- END of Administrator privilege actions ----- */

    @Override
    public void printAllRepository() {
        for (Wine wine : this.wines)
            wine.printProduct();
    }
}
