package persistence.alcohol_repository;


import domain.products.alcohol.Vodka;
import exceptions.InvalidDataException;
import exceptions.NotAdministratorException;
import file_management.read.ReadFile;
import file_management.read.alcohol_reader.VodkaReader;
import file_management.write.WriteFile;
import file_management.write.alcohol_writer.VodkaWriter;
import permits.ActionType;
import permits.Administrator;
import persistence.GenericRepository;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public final class VodkaRepository implements GenericRepository<Vodka> {

    private List<Vodka> vodkas = new LinkedList<>();

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
//                Vodka oneVodka = new Vodka(Integer.parseInt(productFromOneLine.get(0)), Double.parseDouble(productFromOneLine.get(1)), productFromOneLine.get(2), productFromOneLine.get(3), productFromOneLine.get(4));
//                add(oneVodka, admin);
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//    }

    /* -------- CSV READER -------- */
    public void readFromCSV(Administrator admin, ReadFile readFile) throws NotAdministratorException {
        if (admin.getActionType() != ActionType.ADMIN_ACTION)
            throw new NotAdministratorException("Not an administrator! Can not add from CSV file!");

        VodkaReader vodkaReader = new VodkaReader();
        Vodka oneVodkaType = new Vodka();
        List<List<String>> records = vodkaReader.read(admin, readFile, oneVodkaType);

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
            Vodka oneVodka = new Vodka(param1, param2, param3, param4, param5);
            add(oneVodka, admin);
        }

        WriteFile.writeStampCSV("READ ALL VODKAS FILES FROM CSV", admin);
    }

    /* -------- CSV WRITER -------- */
    public void writeToCSV(Administrator admin, WriteFile writeFile) throws NotAdministratorException {
        if (admin.getActionType() != ActionType.ADMIN_ACTION)
            throw new NotAdministratorException("Not an administrator! Can not add entity!");
        VodkaWriter vodkaWriter = new VodkaWriter();
        vodkaWriter.write(vodkas, admin, writeFile);
    }

    /* -------- TO ADD ONE -------- */
    @Override
    public void add(Vodka entity, Administrator admin) throws NotAdministratorException {
        if (admin.getActionType() != ActionType.ADMIN_ACTION)
            throw new NotAdministratorException("Not an administrator! Can not add entity!");
        Vodka oneVodka = new Vodka(entity.getAlcoholPercentage(), entity.getPrice(), entity.getProducer(), entity.getOriginCountry(), entity.getIngredients());
        this.vodkas.add(oneVodka);

        WriteFile.writeStampCSV("added VODKA", admin);
    }

    /* -------- TO DELETE ALL -------- */
    @Override
    public void delete(Administrator admin) throws NotAdministratorException {
        if (admin.getActionType() != ActionType.ADMIN_ACTION)
            throw new NotAdministratorException("Not an administrator! Can not delete all entities!");
        vodkas.clear();

        WriteFile.writeStampCSV("deleted all vodkas", admin);
    }

    /* -------- TO DELETE WITH A GIVEN INDEX -------- */
    @Override
    public void delete(int index, Administrator admin) throws InvalidDataException, NotAdministratorException {
        if (admin.getActionType() != ActionType.ADMIN_ACTION)
            throw new NotAdministratorException("Not an administrator! Can not delete the entity with a given index!");
        if (index < 0 || index > vodkas.size())
            throw new InvalidDataException("Invalid index!");
        vodkas.remove(index);

        WriteFile.writeStampCSV("deleted index: " + index + " from vodkas", admin);
    }
    /* ----- END of Administrator privilege actions ----- */

    @Override
    public void printAllRepository() {
        for (Vodka vodka : this.vodkas)
            vodka.printProduct();
    }
}
