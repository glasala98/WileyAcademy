package com.sg.foundations.random;

import java.util.Random;

public class FortuneCookie {
    public static void main(String[] args) {
        Random randomizer = new Random();
        System.out.println("Your Geek Fortune:");

        int x = randomizer.nextInt(10);// needs to be bound to 6 to access 5


        switch (x) {
            case 0:
                System.out.println("Those aren't the droids you're looking for.");
                break;
            case 1:
                System.out.println("Never go in against a Sicilian when death is on the line!");
                break;
            case 2:
                System.out.println("Goonies never say die");
                break;
            case 3:
                System.out.println("With great power, there must also come — great responsibility");
                break;
            case 4:
                System.out.println("Never argue with the data.");
                break;
            case 6:
                System.out.println("Try not. Do, or do not. There is no try.");
                break;
            case 7:
                System.out.println("You are a leaf on the wind, watch how you soar.");
                break;
            case 8:
                System.out.println("Poopy-di scoop\n" +
                        "Scoop-diddy-whoop\n" +
                        "Whoop-di-scoop-di-poop\n" +
                        "Poop-di-scoopty\n" +
                        "Scoopty-whoop\n" +
                        "Whoopity-scoop, whoop-poop\n" +
                        "Poop-diddy, whoop-scoop\n" +
                        "Poop, poop\n" +
                        "Scoop-diddy-whoop\n" +
                        "Whoop-diddy-scoop\n" +
                        "Whoop-diddy-scoop, poop");
                break;
            case 9:
                System.out.println("Chuba chuba chuba chuba chuba chuba chubby. I don't have any lines to go right here, so chuby Teletubby");
                break;
        }

        System.out.println("Thanks Random, maybe YOU'RE the best!");
    }
}
