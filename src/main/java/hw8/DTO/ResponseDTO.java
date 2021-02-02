package hw8.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDTO {

    private String code;
    private String col;
    private String len;
    private String pos;
    private String row;
    private String[] s;
    private String word;
}
