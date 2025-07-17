package co.com.bancolombia.model.author.gateways;

import co.com.bancolombia.model.author.Author;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IAuthorRepository {

    Mono<Author> findById(String id);

    Flux<Author> findByName(String name);
}
