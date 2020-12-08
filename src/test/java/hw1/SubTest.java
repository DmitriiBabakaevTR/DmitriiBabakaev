package hw1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SubTest extends AbstractCalcTest {

    @DataProvider
    public Object[][] SubDataTest() {
        return new Object[][]{
                {3, 2, 1},
                {1, 2, -1},
                {-1, -2, 1},
                {-1, 3, -4},
                {0, -1, 1}
        };
    }

    @Test(dataProvider = "SubDataTest")
    public void dataProviderSubTest(long a, long b, long expected) {
        double actual = calculator.sub(a, b);
        assertEquals(actual, expected);

    }
}
