package com.sg.foundations.scanner;
import java.util.Scanner;

public class PassingTheTuringTest {

    public static void main(String[] args) {
        String name,color,food,number;
        Scanner myScanner = new Scanner(System.in);
        float num;
        // get user input
        System.out.println("Hello There!");
        System.out.println("What's you name?");
        name = myScanner.nextLine();
        System.out.println("Hi," + name + "! My name is Gerrid");
        System.out.println("What's your favourite color?");
        color = myScanner.nextLine();
        System.out.println("Ew..." + color + ". Mine is Red a real color");
        System.out.println("I love Mangos, Whats your favourite fruit," + name + "?");
        food = myScanner.nextLine();
        System.out.println("Haha!" + food + " really? My favourite is dragon fruit it is actually good");
        System.out.println("Speaking of favorites, what's your favorite number?");
        number = myScanner.nextLine();
        num = Float.parseFloat(number);
        System.out.println(number + " is a cool number. Mine's 13.");
        System.out.println("Did you know " + number +  " * 13 is " + (num * 13) + "? That's a cool number too!");
        System.out.println("Well, thanks for talking to me," + name + "!");
    }
}
