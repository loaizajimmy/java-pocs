package co.com.bancolombia.mongo.repositories.director;

import co.com.bancolombia.model.director.Director;
import co.com.bancolombia.model.director.gateways.IDirectorRepository;
import co.com.bancolombia.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public class DirectorRepositoryAdapter extends AdapterOperations<Director, DirectorData, String, DirectorRepository>
        implements IDirectorRepository {

    public DirectorRepositoryAdapter(DirectorRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, Director.class));
    }

    @Override
    public Flux<Director> findByName(String name) {
        return doQueryMany(repository.findByName(name));
    }

    @Override
    public Flux<Director> getAll() {
        return doQueryMany(repository.findAll());
    }
}
