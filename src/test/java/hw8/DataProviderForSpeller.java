package hw8;

import com.google.gson.Gson;
import hw8.dto.TextDTO;
import hw8.dto.TextsDTO;
import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.stream.IntStream;


public class DataProviderForSpeller {

    private Object[][] resultArrayAfterParsingJson;
    private static final String CheckTextMethodJsonPath = "src/test/resources/hw8/checkTextData.json";
    private static final String CheckTextsMethodJsonPath = "src/test/resources/hw8/checkTextsData.json";

    public Object[][] parseFromJsonToDataProvider(String path) {

        Gson gson = new Gson();
        try {
            if (path.equals(CheckTextMethodJsonPath)) {
                TextDTO[] textDTO = gson.fromJson(new FileReader(path), TextDTO[].class);
                resultArrayAfterParsingJson = new Object[textDTO.length][1];
                IntStream.range(0, textDTO.length).forEach(i -> resultArrayAfterParsingJson[i][0] = textDTO[i]);
            }
            if (path.equals(CheckTextsMethodJsonPath)) {
                TextsDTO[] textsDTO = gson.fromJson(new FileReader(path), TextsDTO[].class);
                resultArrayAfterParsingJson = new Object[textsDTO.length][1];
                IntStream.range(0, textsDTO.length).forEach(i -> resultArrayAfterParsingJson[i][0] = textsDTO[i]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return resultArrayAfterParsingJson;
    }

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
