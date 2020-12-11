package hw1.dataProviders;

import org.testng.annotations.DataProvider;

public class SubDataProvider {

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
}
