package hw1.calculatorTest;

import hw1.dataProviders.MultiDataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class MultiTest extends AbstractCalcTest {

    @Test(dataProvider="MultiDataTest", dataProviderClass = MultiDataProvider.class)
    public void dataProviderMultiTest(long a, long b, long expected){
        double actual = calculator.mult(a,b);
        assertEquals(actual,expected);
    }
}

