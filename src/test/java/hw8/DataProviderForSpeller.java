package hw8;

import org.testng.annotations.DataProvider;

public class DataProviderForSpeller extends ParseJsonToDP {

    @DataProvider
    public Object[][] parsingForCheckTextMethod() {

        resultArrayAfterParsingJson = parseFromJsonToDataProvider(CheckTextMethodJsonPath);
        return resultArrayAfterParsingJson;
    }

    @DataProvider
    public Object[][] parsingForCheckTextsMethod() {

        resultArrayAfterParsingJson = parseFromJsonToDataProvider(CheckTextsMethodJsonPath);
        return resultArrayAfterParsingJson;
    }
}
