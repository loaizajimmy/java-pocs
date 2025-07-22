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
                        .GET("/search-by-categories", handler::getMoviesByCategories)
                        .GET("/recommendations/{movieId}", handler::getRecommendationsByMovieId)
                        .GET("/{id}", handler::getMovieById)
                )
                .path("/directors", builder -> builder
                        .GET("", handler::getAllDirectors)
                        .GET("/top-rated", handler::getTopFiveDirectors)
                        .GET("/best-movie", handler::getBestMovieByDirector)
                        .GET("/{id}", handler::getDirectorById)
                )
                .path("/actors", builder -> builder
                        .GET("/most-frequent-by-category", handler::getMostFrequentActorByCategory)
                )
                .build();
    }
}
