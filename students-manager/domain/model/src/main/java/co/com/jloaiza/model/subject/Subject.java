package co.com.jloaiza.model.subject;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Subject {
    private Integer id;
    private String code;
    private String name;
}
