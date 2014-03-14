package study;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
    private static Calculator calculator = new Calculator();
    
    @Before
    public void setUp() throws Exception {
        calculator.clear();
    }

    @Test
    public void testAdd() {
        calculator.add(2);
        calculator.add(3);
        assertEquals(5, calculator.getResult());
    }

    @Test
    public void testSubstract() {
        calculator.add(3);
        calculator.substract(2);
        assertEquals(1, calculator.getResult());
    }

    @Test
    public void testMultiply() {
        fail("Not yet implemented");
    }

    @Test
    public void testDivide() {
        calculator.add(8);
        calculator.divide(2);
        assertEquals(4, calculator.getResult());
    }

    @Test(expected=ArithmeticException.class)
    public void testDivideByZero() {
        calculator.divide(0);
    }

    @Test
    public void testSquare() {
        calculator.add(2);
        calculator.square(2);
        assertEquals(4, calculator.getResult());
    }

    @Test(timeout=3000)
    public void testSquareRoot() {
        calculator.squareRoot(4);
        assertEquals(2, calculator.getResult());
    }

}
