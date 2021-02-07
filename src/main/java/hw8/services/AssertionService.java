package hw8.services;

import hw8.dto.ResponseDTO;
import hw8.dto.TextDTO;
import hw8.dto.TextsDTO;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AssertionService {

    public AssertionService verifyErrorCode(ResponseDTO[] response, TextDTO textDTO) {

        if (response.length != 0) {
            assertEquals(response[0].getCode(), textDTO.getCode(), "Invalid error code!");
            return this;
        }
        System.out.println("Something got wrong and service return empty response!");
        return null;
    }

    public AssertionService verifyIncorrectWord(ResponseDTO[] response, TextDTO textDTO) {

        if (response.length != 0) {
            assertEquals(response[0].getWord(), textDTO.getWord(), "Invalid incorrect word!");
            return this;
        }
        System.out.println("Something got wrong and service return empty response!");
        return null;
    }

    public AssertionService verifyThatResponseHasFixedWord(ResponseDTO[] response, TextDTO textDTO) {

        List<String> list = Arrays.asList(response[0].getS());
        assertTrue(list.contains(textDTO.getS()), "Invalid fixed word!");
        return this;
    }

    public AssertionService verifyLength(ResponseDTO[] response, TextDTO textDTO) {


        assertEquals(Integer.parseInt(response[0].getLen()), textDTO.getText().length(), "Invalid length!");
        return this;
    }

    public AssertionService verifyAllIncorrectWord(ResponseDTO[][] response, TextsDTO textsDTO) {

        if (response.length != 0) {
            IntStream.range(0, response[0].length).forEach(i -> {
                List<ResponseDTO[]> listDTO = Arrays.asList(response);
                List<String> list = Collections.singletonList(listDTO.get(0)[i].getWord());
                String incorrectWord = textsDTO.getWord()[i];
                assertTrue(list.contains(incorrectWord), "Invalid incorrect words!");
            });
            return null;
        }
        System.out.println("Something got wrong and service return empty response!");
        return null;
    }
}
