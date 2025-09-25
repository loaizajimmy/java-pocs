package co.com.jloaiza.api;

import co.com.jloaiza.model.enrollment.Enrollment;
import co.com.jloaiza.model.student.Student;
import co.com.jloaiza.model.subject.Subject;
import co.com.jloaiza.usecase.enrollments.EnrollmentsUseCase;
import co.com.jloaiza.usecase.students.StudentsUseCase;
import co.com.jloaiza.usecase.subjects.SubjectsUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class ApiRest {

    private final StudentsUseCase studentsUseCase;
    private final SubjectsUseCase subjectsUseCase;
    private final EnrollmentsUseCase enrollmentsUseCase;

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(studentsUseCase.findAll());
    }

    @PostMapping("/students")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        return ResponseEntity.ok(studentsUseCase.save(student));
    }

    @GetMapping(path = "/students/{document}")
    public ResponseEntity<Student> getStudentByDocument(@PathVariable("document") String document) {
        return ResponseEntity.ok(studentsUseCase.findByDocument(document));
    }


    @GetMapping("/subjects")
    public ResponseEntity<List<Subject>> getAllSubjets() {
        return ResponseEntity.ok(subjectsUseCase.findAll());
    }

    @PostMapping("/subjects")
    public ResponseEntity<Subject> saveSubject(@RequestBody Subject subject) {
        return ResponseEntity.ok(subjectsUseCase.save(subject));
    }

    @GetMapping(path = "/subjects/{code}")
    public ResponseEntity<Subject> getSubjectByCode(@PathVariable("code") String code) {
        return ResponseEntity.ok(subjectsUseCase.findByCode(code));
    }

    @PostMapping("/enrollment")
    public ResponseEntity<Enrollment> saveEnrollment(@RequestBody Enrollment enrollment) {
        return ResponseEntity.ok(enrollmentsUseCase.save(enrollment));
    }

    @GetMapping("/enrollments/student/{studentId}")
    public ResponseEntity<List<Enrollment>> getEnrollmentsByStudent(@PathVariable("studentId") int studentId) {
        return ResponseEntity.ok(enrollmentsUseCase.findByStudentId(studentId));
    }

    @GetMapping("/enrollments/subject/{subjectId}")
    public ResponseEntity<List<Enrollment>> getEnrollmentsBySubject(@PathVariable("subjectId") int subjectId) {
        return ResponseEntity.ok(enrollmentsUseCase.findBySubjectId(subjectId));
    }

    @GetMapping("/enrollments/{studentId}/{subjectId}")
    public ResponseEntity<Enrollment> getEnrollmentByStudentAndSubject(@PathVariable("studentId") int studentId, @PathVariable("subjectId") int subjectId) {
        return ResponseEntity.ok(enrollmentsUseCase.findByStudentIdAndSubjectId(studentId, subjectId));
    }
}
