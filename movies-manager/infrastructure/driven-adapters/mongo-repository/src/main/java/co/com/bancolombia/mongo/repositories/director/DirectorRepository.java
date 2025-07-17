package co.com.bancolombia.mongo.repositories.director;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import reactor.core.publisher.Flux;

public interface DirectorRepository extends ReactiveMongoRepository<DirectorData, String>, ReactiveQueryByExampleExecutor<DirectorData> {

    Flux<DirectorData> findByName(String name);
}
