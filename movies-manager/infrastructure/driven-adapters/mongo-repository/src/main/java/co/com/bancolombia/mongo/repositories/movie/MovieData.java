package co.com.bancolombia.mongo.repositories.movie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "movie")
public class MovieData {
    @Id
    private String id;
    private String title;
    private String director;
    private List<String> actors;
    private List<String> categories;
    private Integer year;
    private Double rating;
}
