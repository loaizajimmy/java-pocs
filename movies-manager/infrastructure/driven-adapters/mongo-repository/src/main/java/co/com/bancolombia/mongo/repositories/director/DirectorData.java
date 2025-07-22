package co.com.bancolombia.mongo.repositories.director;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "director")
public class DirectorData {
    @Id
    private String id;
    private String name;
    private String country;
    private Integer birthYear;
    private Integer deathYear;
}
