package hw1.CalculatorTest;

import hw1.dataProviders.DivDataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class DivTest extends AbstractCalcTest {

    @Test(dataProvider="DivDataTest", dataProviderClass = DivDataProvider.class)
    public void dataProviderDivTest(long a, long b, long expected){
        double actual = calculator.div(a,b);
        assertEquals(actual,expected);
    }
}
