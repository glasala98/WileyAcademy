package com.sg.foundations.variables;

public class AllAboutMe {
    public static void main(String[] args) {

        // You can declare all KINDS of variables.
        String name;
        String favFood;
        int numPets;
        String living;
        boolean whistle;

        name = "Gerrid Jordon La Sala";
        favFood = "Pasta";
        numPets = 1;
        living = "a house";
        whistle = false;


        // But declaring them just sets up the space for data
        // to use the variable, you have to put data IN it first!

        System.out.println("My name is " + name);
        System.out.println("My favorite food is " + favFood);
        System.out.println("I have " + numPets + " pet(s)");
        System.out.println("I live in " + living);
        System.out.println("It is " + whistle + " I don't know how to whistle");

    }
}
