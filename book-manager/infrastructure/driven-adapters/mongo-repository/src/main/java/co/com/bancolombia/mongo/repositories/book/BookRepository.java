package co.com.bancolombia.mongo.repositories.book;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import reactor.core.publisher.Flux;

public interface BookRepository extends ReactiveMongoRepository<BookData, String>, ReactiveQueryByExampleExecutor<BookData> {

    Flux<BookData> findByTitle(String title);

    Flux<BookData> findByAuthorIdsContains(String authorId);

    Flux<BookData> findByCategory(String category);
}
