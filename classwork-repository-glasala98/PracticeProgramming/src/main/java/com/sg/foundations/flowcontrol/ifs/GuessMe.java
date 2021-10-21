package com.sg.foundations.flowcontrol.ifs;
import java.util.Scanner;

public class GuessMe {
    public static void main(String[] args) {
        String numb;
        int number = 13;
        int num;
        Scanner myScanner = new Scanner(System.in);
        // get user input
        System.out.println("I've Chosen a number i bet you can't guess it!");
        numb = myScanner.nextLine();
        num = Integer.parseInt(numb);
        System.out.println("Your Guess: " + num);
        if(num == number){
            System.out.println("Wow, nice guess! That was it!");
        }
        if(num < number){
            System.out.println("Ha, nice try - too low! I chose " + number);
        }
        if(num > number){
            System.out.println("Too bad, way too high. I chose " + number);
        }
    }
}
