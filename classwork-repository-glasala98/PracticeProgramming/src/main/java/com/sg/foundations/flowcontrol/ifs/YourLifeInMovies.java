package com.sg.foundations.flowcontrol.ifs;

import java.util.Scanner;

public class YourLifeInMovies {
    public static void main(String[] args) {
        String year,name;
        int yearInt;
        Scanner myScanner = new Scanner(System.in);
        // get user input
        System.out.println("Hey, let's play a game! What's your name?");
        name = myScanner.nextLine();
        System.out.println("Ok, " + name + " ,when were you born?");
        year = myScanner.nextLine();
        yearInt = Integer.parseInt(year);
        System.out.println("Well " + name + "...");
        if(yearInt < 2005){
            System.out.println("Did you know that Pixar's 'Up' came out over a decade ago?");
        }
        if(yearInt < 1995){
            System.out.println("And that the first Harry Potter came out over 15 years ago!");
        }
        if(yearInt < 1985){
            System.out.println("Also, Space Jam came out not last decade, but the one before THAT.");
        }
        if(yearInt < 1975){
            System.out.println(" ... the original Jurassic Park release is closer to the first lunar landing than it is to today");
        }
        if(yearInt < 1965){
            System.out.println(" AND! the MASH TV series has been around for almost half a century!");
        }
    }
}
