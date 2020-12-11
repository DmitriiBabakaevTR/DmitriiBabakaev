package hw1.calculatorTest;

import hw1.dataProviders.SubDataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class SubTest extends AbstractCalcTest {

    @Test(dataProvider = "SubDataTest", dataProviderClass = SubDataProvider.class)
    public void dataProviderSubTest(long a, long b, long expected) {
        double actual = calculator.sub(a, b);
        assertEquals(actual, expected);
    }
}
