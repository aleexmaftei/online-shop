package persistence.non_alcohol_repository;

import domain.products.non_alcohol.Soda;
import exceptions.InvalidDataException;
import exceptions.NotAdministratorException;
import file_management.read.ReadFile;
import file_management.read.non_alcohol_reader.SodaReader;
import permits.ActionType;
import permits.Administrator;
import persistence.GenericRepository;

import java.util.LinkedList;
import java.util.List;

public final class SodaRepository implements GenericRepository<Soda> {

    private List<Soda> sodas = new LinkedList<>();

    /* ----- Administrator privilege actions ----- */
//    public void readFromCSV(Administrator admin, ReadFile readFile) throws NotAdministratorException {
//        if (admin.getActionType() != ActionType.ADMIN_ACTION)
//            throw new NotAdministratorException("Not an administrator! Can not add from CSV file!");
//
//        try (Scanner scanner = new Scanner(new File("src/files/database/non_alcohol/sodaCSV"))) {
//            while (scanner.hasNextLine()) {
//                List<String> productFromOneLine;
//                productFromOneLine = readFile.getLine(scanner.nextLine(), admin);
//
//                /* TO DO... de verificat ca sa fie fisierul in formatul corect cu toti parametrii introdusi */
//                Soda oneSoda = new Soda(Double.parseDouble(productFromOneLine.get(0)), productFromOneLine.get(1), productFromOneLine.get(2), productFromOneLine.get(3));
//                add(oneSoda, admin);
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//    }

    public void readFromCSV(Administrator admin, ReadFile readFile) throws NotAdministratorException {
        if (admin.getActionType() != ActionType.ADMIN_ACTION)
            throw new NotAdministratorException("Not an administrator! Can not add from CSV file!");

        SodaReader sodaReader = new SodaReader();
        Soda oneSodaType = new Soda();
        List<List<String>> records = sodaReader.read(admin, readFile, oneSodaType);

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
                } else {
                    param4 = row;
                }
                k++;
            }
            Soda oneSoda = new Soda(param1, param2, param3, param4);
            add(oneSoda, admin);
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
}
