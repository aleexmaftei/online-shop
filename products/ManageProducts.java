package products;

import products.alcohol.AlcoholType;
import products.alcohol.Wine;
import products.alcohol.Beer;
import products.alcohol.Vodka;
import products.gaming_consoles.ConsoleType;
import products.gaming_consoles.Nintendo;
import products.gaming_consoles.Playstation;
import products.gaming_consoles.Xbox;
import products.non_alcohol.NonAlcoholType;
import products.non_alcohol.Soda;
import products.non_alcohol.Water;

import java.util.*;

public final class ManageProducts
{
    private List<Wine> wines = new LinkedList<>();
    private List<Beer> beers = new LinkedList<>();
    private List<Vodka> vodkas = new LinkedList<>();

    /* map usage for unique ids for products */
    private Map<String, Nintendo> nintendos = new HashMap<>();
    private Map<String, Playstation> playstations = new HashMap<>();
    private Map<String, Xbox> xboxes = new HashMap<>();

    /*
    *  Soda si Water sunt sortata dupa pret
    *  In clasa NonAlcoholType apare implementarea pentru sortare
    * */
    private List<Soda> sodas = new LinkedList<>();
    private List<Water> waters = new LinkedList<>();

    /* urmeaza sa fie puse ca functii generice */
    /* for wines */
    private void addWine(Integer alcoholPercentage, Double price, String producer, String originCountry, String ingredients)
    {
        Wine oneWine = new Wine(alcoholPercentage, price, producer, originCountry, ingredients);
        this.wines.add(oneWine);
    }

    /* for beer */
    private void addBeer(Integer alcoholPercentage, Double price, String producer, String originCountry, String ingredients)
    {
        Beer oneBeer = new Beer(alcoholPercentage, price, producer, originCountry, ingredients);
        this.beers.add(oneBeer);
    }

    /* for vodka */
    private void addVodka(Integer alcoholPercentage, Double price, String producer, String originCountry, String ingredients)
    {
        Vodka oneVodka = new Vodka(alcoholPercentage, price, producer, originCountry, ingredients);
        this.vodkas.add(oneVodka);
    }

    /* for Nintendo */
    private void addNintendo(Double price, String producer, String originCountry, String productionYear)
    {
        Nintendo oneNintendo = new Nintendo(price, producer, originCountry, productionYear);
        this.nintendos.put(oneNintendo.getId(), oneNintendo);
    }

    /* for playstation */
    private void addPlaystation(Double price, String producer, String originCountry, String productionYear)
    {
        Playstation onePlaystation = new Playstation(price, producer, originCountry, productionYear);
        this.playstations.put(onePlaystation.getId(), onePlaystation);
    }

    /* for Xbox */
    private void addXbox(Double price, String producer, String originCountry, String productionYear)
    {
        Xbox oneXbox = new Xbox(price, producer, originCountry, productionYear);
        this.xboxes.put(oneXbox.getId(), oneXbox);
    }

    /* for soda */
    private void addSoda(Double price, String producer, String originCountry, String ingredients)
    {
        Soda oneSoda = new Soda(price, producer, originCountry, ingredients);
        this.sodas.add(oneSoda);
    }

    /* for water */
    private void addWater(Double price, String producer, String originCountry)
    {
        Water oneWater = new Water(price, producer, originCountry);
        this.waters.add(oneWater);
    }

    /* function that adds with a given type of alcohol */
    private <T extends AlcoholType> void add(T alcoholType)
    {
        if(alcoholType == null)
            System.out.println("Nu s-a putut adauga!");
        else
        {
            if(alcoholType instanceof Wine)
                addWine(alcoholType.getAlcoholPercentage(), alcoholType.getPrice(), alcoholType.getProducer(),
                        alcoholType.getOriginCountry(), alcoholType.getIngredients());

            if(alcoholType instanceof Beer)
                addBeer(alcoholType.getAlcoholPercentage(), alcoholType.getPrice(), alcoholType.getProducer(),
                        alcoholType.getOriginCountry(), alcoholType.getIngredients());

            if(alcoholType instanceof Vodka)
                addVodka(alcoholType.getAlcoholPercentage(), alcoholType.getPrice(), alcoholType.getProducer(),
                        alcoholType.getOriginCountry(), alcoholType.getIngredients());
        }
    }


    private <T extends ConsoleType> void add(T consoleType)
    {
        if(consoleType == null)
            System.out.println("Nu s-a putut adauga!");
        else
        {
            if(consoleType instanceof Nintendo)
                addNintendo(consoleType.getPrice(), consoleType.getProducer(), consoleType.getOriginCountry(), consoleType.getIngredients());

            if(consoleType instanceof Playstation)
                addPlaystation(consoleType.getPrice(), consoleType.getProducer(), consoleType.getOriginCountry(), consoleType.getIngredients());

            if(consoleType instanceof Xbox)
                addXbox(consoleType.getPrice(), consoleType.getProducer(), consoleType.getOriginCountry(), consoleType.getIngredients());
        }
    }

    private <T extends NonAlcoholType> void add(T type)
    {
        if(type == null)
            System.out.println("Nu s-a putut adauga!");
        else
        {
            if(type instanceof Soda)
                addSoda(type.getPrice(), type.getProducer(), type.getOriginCountry(), type.getIngredients());

            if(type instanceof Water)
                addWater(type.getPrice(), type.getProducer(), type.getOriginCountry());
        }
    }

    /* to add multiple types of drinks */
    private void addMultiple()
    {
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

        /* aici o sa fie un for care adauga cate de un tip vor fi printate in functie de cantitatea pe care o are in fisierul CSV*/
        add(oneWine);
        add(oneBeer);
        add(oneVodka);

        add(oneNintendo);
        add(onePlaystation);
        add(oneXbox);

        add(oneWater);

        /* astea sunt in ordinea initiala introduse ca 2, 1, 3 (la producer se poate observa mai usor) si vor fi sortate dupa pret */
        add(oneSoda2);
        add(oneSoda);
        add(oneSoda3);
        Collections.sort(sodas);

    }

    /* function to print all */
    public void manageProducts()
    {
        addMultiple();

        System.out.println("Alcohol\n--------------------");
        for (Wine wine : this.wines)
            wine.printProduct();

        System.out.println("--------------------");
        for(Beer beer: this.beers)
            beer.printProduct();

        System.out.println("--------------------");
        for(Vodka vodka: this.vodkas)
            vodka.printProduct();

        System.out.println("\nGaming consoles\n--------------------");
        nintendos.forEach( (id, nintendo) -> { System.out.println("Unique id: " + id); nintendo.printProduct(); } );

        System.out.println();
        playstations.forEach( (id, playstations) -> { System.out.println("Unique id: " + id); playstations.printProduct(); } );

        System.out.println();
        xboxes.forEach( (id, xboxes) -> { System.out.println("Unique id: " + id); xboxes.printProduct(); } );

        System.out.println("\nNon-Alcoholic\n--------------------");
        for(Soda soda: this.sodas)
            soda.printProduct();

        System.out.println();
        for(Water water: this.waters)
            water.printProduct();
    }
}
