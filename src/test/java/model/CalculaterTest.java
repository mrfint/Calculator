
package model;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import java.lang.ArithmeticException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

public class CalculaterTest {
    private Calculater calc=null;

    @Before
    public void setUp(){
        calc = new Calculater();
    } 
    @Test
    public void testAddMethod() {
       assertTrue(calc.calculate(2,8,'+')==10);
    }
    @Test
    public void testMinMethod() {
       assertTrue(calc.calculate(15,5,'-')==10);
    }
    @Test
    public void testMulMethod() {
       assertTrue(calc.calculate(2,5,'*')==10);
    }
    
    @Test
    public void testDivMethod() {
       assertTrue(calc.calculate(100,10,'/')==10);
    }
    @Test(expected=ArithmeticException.class)
    public void testDivByZeroMethod() {
       calc.calculate(6,0,'/');
        
    }
    @Test(expected=IllegalArgumentException.class)
    public void testUnsupportedMethod() {
       calc.calculate(6,3,'%');
    }
}
