package com.sg.foundations.scanner;

import java.util.Scanner;

public class MiniMadLibs {
    public static void main(String[] args) {
        String noun,adjective,noun2,number,adjective2,pluralnoun,pluralnoun2,pluralnoun3,presentVer,pastVerb;
        Scanner myScanner = new Scanner(System.in);
        // get user input
        System.out.println("I need a noun:");
        noun = myScanner.nextLine();
        System.out.println("Now a adjective:");
        adjective = myScanner.nextLine();
        System.out.println("Another noun:");
        noun2 = myScanner.nextLine();
        System.out.println("And A number:");
        number = myScanner.nextLine();
        System.out.println("Another Adjective:");
        adjective2 = myScanner.nextLine();
        System.out.println("A plural noun:");
        pluralnoun = myScanner.nextLine();
        System.out.println("Another one:");
        pluralnoun2 = myScanner.nextLine();
        System.out.println("One more:");
        pluralnoun3 = myScanner.nextLine();
        System.out.println("A present tense verb:");
        presentVer = myScanner.nextLine();
        System.out.println("A past tense verb:");
        pastVerb = myScanner.nextLine();

        System.out.println("*** NOW LETS GET MAD (libs)");
        System.out.println(noun + " the " + adjective + " frontier. These are the voyages of the ship " + noun2 + " Its " + number + "-year mission: to explore strange "+ adjective2 + " " +  pluralnoun + ", to seek out " + adjective2 + " " + pluralnoun2 + " and " + adjective2 + " " + pluralnoun3 + " to boldly " + presentVer + " where no one has " + pastVerb + " before." );
    }
}
