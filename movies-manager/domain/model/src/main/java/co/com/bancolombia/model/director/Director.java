package co.com.bancolombia.model.director;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Director {
    private String id;
    private String name;
    private String country;
    private Integer birthYear;
    private Integer deathYear;
}
