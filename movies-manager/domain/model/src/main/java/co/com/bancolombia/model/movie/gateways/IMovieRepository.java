package co.com.bancolombia.model.movie.gateways;

import co.com.bancolombia.model.movie.Movie;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IMovieRepository {

    Mono<Movie> findById(String id);

    Mono<Movie> findByTitle(String title);

    Flux<Movie> findByCategory(String category);

    Flux<Movie> findByDirectorId(String directorId);

    Flux<Movie> getAll();

}
