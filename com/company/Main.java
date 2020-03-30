package com.company;

import products.ManageProducts;

import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        ManageProducts products = new ManageProducts();
        Scanner sc = new Scanner(System.in);
        Integer option;
        Boolean condition = true;
        Boolean ok = false;
        while(condition)
        {
            System.out.println("\nPentru a iesi, apasati orice nu este din intervalul dat!");
            System.out.println("Alegeti o optiune:");
            System.out.println("1) Adaugati produse;");
            System.out.println("2) Afisati produsele.");

            option = sc.nextInt();

            switch(option)
            {
                default:
                    condition = false;
                    System.out.println("Programul s-a incheiat!");
                    break;
                case 1:
                    products.addMultiple();
                    ok = true;
                    System.out.println("Produsele au fost adaugate!");
                    break;
                case 2:
                    if(!ok)
                    {
                        System.out.println("Adaugati mai intai produse!");
                        break;
                    }
                    products.manageProducts();
                    break;
            }
        }
    }
}
