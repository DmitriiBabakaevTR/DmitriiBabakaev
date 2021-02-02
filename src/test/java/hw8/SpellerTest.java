package hw8;

import hw8.dto.ResponseDTO;
import hw8.dto.TextDTO;
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
    public void checkTextVerifyErrorCodeTest(TextDTO testData) {

        Response response = actionService.prepareRequestForCheckText(testData);
        ResponseDTO[] actualResult = actionService.parseResponseForText(response);
        assertionService
                .verifyErrorCode(actualResult, testData);
    }

    @Test(dataProvider = "parsingForCheckTextMethod", dataProviderClass = DataProviderForSpeller.class)
    public void checkTextVerifyIncorrectWordTest(TextDTO testData) {

        Response response = actionService.prepareRequestForCheckText(testData);
        ResponseDTO[] actualResult = actionService.parseResponseForText(response);
        assertionService
                .verifyIncorrectWord(actualResult, testData);
    }

    @Test(dataProvider = "parsingForCheckTextMethod", dataProviderClass = DataProviderForSpeller.class)
    public void checkTextVerifyFixedWordAtResponse(TextDTO testData) {

        Response response = actionService.prepareRequestForCheckText(testData);
        ResponseDTO[] actualResult = actionService.parseResponseForText(response);
        assertionService
                .verifyThatResponseHasFixedWord(actualResult, testData);
    }
}
