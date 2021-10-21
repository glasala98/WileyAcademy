package com.sg.foundations.random;
import java.util.Random;

public class ALittleChaos {
    public static void main(String[] args) {

        Random randomizer = new Random();

        System.out.println("Random can make integers: " + randomizer.nextInt());
        System.out.println("Or a double: " + randomizer.nextDouble());
        System.out.println("Or even a boolean: " + randomizer.nextBoolean());

        int num = randomizer.nextInt(105);

        System.out.println("You can store a randomized result: " + num);
        System.out.println("And use it over and over again: " + num + ", " + num);

        System.out.println("Or just keep generating new values");
        System.out.println("Here's a bunch of numbers from 0 - 100: ");

        System.out.print(randomizer.nextInt(101) + ", "); // Plus 50 makes a massive number
        System.out.print(randomizer.nextInt(101) + ", ");
        System.out.print(randomizer.nextInt(101) + ", ");
        System.out.print(randomizer.nextInt(101) + ", ");
        System.out.print(randomizer.nextInt(101) + ", ");
        System.out.println(randomizer.nextInt(101));

        //use in math statement, YOU CAN
        int randsum = randomizer.nextInt(101) + randomizer.nextInt(101);
        System.out.println(randsum);
    }
}

/**
 * Random can make integers: -82514924
 * Or a double: 0.10702463389628247
 * Or even a boolean: false
 * You can store a randomized result: 25
 * And use it over and over again: 25, 25
 * Or just keep generating new values
 * Here's a bunch of numbers from 0 - 100:
 * 8910, 35, 58, 100, 27
 *
 *
 * System.out.print(randomizer.nextInt(51) + 50); // Plus 50 makes a massive number
 *         System.out.print(randomizer.nextInt(101) + ", ");
 *         System.out.print(randomizer.nextInt(101) + ", ");
 *         System.out.print(randomizer.nextInt(1) + ", ");
 *         System.out.print(randomizer.nextInt(12) + ", ");
 *         System.out.println(randomizer.nextInt(101));
 * Output
 * Random can make integers: 1685271211
 * Or a double: 0.1350327342685771
 * Or even a boolean: true
 * You can store a randomized result: 90
 * And use it over and over again: 90, 90
 * Or just keep generating new values
 * Here's a bunch of numbers from 0 - 100:
 * 926, 73, 0, 3, 41
 */