package hw1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class MultiTest extends AbstractCalcTest {

    @DataProvider
    public Object[][] MultiDataTest(){
        return new Object[][]{
                {1, 2, 2},
                {0, 2, 0},
                {-1, 0, 0},
                {-1, -3, 3},
                {4, -2, -8}
        };
    }

    @Test(dataProvider="MultiDataTest")
    public void dataProviderMultiTest(long a, long b, long expected){

        double actual = calculator.mult(a,b);
        assertEquals(actual,expected);
    }
}

