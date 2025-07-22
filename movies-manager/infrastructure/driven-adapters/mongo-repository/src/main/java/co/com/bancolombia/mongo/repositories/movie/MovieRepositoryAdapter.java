package co.com.bancolombia.mongo.repositories.movie;

import co.com.bancolombia.model.movie.Movie;
import co.com.bancolombia.model.movie.gateways.IMovieRepository;
import co.com.bancolombia.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class MovieRepositoryAdapter extends AdapterOperations<Movie, MovieData, String, MovieRepository>
        implements IMovieRepository {

    public MovieRepositoryAdapter(MovieRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, Movie.class));
    }

    @Override
    public Mono<Movie> findByTitle(String title) {
        return doQuery(repository.findByTitle(title));
    }

    @Override
    public Flux<Movie> findByCategory(String category) {
        return doQueryMany(repository.findByCategoriesContainsIgnoreCase(category));
    }

    @Override
    public Flux<Movie> findByDirectorId(String directorId) {
        return doQueryMany(repository.findByDirector(directorId));
    }

    @Override
    public Flux<Movie> getAll() {
        return doQueryMany(repository.findAll());
    }
}
