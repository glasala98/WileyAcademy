package com.sg.foundations.simplecalc;

public class SimpleCalculator {
    private float sum,difference,product,quotient;

    public SimpleCalculator() {
    }

    public void addition(float x, float y){
        sum = x + y;
        System.out.println("The sum of the two numbers is: " + sum);
    }

    public void subtraction(float x, float y){
        difference = x - y;
        System.out.println("The difference of the two numbers is: " + difference);
    }

    public void multiplication(float x, float y){
        product = x * y;
        System.out.println("The product of the two numbers is: " + product);
    }

    public void division(float x, float y){
        quotient = x / y;
        System.out.println("The sum of the two numbers is: " + quotient);
    }
}
