package com.company;

import exceptions.NotAdministratorException;
import file_management.read.ReadFile;
import file_management.write.WriteFile;
import permits.Administrator;
import service.ManageRepositories;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws NotAdministratorException {
        ManageRepositories products = new ManageRepositories();
        Administrator admin = Administrator.getAdminInstance(); // singleton administrator account
        ReadFile fileReader = ReadFile.getReadFileInstance(); // singleton file reader
        WriteFile fileWriter = WriteFile.getWriteFileInstance(); // singleton file writer

        Scanner sc = new Scanner(System.in);
        int option;
        boolean condition = true;
        boolean ok = false;
        while (condition) {
            System.out.println("\nPentru a iesi, apasati orice nu este din intervalul dat!");
            System.out.println("Alegeti o optiune:");
            System.out.println("1) Adaugati produse;");
            System.out.println("2) Afisati produsele.");

            option = sc.nextInt();

            switch (option) {
                default:
                    condition = false;
                    System.out.println("Programul s-a incheiat!");
                    break;
                case 1:
                    products.addProducts(admin, fileReader);
                    ok = true;
                    System.out.println("Produsele au fost adaugate!");
                    break;
                case 2:
                    if (!ok) {
                        System.out.println("Adaugati mai intai produse!");
                        break;
                    }
                    products.printProducts();
                    break;
            }
        }

        sc.close();
    }
}
