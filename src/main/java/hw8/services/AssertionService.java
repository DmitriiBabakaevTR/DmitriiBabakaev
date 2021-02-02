package hw8.services;

import hw8.dto.ResponseDTO;
import hw8.dto.TextDTO;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AssertionService {

    public void verifyErrorCode(ResponseDTO[] response, TextDTO textDTO){

        assertEquals(response[0].getCode(),textDTO.getCode(),"Invalid Error code!");
    }

    public void verifyIncorrectWord(ResponseDTO[] response, TextDTO textDTO){

        assertEquals(response[0].getWord(), textDTO.getWord(), "Invalid incorrect word!");
    }

    public void verifyThatResponseHasFixedWord(ResponseDTO[] response, TextDTO textDTO){

        List<String> list = Arrays.asList(response[0].getS());
        assertTrue(list.contains(textDTO.getS()), "Invalid fixed word!");
    }
}
