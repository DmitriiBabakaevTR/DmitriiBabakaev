package hw1;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import static org.testng.Assert.assertEquals;

public class SumTest extends AbstractCalcTest {

    @DataProvider
    public Object[][] SumDataTest(){
        return new Object[][]{
                {1, 2, 3.0},
                {1.1, 2.2, 3.3},
                {1, 2.1, 3.1},
                {-1, -3, -4},
                {4, -1, 3}
        };
    }

    @Test(dataProvider="SumDataTest")
    public void dataProviderSumTest(double a, double b, double expected){
        double actual = calculator.sum(a,b);
        assertEquals(actual,expected,0.00001);
    }
}
