package persistence.non_alcohol_repository;

import domain.products.non_alcohol.Soda;
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

public final class SodaRepository implements GenericRepository<Soda> {

    private List<Soda> sodas = new LinkedList<>();

    /* ----- Administrator privilege actions ----- */
    public void readFromCSV(Administrator admin, ReadFile readFile) throws NotAdministratorException {
        if (admin.getActionType() != ActionType.ADMIN_ACTION)
            throw new NotAdministratorException("Not an administrator! Can not add from CSV file!");

        try (Scanner scanner = new Scanner(new File("src/files/database/non_alcohol/sodaCSV"))) {
            while (scanner.hasNextLine()) {
                List<String> productFromOneLine;
                productFromOneLine = readFile.getLine(scanner.nextLine(), admin);

                /* TO DO... de verificat ca sa fie fisierul in formatul corect cu toti parametrii introdusi */
                Soda oneSoda = new Soda(Double.parseDouble(productFromOneLine.get(0)), productFromOneLine.get(1), productFromOneLine.get(2), productFromOneLine.get(3));
                add(oneSoda, admin);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add(Soda entity, Administrator admin) throws NotAdministratorException {
        if (admin.getActionType() != ActionType.ADMIN_ACTION)
            throw new NotAdministratorException("Not an administrator! Can not add entity!");
        Soda oneSoda = new Soda(entity.getPrice(), entity.getProducer(), entity.getOriginCountry(), entity.getIngredients());
        sodas.add(oneSoda);
    }

    @Override
    public void delete(Administrator admin) throws NotAdministratorException {
        if (admin.getActionType() != ActionType.ADMIN_ACTION)
            throw new NotAdministratorException("Not an administrator! Can not delete all entities!");
        sodas.clear();
    }

    @Override
    public void delete(int index, Administrator admin) throws InvalidDataException, NotAdministratorException {
        if (admin.getActionType() != ActionType.ADMIN_ACTION)
            throw new NotAdministratorException("Not an administrator! Can not delete the entity with a given index!");
        if (index < 0 || index > sodas.size())
            throw new InvalidDataException("Indexul este invalid!");
        sodas.remove(index);
    }
    /* ----- END of Administrator privilege actions ----- */

    @Override
    public void printAllRepository() {
        for (Soda soda : sodas)
            soda.printProduct();
    }

    public String getPathFileCSV() {
        return "src/files/database/non_alcohol/sodaCSV";
    }
}
