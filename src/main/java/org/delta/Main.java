package org.delta;

public class Main {
    public static void main(String[] args) {
        try {
            new App().run();
        } catch (ArithmeticException e) {
            System.out.println("You cant math :(" + e.getMessage());
        } catch (Throwable e) {
            System.out.println("Program ran into an error: " + e.getMessage());
        }
    }
}