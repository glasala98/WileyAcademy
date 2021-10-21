package com.sg.foundations.flowcontrol.ifs;

import java.util.Scanner;

public class BirthStones {
    public static void main(String[] args) {
        String year;
        int yearInt;
        Scanner myScanner = new Scanner(System.in);
        // get user input
        System.out.println("What month's birthstone do you want to know?");
        year = myScanner.nextLine();
        yearInt = Integer.parseInt(year);
        if(yearInt > 12 || yearInt < 0 ){
            System.out.println("I think you must be confused, "+ yearInt +" doesn't match a month.");
            return;
        }
        if(yearInt == 1){
            System.out.println("January's Birth stone is Garnet!");
        }
        if(yearInt == 2){
            System.out.println("February's Birth stone is Amethyst!");
        }
        if(yearInt == 3){
            System.out.println("March's Birth stone is Aquamarine!");
        }
        if(yearInt == 4){
            System.out.println("April's Birth stone is Diamond!");
        }
        if(yearInt == 5){
            System.out.println("May's Birth stone is Emerald!");
        }
        if(yearInt == 6){
            System.out.println("June's Birth stone is Pearl!");
        }
        if(yearInt == 7){
            System.out.println("July's Birth stone is Ruby!");
        }
        if(yearInt == 8){
            System.out.println("August's Birth stone is Peridot!");
        }
        if(yearInt == 9){
            System.out.println("September's Birth stone is Sapphire!");
        }
        if(yearInt == 10){
            System.out.println("October's Birth stone is Opal!");
        }
        if(yearInt == 11){
            System.out.println("November's Birth stone is Topaz!");
        }
        if(yearInt == 12){
            System.out.println("December's Birth stone is Turquoise!");
        }


    }
}
