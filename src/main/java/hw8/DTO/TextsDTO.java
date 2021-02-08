package hw8.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TextsDTO {

    private String[] text;
    private String lang;
    private String options;
    private String[] word;
    private String[] s;
    private String code;
}
