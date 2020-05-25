package com.company;

import domain.products.alcohol.Beer;
import domain.products.alcohol.Vodka;
import domain.products.alcohol.Wine;
import domain.products.non_alcohol.Water;
import service.database_service.alcohol_database_service.BeerService;
import service.database_service.alcohol_database_service.VodkaService;
import service.database_service.alcohol_database_service.WineService;
import service.database_service.non_alcohol_database_service.WaterService;

import java.util.Scanner;

public class Main {

    private static final BeerService beerService = BeerService.getInstance();
    private static final VodkaService vodkaService = VodkaService.getInstance();
    private static final WineService wineService = WineService.getInstance();
    private static final WaterService waterService = WaterService.getInstance();

    public static void main(String[] args) {

        // for testing
        Beer beerToSave = beerService.save(12, 12.5, "bere1", "franta1", "ingrediente 1, ingrediente 2");
        Beer beerToSave2 = beerService.save(13, 5.5, "bere2", "franta2", "ingrediente 1, ingrediente 2");
        Vodka vodkaToSave = vodkaService.save(66, 50.5, "vodka1", "franta1", "ingrediente 1, ingrediente 2");
        Vodka vodkaToSave2 = vodkaService.save(46, 18.5, "vodka", "franta1", "ingrediente 1, ingrediente 2");
        Water waterToSave = waterService.save(12.0, "apa1", "franta1");
        Water waterToSave2 = waterService.save(22.0, "apa2", "franta2");

        Scanner sc = new Scanner(System.in);
        int actionOption;
        boolean actionCondition = true;
        while (actionCondition) {
            System.out.println("\nSelect a number between 1-4!!");
            System.out.println("1) Beer actions;");
            System.out.println("2) Vodka actions;");
            System.out.println("3) Wine actions;");
            System.out.println("--------------------------------------");
            System.out.println("4) Water actions;");


            actionOption = sc.nextInt();

            switch (actionOption) {
                default:
                    actionCondition = false;
                    System.out.println("Program has ended!");
                    break;
                case 1:
                    beerActions();
                    break;
                case 2:
                    vodkaActions();
                    break;
                case 3:
                    wineActions();
                    break;
                case 4:
                    waterActions();
                    break;
            }
        }
        sc.close();
    }

    private static void beerActions() {
        Scanner sc2 = new Scanner(System.in);
        int productOption;
        boolean productCondition = true;
        while (productCondition) {
            System.out.println("\nSelect a number between 1-5!");
            System.out.println("1) Add a beer;");
            System.out.println("2) Delete a beer;");
            System.out.println("3) Search a beer;");
            System.out.println("4) Search a beer by name;");
            System.out.println("5) Update a beer;");

            productOption = sc2.nextInt();

            switch (productOption) {
                default:
                    productCondition = false;
                    System.out.println("Actions for products ended!");
                    break;
                case 1:
                    System.out.println("Add beer from console");
                    System.out.print("Alcohol percentage: ");
                    Integer alcoholPercentage = sc2.nextInt();

                    System.out.print("\nPrice: ");
                    Double price = sc2.nextDouble();

                    sc2.nextLine();

                    System.out.print("\nName: ");
                    String name = sc2.nextLine();

                    System.out.print("\nOrigin country: ");
                    String originCountry = sc2.nextLine();

                    System.out.print("\nIngredients: ");
                    String ingredients = sc2.nextLine();

                    Beer toSave = beerService.save(alcoholPercentage, price, name, originCountry, ingredients);
                    break;
                case 2:
                    System.out.print("\nName to delete: ");
                    String nameDel = sc2.nextLine();

                    Beer beerToDelete = beerService.findName(nameDel);
                    beerService.delete(beerToDelete);
                    break;
                case 3:
                    Beer beerFind = beerService.find(12, 12.5, "bere1", "franta1", "ingrediente 1, ingrediente 2");
                    System.out.println(beerFind);
                    break;
                case 4:
                    System.out.print("\nName to find: ");
                    String nameFind = sc2.nextLine();

                    Beer beerFindName = beerService.findName(nameFind);
                    System.out.println(beerFindName);
                    break;
                case 5:
                    Beer beerUpdate = new Beer(1234, 23.5, "bere3", "franta1", "ingrediente 1, ingrediente 2, ingrediente 3");
                    Beer oldBeer = beerService.findName("bere1");
                    beerService.update(oldBeer, beerUpdate);
                    break;
            }
        }
    }

