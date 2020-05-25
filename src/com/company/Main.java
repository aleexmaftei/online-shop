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
        Scanner sc = new Scanner(System.in);
        int actionOption;
        boolean actionCondition = true;
        while (actionCondition) {
            System.out.println("\nPentru a iesi, apasati orice NU este din intervalul dat!");
            System.out.println("Alegeti o optiune:");
            System.out.println("1) Actiuni pentru bere;");
            System.out.println("2) Actiuni pentru vodka;");
            System.out.println("3) Actiuni pentru vin;");
            System.out.println("--------------------------------------");
            System.out.println("4) Actiuni pentru apa;");


            actionOption = sc.nextInt();

            switch (actionOption) {
                default:
                    actionCondition = false;
                    System.out.println("Programul s-a incheiat!");
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
            System.out.println("\nPentru a iesi, apasati orice NU este din intervalul dat!");
            System.out.println("1) Adaugati o bere;");
            System.out.println("2) Stergeti o bere;");
            System.out.println("3) Cautati o bere;");
            System.out.println("4) Cautati o bere dupa nume;");
            System.out.println("5) Updatati o bere cu una introdusa de la tastatura;");

            productOption = sc2.nextInt();

            switch (productOption) {
                default:
                    productCondition = false;
                    System.out.println("Actiunile pe produse s-au incheiat!");
                    break;
                case 1:
                    Beer beerToSave = beerService.save(12, 12.5, "nume1", "franta1", "ingrediente 1, ingrediente 2");
                    Beer beerToSave2 = beerService.save(12, 12.5, "nume2", "franta1", "ingrediente 1, ingrediente 2");
                    break;
                case 2:
                    Beer beerToDelete = beerService.findName("nume2");
                    beerService.delete(beerToDelete);
                    break;
                case 3:
                    Beer beerFind = beerService.find(12, 12.5, "nume1", "franta1", "ingrediente 1, ingrediente 2");
                    System.out.println(beerFind);
                    break;
                case 4:
                    Beer beerFindName = beerService.findName("nume1");
                    System.out.println(beerFindName);
                    break;
                case 5:
                    Beer beerUpdate = new Beer(1234, 23.5, "nume3", "franta1", "ingrediente 1, ingrediente 2, ingrediente 3");
                    Beer oldBeer = beerService.findName("nume1");
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
            System.out.println("\nPentru a iesi, apasati orice NU este din intervalul dat!");
            System.out.println("1) Adaugati o vodka;");
            System.out.println("2) Stergeti o vodka;");
            System.out.println("3) Cautati o vodka;");
            System.out.println("4) Cautati o vodka dupa nume;");
            System.out.println("5) Updatati o vodka cu una introdusa de la tastatura;");

            productOption = sc2.nextInt();

            switch (productOption) {
                default:
                    productCondition = false;
                    System.out.println("Actiunile pe produse s-au incheiat!");
                    break;
                case 1:
                    Vodka vodkaToSave = vodkaService.save(12, 12.5, "nume1", "franta1", "ingrediente 1, ingrediente 2");
                    Vodka vodkaToSave2 = vodkaService.save(12, 12.5, "nume1", "franta1", "ingrediente 1, ingrediente 2");
                    break;
                case 2:
                    Vodka vodkaToDelete = vodkaService.findName("nume1");
                    vodkaService.delete(vodkaToDelete);
                    break;
                case 3:
                    Vodka vodkaFind = vodkaService.find(12, 12.5, "nume1", "franta1", "ingrediente 1, ingrediente 2");
                    System.out.println(vodkaFind);
                    break;
                case 4:
                    Vodka vodkaFindName = vodkaService.findName("nume1");
                    System.out.println(vodkaFindName);
                    break;
                case 5:
                    Vodka vodkaUpdate = new Vodka(1234, 23.5, "nume3", "franta1", "ingrediente 1, ingrediente 2, ingrediente 3");
                    Vodka oldVodka = vodkaService.findName("nume1");
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
            System.out.println("\nPentru a iesi, apasati orice NU este din intervalul dat!");
            System.out.println("1) Adaugati un vin;");
            System.out.println("2) Stergeti un vin dupa nume;");
            System.out.println("3) Cautati un vin;");
            System.out.println("4) Cautati un vin dupa nume;");
            System.out.println("5) Updatati un vin cu unul introdus de la tastatura;");

            productOption = sc2.nextInt();

            switch (productOption) {
                default:
                    productCondition = false;
                    System.out.println("Actiunile pe produse s-au incheiat!");
                    break;
                case 1:
                    Wine wineToSave = wineService.save(12, 12.5, "nume1", "franta1", "ingrediente 1, ingrediente 2");
                    Wine wineToSave2 = wineService.save(12, 12.5, "nume1", "franta1", "ingrediente 1, ingrediente 2");
                    break;
                case 2:
                    Wine wineToDelete = wineService.findName("nume1");
                    wineService.delete(wineToDelete);
                    break;
                case 3:
                    Wine wineFind = wineService.find(12, 12.5, "nume1", "franta1", "ingrediente 1, ingrediente 2");
                    System.out.println(wineFind);
                    break;
                case 4:
                    Wine wineFindName = wineService.findName("nume1");
                    System.out.println(wineFindName);
                    break;
                case 5:
                    Wine wineUpdate = new Wine(1234, 23.5, "nume3", "franta1", "ingrediente 1, ingrediente 2, ingrediente 3");
                    Wine oldWine = wineService.findName("nume1");
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
            System.out.println("\nPentru a iesi, apasati orice NU este din intervalul dat!");
            System.out.println("1) Adaugati o apa;");
            System.out.println("2) Stergeti o apa dupa nume;");
            System.out.println("3) Cautati o apa;");
            System.out.println("4) Cautati o apa dupa nume;");
            System.out.println("5) Updatati o apa cu una introdusa de la tastatura;");

            productOption = sc2.nextInt();

            switch (productOption) {
                default:
                    productCondition = false;
                    System.out.println("Actiunile pe produse s-au incheiat!");
                    break;
                case 1:
                    Water waterToSave = waterService.save(12.0, "nume1", "franta1");
                    Water waterToSave2 = waterService.save(22.0, "nume2", "franta2");
                    break;
                case 2:
                    Water waterToDelete = waterService.findName("nume1");
                    waterService.delete(waterToDelete);
                    break;
                case 3:
                    Water waterFind = waterService.find(12.0, "nume1", "franta1");
                    System.out.println(waterFind);
                    break;
                case 4:
                    Water waterFindName = waterService.findName("nume1");
                    System.out.println(waterFindName);
                    break;
                case 5:
                    Water waterUpdate = new Water(2.0, "nume3", "franta3");
                    Water oldWine = waterService.findName("nume1");
                    waterService.update(oldWine, waterUpdate);
                    break;
            }
        }
    }
}