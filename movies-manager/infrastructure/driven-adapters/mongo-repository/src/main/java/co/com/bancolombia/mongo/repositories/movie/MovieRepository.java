package co.com.bancolombia.mongo.repositories.movie;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import reactor.core.publisher.Flux;

public interface MovieRepository extends ReactiveMongoRepository<MovieData, String>, ReactiveQueryByExampleExecutor<MovieData> {

    Flux<MovieData> findByTitle(String title);

    Flux<MovieData> findByActorsContains(String actorId);

    Flux<MovieData> findByCategoriesContains(String category);
}
