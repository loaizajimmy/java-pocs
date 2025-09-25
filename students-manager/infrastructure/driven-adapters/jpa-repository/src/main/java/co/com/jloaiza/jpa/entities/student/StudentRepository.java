package co.com.jloaiza.jpa.entities.student;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface StudentRepository extends CrudRepository<StudentData, Integer>, QueryByExampleExecutor<StudentData> {

    StudentData findByDocument(String document);
}
