package hw1.dataProviders;

import org.testng.annotations.DataProvider;

public class SumDataProvider {

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
}
