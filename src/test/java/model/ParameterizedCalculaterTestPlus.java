
package model;

import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.ArithmeticException;
import java.util.Arrays;
import java.util.Collection;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value=Parameterized.class)
public class ParameterizedCalculaterTestPlus {
    
    private int a;
    private int b;
    private int r;

    public ParameterizedCalculaterTestPlus(int a, int b, int r) {
        this.a = a;
        this.b = b;
        this.r = r;
    }
  
    @Parameters
    public static Collection<Object[]> generateData()
    {
         Object[][] data = new Object[][]{
             {3,7,10},
             {10,0,10},
             {5,5,10},
             {20,-10,10}
         };
    return Arrays.asList(data);
    }

    @Test
    public void testCalculateMethod() {
       CalculaterMock calc = new CalculaterMock();
       assertEquals(r,calc.calculate(a,b,'+'));
    }

}
