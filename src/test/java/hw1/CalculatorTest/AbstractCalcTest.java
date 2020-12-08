package hw1.CalculatorTest;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public abstract class AbstractCalcTest {

    protected Calculator calculator;

    @BeforeSuite
    public void setUp() {
        calculator = new Calculator();
    }

    @AfterSuite
    public void tearDown() {
        calculator = null;
    }
}
