package service;

import exceptions.NotAdministratorException;
import file_management.read.ReadFile;
import file_management.write.WriteFile;
import permits.ActionType;
import permits.Administrator;
import persistence.alcohol_repository.BeerRepository;
import persistence.alcohol_repository.VodkaRepository;
import persistence.alcohol_repository.WineRepository;
import persistence.gaming_consoles_repository.NintendoRepository;
import persistence.gaming_consoles_repository.PlaystationRepository;
import persistence.gaming_consoles_repository.XboxRepository;
import persistence.non_alcohol_repository.SodaRepository;
import persistence.non_alcohol_repository.WaterRepository;

import java.io.IOException;

public final class ManageRepositories {

    BeerRepository beerRepository = new BeerRepository();
    VodkaRepository vodkaRepository = new VodkaRepository();
    WineRepository wineRepository = new WineRepository();

    NintendoRepository nintendoRepository = new NintendoRepository();
    PlaystationRepository playstationRepository = new PlaystationRepository();
    XboxRepository xboxRepository = new XboxRepository();

    SodaRepository sodaRepository = new SodaRepository();
    WaterRepository waterRepository = new WaterRepository();

    /* ----- Administrator privilege actions ----- */
    // option 1
    public void addProducts(Administrator admin, ReadFile fileReader) throws NotAdministratorException {
        if (admin.getActionType() != ActionType.ADMIN_ACTION)
            throw new NotAdministratorException("Not an administrator! Can not add from CSV file!");

        beerRepository.readFromCSV(admin, fileReader);
        wineRepository.readFromCSV(admin, fileReader);
        vodkaRepository.readFromCSV(admin, fileReader);

        nintendoRepository.readFromCSV(admin, fileReader);
        playstationRepository.readFromCSV(admin, fileReader);
        xboxRepository.readFromCSV(admin, fileReader);

        sodaRepository.readFromCSV(admin, fileReader);
        waterRepository.readFromCSV(admin, fileReader);
    }

    // option 3
    public void updateFilesCSV(Administrator admin, WriteFile fileWriter) throws NotAdministratorException {
        beerRepository.writeToCSV(admin, fileWriter);
        vodkaRepository.writeToCSV(admin, fileWriter);
        wineRepository.writeToCSV(admin, fileWriter);

        // nintendoRepository.writeToCSV(admin, fileWriter);
        // playstationRepository.writeToCSV(admin, fileWriter);
        // xboxRepository.writeToCSV(admin, fileWriter);

        sodaRepository.writeToCSV(admin, fileWriter);
        waterRepository.writeToCSV(admin, fileWriter);
    }
    /* ----- END of Administrator privilege actions ----- */

    // option 2
    public void printProducts() {
        beerRepository.printAllRepository();
        wineRepository.printAllRepository();
        vodkaRepository.printAllRepository();

        System.out.println("-----------------------------");
        nintendoRepository.printAllRepository();
        playstationRepository.printAllRepository();
        xboxRepository.printAllRepository();

        System.out.println("-----------------------------");
        sodaRepository.printAllRepository();
        waterRepository.printAllRepository();
    }
}
