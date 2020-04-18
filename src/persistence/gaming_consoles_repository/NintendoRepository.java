package persistence.gaming_consoles_repository;

import domain.products.gaming_consoles.Nintendo;
import exceptions.InvalidDataException;
import exceptions.NotAdministratorException;
import file_management.read.ReadFile;
import file_management.read.gaming_consoles_reader.NintendoReader;
import permits.ActionType;
import permits.Administrator;
import persistence.GenericRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class NintendoRepository implements GenericRepository<Nintendo> {

    private Set<Nintendo> nintendos = new HashSet<>();

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
//                Nintendo oneNintendo = new Nintendo(Double.parseDouble(productFromOneLine.get(0)), productFromOneLine.get(1), productFromOneLine.get(2), productFromOneLine.get(3));
//                add(oneNintendo, admin);
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//    }

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
    }

    @Override
    public void add(Nintendo entity, Administrator admin) throws NotAdministratorException {
        if (admin.getActionType() != ActionType.ADMIN_ACTION)
            throw new NotAdministratorException("Not an administrator! Can not add entity!");
        Nintendo oneNintendo = new Nintendo(entity.getPrice(), entity.getProducer(), entity.getOriginCountry(), entity.getProductionYear());
        this.nintendos.add(oneNintendo);
    }

    @Override
    public void delete(Administrator admin) throws NotAdministratorException {
        if (admin.getActionType() != ActionType.ADMIN_ACTION)
            throw new NotAdministratorException("Not an administrator! Can not delete all entities!");
        nintendos.clear();
    }

    @Override
    public void delete(int index, Administrator admin) throws InvalidDataException, NotAdministratorException {
        if (admin.getActionType() != ActionType.ADMIN_ACTION)
            throw new NotAdministratorException("Not an administrator! Can not delete the entity with a given index!");
        if (index < 0 || index > nintendos.size())
            throw new InvalidDataException("Indexul este invalid!");
        // to do...
    }
    /* ----- END of Administrator privilege actions ----- */

    @Override
    public void printAllRepository() {
        for (Nintendo nintendo : this.nintendos)
            nintendo.printProduct();
    }
}
