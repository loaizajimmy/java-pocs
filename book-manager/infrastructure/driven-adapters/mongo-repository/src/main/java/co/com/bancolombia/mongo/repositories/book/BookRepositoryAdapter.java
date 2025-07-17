package co.com.bancolombia.mongo.repositories.book;

import co.com.bancolombia.model.book.Book;
import co.com.bancolombia.model.book.gateways.IBookRepository;
import co.com.bancolombia.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public class BookRepositoryAdapter extends AdapterOperations<Book, BookData, String, BookRepository>
        implements IBookRepository {

    public BookRepositoryAdapter(BookRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Book.class));
    }

    @Override
    public Flux<Book> findByTitle(String title) {
        return doQueryMany(repository.findByTitle(title));
    }

    @Override
    public Flux<Book> findByAuthorId(String authorId) {
        return doQueryMany(repository.findByAuthorIdsContains(authorId));
    }

    @Override
    public Flux<Book> findByCategory(String category) {
        return doQueryMany(repository.findByCategory(category));
    }

    @Override
    public Flux<Book> getAll() {
        return doQueryMany(repository.findAll());
    }
}
