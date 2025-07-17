package co.com.bancolombia.mongo.config;

import co.com.bancolombia.mongo.repositories.book.BookData;
import co.com.bancolombia.mongo.repositories.book.BookRepository;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;

@Component
@RequiredArgsConstructor
@Log4j2
public class DataLoader {

    private final BookRepository bookRepository;
    private final Gson gson;

    @PostConstruct
    public void loadData() {
        log.info("DataLoader initialized. Loading initial data...");
        loadBooks();
    }

    private void loadBooks() {
        try {
            Type type = new TypeToken<List<BookData>>() {
            }.getType();
            var resource = new ClassPathResource("data/books.json");
            List<BookData> books = gson.fromJson(new InputStreamReader(resource.getInputStream()), type);
            log.info("Books loaded from JSON file: {}", books.size());
            bookRepository.deleteAll()
                    .thenMany(bookRepository.saveAll(books))
                    .subscribe();

        } catch (IOException e) {
            log.error("File not found: data/books.json", e);
        }
    }
}
