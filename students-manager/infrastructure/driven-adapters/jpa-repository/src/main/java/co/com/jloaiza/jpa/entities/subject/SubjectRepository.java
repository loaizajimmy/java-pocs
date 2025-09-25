package co.com.jloaiza.jpa.entities.subject;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface SubjectRepository extends CrudRepository<SubjectData, Integer>, QueryByExampleExecutor<SubjectData> {

    SubjectData findByCode(String code);
}
