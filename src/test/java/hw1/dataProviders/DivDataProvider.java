package hw1.dataProviders;

import org.testng.annotations.DataProvider;

public class DivDataProvider {

    @DataProvider
    public Object[][] DivDataTest(){
        return new Object[][]{
                {4, 2, 2},
                {-4, 2, -2},
                {4, -2, -2},
        };
    }
}
