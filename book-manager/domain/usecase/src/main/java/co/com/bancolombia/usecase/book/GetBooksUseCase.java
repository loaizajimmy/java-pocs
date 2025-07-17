package co.com.bancolombia.usecase.book;

import co.com.bancolombia.model.book.Book;
import co.com.bancolombia.model.book.gateways.IBookRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class GetBooksUseCase {

    private final IBookRepository bookRepository;

    public Flux<Book> getAll() {
        return bookRepository.getAll();
    }
}
