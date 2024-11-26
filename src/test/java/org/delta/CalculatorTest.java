package org.delta;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void add() {
        Calculator calculator = new Calculator();
        assertEquals(8, calculator.add(5, 3));
        assertEquals(-2, calculator.add(-5, 3));
        assertEquals(0, calculator.add(0, 0));
    }

    @Test
    void sub() {
        Calculator calculator = new Calculator();
        assertEquals(2, calculator.sub(5, 3));
        assertEquals(-8, calculator.sub(-5, 3));
        assertEquals(0, calculator.sub(0, 0));
    }

    @Test
    void mul() {
        Calculator calculator = new Calculator();
        assertEquals(15, calculator.mul(5, 3));
        assertEquals(-15, calculator.mul(-5, 3));
        assertEquals(0, calculator.mul(0, 3));
    }

    @Test
    void div() {
        Calculator calculator = new Calculator();
        assertEquals(2, calculator.div(6, 3));
        assertEquals(-2, calculator.div(-6, 3));
        assertThrows(ArithmeticException.class, () -> calculator.div(1, 0));
    }
}