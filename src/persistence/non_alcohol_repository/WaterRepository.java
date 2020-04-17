package persistence.non_alcohol_repository;

import domain.products.non_alcohol.Water;
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

public final class WaterRepository implements GenericRepository<Water> {

    private List<Water> waters = new LinkedList<>();

    /* ----- Administrator privilege actions ----- */
    public void readFromCSV(Administrator admin, ReadFile readFile) throws NotAdministratorException {
        if (admin.getActionType() != ActionType.ADMIN_ACTION)
            throw new NotAdministratorException("Not an administrator! Can not add from CSV file!");

        try (Scanner scanner = new Scanner(new File(getPathFileCSV()))) {
            while (scanner.hasNextLine()) {
                List<String> productFromOneLine;
                productFromOneLine = readFile.getLine(scanner.nextLine(), admin);

                /* TO DO... de verificat ca sa fie fisierul in formatul corect cu toti parametrii introdusi */
                Water oneWater = new Water(Double.parseDouble(productFromOneLine.get(0)), productFromOneLine.get(1), productFromOneLine.get(2));
                add(oneWater, admin);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add(Water entity, Administrator admin) throws NotAdministratorException {
        if (admin.getActionType() != ActionType.ADMIN_ACTION)
            throw new NotAdministratorException("Not an administrator! Can not add entity!");
        Water oneWater = new Water(entity.getPrice(), entity.getProducer(), entity.getOriginCountry());
        this.waters.add(oneWater);
    }


    @Override
    public void delete(Administrator admin) throws NotAdministratorException {
        if (admin.getActionType() != ActionType.ADMIN_ACTION)
            throw new NotAdministratorException("Not an administrator! Can not delete all entities!");
        waters.clear();
    }

    @Override
    public void delete(int index, Administrator admin) throws InvalidDataException, NotAdministratorException {
        if (admin.getActionType() != ActionType.ADMIN_ACTION)
            throw new NotAdministratorException("Not an administrator! Can not delete the entity with a given index!");
        if (index < 0 || index > waters.size())
            throw new InvalidDataException("Indexul este invalid!");
        waters.remove(index);
    }
    /* ----- END of Administrator privilege actions ----- */

    @Override
    public void printAllRepository() {
        for (Water water : this.waters)
            water.printProduct();
    }

    public String getPathFileCSV() {
        return "src/files/database/non_alcohol/waterCSV";
    }
}
