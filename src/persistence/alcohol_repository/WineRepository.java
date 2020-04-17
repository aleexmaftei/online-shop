package persistence.alcohol_repository;

import domain.products.alcohol.Wine;
import exceptions.InvalidDataException;
import exceptions.NotAdministratorException;
import file_management.read.ReadFile;
import permits.ActionType;
import permits.Administrator;
import persistence.GenericRepository;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public final class WineRepository implements GenericRepository<Wine> {

    private List<Wine> wines = new LinkedList<>();

    /* ----- Administrator privilege actions ----- */
    public void readFromCSV(Administrator admin, ReadFile readFile) throws NotAdministratorException {
        if (admin.getActionType() != ActionType.ADMIN_ACTION)
            throw new NotAdministratorException("Not an administrator! Can not add from CSV file!");

        try (Scanner scanner = new Scanner(new File(getPathFileCSV()))) {
            while (scanner.hasNextLine()) {
                List<String> productFromOneLine;
                productFromOneLine = readFile.getLine(scanner.nextLine(), admin);

                /* TO DO... de verificat ca sa fie fisierul in formatul corect cu toti parametrii introdusi */
                Wine oneWine = new Wine(Integer.parseInt(productFromOneLine.get(0)), Double.parseDouble(productFromOneLine.get(1)), productFromOneLine.get(2), productFromOneLine.get(3), productFromOneLine.get(4));
                add(oneWine, admin);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add(Wine entity, Administrator admin) throws NotAdministratorException {
        if (admin.getActionType() != ActionType.ADMIN_ACTION)
            throw new NotAdministratorException("Not an administrator! Can not add entity!");
        Wine oneWine = new Wine(entity.getAlcoholPercentage(), entity.getPrice(), entity.getProducer(), entity.getOriginCountry(), entity.getIngredients());
        this.wines.add(oneWine);
    }

    @Override
    public void delete(Administrator admin) throws NotAdministratorException {
        if (admin.getActionType() != ActionType.ADMIN_ACTION)
            throw new NotAdministratorException("Not an administrator! Can not delete all entities!");
        wines.clear();
    }

    @Override
    public void delete(int index, Administrator admin) throws InvalidDataException, NotAdministratorException {
        if (admin.getActionType() != ActionType.ADMIN_ACTION)
            throw new NotAdministratorException("Not an administrator! Can not delete the entity with a given index!");
        if (index < 0 || index > wines.size())
            throw new InvalidDataException("Invalid index!");
        wines.remove(index);
    }
    /* ----- END of Administrator privilege actions ----- */

    @Override
    public void printAllRepository() {
        for (Wine wine : this.wines)
            wine.printProduct();
    }

    public String getPathFileCSV() {
        return "src/files/database/alcohol/wineCSV";
    }
}
