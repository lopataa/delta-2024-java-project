package org.delta;

public class Calculator implements ICalculator {
    public double add(double a, double b) {
        return a + b;
    }

    public double sub(double a, double b) {
        return a - b;
    }

    public double mul(double a, double b) {
        return a * b;
    }

    public double div(double a, double b) {
        if(b == 0) {
            throw new ArithmeticException("fuck you man");
        }
        
        return a / b;
    }


}
