package hw1.dataProviders;

import org.testng.annotations.DataProvider;

public class MultiDataProvider {

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
}
