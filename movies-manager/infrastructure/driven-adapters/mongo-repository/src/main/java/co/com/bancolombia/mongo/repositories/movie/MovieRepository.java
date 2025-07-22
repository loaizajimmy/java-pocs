package co.com.bancolombia.mongo.repositories.movie;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MovieRepository extends ReactiveMongoRepository<MovieData, String>, ReactiveQueryByExampleExecutor<MovieData> {

    Mono<MovieData> findByTitle(String title);

    Flux<MovieData> findByCategoriesContainsIgnoreCase(String category);

    Flux<MovieData> findByDirector(String director);
}
