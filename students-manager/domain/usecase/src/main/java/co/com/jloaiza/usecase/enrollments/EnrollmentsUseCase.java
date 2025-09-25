package co.com.jloaiza.usecase.enrollments;

import co.com.jloaiza.model.enrollment.Enrollment;
import co.com.jloaiza.model.enrollment.gateways.IEnrollmentRepository;
import co.com.jloaiza.model.student.gateways.IStudentRepository;
import co.com.jloaiza.model.subject.gateways.ISubjectRepository;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

import static co.com.jloaiza.model.error.BusinessException.Type.ENROLLMENT_ALREADY_EXISTS;
import static co.com.jloaiza.model.error.BusinessException.Type.RESOURCE_NOT_FOUND;

@RequiredArgsConstructor
public class EnrollmentsUseCase {

    private final IEnrollmentRepository enrollmentRepository;
    private final IStudentRepository studentRepository;
    private final ISubjectRepository subjectRepository;

    public Enrollment save(Enrollment enrollment) {
        var existingEnrollment = this.enrollmentRepository.findByStudentIdAndSubjectId(enrollment.getStudentId(), enrollment.getSubjectId());
        if (existingEnrollment != null) {
            throw ENROLLMENT_ALREADY_EXISTS.build(String.format("Student: %s, Subject: %s", enrollment.getStudentId(), enrollment.getSubjectId()));
        }

        var existingUser = this.studentRepository.findById(enrollment.getStudentId());
        if (existingUser == null) {
            throw RESOURCE_NOT_FOUND.build(String.format("Student with id: %s not found", enrollment.getStudentId()));
        }

        var existingSubject = this.subjectRepository.findById(enrollment.getSubjectId());
        if (existingSubject == null) {
            throw RESOURCE_NOT_FOUND.build(String.format("Subject with id: %s not found", enrollment.getSubjectId()));
        }

        enrollment.setEnrolledAt(LocalDateTime.now());
        return this.enrollmentRepository.save(enrollment);
    }

    public Enrollment findByStudentIdAndSubjectId(int studentId, int subjectId) {
        var enrollment = this.enrollmentRepository.findByStudentIdAndSubjectId(studentId, subjectId);
        if (enrollment == null) {
            throw RESOURCE_NOT_FOUND.build(String.format("Enrollment with studentId: %s and subjectId: %s not found", studentId, subjectId));
        }
        return enrollment;
    }

    public List<Enrollment> findByStudentId(int studentId) {
        return this.enrollmentRepository.findByStudentId(studentId);
    }

    public List<Enrollment> findBySubjectId(int subjectId) {
        return this.enrollmentRepository.findBySubjectId(subjectId);
    }
}
