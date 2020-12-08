package hw1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class DivTest extends AbstractCalcTest{

    @DataProvider
    public Object[][] DivDataTest(){
        return new Object[][]{
                {4, 2, 2},
                {-4, 2, -2},
                {4, -2, -2},

        };
    }

    @Test(dataProvider="DivDataTest")
    public void dataProviderDivTest(long a, long b, long expected){
        double actual = calculator.div(a,b);
        assertEquals(actual,expected);
    }
}
