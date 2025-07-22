package co.com.bancolombia.api;

import co.com.bancolombia.usecase.director.GetDirectorsUseCase;
import co.com.bancolombia.usecase.movies.GetMoviesUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class Handler {

    private final GetMoviesUseCase getMoviesUseCase;
    private final GetDirectorsUseCase getDirectorsUseCase;

    public Mono<ServerResponse> getAllMovies(ServerRequest serverRequest) {
        return getMoviesUseCase.getAll()
                .collectList()
                .flatMap(movies -> ServerResponse.ok().bodyValue(movies))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> getAllDirectors(ServerRequest serverRequest) {
        return getDirectorsUseCase.getAll()
                .collectList()
                .flatMap(directors -> ServerResponse.ok().bodyValue(directors))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> getTopFiveDirectors(ServerRequest serverRequest) {
        return getDirectorsUseCase.getTopFiveDirectors()
                .collectList()
                .flatMap(directors -> ServerResponse.ok().bodyValue(directors))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> getMoviesByCategories(ServerRequest serverRequest) {
        var categories = serverRequest.queryParam("categories").orElse("");
        if (categories.isBlank()) {
            return ServerResponse.badRequest().bodyValue("Categories parameter is required");
        }
        var categoryList = Arrays.asList(categories.split(","));
        return getMoviesUseCase.getMoviesByCategories(categoryList)
                .collectList()
                .flatMap(movies -> ServerResponse.ok().bodyValue(movies))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> getMostFrequentActorByCategory(ServerRequest serverRequest) {
        var category = serverRequest.queryParam("category").orElse("");
        if (category.isBlank()) {
            return ServerResponse.badRequest().bodyValue("Category parameter is required");
        }
        return getMoviesUseCase.getMostFrequentActorByCategory(category)
                .flatMap(actor -> ServerResponse.ok().bodyValue(actor))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> getRecommendationsByMovieId(ServerRequest serverRequest) {
        var movieId = serverRequest.pathVariable("movieId");
        if (movieId.isBlank()) {
            return ServerResponse.badRequest().bodyValue("Movie ID is required");
        }

        return getMoviesUseCase.getRecommendationsByMovieId(movieId)
                .collectList()
                .flatMap(recommendations -> ServerResponse.ok().bodyValue(recommendations))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> getBestMovieByDirector(ServerRequest serverRequest) {
        return getDirectorsUseCase.getBestMovieByDirector()
                .flatMap(bestMovies -> ServerResponse.ok().bodyValue(bestMovies))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> getMovieById(ServerRequest serverRequest) {
        var movieId = serverRequest.pathVariable("id");
        if (movieId.isBlank()) {
            return ServerResponse.badRequest().bodyValue("Movie ID is required");
        }
        return getMoviesUseCase.getById(movieId)
                .flatMap(movie -> ServerResponse.ok().bodyValue(movie))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> getDirectorById(ServerRequest serverRequest) {
        var directorId = serverRequest.pathVariable("id");
        if (directorId.isBlank()) {
            return ServerResponse.badRequest().bodyValue("Director ID is required");
        }
        return getDirectorsUseCase.getById(directorId)
                .flatMap(director -> ServerResponse.ok().bodyValue(director))
                .switchIfEmpty(ServerResponse.notFound().build());
    }
}
