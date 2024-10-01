package org.delta;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {
    public static void main(String[] args) {
        try {
            Injector injector = Guice.createInjector(new BankModule());
            App app = injector.getInstance(App.class);
            app.run();
        } catch (ArithmeticException e) {
            System.out.println("You cant math :(" + e.getMessage());
        } catch (Throwable e) {
            System.out.println("Program ran into an error: " + e.getMessage());
        }
    }
}