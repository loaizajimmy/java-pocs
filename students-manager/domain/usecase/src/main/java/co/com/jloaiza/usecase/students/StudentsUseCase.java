package co.com.jloaiza.usecase.students;

import co.com.jloaiza.model.student.Student;
import co.com.jloaiza.model.student.gateways.IStudentRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static co.com.jloaiza.model.error.BusinessException.Type.RESOURCE_NOT_FOUND;
import static co.com.jloaiza.model.error.BusinessException.Type.STUDENT_ALREADY_EXISTS;

@RequiredArgsConstructor
public class StudentsUseCase {

    private final IStudentRepository studentRepository;

    public Student save(Student student) {
        var existingStudent = this.studentRepository.findByDocument(student.getDocument());
        if (existingStudent != null) {
            throw STUDENT_ALREADY_EXISTS.build(String.format("Document: %s", student.getDocument()));
        }
        return this.studentRepository.save(student);
    }

    public Student findByDocument(String document) {
        var student = this.studentRepository.findByDocument(document);
        if (student == null) {
            throw RESOURCE_NOT_FOUND.build(String.format("Student with document %s not found", document));
        }
        return student;
    }

    public List<Student> findAll() {
        return this.studentRepository.findAll();
    }
}
