package co.com.bancolombia.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterRest {
    @Bean
    public RouterFunction<ServerResponse> routerFunction(Handler handler) {
        return route()
                .path("/movies", builder -> builder
                        .GET("", handler::getAllMovies)
                        .GET("/{id}", handler::getMovieById)
                        .GET("/search-by-categories", handler::getMoviesByCategories)
                        .GET("/recommendations/{movieId}", handler::getRecommendationsByMovieId)
                )
                .path("/directors", builder -> builder
                        .GET("", handler::getAllDirectors)
                        .GET("/{id}", handler::getDirectorById)
                        .GET("/top-rated", handler::getTopFiveDirectors)
                        .GET("/best-movie", handler::getBestMovieByDirector)
                )
                .path("/actors", builder -> builder
                        .GET("/most-frequent-by-category", handler::getMostFrequentActorByCategory)
                )
                .build();
    }
}
