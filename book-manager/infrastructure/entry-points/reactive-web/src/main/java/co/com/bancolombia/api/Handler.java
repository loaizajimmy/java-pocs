package co.com.bancolombia.api;

import co.com.bancolombia.usecase.book.GetBooksUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class Handler {

    private final GetBooksUseCase getBooksUseCase;

    public Mono<ServerResponse> getAllBooks(ServerRequest serverRequest) {
        return getBooksUseCase.getAll()
                .collectList()
                .flatMap(books -> ServerResponse.ok().bodyValue(books))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> listenPOSTUseCase(ServerRequest serverRequest) {
        // useCase.logic();
        return ServerResponse.ok().bodyValue("");
    }
}
