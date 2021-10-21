package com.sg.foundations.scanner;

import java.util.Scanner;

public class HealthyHearts {
    public static void main(String[] args) {
        String age;
        Scanner myScanner = new Scanner(System.in);
        double intage,maxHR,targetHR1, targetHR2, fraction;
        // get user input
        System.out.println("Hello There! What is your age?");
        age = myScanner.nextLine();
        intage = Double.parseDouble(age);
        maxHR = 220 - intage;
        targetHR1 = maxHR * 0.5;
        targetHR2 = maxHR * 0.85;
        System.out.println("Your maximum heart rate should be " + maxHR);
        System.out.println("Your target heart rate zone is " + targetHR1 + " - " + targetHR2 + " beats per minute");
    }
}
