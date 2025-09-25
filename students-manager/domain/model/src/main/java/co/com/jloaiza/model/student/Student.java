package co.com.jloaiza.model.student;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Student {
    private Integer id;
    private String document;
    private String name;
    private String lastName;
}