    private static void vodkaActions() {
        Scanner sc2 = new Scanner(System.in);
        int productOption;
        boolean productCondition = true;
        while (productCondition) {
            System.out.println("\nSelect a number between 1-5!");
            System.out.println("1) Add a vodka;");
            System.out.println("2) Delete a vodka;");
            System.out.println("3) Search a vodka;");
            System.out.println("4) Search a vodka by name;");
            System.out.println("5) Updated a vodka;");

            productOption = sc2.nextInt();

            switch (productOption) {
                default:
                    productCondition = false;
                    System.out.println("Actions for products ended!");
                    break;
                case 1:
                    System.out.println("Add vodka from console");
                    System.out.print("Alcohol percentage: ");
                    Integer alcoholPercentage = sc2.nextInt();

                    System.out.print("\nPrice: ");
                    Double price = sc2.nextDouble();

                    sc2.nextLine();

                    System.out.print("\nName: ");
                    String name = sc2.nextLine();

                    System.out.print("\nOrigin country: ");
                    String originCountry = sc2.nextLine();

                    System.out.print("\nIngredients: ");
                    String ingredients = sc2.nextLine();

                    Vodka toSave = vodkaService.save(alcoholPercentage, price, name, originCountry, ingredients);
                    break;
                case 2:
                    System.out.print("\nName to delete: ");
                    String nameDel = sc2.nextLine();

                    Vodka vodkaToDelete = vodkaService.findName(nameDel);
                    vodkaService.delete(vodkaToDelete);
                    break;
                case 3:
                    Vodka vodkaFind = vodkaService.find(12, 12.5, "vodka1", "franta1", "ingrediente 1, ingrediente 2");
                    System.out.println(vodkaFind);
                    break;
                case 4:
                    System.out.print("\nName to find: ");
                    String nameFind = sc2.nextLine();

                    Vodka vodkaFindName = vodkaService.findName(nameFind);
                    System.out.println(vodkaFindName);
                    break;
                case 5:
                    Vodka vodkaUpdate = new Vodka(1234, 23.5, "vodka3", "franta1", "ingrediente 1, ingrediente 2, ingrediente 3");
                    Vodka oldVodka = vodkaService.findName("vodka1");
                    vodkaService.update(oldVodka, vodkaUpdate);
                    break;
            }
        }
    }

    private static void wineActions() {
        Scanner sc2 = new Scanner(System.in);
        int productOption;
        boolean productCondition = true;
        while (productCondition) {
            System.out.println("\nSelect a number between 1-5!");
            System.out.println("1) Add a wine;");
            System.out.println("2) Delete a wine;");
            System.out.println("3) Search a wine;");
            System.out.println("4) Search a wine by name;");
            System.out.println("5) Update a wine;");

            productOption = sc2.nextInt();

            switch (productOption) {
                default:
                    productCondition = false;
                    System.out.println("Actions for products ended!");
                    break;
                case 1:
                    System.out.println("Add beer from console");
                    System.out.print("Alcohol percentage: ");
                    Integer alcoholPercentage = sc2.nextInt();

                    System.out.print("\nPrice: ");
                    Double price = sc2.nextDouble();

                    sc2.nextLine();

                    System.out.print("\nName: ");
                    String name = sc2.nextLine();

                    System.out.print("\nOrigin country: ");
                    String originCountry = sc2.nextLine();

                    System.out.print("\nIngredients: ");
                    String ingredients = sc2.nextLine();

                    Wine toSave = wineService.save(alcoholPercentage, price, name, originCountry, ingredients);
                    break;
                case 2:
                    System.out.print("\nName to delete: ");
                    String nameDel = sc2.nextLine();

                    Wine wineToDelete = wineService.findName(nameDel);
                    wineService.delete(wineToDelete);
                    break;
                case 3:
                    Wine wineFind = wineService.find(12, 12.5, "vin1", "franta1", "ingrediente 1, ingrediente 2");
                    System.out.println(wineFind);
                    break;
                case 4:
                    System.out.print("\nName to find: ");
                    String nameFind = sc2.nextLine();

                    Wine wineFindName = wineService.findName(nameFind);
                    System.out.println(wineFindName);
                    break;
                case 5:
                    Wine wineUpdate = new Wine(1234, 23.5, "vin3", "franta1", "ingrediente 1, ingrediente 2, ingrediente 3");
                    Wine oldWine = wineService.findName("vin1");
                    wineService.update(oldWine, wineUpdate);
                    break;
            }
        }
    }

    private static void waterActions() {
        Scanner sc2 = new Scanner(System.in);
        int productOption;
        boolean productCondition = true;
        while (productCondition) {
            System.out.println("\nSelect a number between 1-5!");
            System.out.println("1) Add a water;");
            System.out.println("2) Detele a water by name;");
            System.out.println("3) Search a water;");
            System.out.println("4) Search a water by name;");
            System.out.println("5) Update a water;");

            productOption = sc2.nextInt();

            switch (productOption) {
                default:
                    productCondition = false;
                    System.out.println("Actions for products ended!");
                    break;
                case 1:
                    System.out.println("Add water from console");

                    System.out.print("\nPrice: ");
                    Double price = sc2.nextDouble();

                    sc2.nextLine();

                    System.out.print("\nName: ");
                    String name = sc2.nextLine();

                    System.out.print("\nOrigin country: ");
                    String originCountry = sc2.nextLine();

                    Water toSave = waterService.save(price, name, originCountry);
                    break;
                case 2:
                    System.out.print("\nName to delete: ");
                    String nameDel = sc2.nextLine();

                    Water waterToDelete = waterService.findName(nameDel);
                    waterService.delete(waterToDelete);
                    break;
                case 3:
                    Water waterFind = waterService.find(12.0, "apa1", "franta1");
                    System.out.println(waterFind);
                    break;
                case 4:
                    System.out.print("\nName to find: ");
                    String nameFind = sc2.nextLine();

                    Water waterFindName = waterService.findName(nameFind);
                    System.out.println(waterFindName);
                    break;
                case 5:
                    Water waterUpdate = new Water(100.0, "apa3", "franta3");
                    Water oldWine = waterService.findName("apa1");
                    waterService.update(oldWine, waterUpdate);
                    break;
            }
        }
    }
}