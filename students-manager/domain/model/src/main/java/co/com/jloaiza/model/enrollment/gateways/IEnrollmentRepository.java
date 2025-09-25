package co.com.jloaiza.model.enrollment.gateways;

import co.com.jloaiza.model.enrollment.Enrollment;

import java.util.List;

public interface IEnrollmentRepository {
    Enrollment save(Enrollment enrollment);

    Enrollment findByStudentIdAndSubjectId(int studentId, int subjectId);

    List<Enrollment> findByStudentId(int studentId);

    List<Enrollment> findBySubjectId(int subjectId);
}
