package persistence.gaming_consoles_repository;

import domain.products.gaming_consoles.Xbox;
import exceptions.InvalidDataException;
import exceptions.NotAdministratorException;
import file_management.read.ReadFile;
import file_management.read.gaming_consoles_reader.XboxReader;
import permits.ActionType;
import permits.Administrator;
import persistence.GenericRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class XboxRepository implements GenericRepository<Xbox> {

    private Set<Xbox> xboxes = new HashSet<>();

    /* ----- Administrator privilege actions ----- */
//    public void readFromCSV(Administrator admin, ReadFile readFile) throws NotAdministratorException {
//        if (admin.getActionType() != ActionType.ADMIN_ACTION)
//            throw new NotAdministratorException("Not an administrator! Can not add from CSV file!");
//
//        try (Scanner scanner = new Scanner(new File(getPathFileCSV()))) {
//            while (scanner.hasNextLine()) {
//                List<String> productFromOneLine;
//                productFromOneLine = readFile.getLine(scanner.nextLine(), admin);
//
//                /* TO DO... de verificat ca sa fie fisierul in formatul corect cu toti parametrii introdusi */
//                Xbox oneXbox = new Xbox(Double.parseDouble(productFromOneLine.get(0)), productFromOneLine.get(1), productFromOneLine.get(2), productFromOneLine.get(3));
//                add(oneXbox, admin);
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//    }

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
    }

    @Override
    public void add(Xbox entity, Administrator admin) throws NotAdministratorException {
        if (admin.getActionType() != ActionType.ADMIN_ACTION)
            throw new NotAdministratorException("Not an administrator! Can not add entity!");
        Xbox oneXbox = new Xbox(entity.getPrice(), entity.getProducer(), entity.getOriginCountry(), entity.getProductionYear());
        this.xboxes.add(oneXbox);
    }

    @Override
    public void delete(Administrator admin) throws NotAdministratorException {
        if (admin.getActionType() != ActionType.ADMIN_ACTION)
            throw new NotAdministratorException("Not an administrator! Can not delete all entities!");
        xboxes.clear();
    }

    @Override
    public void delete(int index, Administrator admin) throws InvalidDataException, NotAdministratorException {
        if (admin.getActionType() != ActionType.ADMIN_ACTION)
            throw new NotAdministratorException("Not an administrator! Can not delete the entity with a given index!");
        if (index < 0 || index > xboxes.size())
            throw new InvalidDataException("Indexul este invalid!");
        // to do...
    }
    /* ----- END of Administrator privilege actions ----- */

    @Override
    public void printAllRepository() {
        for (Xbox xbox : this.xboxes)
            xbox.printProduct();
    }
}
