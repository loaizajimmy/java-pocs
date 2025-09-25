package co.com.jloaiza.api;

import co.com.jloaiza.model.student.Student;
import co.com.jloaiza.model.subject.Subject;
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
}
