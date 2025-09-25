package co.com.jloaiza.jpa.entities.enrollment;

import co.com.jloaiza.jpa.helper.AdapterOperations;
import co.com.jloaiza.model.enrollment.Enrollment;
import co.com.jloaiza.model.enrollment.gateways.IEnrollmentRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EnrollmentRepositoryAdapter extends AdapterOperations<Enrollment, EnrollmentData, Integer, EnrollmentRepository>
        implements IEnrollmentRepository {

    public EnrollmentRepositoryAdapter(EnrollmentRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, Enrollment.class));
    }

    @Override
    public Enrollment findByStudentIdAndSubjectId(int studentId, int subjectId) {
        return this.toEntity(repository.findByStudentIdAndSubjectId(studentId, subjectId));
    }

    @Override
    public List<Enrollment> findByStudentId(int studentId) {
        return this.toList(repository.findByStudentId(studentId));
    }

    @Override
    public List<Enrollment> findBySubjectId(int subjectId) {
        return this.toList(repository.findBySubjectId(subjectId));
    }
}
