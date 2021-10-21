package com.sg.foundations.variables;
import java.util.Scanner;
public class BestAdderEver {
    public static void main(String[] args) {
        String num1,num2,num3;
        float num1flt,num2flt,num3flt,sum;
        Scanner myScanner = new Scanner(System.in);
        // get user input
        System.out.println("Please enter the first number to add:");
        num1 = myScanner.nextLine();
        System.out.println("Please enter the second number to add:");
        num2 = myScanner.nextLine();
        System.out.println("Please enter the third number to add:");
        num3 = myScanner.nextLine();

        num1flt = Float.parseFloat(num1);
        num2flt = Float.parseFloat(num2);
        num3flt = Float.parseFloat(num3);

        System.out.println(num1 + " + " + num2 + " + " + num3);
        sum = num1flt +num2flt +num3flt;
        System.out.println("The sum of the numbers is: "+ sum);
    }
}
