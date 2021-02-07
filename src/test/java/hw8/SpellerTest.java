package hw8;

import hw8.dto.ResponseDTO;
import hw8.dto.TextDTO;
import hw8.dto.TextsDTO;
import hw8.services.ActionService;
import hw8.services.AssertionService;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SpellerTest {

    private AssertionService assertionService;
    private ActionService actionService;

    @BeforeClass
    public void SetUp() {
        assertionService = new AssertionService();
        actionService = new ActionService();
    }

    @Test(dataProvider = "parsingForCheckTextMethod", dataProviderClass = DataProviderForSpeller.class)
    public void verifyCheckTextEndpointForCodeAndLength(TextDTO testData) {

        Response response = actionService.prepareRequestForCheckText(testData);
        ResponseDTO[] actualResult = actionService.parseResponseForText(response);
        assertionService
                .verifyErrorCode(actualResult, testData)
                .verifyLength(actualResult, testData);
    }

    @Test(dataProvider = "parsingForCheckTextMethod", dataProviderClass = DataProviderForSpeller.class)
    public void verifyCheckTextEndpointForIncorrectWordAndFixedWordInResponse(TextDTO testData) {

        Response response = actionService.prepareRequestForCheckText(testData);
        ResponseDTO[] actualResult = actionService.parseResponseForText(response);
        assertionService
                .verifyIncorrectWord(actualResult, testData)
                .verifyThatResponseHasFixedWord(actualResult, testData);
    }

    @Test(dataProvider = "parsingForCheckTextMethod", dataProviderClass = DataProviderForSpeller.class)
    public void verifyCheckTextEndpointJustForCode(TextDTO testData) {

        Response response = actionService.prepareRequestForCheckText(testData);
        ResponseDTO[] actualResult = actionService.parseResponseForText(response);
        assertionService.verifyErrorCode(actualResult, testData);
    }

    @Test(dataProvider = "parsingForCheckTextMethod", dataProviderClass = DataProviderForSpeller.class)
    public void verifyCheckTextEndpointJustForFixedWordInResponse(TextDTO testData) {

        Response response = actionService.prepareRequestForCheckText(testData);
        ResponseDTO[] actualResult = actionService.parseResponseForText(response);
        assertionService.verifyThatResponseHasFixedWord(actualResult, testData);

    }

    @Test(dataProvider = "parsingForCheckTextsMethod", dataProviderClass = DataProviderForSpeller.class)
    public void verifyCheckTextsEndpoint(TextsDTO testData) {

        Response response = actionService.prepareRequestForCheckTexts(testData);
        ResponseDTO[][] actualResult = actionService.parseResponseForTexts(response);
        assertionService.
                verifyAllIncorrectWord(actualResult, testData);
    }
}
