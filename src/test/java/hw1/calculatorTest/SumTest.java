package hw1.calculatorTest;

import hw1.dataProviders.SumDataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class SumTest extends AbstractCalcTest {

    @Test(dataProvider="SumDataTest", dataProviderClass = SumDataProvider.class)
    public void dataProviderSumTest(double a, double b, double expected){
        double actual = calculator.sum(a,b);
        assertEquals(actual,expected,0.00001);
    }
}
