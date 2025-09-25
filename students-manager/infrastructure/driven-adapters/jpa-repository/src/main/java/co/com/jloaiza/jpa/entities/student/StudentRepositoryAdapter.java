package co.com.jloaiza.jpa.entities.student;

import co.com.jloaiza.jpa.helper.AdapterOperations;
import co.com.jloaiza.model.student.Student;
import co.com.jloaiza.model.student.gateways.IStudentRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepositoryAdapter extends AdapterOperations<Student, StudentData, Integer, StudentRepository>
        implements IStudentRepository {

    public StudentRepositoryAdapter(StudentRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, Student.class));
    }

    @Override
    public Student findByDocument(String document) {
        return this.toEntity(this.repository.findByDocument(document));
    }
}
