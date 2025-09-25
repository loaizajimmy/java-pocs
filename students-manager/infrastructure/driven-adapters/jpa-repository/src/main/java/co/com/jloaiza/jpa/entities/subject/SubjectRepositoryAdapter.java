package co.com.jloaiza.jpa.entities.subject;

import co.com.jloaiza.jpa.helper.AdapterOperations;
import co.com.jloaiza.model.subject.Subject;
import co.com.jloaiza.model.subject.gateways.ISubjectRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

@Repository
public class SubjectRepositoryAdapter extends AdapterOperations<Subject, SubjectData, Integer, SubjectRepository>
        implements ISubjectRepository {

    public SubjectRepositoryAdapter(SubjectRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, Subject.class));
    }

    @Override
    public Subject findByCode(String code) {
        return this.toEntity(repository.findByCode(code));
    }
}
