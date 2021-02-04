package hw8.services;

import hw8.dto.ResponseDTO;
import hw8.dto.TextDTO;
import hw8.dto.TextsDTO;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class ActionService extends CommonService {

    private static final String URI_FOR_TEXT = "/checkText";
    private static final String URI_FOR_TEXTS = "/checkTexts";

    public Response prepareRequestForCheckText(TextDTO textDTO) {
        Map<String, Object> map = new HashMap<>();
        map.put("text", textDTO.getText());
        map.put("lang", textDTO.getLang());
        map.put("options", textDTO.getOptions());
        return getWithParams(URI_FOR_TEXT, map);
    }

    public ResponseDTO[] parseResponseForText(Response response) {

        return response
                .then()
                .extract()
                .body()
                .as(ResponseDTO[].class);
    }



    public Response prepareRequestForCheckTexts(TextsDTO textsDTO) {
        Map<String, Object> map = new HashMap<>();
        map.put("text", textsDTO.getText());
        map.put("lang", textsDTO.getLang());
        map.put("options", textsDTO.getOptions());
        return getWithParams(URI_FOR_TEXTS, map);
    }

    public ResponseDTO[][] parseResponseForTexts(Response response) {
        return response
                .then()
                .extract()
                .body()
                .as(ResponseDTO[][].class);
    }
}
