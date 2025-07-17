package co.com.bancolombia.model.book;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Book {
    private String id;
    private String title;
    private List<String> authorIds;
    private String category;
    private Integer year;
    private Double rating;
}
