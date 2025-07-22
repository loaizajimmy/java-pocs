package co.com.bancolombia.model.movie;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Movie {
    private String id;
    private String title;
    private String director;
    private List<String> actors;
    private List<String> categories;
    private Integer year;
    private Double rating;
}
