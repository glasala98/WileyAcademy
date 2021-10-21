package com.sg.foundations.simplecalc;
import java.util.Scanner;

public class App {
    public static void main(String args[]){
        String input;
        int operation;
        float operand1,operand2;
        Scanner s = new Scanner(System.in);
        SimpleCalculator newOperation =  new SimpleCalculator();
        System.out.println("Welcome to Simple Calc!");
        operation = 0;
        while(operation!= 5 ) {
            System.out.println("What Operation do you wish to perform? Addition = 1, Subtraction = 2, Multiplication = 3 or Division = 4? or 5 to exit!");
            input = s.nextLine();
            try {
                operation = Integer.parseInt(input);
            }
            catch(NumberFormatException e){
                System.out.println("Given value \"" + operation + "\" is not valid try again.");
            }
            if(operation < 1 || operation > 5){
                System.out.println("Provide a valid operation");
                operation = 0;
            }
            switch (operation) {
                case 1:
                    System.out.println("You have selected addition, please input your first operand");
                    try {
                        operand1 = Float.parseFloat(s.nextLine());
                        System.out.println("Now your second");
                        operand2 = Float.parseFloat(s.nextLine());
                        newOperation.addition(operand1, operand2);
                    }
                    catch(NumberFormatException e){
                        System.out.println("Given value \"" + operation + "\" is not valid.");
                    }
                    break;
                case 2:
                    System.out.println("You have selected subtraction, please input your first operand");
                    try {
                        operand1 = Float.parseFloat(s.nextLine());
                        System.out.println("Now your second");
                        operand2 = Float.parseFloat(s.nextLine());
                        newOperation.subtraction(operand1, operand2);
                    }
                    catch(NumberFormatException e){
                        System.out.println("Given value \"" + operation + "\" is not valid.");
                    }
                    break;
                case 3:
                    System.out.println("You have selected multiplication, please input your first operand");
                    try {
                        operand1 = Float.parseFloat(s.nextLine());
                        System.out.println("Now your second");
                        operand2 = Float.parseFloat(s.nextLine());
                        newOperation.multiplication(operand1, operand2);
                    }
                    catch(NumberFormatException e){
                        System.out.println("Given value \"" + operation + "\" is not valid.");
                    }
                    break;
                case 4:
                    try {
                        System.out.println("You have selected division, please input your first operand");
                        operand1 = Float.parseFloat(s.nextLine());
                        System.out.println("Now your second");
                        operand2 = Float.parseFloat(s.nextLine());
                        newOperation.division(operand1, operand2);
                    }
                    catch(NumberFormatException e){
                        System.out.println("Given value \"" + operation + "\" is not valid.");
                    }
                    break;
            }

        }
            System.out.println("Bye!");
            System.exit(0);
    }
}
