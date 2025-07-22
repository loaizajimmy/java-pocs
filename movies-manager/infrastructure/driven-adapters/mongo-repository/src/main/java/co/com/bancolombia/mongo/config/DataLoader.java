package co.com.bancolombia.mongo.config;

import co.com.bancolombia.mongo.repositories.director.DirectorData;
import co.com.bancolombia.mongo.repositories.director.DirectorRepository;
import co.com.bancolombia.mongo.repositories.movie.MovieData;
import co.com.bancolombia.mongo.repositories.movie.MovieRepository;
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

    private final MovieRepository movieRepository;
    private final DirectorRepository directorRepository;
    private final Gson gson;

    @PostConstruct
    public void loadData() {
        log.info("DataLoader initialized. Loading initial data...");
        loadMovies();
        loadDirectors();
    }

    private void loadMovies() {
        List<MovieData> movies = loadDataFromJson("data/movies.json", MovieData.class);
        if (!movies.isEmpty()) {
            log.info("Movies loaded from JSON file: {}", movies.size());
            movieRepository.deleteAll()
                    .thenMany(movieRepository.saveAll(movies))
                    .subscribe();
        } else {
            log.warn("No movies found in data/movies.json");
        }
    }

    private void loadDirectors() {
        List<DirectorData> directors = loadDataFromJson("data/directors.json", DirectorData.class);
        if (!directors.isEmpty()) {
            log.info("Directors loaded from JSON file: {}", directors.size());
            directorRepository.deleteAll()
                    .thenMany(directorRepository.saveAll(directors))
                    .subscribe();
        } else {
            log.warn("No directors found in data/directors.json");
        }
    }


    private <T> List<T> loadDataFromJson(String filePath, Class<T> clazz) {
        try {
            Type type = TypeToken.getParameterized(List.class, clazz).getType();
            var resource = new ClassPathResource(filePath);
            return gson.fromJson(new InputStreamReader(resource.getInputStream()), type);
        } catch (IOException e) {
            log.error("File not found: {}", filePath, e);
            return List.of();
        }
    }
}
