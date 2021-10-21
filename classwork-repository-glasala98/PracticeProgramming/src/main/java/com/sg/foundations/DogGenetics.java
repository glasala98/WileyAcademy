package com.sg.foundations;
import java.util.Random;
import java.util.Scanner;

public class DogGenetics {
    public static void main(String[] args) {
        String[] doges = {"Pitbull", "Retriever", "Poodle", "Shi Tzu", "Dachshound", "Greyhound",
                "St. Bernard", "Chihuahua", "Great Dane", "Shiba Inu", "King Doberman", "Pomeranian", "Bulldog", "Rottweiler",
                "Dobermann", "Corgi", "Bernese Mountain Dog", "Newfoundland", "Yorki", "Border Collie", "Boston Terrier", "Dalmatian"};
        Scanner sc = new Scanner(System.in);
        System.out.println("What is your dog's name?");
// Entering name of dog
        String name = sc.nextLine();

        System.out.println("Well then, I have this highly reliable report on " + name + "'s prestigious background right here.");

        System.out.println("\n\nSir " + name + " is\n\n");

//Generating random numbers
        Random ran = new Random();
        int sum = 0;
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        int e = 0;
        while(sum != 100)
        {
            a = ran.nextInt(100);

            b = ran.nextInt(100-a);

            c = ran.nextInt(100-b);

            d = ran.nextInt(100-c);

            e = ran.nextInt(100-d);
            sum = a + b+ c + d + e;
        }
// Random number for dog type
        Random ran2 = new Random();
        int sum2 = 0;
        int a2 = 0;
        String sa2;
        int b2 = 0;
        String sb2;
        int c2 = 0;
        String sc2;
        int d2 = 0;
        String sd2;
        int e2 = 0;
        String se2;

        a2 = ran.nextInt(doges.length);
        sa2 = doges[a2];

        b2 = ran.nextInt(doges.length);
        sb2 = doges[b2];

        c2 = ran.nextInt(doges.length);
        sc2 = doges[c2];

        d2 = ran.nextInt(doges.length);
        sd2 = doges[d2];

        e2 = ran.nextInt(doges.length);
        se2 = doges[e2];

        System.out.println(a + "% " + sa2);
        System.out.println(b + "% " + sb2);
        System.out.println(c + "% " + sc2);
        System.out.println(d + "% " + sd2);
        System.out.println(e + "% " + se2);

        System.out.println("\n\nWow, that's QUITE the dog!");
    }
}
