package co.com.bancolombia.model.director.gateways;

import co.com.bancolombia.model.director.Director;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IDirectorRepository {

    Mono<Director> findById(String id);

    Flux<Director> findByName(String name);

    Flux<Director> getAll();
}
