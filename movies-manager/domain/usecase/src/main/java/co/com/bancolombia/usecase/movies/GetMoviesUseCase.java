package co.com.bancolombia.usecase.movies;

import co.com.bancolombia.model.movie.Movie;
import co.com.bancolombia.model.movie.gateways.IMovieRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class GetMoviesUseCase {

    private final IMovieRepository movieRepository;

    public Flux<Movie> getAll() {
        return movieRepository.getAll();
    }

    public Mono<Movie> getById(String id) {
        return movieRepository.findById(id);
    }

    public Flux<Movie> getMoviesByCategories(List<String> categories) {
        //TODO: Implement logic to get movies by each category in the list
        return Flux.empty();
    }

    public Mono<String> getMostFrequentActorByCategory(String category) {
        //TODO: Implement logic to get the most frequent actor in movies of a specific category
        return Mono.empty();
    }

    public Flux<Movie> getRecommendationsByMovieId(String movieId) {
        //TODO: Implement logic to get movie recommendations based on a specific movie ID
        return Flux.empty();
    }
}
