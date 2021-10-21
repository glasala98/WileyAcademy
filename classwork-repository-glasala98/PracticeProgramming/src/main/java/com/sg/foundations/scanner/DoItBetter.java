package com.sg.foundations.scanner;

import java.util.Scanner;

public class DoItBetter {
    public static void main(String[] args) {
        String miles,hotdogs,languages;
        Scanner myScanner = new Scanner(System.in);
        int intMiles, intHotdogs, intLangues;
        // get user input
        System.out.println("Hello There! How many miles can you run?");
        miles = myScanner.nextLine();
        intMiles = Integer.parseInt(miles);
        intMiles = intMiles * 2 + 1;
        System.out.println(miles+" wow you have week lungs. I can run " + intMiles);

        System.out.println("How many hotdogs can you eat?");
        hotdogs = myScanner.nextLine();
        intHotdogs = Integer.parseInt(hotdogs);
        intHotdogs = intHotdogs * 2 + 1;
        System.out.println(hotdogs + " That is it??? I can eat "+ intHotdogs);

        System.out.println("How many languages can you speak?");
        languages = myScanner.nextLine();
        intLangues = Integer.parseInt(languages);
        intLangues = intLangues * 2 + 1;
        System.out.println("Haha! " + languages + " really? I can speak " + intLangues + " fluently!");

    }
}
