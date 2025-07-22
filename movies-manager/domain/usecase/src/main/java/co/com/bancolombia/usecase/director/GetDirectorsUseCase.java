package co.com.bancolombia.usecase.director;

import co.com.bancolombia.model.director.Director;
import co.com.bancolombia.model.director.gateways.IDirectorRepository;
import co.com.bancolombia.model.movie.Movie;
import co.com.bancolombia.model.movie.gateways.IMovieRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

@RequiredArgsConstructor
public class GetDirectorsUseCase {

    private final IDirectorRepository directorRepository;
    private final IMovieRepository movieRepository;

    public Flux<Director> getAll() {
        return directorRepository.getAll();
    }

    public Mono<Director> getById(String id) {
        return directorRepository.findById(id);
    }

    public Flux<Director> getTopFiveDirectors() {
        //TODO: Implement logic to get top five directors according to movies rating
        return Flux.empty();
    }

    public Mono<Map<String, String>> getBestMovieByDirector() {
        //TODO: Implement logic to get the best rated movie by each director
        return Mono.empty();
    }
}
