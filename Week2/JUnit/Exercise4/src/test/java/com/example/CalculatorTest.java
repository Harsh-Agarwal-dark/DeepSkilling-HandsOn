package com.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator calculator;


    @Before
    public void setUp() {
        calculator = new Calculator();
        System.out.println("Before each test: Calculator created.");
    }


    @After
    public void tearDown() {
        calculator = null;
        System.out.println("After each test: Calculator cleared.");
    }

    @Test
    public void testAddition() {

        int result = calculator.add(3, 2);
        
        assertEquals(5, result);
    }

    @Test
    public void testSubtraction() {
        int result = calculator.subtract(10, 4);
        assertEquals(6, result);
    }
}
