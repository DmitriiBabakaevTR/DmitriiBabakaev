package hw6;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import hw6.entities.MetalsColors;
import org.testng.annotations.DataProvider;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class JdiDataProvider {

    private static final String filePath = "src/test/resources/hw6/JdiDataSet.json";
    Object[][] objectWithDataProvider;

    @DataProvider
    public Object[][] provideDataSetForMetalColorTest() {

        try {
            ObjectMapper mapper = new ObjectMapper();
            FileInputStream fileInputStream = new FileInputStream(filePath);
            HashMap<String, MetalsColors> map = mapper.readValue(fileInputStream, new TypeReference<HashMap<String, MetalsColors>>() {
                    });
            int i = 0;
            objectWithDataProvider = new Object[map.size()][1];
            for (Map.Entry<String, MetalsColors> entry : map.entrySet()) {
                objectWithDataProvider[i][0] = entry.getValue();
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return objectWithDataProvider;
    }
}