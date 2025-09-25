package co.com.jloaiza.jpa.entities.enrollment;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.List;

public interface EnrollmentRepository extends CrudRepository<EnrollmentData, Integer>, QueryByExampleExecutor<EnrollmentData> {

    EnrollmentData findByStudentIdAndSubjectId(int studentId, int subjectId);

    List<EnrollmentData> findBySubjectId(int subjectId);

    List<EnrollmentData> findByStudentId(int studentId);
}
