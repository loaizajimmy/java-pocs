package co.com.bancolombia.model.book.gateways;

import co.com.bancolombia.model.book.Book;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IBookRepository {

    Mono<Book> findById(String id);

    Flux<Book> findByTitle(String title);

    Flux<Book> findByAuthorId(String authorId);

    Flux<Book> findByCategory(String category);

    Flux<Book> getAll();

}
