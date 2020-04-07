package service;

import domain.products.alcohol.Beer;
import domain.products.alcohol.Vodka;
import domain.products.alcohol.Wine;
import domain.products.gaming_consoles.Nintendo;
import domain.products.gaming_consoles.Playstation;
import domain.products.gaming_consoles.Xbox;
import domain.products.non_alcohol.Soda;
import domain.products.non_alcohol.Water;
import persistence.alcohol_repository.BeerRepository;
import persistence.alcohol_repository.VodkaRepository;
import persistence.alcohol_repository.WineRepository;
import persistence.gaming_consoles_repository.NintendoRepository;
import persistence.gaming_consoles_repository.PlaystationRepository;
import persistence.gaming_consoles_repository.XboxRepository;
import persistence.non_alcohol_repository.SodaRepository;
import persistence.non_alcohol_repository.WaterRepository;

public final class ManageRepositories {

    BeerRepository beerRepository = new BeerRepository();
    VodkaRepository vodkaRepository = new VodkaRepository();
    WineRepository wineRepository = new WineRepository();

    NintendoRepository nintendoRepository = new NintendoRepository();
    PlaystationRepository playstationRepository = new PlaystationRepository();
    XboxRepository xboxRepository = new XboxRepository();

    SodaRepository sodaRepository = new SodaRepository();
    WaterRepository waterRepository = new WaterRepository();

    public void addProducts() {
        /*
         * aici trebuei citire din fisier CSV sau de undeva in partea a doua a proiectului
         * si vor fi memorate din fisier in functie de ce se citeste, nu asa direct cum fac eu ca exemplu sa
         * vad daca merge
         * */

        Wine oneWine = new Wine(14, 15.5, "S.C Franta", "Franta", "de toate");
        Beer oneBeer = new Beer(8, 16.0, "S.C Franta", "Franta", "de toate");
        Vodka oneVodka = new Vodka(30, 30.0, "S.C Franta", "Franta", "de toate");

        Nintendo oneNintendo = new Nintendo(123.3, "Nintendo Co., Ltd.", "Japan", "2010");
        Playstation onePlaystation = new Playstation(4132.3, " Sony Interactive Entertainment", "Japan", "2011");
        Xbox oneXbox = new Xbox(11323.9, "Microsoft", "America", "2013");

        Water oneWater = new Water(1.0, "Dorna", "da");
        Soda oneSoda = new Soda(2.0, "1", "America", "Chimicale");
        Soda oneSoda2 = new Soda(4.0, "2", "America", "Chimicale");
        Soda oneSoda3 = new Soda(6.0, "3", "America", "Chimicale");

        beerRepository.add(oneBeer);
        wineRepository.add(oneWine);
        vodkaRepository.add(oneVodka);

        nintendoRepository.add(oneNintendo);
        playstationRepository.add(onePlaystation);
        xboxRepository.add(oneXbox);

        waterRepository.add(oneWater);
        sodaRepository.add(oneSoda);
        sodaRepository.add(oneSoda2);
        sodaRepository.add(oneSoda3);

    }

    public void printProducts() {
            sodaRepository.printAllRepository();
    }
}
