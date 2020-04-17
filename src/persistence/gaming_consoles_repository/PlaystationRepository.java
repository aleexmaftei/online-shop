package persistence.gaming_consoles_repository;

import domain.products.gaming_consoles.Playstation;
import exceptions.InvalidDataException;
import exceptions.NotAdministratorException;
import file_management.read.ReadFile;
import permits.ActionType;
import permits.Administrator;
import persistence.GenericRepository;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public final class PlaystationRepository implements GenericRepository<Playstation> {

    private Set<Playstation> playstations = new HashSet<>();

    /* ----- Administrator privilege actions ----- */
    public void readFromCSV(Administrator admin, ReadFile readFile) throws NotAdministratorException {
        if (admin.getActionType() != ActionType.ADMIN_ACTION)
            throw new NotAdministratorException("Not an administrator! Can not add from CSV file!");

        try (Scanner scanner = new Scanner(new File(getPathFileCSV()))) {
            while (scanner.hasNextLine()) {
                List<String> productFromOneLine;
                productFromOneLine = readFile.getLine(scanner.nextLine(), admin);

                /* TO DO... de verificat ca sa fie fisierul in formatul corect cu toti parametrii introdusi */
                Playstation onePlaystation = new Playstation(Double.parseDouble(productFromOneLine.get(0)), productFromOneLine.get(1), productFromOneLine.get(2), productFromOneLine.get(3));
                add(onePlaystation, admin);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add(Playstation entity, Administrator admin) throws NotAdministratorException {
        if (admin.getActionType() != ActionType.ADMIN_ACTION)
            throw new NotAdministratorException("Not an administrator! Can not add entity!");
        Playstation onePlaystation = new Playstation(entity.getPrice(), entity.getProducer(), entity.getOriginCountry(), entity.getProductionYear());
        this.playstations.add(onePlaystation);
    }

    @Override
    public void delete(Administrator admin) throws NotAdministratorException {
        if (admin.getActionType() != ActionType.ADMIN_ACTION)
            throw new NotAdministratorException("Not an administrator! Can not delete all entities!");
        playstations.clear();
    }

    @Override
    public void delete(int index, Administrator admin) throws InvalidDataException, NotAdministratorException {
        if (admin.getActionType() != ActionType.ADMIN_ACTION)
            throw new NotAdministratorException("Not an administrator! Can not delete the entity with a given index!");
        if (index < 0 || index > playstations.size())
            throw new InvalidDataException("Indexul este invalid!");
        // to do...
    }
    /* ----- END of Administrator privilege actions ----- */

    @Override
    public void printAllRepository() {
        for (Playstation playstation : this.playstations)
            playstation.printProduct();
    }

    public String getPathFileCSV() {
        return "src/files/database/gaming_consoles/playstationCSV";
    }
}
