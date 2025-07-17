package co.com.bancolombia.mongo.repositories.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "book")
public class BookData {
    @Id
    private String id;
    private String title;
    private List<String> authorIds;
    private String category;
    private Integer year;
    private Double rating;
}
